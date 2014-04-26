
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import Backend.Patient;
import java.awt.Font;


public class PatientEditProfilePanel extends JPanel {
	private JTextField patientNameTextField;
	private JTextField dateOfBirthTextField;
	private JTextField addressTextField;
	private JTextField homePhoneTextField;
	private JTextField workPhoneTextField;
	private JTextField weightTextField;
	private JTextField heightTextField;
	private JTextField allergyTextField;
	private JTextField eContactNameTxtField;
	private JTextField eContactPhoneTxtField;
	private JTextField allergiesTxtField;
	
	private MedicalFrame parent;
	private String username;
	
	private JButton btnSubmit;
	private JButton btnBack;
	private JButton btnAddAllergy;
	
	private JComboBox genderComboBox;
	private JComboBox annualIncomeComboBox;
	
	private JList list;
	private DefaultListModel model;

	private Object[] listData = {"Nothing"};
	private ArrayList<String> allergyList;
	private JLabel lblEditPatientProfile;

	/**
	 * Create the panel.
	 */
	public PatientEditProfilePanel(MedicalFrame parent, String username) {
		setBackground(SystemColor.textHighlight);
		
		allergyList = new ArrayList<String>();
		
		this.parent = parent;
		this.username = username;
		this.setBounds(100, 100, 1000, 600);
		ButtonListener listener = new ButtonListener();
		setLayout(null);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setBounds(295, 113, 83, 16);
		add(lblPatientName);
		
		patientNameTextField = new JTextField();
		patientNameTextField.setBounds(382, 107, 134, 28);
		add(patientNameTextField);
		patientNameTextField.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(299, 145, 79, 16);
		add(lblDateOfBirth);
		
		dateOfBirthTextField = new JTextField();
		dateOfBirthTextField.setBounds(382, 139, 134, 28);
		add(dateOfBirthTextField);
		dateOfBirthTextField.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(325, 172, 42, 16);
		add(lblGender);
		
		String[] genderOption = {"Male", "Female"};
		genderComboBox = new JComboBox(genderOption);
		genderComboBox.setBounds(382, 171, 100, 27);
		add(genderComboBox);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(319, 208, 51, 16);
		add(lblAddress);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(382, 202, 134, 28);
		add(addressTextField);
		addressTextField.setColumns(10);
		
		JLabel lblHomePhone = new JLabel("Home Phone");
		lblHomePhone.setBounds(299, 240, 79, 16);
		add(lblHomePhone);
		
		homePhoneTextField = new JTextField();
		homePhoneTextField.setBounds(382, 234, 134, 28);
		add(homePhoneTextField);
		homePhoneTextField.setColumns(10);
		
		JLabel lblWorkPhone = new JLabel("Work Phone");
		lblWorkPhone.setBounds(304, 272, 74, 16);
		add(lblWorkPhone);
		
		workPhoneTextField = new JTextField();
		workPhoneTextField.setBounds(382, 266, 134, 28);
		add(workPhoneTextField);
		workPhoneTextField.setColumns(10);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(325, 373, 43, 16);
		add(lblWeight);
		
		weightTextField = new JTextField();
		weightTextField.setBounds(382, 367, 134, 28);
		add(weightTextField);
		weightTextField.setColumns(10);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setBounds(325, 402, 42, 16);
		add(lblHeight);
		
		heightTextField = new JTextField();
		heightTextField.setBounds(382, 396, 134, 28);
		add(heightTextField);
		heightTextField.setColumns(10);
		
		JLabel lblAnnualIncome = new JLabel("Annual Income ($)");
		lblAnnualIncome.setBounds(264, 429, 114, 16);
		add(lblAnnualIncome);
		
		JLabel lblAllergies = new JLabel("Allergies");
		lblAllergies.setBounds(319, 468, 55, 16);
		add(lblAllergies);
		
		allergiesTxtField = new JTextField();
		allergiesTxtField.setBounds(385, 462, 134, 28);
		add(allergiesTxtField);
		allergiesTxtField.setColumns(10);
		
		btnAddAllergy = new JButton("+");
		btnAddAllergy.setBounds(529, 462, 75, 29);
		btnAddAllergy.addActionListener(listener);
		add(btnAddAllergy);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(794, 539, 88, 29);
		btnSubmit.addActionListener(listener);
		add(btnSubmit);
		btnSubmit.addActionListener(listener);
		
		JLabel lblAllergies_1 = new JLabel("Allergies");
		lblAllergies_1.setBounds(648, 91, 61, 16);
		add(lblAllergies_1);
		
		String[] annualIncomeBox = {"10000-25000", "25000-50000", "50000-75000", "75000-100000", "100000-150000", "1500000-200000", "More than 200000"};
		annualIncomeComboBox = new JComboBox(annualIncomeBox);
		annualIncomeComboBox.setBounds(382, 428, 150, 27);
		add(annualIncomeComboBox);
		
		JLabel lblEmergencyContact = new JLabel("Emergency Contact Name");
		lblEmergencyContact.setBounds(233, 304, 134, 16);
		add(lblEmergencyContact);
		
		eContactNameTxtField = new JTextField();
		eContactNameTxtField.setBounds(382, 298, 145, 28);
		add(eContactNameTxtField);
		eContactNameTxtField.setColumns(10);
		
		JLabel eContactPhonelbl = new JLabel("Emergency Contact Phone");
		eContactPhonelbl.setBounds(233, 336, 134, 16);
		add(eContactPhonelbl);
		
		eContactPhoneTxtField = new JTextField();
		eContactPhoneTxtField.setColumns(10);
		eContactPhoneTxtField.setBounds(382, 330, 145, 28);
		add(eContactPhoneTxtField);	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(610, 110, 145, 178);
		add(scrollPane);
		
		model = new DefaultListModel();
		list = new JList(model);
		scrollPane.setViewportView(list);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(162, 520, 117, 29);
		add(btnBack);
		
		lblEditPatientProfile = new JLabel("Edit Patient Profile");
		lblEditPatientProfile.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblEditPatientProfile.setBounds(399, 23, 356, 41);
		add(lblEditPatientProfile);
		btnBack.addActionListener(listener);
		
		populateFields();
	}
	
