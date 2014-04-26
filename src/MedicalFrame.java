import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RootPaneContainer;
import javax.swing.border.EmptyBorder;

import Backend.DatabaseHandler;
import java.awt.SystemColor;


public class MedicalFrame extends JFrame {

	private JPanel contentPane;
	private DatabaseHandler handler;

	/**
	 * Create the frame.
	 */
	public MedicalFrame() {
		getContentPane().setBackground(SystemColor.textHighlight);
		handler = new DatabaseHandler();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setLayout(new CardLayout());
		contentPane.setBounds(100, 100, 1000, 600);
		this.setContentPane(contentPane);
	}
	
	public DatabaseHandler getHandler() {
		return handler;
	}
	
	public static boolean phoneNumberTest(String p) {
		return p.matches("([(]?)([0-9])([)]?)([0-9]{3})([-|\\s]?)([0-9]{4})");
	}

	public static boolean timeTest(String t) {
		return t.matches("(([0|1][0-9])|([2][0-4]))[:](([0-5][0-9])|([6][0]))[:](([0-5][0-9])|([6][0]))");
	}

	public static boolean dateTest(String d) {
		return d.matches("(([0-9]{4})|([0-9]{2}))[-|/][0|1][0-9][-|/][0-3][0-9]");
	}

	public static boolean dateTimeTest(String dt) {
		return dt.matches("((([0-9]{4})|([0-9]{2}))[-|/][0|1][0-9][-|/][0-3][0-9])\\s((([0|1][0-9])|([2][0-4]))[:](([0-5][0-9])|([6][0]))[:](([0-5][0-9])|([6][0])))");
	}

	public static boolean cardTest(String c) {
		return c.matches("(([0-9]{4})[-|\\s]([0-9]{4})[-|\\s]([0-9]{4})[-|\\s]([0-9]{4}))|(([0-9]{4})[-|\\s]([0-9]{6})[-|\\s]([0-9]{6}))");
	}

	public static boolean numTest(String n) {
		return n.matches("[0-9][0-9]*");
	}

	public static boolean firstNameTest(String fn){
		return fn.matches("[A-Z][A-Za-z-]+([A-Z][A-Za-z]+)*");
	}

	public static boolean lastNameTest(String ln){
		return ln.matches("[A-Z][']?[A-Za-z]+");
	}
	
	public static boolean nameTest(String n) {
		return n.matches("[A-Z][A-Za-z-]+([A-Z][A-Za-z]+)*[A-Z][']?[A-Za-z]+");
	}
}
