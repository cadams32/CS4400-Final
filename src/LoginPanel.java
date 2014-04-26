import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;


public class LoginPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	JButton btnAdminLogin, btnCreateNewAccount;
	MedicalFrame parent;
	private JButton btnPatientHome;
	private JButton btnDoctorHome;
	private JButton btnAdminHome;
	
	/**
	 * Create the panel.
	 */
	public LoginPanel(MedicalFrame parent) {
		setBackground(SystemColor.textHighlight);
		this.setBounds(100, 100, 1000, 600);
		
		ButtonListener listener = new ButtonListener();
		this.parent = parent;
		setLayout(null);
		
		btnAdminLogin = new JButton("Login");
		btnAdminLogin.setBounds(618, 392, 79, 29);
		add(btnAdminLogin);
		
		btnCreateNewAccount = new JButton("Create New Account");
		btnCreateNewAccount.setBounds(319, 392, 171, 29);
		add(btnCreateNewAccount);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(344, 197, 66, 16);
		add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(418, 191, 255, 28);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(344, 233, 63, 16);
		add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(418, 227, 255, 28);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblGtmrsLogin = new JLabel("GTMRS Login");
		lblGtmrsLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblGtmrsLogin.setBounds(426, 42, 247, 41);
		add(lblGtmrsLogin);
		
		btnCreateNewAccount.addActionListener(listener);
		btnAdminLogin.addActionListener(listener);

		btnPatientHome = new JButton("Patient Home");
		btnPatientHome.setBounds(827, 548, 117, 29);
		add(btnPatientHome);
		btnPatientHome.addActionListener(listener);
		
		btnDoctorHome = new JButton("Doctor Home");
		btnDoctorHome.setBounds(698, 548, 117, 29);
		add(btnDoctorHome);
		btnDoctorHome.addActionListener(listener);
		
		btnAdminHome = new JButton("Admin Home");
		btnAdminHome.setBounds(572, 548, 117, 29);
		add(btnAdminHome);
		btnAdminHome.addActionListener(listener);
	}
	
private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			
			if(e.getSource() == btnAdminLogin){
				if(!textField.getText().equals("") && !textField_1.getText().equals("")) {
					String check = parent.getHandler().login(textField.getText(), textField_1.getText());
					if (check.equals("Patient")) {
						PatientHomePanel php = new PatientHomePanel(parent, textField.getText());
						parent.getContentPane().add(php);
						CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
						cl.next(parent.getContentPane());
					} else if (check.equals("Doctor")) {
						DoctorHomePanel dhp = new DoctorHomePanel(parent, textField.getText());
						parent.getContentPane().add(dhp);
						CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
						cl.next(parent.getContentPane());
					} else if (check.equals("Admin")) {
						AdminHomePanel ahp = new AdminHomePanel(parent, textField.getText());
						parent.getContentPane().add(ahp);
						CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
						cl.next(parent.getContentPane());
					} else if (check.equals("Invalid")) {
					
					}
				}
			}
			else if (e.getSource() == btnPatientHome) {
				PatientHomePanel php = new PatientHomePanel(parent, "PatientZero");
				parent.getContentPane().add(php);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
			}
			else if (e.getSource() == btnDoctorHome) {
				DoctorHomePanel dhp = new DoctorHomePanel(parent, "DoctorDoctor");
				parent.getContentPane().add(dhp);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
			}
			else if (e.getSource() == btnAdminHome) {
				AdminHomePanel ahp = new AdminHomePanel(parent, "Administrator");
				parent.getContentPane().add(ahp);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
			}
			else if(e.getSource() == btnCreateNewAccount){
				NewUserPanel nup = new NewUserPanel(parent);
				parent.getContentPane().add(nup);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
			}
		}
	}
}
