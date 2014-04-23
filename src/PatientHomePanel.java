
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PatientHomePanel extends JPanel {
	
	
	private MedicalFrame parent;
	private String username;
	
	private JLabel lblPatient;
	private JLabel lblYouHaveMessages;
	JButton btnMakeAppointments, btnEditProfile, btnViewVisitHistory, btnViewMessages, btnOrderMedication, btnCommunicate, btnRateADoctor;

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
			}
		}
		
	}

}
