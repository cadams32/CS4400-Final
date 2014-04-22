
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


public class DoctorMessagingPanel extends JPanel {

	
	private MedicalFrame parent;
	private String username;
	
	private JComboBox selectDocComboBox;
	private JComboBox selectPatComboBox;
	private JTextPane docTextPane;
	private JTextPane patTextPane;
	JButton btnBack, btnSend, btnSend_1;
	
	/**
	 * Create the panel.
	 */
	public DoctorMessagingPanel(MedicalFrame parent, String username) {
		
		this.parent = parent;
		this.username = username;
		ButtonListener listener = new ButtonListener();
		
		setLayout(new MigLayout("", "[986px,grow]", "[93px][442px][grow]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0,grow");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[49.00][109.00][][268.00,grow][][102.00][358.00,grow]", "[69.00][][][50.00,grow][247.00][71.00]"));
		
		JLabel lblSelectDoctor = new JLabel("Select Doctor");
		panel_1.add(lblSelectDoctor, "cell 1 1,alignx leading");
		
		selectDocComboBox = new JComboBox();
		panel_1.add(selectDocComboBox, "cell 2 1 2 1,growx");
		
		JLabel lblSelectPatient = new JLabel("Select Patient");
		panel_1.add(lblSelectPatient, "cell 5 1,alignx trailing");
		
		selectPatComboBox = new JComboBox();
		panel_1.add(selectPatComboBox, "cell 6 1,growx");
		
		JLabel lblMessage = new JLabel("Message");
		panel_1.add(lblMessage, "cell 1 3,alignx leading");
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 2 3 2 2,grow");
		
		docTextPane = new JTextPane();
		scrollPane.setViewportView(docTextPane);
		
		JLabel lblMessage_1 = new JLabel("Message");
		panel_1.add(lblMessage_1, "cell 5 3");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, "cell 6 3 1 2,grow");
		
		patTextPane = new JTextPane();
		scrollPane_1.setViewportView(patTextPane);
		
		btnSend = new JButton("Send");
		panel_1.add(btnSend, "cell 3 5");
		btnSend.addActionListener(listener);
		
		btnSend_1 = new JButton("Send");
		panel_1.add(btnSend_1, "cell 6 5");
		btnSend_1.addActionListener(listener);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 2,grow");
		panel_2.setLayout(new MigLayout("", "[895.00][]", "[]"));
		
		btnBack = new JButton("Back");
		panel_2.add(btnBack, "cell 1 0");
		btnBack.addActionListener(listener);

	}
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnBack) {
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			}
			else if(e.getSource() == btnSend){
				//This is for messaging doctors
				
			}
			else if(e.getSource() == btnSend_1){
				//This is for messaging patients
				
			}
		}
	}
}
