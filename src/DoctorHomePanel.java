import javax.swing.JPanel;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;

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
	private JButton btnLogout;
	
	/**
	 * Create the panel.
	 */
	public DoctorHomePanel(MedicalFrame parent, String username) {
		setBackground(SystemColor.textHighlight);
		
		this.parent = parent;
		this.username = username;
		this.setBounds(100, 100, 1000, 600);
		ButtonListener listener = new ButtonListener();
		setLayout(null);
		
		btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.setBounds(228, 350, 112, 29);
		add(btnEditProfile);
		btnEditProfile.addActionListener(listener);

		JLabel lblDoctor = new JLabel("Doctor Home");
		lblDoctor.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblDoctor.setBounds(426, 48, 263, 44);
		add(lblDoctor);
		
		JLabel lblYouHaveMessages = new JLabel("Inbox");
		lblYouHaveMessages.setBounds(667, 203, 123, 16);
		add(lblYouHaveMessages);
		
		btnViewAppointmentCalendar = new JButton("View Appointment Calendar");
		btnViewAppointmentCalendar.setBounds(228, 218, 218, 29);
		add(btnViewAppointmentCalendar);
		btnViewAppointmentCalendar.addActionListener(listener);
		
		btnPatientVisits = new JButton("Patient Visits");
		btnPatientVisits.setBounds(228, 251, 126, 29);
		add(btnPatientVisits);
		btnPatientVisits.addActionListener(listener);
		
		btnViewMessages = new JButton("View Messages");
		btnViewMessages.setBounds(622, 218, 138, 29);
		add(btnViewMessages);
		btnViewMessages.addActionListener(listener);
		
		btnRecordASurgery = new JButton("Record a Surgery");
		btnRecordASurgery.setBounds(228, 284, 149, 29);
		add(btnRecordASurgery);
		btnRecordASurgery.addActionListener(listener);
		
		btnCommunicate = new JButton("Communicate");
		btnCommunicate.setBounds(228, 317, 131, 29);
		add(btnCommunicate);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(228, 387, 117, 29);
		add(btnLogout);
		btnLogout.addActionListener(listener);
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
				
			} else if (e.getSource() == btnViewMessages) {
				InboxPanel ip = new InboxPanel(parent, username);
				parent.getContentPane().add(ip);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
			} else if (e.getSource() == btnLogout) {
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			}
		}
		
	}
}
