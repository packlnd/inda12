import java.util.HashSet;
/**
 * Parses commands from View and turns it into commands 
 * for the MatrixOperations class.
 */
public class InputParser {

	private HashSet<String> keywords = new HashSet<String>();

	/**
	 * Class constructor.
	 */
	public InputParser() {
		keywords.add("invert");
		keywords.add("multiply");
		keywords.add("determinant");
		keywords.add("add");
	}

	/**
	 * Takes a string and turns it into matrix operations.
	 */
	public String parseData(String input) {
		String[] rows = input.split("(] \\[)|(\\[\\[)|(]])");
		String keyword = "";
		String rowOfNumbers = "(\\d)(\\s\\d)*";

		// Has keyword
		if (keywords.contains(rows[0].trim())) {
			keyword = rows[0].trim();

		// Only matrix
		} else if (rows[0].trim().matches("")) {
			for (int i = 1; i < rows.length; i++) {
				if (rows[i].trim().matches(rowOfNumbers)) {
					continue;
				}
				return "I do not know what you mean!";
			}
			return input;

		// Something wrong with input
		} else {
			return "I do not know what you mean!";
		}

		for (int i = 1; i < rows.length; i++) {
			// Matrix operations
		}
		return "Correct input";
	}
}