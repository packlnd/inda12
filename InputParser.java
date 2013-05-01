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
		final String wrongString = "I do not know what you mean!";

		if (rows.length <= 0) {
			return wrongString;
		}

		// Has keyword
		if (keywords.contains(rows[0].trim().toLowerCase())) {
			keyword = rows[0].trim().toLowerCase();

		// Only matrix
		} else if (rows[0].trim().matches("")) {
			int numberOfElements = elementsInRow(rows[1].trim());
			for (int i = 1; i < rows.length; i++) {
				if (rows[i].trim().matches(rowOfNumbers) && 
					elementsInRow(rows[i].trim()) == numberOfElements) {
					continue;
				}
				return wrongString;
			}
			return input;

		// Something wrong with input
		} else {
			return wrongString;
		}

		// When does the first matrix end?
		int matrixLength = rows.length - 1; //All coming rows
		for (int i = 1; i < rows.length; i++) {
			if (rows[i].trim().equals("")) {
				matrixLength = i-1; //Found another matrix
			}
		}

		// Go through all remaining rows
		double[][] matrix = new double[matrixLength][elementsInRow(rows[1])];
		LinkedList<Matrix> matrices = new LinkedList<Matrix>();
		int mRow = 0;
		for (int i = 1; i < rows.length; i++) {
			if (rows[i].trim().equals("")) {
				matrices.add(new Matrix(matrix));
				matrixLength = rows.length-2 - matrixLength;
				matrix = new double[matrixLength][elementsInRow(rows[i + 1])];
				mRow = 0;
				continue;
			}
			String[] elements = rows[i].trim().split("(\\s)");
			for (int j = 0; j < elements.length; j++) {
				matrix[mRow][j] = Double.parseDouble(elements[j]);
			}
			mRow++;
		}
		Matrix m = new Matrix(matrix);

		/*if (keyword.equals("reduce")) {
			Matrix result = calculator.gauss(m);
			return result.toString();
		} else if (keyword.equals("invert")) {
			Matrix result = calculator.invert(m);
			return result.toString();
		}*/
		return wrongString;
	}

	/**
	 * Return the number of elemens in this row.
	 */
	private int elementsInRow(String s) {
		return ((s.toCharArray().length + 1)/2);
	}
}

/*
multiply [[1 1] [2 2]][[3 3] [4 4]]
multiply [[1 1] [2 2]][[3 3] [4 4]][[5 5] [6 6]]
multiply [[1 0 0] [0 1 0] [0 0 1]][[1 0 0] [0 1 0] [0 0 1]]
invert [[1 2] [3 4]]
*/