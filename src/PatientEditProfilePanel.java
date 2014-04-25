
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

	/**
	 * Create the panel.
	 */
	public PatientEditProfilePanel(MedicalFrame parent, String username) {
		
		allergyList = new ArrayList<String>();
		
		this.parent = parent;
		this.username = username;
		
		ButtonListener listener = new ButtonListener();
		setLayout(null);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setBounds(108, 70, 83, 16);
		add(lblPatientName);
		
		patientNameTextField = new JTextField();
		patientNameTextField.setBounds(195, 64, 134, 28);
		add(patientNameTextField);
		patientNameTextField.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(112, 102, 79, 16);
		add(lblDateOfBirth);
		
		dateOfBirthTextField = new JTextField();
		dateOfBirthTextField.setBounds(195, 96, 134, 28);
		add(dateOfBirthTextField);
		dateOfBirthTextField.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(138, 129, 42, 16);
		add(lblGender);
		
		String[] genderOption = {"Male", "Female"};
		genderComboBox = new JComboBox(genderOption);
		genderComboBox.setBounds(195, 128, 100, 27);
		add(genderComboBox);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(132, 165, 51, 16);
		add(lblAddress);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(195, 159, 134, 28);
		add(addressTextField);
		addressTextField.setColumns(10);
		
		JLabel lblHomePhone = new JLabel("Home Phone");
		lblHomePhone.setBounds(112, 197, 79, 16);
		add(lblHomePhone);
		
		homePhoneTextField = new JTextField();
		homePhoneTextField.setBounds(195, 191, 134, 28);
		add(homePhoneTextField);
		homePhoneTextField.setColumns(10);
		
		JLabel lblWorkPhone = new JLabel("Work Phone");
		lblWorkPhone.setBounds(117, 229, 74, 16);
		add(lblWorkPhone);
		
		workPhoneTextField = new JTextField();
		workPhoneTextField.setBounds(195, 223, 134, 28);
		add(workPhoneTextField);
		workPhoneTextField.setColumns(10);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(138, 330, 43, 16);
		add(lblWeight);
		
		weightTextField = new JTextField();
		weightTextField.setBounds(195, 324, 134, 28);
		add(weightTextField);
		weightTextField.setColumns(10);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setBounds(138, 359, 42, 16);
		add(lblHeight);
		
		heightTextField = new JTextField();
		heightTextField.setBounds(195, 353, 134, 28);
		add(heightTextField);
		heightTextField.setColumns(10);
		
		JLabel lblAnnualIncome = new JLabel("Annual Income ($)");
		lblAnnualIncome.setBounds(77, 386, 114, 16);
		add(lblAnnualIncome);
		
		JLabel lblAllergies = new JLabel("Allergies");
		lblAllergies.setBounds(132, 425, 55, 16);
		add(lblAllergies);
		
		allergiesTxtField = new JTextField();
		allergiesTxtField.setBounds(198, 419, 134, 28);
		add(allergiesTxtField);
		allergiesTxtField.setColumns(10);
		
		btnAddAllergy = new JButton("+");
		btnAddAllergy.setBounds(342, 419, 75, 29);
		btnAddAllergy.addActionListener(listener);
		add(btnAddAllergy);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(577, 509, 88, 29);
		btnSubmit.addActionListener(listener);
		add(btnSubmit);
		btnSubmit.addActionListener(listener);
		
		JLabel lblAllergies_1 = new JLabel("Allergies");
		lblAllergies_1.setBounds(461, 48, 61, 16);
		add(lblAllergies_1);
		
		String[] annualIncomeBox = {"10000-25000", "25000-50000", "50000-75000", "75000-100000", "100000-150000", "1500000-200000", "More than 200000"};
		annualIncomeComboBox = new JComboBox(annualIncomeBox);
		annualIncomeComboBox.setBounds(195, 385, 150, 27);
		add(annualIncomeComboBox);
		
		JLabel lblEmergencyContact = new JLabel("Emergency Contact Name");
		lblEmergencyContact.setBounds(46, 261, 134, 16);
		add(lblEmergencyContact);
		
		eContactNameTxtField = new JTextField();
		eContactNameTxtField.setBounds(195, 255, 145, 28);
		add(eContactNameTxtField);
		eContactNameTxtField.setColumns(10);
		
		JLabel eContactPhonelbl = new JLabel("Emergency Contact Phone");
		eContactPhonelbl.setBounds(46, 293, 134, 16);
		add(eContactPhonelbl);
		
		eContactPhoneTxtField = new JTextField();
		eContactPhoneTxtField.setColumns(10);
		eContactPhoneTxtField.setBounds(195, 287, 145, 28);
		add(eContactPhoneTxtField);	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(423, 67, 145, 178);
		add(scrollPane);
		
		model = new DefaultListModel();
		list = new JList(model);
		scrollPane.setViewportView(list);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(39, 509, 117, 29);
		add(btnBack);
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
								System.out.println(s);
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
