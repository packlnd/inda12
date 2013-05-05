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
	JButton btnMatrix;
	JButton btnCopy;
	JPanel backgroundPanel;
	JPanel mainPanel;
	JPanel buttonPanel;
	JTextField txtInput;
	JTextArea txtOutput;
	InputParser parser;
	
	/**
	 * Class constructor. Initializes GUI
	 */
	public View(InputParser parser) {
		super("Matrix");
		this.parser = parser;
	}
	
	/**
	 * Create the GUI and display to the user.
	 */
	public void createGUI() {
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

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		btnMatrix = new JButton("Ny matris");
		btnMatrix.addActionListener(new onMatrixClick());
		buttonPanel.add(btnMatrix);

		btnCopy = new JButton("Kopiera");
		btnCopy.addActionListener(new onCopyClick());
		buttonPanel.add(btnCopy);

		backgroundPanel.add(buttonPanel);

		txtOutput = new JTextArea();
		txtOutput.setFont(f);
		txtOutput.setEditable(false);
		backgroundPanel.add(txtOutput);

		setContentPane(backgroundPanel);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

	/**
	 * Handle click on copy button.
	 */
	private class onCopyClick implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}

	/**
	 * Handle click on matrix button.
	 */
	private class onMatrixClick implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}