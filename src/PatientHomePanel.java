
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;


public class PatientHomePanel extends JPanel {
	
	
	private MedicalFrame parent;
	private String username;
	
	private JLabel lblPatient;
	private JLabel lblYouHaveMessages;
	private JButton btnMakeAppointments, btnEditProfile, btnViewVisitHistory, btnLogout, btnViewMessages, btnOrderMedication, btnCommunicate, btnRateADoctor;

	/**
	 * Create the panel.
	 */
	public PatientHomePanel(MedicalFrame parent, String username) {
		setBackground(SystemColor.textHighlight);
		
		this.parent = parent;
		this.username = username;
		this.setBounds(100, 100, 1000, 600);
		
		ButtonListener listener = new ButtonListener();
		setLayout(null);
		
		JLabel lblPatient = new JLabel("Patient Home");
		lblPatient.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblPatient.setBounds(411, 49, 307, 76);
		add(lblPatient);
		
		btnMakeAppointments = new JButton("Make Appointments");
		btnMakeAppointments.setBounds(267, 175, 170, 29);
		add(btnMakeAppointments);
		btnMakeAppointments.addActionListener(listener);
		
		btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.setBounds(267, 340, 112, 29);
		add(btnEditProfile);
		btnEditProfile.addActionListener(listener);
		
		btnViewVisitHistory = new JButton("View Visit History");
		btnViewVisitHistory.setBounds(267, 208, 155, 29);
		add(btnViewVisitHistory);
		btnViewVisitHistory.addActionListener(listener);
		
		lblYouHaveMessages = new JLabel("Inbox");
		lblYouHaveMessages.setBounds(580, 180, 123, 16);
		add(lblYouHaveMessages);
		
		btnOrderMedication = new JButton("Order Medication");
		btnOrderMedication.setBounds(267, 241, 152, 29);
		add(btnOrderMedication);
		btnOrderMedication.addActionListener(listener);
		
		btnCommunicate = new JButton("Communicate");
		btnCommunicate.setBounds(267, 274, 131, 29);
		add(btnCommunicate);
		btnCommunicate.addActionListener(listener);
		
		btnRateADoctor = new JButton("Rate A Doctor");
		btnRateADoctor.setBounds(267, 307, 131, 29);
		add(btnRateADoctor);
		btnRateADoctor.addActionListener(listener);
		
		//Added this one.
		btnViewMessages = new JButton("View Messages");
		btnViewMessages.setBounds(533, 208, 138, 29);
		add(btnViewMessages);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(267, 382, 117, 29);
		add(btnLogout);
		btnLogout.addActionListener(listener);
		btnViewMessages.addActionListener(listener);

	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnMakeAppointments) {
				//GOTO make appointments
				ViewAppointmentPanel vap = new ViewAppointmentPanel(parent, username);
				parent.getContentPane().add(vap);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
			}
			else if (e.getSource() == btnEditProfile) {
				//GOTO edit profile
				PatientEditProfilePanel pepp = new PatientEditProfilePanel(parent, username);
				parent.getContentPane().add(pepp);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
			}
			else if (e.getSource() == btnViewVisitHistory) {
				//GOTO View Visit History
				ViewVisitHistoryPanel vvhp = new ViewVisitHistoryPanel(parent, username);
				parent.getContentPane().add(vvhp);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
			}
			else if (e.getSource() == btnOrderMedication) {
				//GOTO Order Medication
				OrderMedicationPanel omp = new OrderMedicationPanel(parent, username);
				parent.getContentPane().add(omp);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
			}
			else if (e.getSource() == btnCommunicate) {
				//GOTO communicate
				PatientMessagingPanel pmp = new PatientMessagingPanel(parent, username);
				parent.getContentPane().add(pmp);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
			}
			else if (e.getSource() == btnRateADoctor) {
				//GOTO rate a doctor
				RateDoctorPanel rdp = new RateDoctorPanel(parent, username);
				parent.getContentPane().add(rdp);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
			}
			else if (e.getSource() == btnViewMessages){
				//GOTO view messages
				InboxPanel ip = new InboxPanel(parent, username);
				parent.getContentPane().add(ip);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
			} else if (e.getSource() == btnLogout){
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			}
		}
		
	}
}