	public void populateFields(){
		Patient p = parent.getHandler().getOnePatient(username);
		patientNameTextField.setText(p.getName());
		dateOfBirthTextField.setText(p.getDob());
		genderComboBox.setSelectedIndex(p.getGender().equals("Male")?0:1);
		addressTextField.setText(p.getAddress());
		homePhoneTextField.setText(p.getHomephone());
		workPhoneTextField.setText(p.getWorkphone());
		weightTextField.setText(p.getWeight());
		heightTextField.setText(p.getHeight());
		annualIncomeComboBox.setSelectedItem(p.getAnnualIncome());
		eContactNameTxtField.setText(p.getEmerContactName());
		eContactPhoneTxtField.setText(p.getEmerContactPhone());
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnBack) {
				//Go Back to prev page
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
				
			} else if (e.getSource() == btnSubmit) {
				//update the DB with the changes
				
				String name = patientNameTextField.getText();
				String DOB = dateOfBirthTextField.getText();
				String gender = (String) genderComboBox.getSelectedItem();
				String address = addressTextField.getText();
				String workPhone = workPhoneTextField.getText();
				String homePhone = homePhoneTextField.getText();
				String eContactName = eContactNameTxtField.getText();
				String eContactPhone = eContactPhoneTxtField.getText();
				String annualIncome = (String) annualIncomeComboBox.getSelectedItem();
				
				if ((name.equals("")) || (DOB.equals("")) || (gender == null) || (address.equals("")) || (workPhone.equals("")) || (homePhone.equals("")) 
						|| (eContactName.equals("")) || (eContactPhone.equals("")) || (annualIncome == null)) {
					
					JOptionPane.showMessageDialog(null, "Empty value. All field must be filled.");
				} else if ((!parent.nameTest(name)) && (!parent.dateTest(DOB)) && (!parent.phoneNumberTest(workPhone)) && (!parent.phoneNumberTest(homePhone)) 
						&& (!parent.nameTest(eContactName)) && (!parent.phoneNumberTest(eContactPhone)) && (!parent.numTest(weightTextField.getText())) 
						&& (!parent.numTest(heightTextField.getText()))) {
					
					JOptionPane.showMessageDialog(null, "Incorrect value, please try again.");
				} else {
					if(parent.getHandler().updatePatientProfile(username, name, DOB, gender, address, 
							workPhone, homePhone, eContactName, eContactPhone, 
							Integer.parseInt(weightTextField.getText()), Integer.parseInt(heightTextField.getText()), annualIncome)) {
						
						if(!allergyList.isEmpty()) {
							for(String s : allergyList) {
								parent.getHandler().addNewPatientAllergy(username, s);
							}
						}
						
						CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
						parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
						PatientHomePanel php = new PatientHomePanel(parent, username);
						parent.getContentPane().add(php);
						cl.last(parent.getContentPane());
					}
				}
				
			} else if (e.getSource() == btnAddAllergy) {
				allergyList.add(allergiesTxtField.getText());
				model.addElement(allergiesTxtField.getText());
				list = new JList(model);
			}
			
		}
		
	}

}
