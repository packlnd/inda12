import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 * Class responsible for the view to the user. 
 * Handles input and ouput from and to the user.
 */
public class View extends JFrame {

	JButton btnSearch;
	JPanel panel;
	JTextArea txtInput;
	
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
		panel.setSize(300, 200);
		panel.setLayout(new BorderLayout(2, 2));
		
		txtInput = new JTextArea();
		txtInput.setEditable(true);
		txtInput.setPreferredSize(new Dimension(400, 10));
		panel.add(txtInput, BorderLayout.LINE_START);
		
		btnSearch = new JButton("Sök");
		btnSearch.addActionListener(new onSearchClick());
		panel.add(btnSearch, BorderLayout.LINE_END);
		setContentPane(panel);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new View();
	}

	private class onSearchClick implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			txtInput.setText("Hejhej");
		}
	}
}