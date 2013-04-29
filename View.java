import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Component;

/**
 * Class responsible for the view to the user. 
 * Handles input and ouput from and to the user.
 */
public class View extends JFrame {

	JButton btnCalculate;
	JPanel panel;
	JPanel mainPanel;
	JTextArea txtInput;
	JTextArea txtOutput;
	InputParser parser;
	
	/**
	 * Class constructor. Initializes GUI
	 */
	public View() {
		super("Matrix");
		createGUI();
	}
	
	/**
	 * Create the GUI and display to the user.
	 */
	private void createGUI() {
		setPreferredSize(new Dimension(600, 400));
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		
		txtInput = new JTextArea();
		txtInput.setPreferredSize(new Dimension(400, 30));
		mainPanel.add(txtInput);

		btnCalculate = new JButton("=");
		btnCalculate.addActionListener(new onCalculateClick());
		btnCalculate.setAlignmentX(Component.RIGHT_ALIGNMENT);
		mainPanel.add(btnCalculate);
		panel.add(mainPanel);

		txtOutput = new JTextArea();
		panel.add(txtOutput);

		setContentPane(panel);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		parser = new InputParser();
	}
	
	public static void main(String[] args) {
		new View();
	}

	/**
	 * Handle click on calculate button.
	 */
	private class onCalculateClick implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// gör massa
		}
	}
}