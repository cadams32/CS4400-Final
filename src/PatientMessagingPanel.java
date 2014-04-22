
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;


public class PatientMessagingPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private MedicalFrame parent;
	private String username;
	JButton btnSendMessage, btnBack;
	
	public PatientMessagingPanel(MedicalFrame parent, String username) {
		
		this.parent = parent;
		this.username = username;
		
		setLayout(new MigLayout("", "[986px,grow]", "[93px][442px][grow]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0,grow");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[147.00][][211.00,grow][325.00][176.00]", "[69.00][][][50.00,grow][247.00][71.00]"));
		
		JLabel lblSelectName = new JLabel("Select Name");
		panel_1.add(lblSelectName, "cell 1 1,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox, "cell 2 1,growx");
		
		JLabel lblMessage = new JLabel("Message");
		panel_1.add(lblMessage, "cell 1 3");
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 2 3 2 2,grow");
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 2,grow");
		panel_2.setLayout(new MigLayout("", "[394.00][][334.00][]", "[]"));
		
		btnSendMessage = new JButton("Send Message");
		panel_2.add(btnSendMessage, "cell 1 0");
		
		btnBack = new JButton("Back");
		panel_2.add(btnBack, "cell 3 0");

	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnSendMessage) {
				//DB transaction to send message
			}
			else if(e.getSource() == btnBack){
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			}
		}
		
		
	}
}
