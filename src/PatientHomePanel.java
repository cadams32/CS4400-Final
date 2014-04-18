
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PatientHomePanel extends JPanel {
	
	
	private MedicalFrame parent;
	private String username;
	
	private JLabel lblPatient;
	private JLabel lblYouHaveMessages;
	private JButton btnMakeAppointments;
	private JButton btnEditProfile;
	private JButton btnViewVisitHistory;
	private JButton btnViewMessages;
	private JButton btnOrderMedication;
	private JButton btnCommunicate;
	private JButton btnRateADoctor;

	/**
	 * Create the panel.
	 */
	public PatientHomePanel(MedicalFrame parent, String username) {
		
		this.parent = parent;
		this.username = username;
		
		setLayout(new MigLayout("", "[][][][][][][][]", "[][][][][][][][]"));
		
		ButtonListener listener = new ButtonListener();
		
		JLabel lblPatient = new JLabel("Patient");
		add(lblPatient, "cell 4 0");
		
		btnMakeAppointments = new JButton("Make Appointments");
		add(btnMakeAppointments, "cell 3 2");
		btnMakeAppointments.addActionListener(listener);
		
		btnEditProfile = new JButton("Edit Profile");
		add(btnEditProfile, "cell 3 7");
		btnEditProfile.addActionListener(listener);
		
		btnViewVisitHistory = new JButton("View Visit History");
		add(btnViewVisitHistory, "cell 3 3");
		btnViewVisitHistory.addActionListener(listener);
		
		lblYouHaveMessages = new JLabel("You have messages");
		add(lblYouHaveMessages, "cell 7 2");
		
		btnOrderMedication = new JButton("Order Medication");
		add(btnOrderMedication, "cell 3 4");
		btnOrderMedication.addActionListener(listener);
		
		btnCommunicate = new JButton("Communicate");
		add(btnCommunicate, "cell 3 5");
		btnCommunicate.addActionListener(listener);
		
		btnRateADoctor = new JButton("Rate A Doctor");
		add(btnRateADoctor, "cell 3 6");
		btnRateADoctor.addActionListener(listener);
		
		//Added this one.
		btnViewMessages = new JButton("View Messages");
		add(btnViewMessages, "cell 7 3");
		btnViewMessages.addActionListener(listener);

	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnMakeAppointments) {
				//GOTO make appointments
				
			} else if (e.getSource() == btnEditProfile) {
				//GOTO edit profile
				
			} else if (e.getSource() == btnViewVisitHistory) {
				//GOTO View Visit History
				
			} else if (e.getSource() == btnOrderMedication) {
				//GOTO Order Medication
				
			} else if (e.getSource() == btnCommunicate) {
				//GOTO communicate
				
			} else if (e.getSource() == btnRateADoctor) {
				//GOTO rate a doctor
				
			}
		}
		
	}

}
