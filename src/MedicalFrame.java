import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Backend.DatabaseHandler;


public class MedicalFrame extends JFrame {

	private JPanel contentPane;
	private DatabaseHandler handler;

	/**
	 * Create the frame.
	 */
	public MedicalFrame() {
		handler = new DatabaseHandler();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setLayout(new CardLayout());
		setContentPane(contentPane);
	}
	
	public DatabaseHandler getHandler() {
		return handler;
	}
	
	public static boolean phoneNumber(String p) {
		return p.matches("[(]([0-9])[)][0-9]{3}-[0-9]{4}");
	}

	public static boolean time(String t) {
		return t.matches("[0-2][0-9][:][0-6][0-9][:][0-6][0-9]");
	}

	public static boolean date(String d) {
		return d.matches("[0-9]{4}[-][0|1][0-9][-][0-3][0-9]");
	}

	public static boolean dateTime(String dt) {
		return dt.matches("(([0-9]{4})[-][0|1][0-9][-][0-3][0-9])\\s([0-2][0-9][:][0-6][0-9][:][0-6][0-9])");
	}

}
