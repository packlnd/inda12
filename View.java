import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.*;

/**
 * Class responsible for the view to the user. 
 * Handles input and ouput from and to the user.
 */
public class View extends JFrame {

	JButton btnCalculate;
	JPanel backgroundPanel;
	JPanel mainPanel;
	JTextField txtInput;
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
		backgroundPanel = new JPanel();
		backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));
		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		
		Font f = new Font("Verdana", Font.BOLD, 12);

		txtInput = new JTextField();
		txtInput.setPreferredSize(new Dimension(400, 30));
		txtInput.setFont(f);
		txtInput.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnCalculate.doClick();
				}
			}
		});
		mainPanel.add(txtInput);

		btnCalculate = new JButton("=");
		btnCalculate.addActionListener(new onCalculateClick());
		btnCalculate.setAlignmentX(Component.RIGHT_ALIGNMENT);
		mainPanel.add(btnCalculate);
		backgroundPanel.add(mainPanel);

		txtOutput = new JTextArea();
		txtOutput.setFont(f);
		backgroundPanel.add(txtOutput);

		setContentPane(backgroundPanel);
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
			String output = parser.parseData(txtInput.getText()); 
			// What to do with output? hashmap for later?
			// ...
			txtOutput.setText(output);
		}
	}
}