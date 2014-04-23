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
		
		ButtonListener listener = new ButtonListener();
		
		setLayout(new MigLayout("", "[][][][][][][][]", "[][][][][][][]"));
		
		JButton btnEditProfile = new JButton("Edit Profile");
		
		JLabel lblDoctor = new JLabel("Doctor");
		add(lblDoctor, "cell 3 0");
		
		JLabel lblYouHaveMessages = new JLabel("You have messages");
		add(lblYouHaveMessages, "cell 7 2");
		
		btnViewAppointmentCalendar = new JButton("View Appointment Calendar");
		add(btnViewAppointmentCalendar, "cell 2 2");
		btnViewAppointmentCalendar.addActionListener(listener);
		
		btnPatientVisits = new JButton("Patient Visits");
		add(btnPatientVisits, "cell 2 3");
		btnPatientVisits.addActionListener(listener);
		
		btnViewMessages = new JButton("View Messages");
		add(btnViewMessages, "cell 7 3");
		btnViewMessages.addActionListener(listener);
		
		btnRecordASurgery = new JButton("Record a Surgery");
		add(btnRecordASurgery, "cell 2 4");
		btnRecordASurgery.addActionListener(listener);
		
		btnCommunicate = new JButton("Communicate");
		add(btnCommunicate, "cell 2 5");
		add(btnEditProfile, "cell 2 6");
		btnCommunicate.addActionListener(listener);

	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnViewAppointmentCalendar) {
				//GOTO view appointment calendar
				ViewAppointmentCalendarPanel vacp = new ViewAppointmentCalendarPanel(parent, username);
				parent.getContentPane().add(vacp);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
				
			}
			else if (e.getSource() == btnPatientVisits) {
				//GOTO patientVisits
				ViewPatientHistoryPanel vphp = new ViewPatientHistoryPanel(parent, username);
				parent.getContentPane().add(vphp);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
			}
			else if (e.getSource() == btnRecordASurgery) {
				//GOTO View Visit History
				SurgeryPanel sp = new SurgeryPanel(parent, username);
				parent.getContentPane().add(sp);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
				
			}
			else if (e.getSource() == btnCommunicate) {
				//GOTO communicate
				DoctorMessagingPanel dmp = new DoctorMessagingPanel(parent, username);
				parent.getContentPane().add(dmp);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
				
			}
			else if (e.getSource() == btnEditProfile) {
				//GOTO rate a doctor
				DoctorEditProfilePanel depp = new DoctorEditProfilePanel(parent, username);
				parent.getContentPane().add(depp);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
				
			}
		}
		
	}
}
