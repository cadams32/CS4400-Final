
import javax.swing.JPanel;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class DoctorHomePanel extends JPanel {

	private JLabel lblDoctor;
	private JLabel lblYouHaveMessages;
	
	private JButton btnEditProfile;
	private JButton btnViewAppointmentCalendar;
	private JButton btnPatientVisits;
	private JButton btnRecordASurgery;
	private JButton btnCommunicate;

	private JButton btnViewMessages;
	
	private MedicalFrame parent;
	private String username;
	
	/**
	 * Create the panel.
	 */
	public DoctorHomePanel(MedicalFrame parent, String username) {
		
		this.parent = parent;
		this.username = username;
		
		setLayout(new MigLayout("", "[][][][][][][][]", "[][][][][][][]"));
		
		ButtonListener listener = new ButtonListener();
		
		JButton btnEditProfile = new JButton("Edit Profile");
		
		JLabel lblDoctor = new JLabel("Doctor");
		add(lblDoctor, "cell 3 0");
		
		JLabel lblYouHaveMessages = new JLabel("You have messages");
		add(lblYouHaveMessages, "cell 7 2");
		
		JButton btnViewAppointmentCalendar = new JButton("View Appointment Calendar");
		add(btnViewAppointmentCalendar, "cell 2 2");
		btnViewAppointmentCalendar.addActionListener(listener);
		
		JButton btnPatientVisits = new JButton("Patient Visits");
		add(btnPatientVisits, "cell 2 3");
		btnPatientVisits.addActionListener(listener);
		
		JButton btnViewMessages = new JButton("View Messages");
		add(btnViewMessages, "cell 7 3");
		btnViewMessages.addActionListener(listener);
		
		JButton btnRecordASurgery = new JButton("Record a Surgery");
		add(btnRecordASurgery, "cell 2 4");
		btnRecordASurgery.addActionListener(listener);
		
		JButton btnCommunicate = new JButton("Communicate");
		add(btnCommunicate, "cell 2 5");
		add(btnEditProfile, "cell 2 6");
		btnCommunicate.addActionListener(listener);

	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnViewAppointmentCalendar) {
				//GOTO view appointment calendar
				
			} else if (e.getSource() == btnPatientVisits) {
				//GOTO patientVisits
				
			} else if (e.getSource() == btnRecordASurgery) {
				//GOTO View Visit History
				
			} else if (e.getSource() == btnCommunicate) {
				//GOTO communicate
				
			} else if (e.getSource() == btnEditProfile) {
				//GOTO rate a doctor
				
			}
		}
		
	}
}
