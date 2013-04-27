import javax.swing.BoxLayout;
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
	JTextArea txtInput;
	JTextArea txtOutput;
	
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
		setPreferredSize(new Dimension(600, 800));
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		txtInput = new JTextArea();
		panel.add(txtInput);

		btnCalculate = new JButton("=");
		btnCalculate.addActionListener(new onCalculateClick());
		btnCalculate.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.add(btnCalculate);

		txtOutput = new JTextArea();
		panel.add(txtOutput);

		setContentPane(panel);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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