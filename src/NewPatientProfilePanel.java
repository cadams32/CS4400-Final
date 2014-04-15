import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;


public class NewPatientProfilePanel extends JPanel {
	
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
	private MedicalFrame parent;
	
	private String name, gender, dateOfBirth, address, height, weight, homePhone, workPhone, allergies;
	
	/**
	 * Create the panel.
	 */
	public NewPatientProfilePanel(MedicalFrame parent) {
		
		this.parent = parent;
		
		setLayout(new MigLayout("", "[96.00][][319.00,grow][111.00,grow][][]", "[-1.00][110.00][][][][][][][][][][17.00][][-69.00][][][]"));
		
		JLabel lblPatientName = new JLabel("Patient Name");
		add(lblPatientName, "cell 1 2,alignx trailing");
		
		patientNameTxtField = new JTextField();
		add(patientNameTxtField, "cell 2 2");
		patientNameTxtField.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		add(lblDateOfBirth, "cell 1 3,alignx trailing");
		
		dateOfBirthTxtField = new JTextField();
		add(dateOfBirthTxtField, "cell 2 3,alignx left");
		dateOfBirthTxtField.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		add(lblGender, "cell 1 4,alignx trailing");
		
		String[] genderOption = {"Male", "Female"};
		JComboBox genderComboBox = new JComboBox(genderOption);
		add(genderComboBox, "cell 2 4");
		
		JLabel lblAddress = new JLabel("Address");
		add(lblAddress, "cell 1 5,alignx trailing");
		
		addressTxtField = new JTextField();
		add(addressTxtField, "cell 2 5");
		addressTxtField.setColumns(10);
		
		JLabel lblHomePhone = new JLabel("Home Phone");
		add(lblHomePhone, "cell 1 6,alignx trailing");
		
		homePhoneTxtField = new JTextField();
		add(homePhoneTxtField, "cell 2 6,alignx left");
		homePhoneTxtField.setColumns(10);
		
		JLabel lblWorkPhone = new JLabel("Work Phone");
		add(lblWorkPhone, "cell 1 7,alignx trailing");
		
		workPhoneTxtField = new JTextField();
		add(workPhoneTxtField, "cell 2 7,alignx left");
		workPhoneTxtField.setColumns(10);
		
		JLabel lblWeight = new JLabel("Weight");
		add(lblWeight, "cell 1 8,alignx trailing");
		
		weightTxtField = new JTextField();
		add(weightTxtField, "cell 2 8,alignx left");
		weightTxtField.setColumns(10);
		
		JLabel lblHeight = new JLabel("Height");
		add(lblHeight, "cell 1 9,alignx trailing");
		
		heightTxtField = new JTextField();
		add(heightTxtField, "cell 2 9,alignx left");
		heightTxtField.setColumns(10);
		
		JLabel lblAnnualIncome = new JLabel("Annual Income ($)");
		add(lblAnnualIncome, "cell 1 10,alignx trailing");
		
		JLabel lblAllergies = new JLabel("Allergies");
		add(lblAllergies, "cell 1 11,alignx trailing");
		
		allergiesTxtField = new JTextField();
		add(allergiesTxtField, "flowx,cell 2 11");
		allergiesTxtField.setColumns(10);
		
		allergyButton = new JButton("+");
		add(allergyButton, "cell 2 11");
		
		btnSubmit = new JButton("Submit");
		add(btnSubmit, "cell 3 12");
		
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
