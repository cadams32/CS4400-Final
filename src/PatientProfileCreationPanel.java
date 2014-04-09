import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;


public class PatientProfileCreationPanel extends JPanel {
	
	private JTextField patientNameTxtField;
	private JTextField addressTxtField;
	private JTextField allergiesTxtField;
	private JTextField homePhoneTxtField;
	private JTextField workPhoneTxtField;
	private JTextField weightTxtField;
	private JTextField heightTxtField;
	private JTextField dateOfBirthTxtField;
	private JButton btnSubmit;
	private JButton allergyButton;
	
	private String name, gender, dateOfBirth, address, height, weight, homePhone, workPhone, allergies;
	
	/**
	 * Create the panel.
	 */
	public PatientProfileCreationPanel() {
		setLayout(new MigLayout("", "[][][][151.00,grow][grow]", "[][][][][][][][][][][][][]"));
		
		JLabel lblPatientName = new JLabel("Patient Name");
		add(lblPatientName, "cell 2 1,alignx trailing");
		
		patientNameTxtField = new JTextField();
		add(patientNameTxtField, "cell 3 1");
		patientNameTxtField.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		add(lblDateOfBirth, "cell 2 2,alignx trailing");
		
		dateOfBirthTxtField = new JTextField();
		add(dateOfBirthTxtField, "cell 3 2,alignx left");
		dateOfBirthTxtField.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		add(lblGender, "cell 2 3,alignx trailing");
		
		String[] genderOption = {"Male", "Female"};
		JComboBox genderComboBox = new JComboBox(genderOption);
		add(genderComboBox, "cell 3 3");
		
		JLabel lblAddress = new JLabel("Address");
		add(lblAddress, "cell 2 4,alignx trailing");
		
		addressTxtField = new JTextField();
		add(addressTxtField, "cell 3 4");
		addressTxtField.setColumns(10);
		
		JLabel lblHomePhone = new JLabel("Home Phone");
		add(lblHomePhone, "cell 2 5,alignx trailing");
		
		homePhoneTxtField = new JTextField();
		add(homePhoneTxtField, "cell 3 5,alignx left");
		homePhoneTxtField.setColumns(10);
		
		JLabel lblWorkPhone = new JLabel("Work Phone");
		add(lblWorkPhone, "cell 2 6,alignx trailing");
		
		workPhoneTxtField = new JTextField();
		add(workPhoneTxtField, "cell 3 6,alignx left");
		workPhoneTxtField.setColumns(10);
		
		JLabel lblWeight = new JLabel("Weight");
		add(lblWeight, "cell 2 7,alignx trailing");
		
		weightTxtField = new JTextField();
		add(weightTxtField, "cell 3 7,alignx left");
		weightTxtField.setColumns(10);
		
		JLabel lblHeight = new JLabel("Height");
		add(lblHeight, "cell 2 8,alignx trailing");
		
		heightTxtField = new JTextField();
		add(heightTxtField, "cell 3 8,alignx left");
		heightTxtField.setColumns(10);
		
		JLabel lblAnnualIncome = new JLabel("Annual Income ($)");
		add(lblAnnualIncome, "cell 2 9,alignx trailing");
		
		JLabel lblAllergies = new JLabel("Allergies");
		add(lblAllergies, "cell 2 10,alignx trailing");
		
		allergiesTxtField = new JTextField();
		add(allergiesTxtField, "flowx,cell 3 10");
		allergiesTxtField.setColumns(10);
		
		allergyButton = new JButton("+");
		add(allergyButton, "cell 3 10");
		
		btnSubmit = new JButton("Submit");
		add(btnSubmit, "cell 4 12");
		
	}
	
	private boolean checkValidity() {
		//this is where we check everything for proper input.
		
		
		return false;
		
	}
	
	private void insertDatabase() {
		//insert into databse
		
	}
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == btnSubmit) {
				if (checkValidity()) {
					insertDatabase();
				}
			}
		
		}
		

	}
}
