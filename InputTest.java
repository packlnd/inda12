import static org.junit.Assert.*;
import org.junit.Test;

public class InputTest {
	/**
	 * Test empty input.
	 */
	 @Test
	 public void testEmpty() {
	 	assertTrue(doTest("", ""));
	 }

	 /**
	  * Test null input.
	  */
	 @Test
	 public void testNull() {
	 	assertTrue(doTest(null, InputParser.WRONG_INPUT));
	 }

	 /**
	  * Test determinants of different sizes.
	  */
	 @Test
	 public void testDeterminant() {
	 	assertTrue(doTest("determinant [[1 0] [0 1]]", "1.0"));
	 	assertTrue(doTest("determinant [[3 0 0] [0 4 0] [0 0 1]]", "12.0"));
	 	assertTrue(doTest("determinant [[8 3] [4 2]]", "4.0"));
	 }

	 /**
	  * Test matrix with weird size.
	  */
	 @Test
	 public void testWeirdSize() {
	 	assertTrue(doTest("[[1 0 0] [0 1] [0 1 0]]", InputParser.WRONG_INPUT));
	 	assertTrue(doTest("determinant [[1 0 0] [0 1] [0 1 0]]", InputParser.WRONG_INPUT));
	 	assertTrue(doTest("invert [[1 0 0] [0 1] [0 1 0]]", InputParser.WRONG_INPUT));
	 	assertTrue(doTest("[[1] [1 0] [1 0 0]]", InputParser.WRONG_INPUT));
	 }

	 private boolean doTest(String input, String solutionOutput) {
		InputParser parser = new InputParser(new MatrixCalculator());
		String output = parser.parseData(input) + "";
	 	return output.equals(solutionOutput);
	 }
}