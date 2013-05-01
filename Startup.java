public class Startup {
	
	public static void main(String[] args) {
		MatrixCalculator calculator = new MatrixCalculator();
		InputParser parser = new InputParser(calculator);
		View view = new View(parser);
		view.createGUI();
	}
}