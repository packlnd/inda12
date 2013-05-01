import java.util.HashSet;
import java.util.Arrays;
import java.util.LinkedList;
/**
 * Parses commands from View and turns it into commands 
 * for the MatrixOperations class.
 */
public class InputParser {

	private HashSet<String> keywords = new HashSet<String>();
	private MatrixCalculator calculator;

	/**
	 * Class constructor.
	 */
	public InputParser(MatrixCalculator calculator) {
		keywords.add("invert");
		keywords.add("multiply");
		keywords.add("determinant");
		keywords.add("add");
		this.calculator = calculator;
	}

	/**
	 * Takes a string and turns it into matrix operations.
	 */
	public String parseData(String input) {
		String[] rows = input.split("(](\\s)?\\[)|(\\[\\[)|(]])");
		String keyword = "";
		String rowOfNumbers = "(\\d)(\\s\\d)*";
		final String wrongString = "Jag förstår inte vad du menar!";

		if (rows.length <= 0) {
			return wrongString;
		}

		// clean up
		for (int i = 0; i < rows.length; i++) {
			rows[i] = rows[i].trim().toLowerCase();
		}

		// Has keyword
		if (keywords.contains(rows[0])) {
			keyword = rows[0];
		// Only matrix
		} else if (rows[0].matches("")) {
			return handleOnlyMatrix(rows);
		// Something wrong with input
		} else {
			return wrongString;
		}

		int matrixLength = lengthOfFirstMatrix(rows);

		// Go through all remaining rows
		double[][] matrix = new double[matrixLength][elementsInRow(rows[1])];
		LinkedList<Matrix> matrices = new LinkedList<Matrix>();
		int mRow = 0;
		for (int i = 1; i < rows.length; i++) {
			if (rows[i].equals("")) {
				matrices.add(new Matrix(matrix));
				matrixLength = rows.length-2 - matrixLength;
				matrix = new double[matrixLength][elementsInRow(rows[i + 1])];
				mRow = 0;
				continue;
			}
			String[] elements = rows[i].split("(\\s)");
			for (int j = 0; j < elements.length; j++) {
				matrix[mRow][j] = Double.parseDouble(elements[j]);
			}
			mRow++;
		}
		matrices.add(new Matrix(matrix));

		return doOperation(keyword, matrices);
	}

	/**
	 * Executes the operation based on the keyword and matrices provided.
	 */
	private String doOperation() {
		if (keyword.equals("reduce")) {
			Matrix result = calculator.gauss(m);
			return result.toString();
		} else if (keyword.equals("invert")) {
			Matrix result = calculator.invert(m);
			return result.toString();
		}
		return wrongString;
	}

	/**
	 * Handles the case where input is a (pair) of matrices without an operation.
	 */
	private String handleOnlyMatrix(String[] rows) {
		int numberOfElements = elementsInRow(rows[1].trim());
		for (int i = 1; i < rows.length; i++) {
			if (rows[i].trim().matches(rowOfNumbers) && 
				elementsInRow(rows[i].trim()) == numberOfElements) {
				continue;
			}
			return wrongString;
		}
		return input;
	}


	/**
	 * Return the number of elemens in this row.
	 */
	private int elementsInRow(String s) {
		return ((s.toCharArray().length + 1)/2);
	}

	/**
	 * Gets the length of the first matrix. 
	 * Matrices are separated with an empty row.
	 */
	private int lengthOfFirstMatrix(String[] rows) {
		int matrixLength = rows.length - 1; //All coming rows
		for (int i = 1; i < rows.length; i++) {
			if (rows[i].equals("")) {
				matrixLength = i-1; //Found another matrix
			}
		}
		return matrixLength;
	}
}

/*
multiply [[1 1] [2 2]][[3 3] [4 4]]
multiply [[1 1] [2 2]][[3 3] [4 4]][[5 5] [6 6]]
multiply [[1 0 0] [0 1 0] [0 0 1]][[1 0 0] [0 1 0] [0 0 1]]
invert [[1 2] [3 4]]
*/