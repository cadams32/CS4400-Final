import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListModel;


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
	private String username;
	private String password;
	private JComboBox genderComboBox;
	private JTextField eContactNameTxtField;
	private JTextField eContactPhoneTxtField;
	private JComboBox annualIncomeComboBox;
	
	private JList list;
	private DefaultListModel model;
	
	private Object[] listData = {"Nothing"};
	private ArrayList<String> allergies = new ArrayList<String>();
	
	/**
	 * Create the panel.
	 */
	public NewPatientProfilePanel(MedicalFrame parent, String username, String password) {
		
		this.parent = parent;
		this.username = username;
		this.password = password;
		
		ButtonListener listener = new ButtonListener();
		setLayout(null);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setBounds(108, 70, 83, 16);
		add(lblPatientName);
		
		patientNameTxtField = new JTextField();
		patientNameTxtField.setBounds(195, 64, 134, 28);
		add(patientNameTxtField);
		patientNameTxtField.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(112, 102, 79, 16);
		add(lblDateOfBirth);
		
		dateOfBirthTxtField = new JTextField();
		dateOfBirthTxtField.setBounds(195, 96, 134, 28);
		add(dateOfBirthTxtField);
		dateOfBirthTxtField.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(147, 132, 44, 16);
		add(lblGender);
		
		String[] genderOption = {"Male", "Female"};
		genderComboBox = new JComboBox(genderOption);
		genderComboBox.setBounds(195, 128, 100, 27);
		add(genderComboBox);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(140, 165, 51, 16);
		add(lblAddress);
		
		addressTxtField = new JTextField();
		addressTxtField.setBounds(195, 159, 134, 28);
		add(addressTxtField);
		addressTxtField.setColumns(10);
		
		JLabel lblHomePhone = new JLabel("Home Phone");
		lblHomePhone.setBounds(112, 197, 79, 16);
		add(lblHomePhone);
		
		homePhoneTxtField = new JTextField();
		homePhoneTxtField.setBounds(195, 191, 134, 28);
		add(homePhoneTxtField);
		homePhoneTxtField.setColumns(10);
		
		JLabel lblWorkPhone = new JLabel("Work Phone");
		lblWorkPhone.setBounds(117, 229, 74, 16);
		add(lblWorkPhone);
		
		workPhoneTxtField = new JTextField();
		workPhoneTxtField.setBounds(195, 223, 134, 28);
		add(workPhoneTxtField);
		workPhoneTxtField.setColumns(10);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(151, 320, 43, 16);
		add(lblWeight);
		
		weightTxtField = new JTextField();
		weightTxtField.setBounds(198, 314, 134, 28);
		add(weightTxtField);
		weightTxtField.setColumns(10);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setBounds(152, 352, 42, 16);
		add(lblHeight);
		
		heightTxtField = new JTextField();
		heightTxtField.setBounds(198, 346, 134, 28);
		add(heightTxtField);
		heightTxtField.setColumns(10);
		
		JLabel lblAnnualIncome = new JLabel("Annual Income ($)");
		lblAnnualIncome.setBounds(80, 378, 114, 16);
		add(lblAnnualIncome);
		
		JLabel lblAllergies = new JLabel("Allergies");
		lblAllergies.setBounds(139, 404, 55, 16);
		add(lblAllergies);
		
		allergiesTxtField = new JTextField();
		allergiesTxtField.setBounds(198, 398, 134, 28);
		add(allergiesTxtField);
		allergiesTxtField.setColumns(10);
		
		allergyButton = new JButton("+");
		allergyButton.setBounds(336, 399, 75, 29);
		allergyButton.addActionListener(listener);
		add(allergyButton);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(512, 385, 88, 29);
		btnSubmit.addActionListener(listener);
		add(btnSubmit);
		
		JLabel lblAllergies_1 = new JLabel("Allergies");
		lblAllergies_1.setBounds(461, 48, 61, 16);
		add(lblAllergies_1);
		
		String[] annualIncomeBox = {"10000-25000", "25000-50000", "50000-75000", "75000-100000", "100000-150000", "1500000-200000", "More than 200000"};
		annualIncomeComboBox = new JComboBox(annualIncomeBox);
		annualIncomeComboBox.setBounds(198, 374, 150, 27);
		add(annualIncomeComboBox);
		
		JLabel lblEmergencyContact = new JLabel("Emergency Contact Name");
		lblEmergencyContact.setBounds(25, 261, 178, 16);
		add(lblEmergencyContact);
		
		eContactNameTxtField = new JTextField();
		eContactNameTxtField.setBounds(195, 255, 145, 28);
		add(eContactNameTxtField);
		eContactNameTxtField.setColumns(10);
		
		JLabel eContactPhonelbl = new JLabel("Emergency Contact Phone");
		eContactPhonelbl.setBounds(25, 292, 188, 16);
		add(eContactPhonelbl);
		
		eContactPhoneTxtField = new JTextField();
		eContactPhoneTxtField.setColumns(10);
		eContactPhoneTxtField.setBounds(195, 286, 145, 28);
		add(eContactPhoneTxtField);	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(423, 67, 145, 178);
		add(scrollPane);
		
		model = new DefaultListModel();
		list = new JList(model);
		scrollPane.setViewportView(list);
	}
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == btnSubmit) {
				
				String name = patientNameTxtField.getText();
				String DOB = dateOfBirthTxtField.getText();
				String gender = (String) genderComboBox.getSelectedItem();
				String address = addressTxtField.getText();
				String workPhone = workPhoneTxtField.getText();
				String homePhone = homePhoneTxtField.getText();
				String eContactName = eContactNameTxtField.getText();
				String eContactPhone = eContactPhoneTxtField.getText();
				String annualIncome = (String) annualIncomeComboBox.getSelectedItem();
				
				if (!(name == null) && !(DOB == null) && !(gender == null) && !(address == null) && !(workPhone == null) && !(homePhone == null) 
						&& !(eContactName == null) && !(eContactPhone == null) && !(annualIncome == null)) {
					
					JOptionPane.showMessageDialog(null, "Empty value. All field must be filled.");
				} else if ((!parent.nameTest(name)) && (!parent.dateTest(DOB)) && (!parent.phoneNumberTest(workPhone)) && (!parent.phoneNumberTest(homePhone)) 
						&& (!parent.nameTest(eContactName)) && (!parent.phoneNumberTest(eContactPhone)) && (!parent.numTest(weightTxtField.getText())) 
						&& (!parent.numTest(heightTxtField.getText()))) {
					
					JOptionPane.showMessageDialog(null, "Incorrect value, please try again.");
				} else {
					if(parent.getHandler().addNewPatient(username, password, name, DOB, gender, address, workPhone, homePhone, 
							eContactName, eContactPhone, Integer.parseInt(weightTxtField.getText()), Integer.parseInt(heightTxtField.getText()), annualIncome)) {
						
						if(!allergies.isEmpty()) {
							for(String s : allergies) {
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
			} else if (e.getSource() == allergyButton) {
				allergies.add(allergiesTxtField.getText());
				model.addElement(allergiesTxtField.getText());
				list = new JList(model);
			}
		}
		

	}
}
