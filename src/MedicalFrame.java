import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Backend.DatabaseHandler;


public class MedicalFrame extends JFrame {

	private JPanel contentPane;
	private static DatabaseHandler handler;

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

}
