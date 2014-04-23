import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class LoginPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	JButton btnAdminLogin, btnCreateNewAccount;
	MedicalFrame parent;
	
	/**
	 * Create the panel.
	 */
	public LoginPanel(MedicalFrame parent) {
		
		ButtonListener listener = new ButtonListener();
		
		setLayout(new MigLayout("", "[1000.00,grow]", "[99.00][495.00,grow]"));
		this.parent = parent;
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 1,grow");
		panel.setLayout(new MigLayout("", "[][][][][][grow][][][][][][grow][grow][][][][][][][][][][][][][][][-22.00][]", "[70.00][][][][280.00][][][]"));
		
		JLabel lblUsername = new JLabel("Username:");
		panel.add(lblUsername, "cell 9 1");
		
		textField = new JTextField();
		panel.add(textField, "cell 11 1 10 1,growx");
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		panel.add(lblPassword, "cell 9 3");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "cell 11 3 10 1,growx");
		textField_1.setColumns(10);
		
		btnCreateNewAccount = new JButton("Create New Account");
		panel.add(btnCreateNewAccount, "cell 25 7");
		btnCreateNewAccount.addActionListener(listener);
		
		btnAdminLogin = new JButton("Login");
		panel.add(btnAdminLogin, "cell 28 7");
		btnAdminLogin.addActionListener(listener);
		
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
			else if(e.getSource() == btnCreateNewAccount){
				NewUserPanel nup = new NewUserPanel(parent);
				parent.getContentPane().add(nup);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
			}
		}
	}
}
