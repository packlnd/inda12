public class Startup {

	/**
	 * Starts up the application.
	 */
	public static void main(String[] args) {
		MatrixCalculator calculator = new MatrixCalculator();
		InputParser parser = new InputParser(calculator);
		View view = new View(parser);
		view.createGUI();
	}
}