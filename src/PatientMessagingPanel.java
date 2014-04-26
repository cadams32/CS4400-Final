
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;

import Backend.Doctor;
import Backend.Patient;
import java.awt.SystemColor;
import java.awt.Font;


public class PatientMessagingPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private MedicalFrame parent;
	private String username;
	private JButton btnSendMessage, btnBack;
	
	private JTextPane textPane;
	private JComboBox comboBox;
	
	private ArrayList<Doctor> docs;
	private ArrayList<String> docNames;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public PatientMessagingPanel(MedicalFrame parent, String username) {
		setBackground(SystemColor.textHighlight);
		
		docs = new ArrayList<Doctor>();
		docNames = new ArrayList<String>();
		this.setBounds(100, 100, 1000, 600);
		this.parent = parent;
		this.username = username;
		ButtonListener listener = new ButtonListener();
		
		setLayout(new MigLayout("", "[986px,grow]", "[93px][442px][grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		add(panel, "cell 0 0,grow");
		panel.setLayout(null);
		
		JLabel lblPatientMessaging = new JLabel("Patient Messaging");
		lblPatientMessaging.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblPatientMessaging.setBounds(354, 24, 357, 45);
		panel.add(lblPatientMessaging);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[147.00][][211.00,grow][325.00][176.00]", "[69.00][][][50.00,grow][247.00][71.00]"));
		
		JLabel lblSelectName = new JLabel("Select Name");
		panel_1.add(lblSelectName, "cell 1 1,alignx trailing");
		
		docs = parent.getHandler().getDoctors();
		for(Doctor d : docs) {
			docNames.add("Dr. " + d.getfName() + " " + d.getlName());
		}
		
		comboBox = new JComboBox(docNames.toArray());
		panel_1.add(comboBox, "cell 2 1,growx");
		
		JLabel lblMessage = new JLabel("Message");
		panel_1.add(lblMessage, "cell 1 3");
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 2 3 2 2,grow");
		
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlight);
		add(panel_2, "cell 0 2,grow");
		panel_2.setLayout(new MigLayout("", "[394.00][][334.00][]", "[]"));
		
		btnSendMessage = new JButton("Send Message");
		panel_2.add(btnSendMessage, "cell 1 0");
		btnSendMessage.addActionListener(listener);
		
		btnBack = new JButton("Back");
		panel_2.add(btnBack, "cell 3 0");
		btnBack.addActionListener(listener);

	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnSendMessage) {
				//DB transaction to send message
				int index = comboBox.getSelectedIndex();
				Doctor doc = docs.get(index);
				String docReceiver = doc.getUsername();
				parent.getHandler().addNewSendMessageToDoc(username, docReceiver, dateFormat.format(Calendar.getInstance().getTime()), textPane.getText(), "Unread");	
				
			}
			else if(e.getSource() == btnBack){
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			}
		}
		
		
	}
}
