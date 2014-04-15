import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewDoctorProfilePanel extends JPanel {
	private JTextField licenseTextField;
	private JTextField FnameTextField;
	private JTextField LnameTextField;
	private JTextField DOBTextField;
	private JTextField workPhoneTextField;
	private JTextField addressTextField;
	private JLabel licenseLabel;
	private JLabel fnameLabel;
	private JLabel lnameLabel;
	private JLabel DOBLabel;
	private JLabel wPhoneLabel;
	private JLabel specialtyLabel;
	private JLabel addressLabel;
	private JLabel availLabel;
	private JComboBox<String> cbSpecialty;
	private JComboBox<String> cbDays;
	private JComboBox<String> cbFromTime;
	private JComboBox<String> cbToTime; 
	JButton btnAddAvail, btnCreateProfile;
	MedicalFrame parent;

	/**
	 * Create the panel.
	 */
	public NewDoctorProfilePanel(MedicalFrame parent) {
		setLayout(new MigLayout("", "[1000.00,grow]", "[100.00][491.00,grow]"));
		ButtonListener listener = new ButtonListener();
		this.parent = parent;
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 1,grow");
		panel.setLayout(new MigLayout("", "[199.00][][][grow][][][][][][][][23.00][][][][][grow]", "[][][][][][][][][][][142.00][36.00]"));
		
		licenseLabel = new JLabel("License Numer");
		panel.add(licenseLabel, "cell 1 3");
		
		licenseTextField = new JTextField();
		panel.add(licenseTextField, "cell 3 3 10 1,growx");
		licenseTextField.setColumns(10);
		
		fnameLabel = new JLabel("First Name");
		panel.add(fnameLabel, "cell 1 5");
		
		FnameTextField = new JTextField();
		panel.add(FnameTextField, "cell 3 5 10 1,growx");
		FnameTextField.setColumns(10);
		
		lnameLabel = new JLabel("Last Name");
		panel.add(lnameLabel, "cell 1 7");
		
		LnameTextField = new JTextField();
		panel.add(LnameTextField, "cell 3 7 10 1,growx");
		LnameTextField.setColumns(10);
		
		DOBLabel = new JLabel("Date of Birth");
		panel.add(DOBLabel, "cell 1 7");
		
		DOBTextField = new JTextField();
		panel.add(DOBTextField, "cell 3 7 10 1,growx");
		DOBTextField.setColumns(10);
		
		wPhoneLabel = new JLabel("Work Phone");
		panel.add(wPhoneLabel, "cell 1 7");
			
		workPhoneTextField = new JTextField();
		panel.add(workPhoneTextField, "cell 3 7 10 1,growx");
		workPhoneTextField.setColumns(10);
		
		String[] user_opSpecial = {"General Physician", " Heart Specialist", "Eye Physician",
				"Orthopedics", "Psyciatry", "GyneCologist"};
		
		specialtyLabel = new JLabel("Specialty");
		panel.add(specialtyLabel, "cell 1 9");
		cbSpecialty = new JComboBox<String>(user_opSpecial);
		panel.add(cbSpecialty, "cell 3 9 10 1,growx");
		
		addressLabel = new JLabel("Address");
		panel.add(addressLabel, "cell 1 7");
			
		addressTextField = new JTextField();
		panel.add(addressTextField, "cell 3 7 10 1,growx");
		addressTextField.setColumns(10);
		
		availLabel = new JLabel("Availablity");
		panel.add(availLabel, "cell 1 7");
		
		String[] user_opDays = {};
		String[] user_opTime = {};
		
		cbDays = new JComboBox<String>(user_opDays);
		panel.add(cbDays, "cell 3 9 10 1,growx");
		
		cbFromTime = new JComboBox<String>(user_opTime);
		panel.add(cbFromTime, "cell 3 9 10 1,growx");
		
		cbToTime = new JComboBox<String>(user_opTime);
		panel.add(cbToTime, "cell 3 9 10 1,growx");
		
		btnAddAvail = new JButton("Add Availablility");
		panel.add(btnAddAvail, "cell 25 5");
		btnAddAvail.addActionListener(listener);
		
		btnCreateProfile = new JButton("Create Profile");
		panel.add(btnCreateProfile, "cell 28 5");
		btnCreateProfile.addActionListener(listener);
	}
	
	private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == btnAddAvail){
				
			}
			else if(e.getSource() == btnCreateProfile){

			}
		}
	}

}
