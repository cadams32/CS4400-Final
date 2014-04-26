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
import java.awt.SystemColor;
import java.awt.Font;


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
	private JLabel lblPatientProfileCreation;
	
	/**
	 * Create the panel.
	 */
	public NewPatientProfilePanel(MedicalFrame parent, String username, String password) {
		setBackground(SystemColor.textHighlight);
		
		this.parent = parent;
		this.username = username;
		this.password = password;
		
		ButtonListener listener = new ButtonListener();
		setLayout(null);
		
		this.setBounds(100, 100, 1000, 600);
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setBounds(222, 157, 83, 16);
		add(lblPatientName);
		
		patientNameTxtField = new JTextField();
		patientNameTxtField.setBounds(309, 151, 134, 28);
		add(patientNameTxtField);
		patientNameTxtField.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(226, 189, 79, 16);
		add(lblDateOfBirth);
		
		dateOfBirthTxtField = new JTextField();
		dateOfBirthTxtField.setBounds(309, 183, 134, 28);
		add(dateOfBirthTxtField);
		dateOfBirthTxtField.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(261, 219, 44, 16);
		add(lblGender);
		
		String[] genderOption = {"Male", "Female"};
		genderComboBox = new JComboBox(genderOption);
		genderComboBox.setBounds(309, 215, 100, 27);
		add(genderComboBox);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(254, 252, 51, 16);
		add(lblAddress);
		
		addressTxtField = new JTextField();
		addressTxtField.setBounds(309, 246, 134, 28);
		add(addressTxtField);
		addressTxtField.setColumns(10);
		
		JLabel lblHomePhone = new JLabel("Home Phone");
		lblHomePhone.setBounds(226, 284, 79, 16);
		add(lblHomePhone);
		
		homePhoneTxtField = new JTextField();
		homePhoneTxtField.setBounds(309, 278, 134, 28);
		add(homePhoneTxtField);
		homePhoneTxtField.setColumns(10);
		
		JLabel lblWorkPhone = new JLabel("Work Phone");
		lblWorkPhone.setBounds(231, 316, 74, 16);
		add(lblWorkPhone);
		
		workPhoneTxtField = new JTextField();
		workPhoneTxtField.setBounds(309, 310, 134, 28);
		add(workPhoneTxtField);
		workPhoneTxtField.setColumns(10);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(265, 407, 43, 16);
		add(lblWeight);
		
		weightTxtField = new JTextField();
		weightTxtField.setBounds(312, 401, 134, 28);
		add(weightTxtField);
		weightTxtField.setColumns(10);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setBounds(266, 439, 42, 16);
		add(lblHeight);
		
		heightTxtField = new JTextField();
		heightTxtField.setBounds(312, 433, 134, 28);
		add(heightTxtField);
		heightTxtField.setColumns(10);
		
		JLabel lblAnnualIncome = new JLabel("Annual Income ($)");
		lblAnnualIncome.setBounds(194, 465, 114, 16);
		add(lblAnnualIncome);
		
		JLabel lblAllergies = new JLabel("Allergies");
		lblAllergies.setBounds(253, 491, 55, 16);
		add(lblAllergies);
		
		allergiesTxtField = new JTextField();
		allergiesTxtField.setBounds(312, 485, 134, 28);
		add(allergiesTxtField);
		allergiesTxtField.setColumns(10);
		
		allergyButton = new JButton("+");
		allergyButton.setBounds(450, 486, 75, 29);
		allergyButton.addActionListener(listener);
		add(allergyButton);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(718, 519, 88, 29);
		btnSubmit.addActionListener(listener);
		add(btnSubmit);
		
		JLabel lblAllergies_1 = new JLabel("Allergies");
		lblAllergies_1.setBounds(625, 151, 61, 16);
		add(lblAllergies_1);
		
		String[] annualIncomeBox = {"10000-25000", "25000-50000", "50000-75000", "75000-100000", "100000-150000", "1500000-200000", "More than 200000"};
		annualIncomeComboBox = new JComboBox(annualIncomeBox);
		annualIncomeComboBox.setBounds(312, 461, 150, 27);
		add(annualIncomeComboBox);
		
		JLabel lblEmergencyContact = new JLabel("Emergency Contact Name");
		lblEmergencyContact.setBounds(141, 348, 178, 16);
		add(lblEmergencyContact);
		
		eContactNameTxtField = new JTextField();
		eContactNameTxtField.setBounds(309, 342, 145, 28);
		add(eContactNameTxtField);
		eContactNameTxtField.setColumns(10);
		
		JLabel eContactPhonelbl = new JLabel("Emergency Contact Phone");
		eContactPhonelbl.setBounds(141, 382, 188, 16);
		add(eContactPhonelbl);
		
		eContactPhoneTxtField = new JTextField();
		eContactPhoneTxtField.setColumns(10);
		eContactPhoneTxtField.setBounds(309, 373, 145, 28);
		add(eContactPhoneTxtField);	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(587, 170, 145, 178);
		add(scrollPane);
		
		model = new DefaultListModel();
		list = new JList(model);
		scrollPane.setViewportView(list);
		
		lblPatientProfileCreation = new JLabel("Patient Profile Creation");
		lblPatientProfileCreation.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblPatientProfileCreation.setBounds(358, 34, 397, 62);
		add(lblPatientProfileCreation);
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
				
				if ((name.equals("")) || (DOB.equals("")) || (gender == null) || (address.equals("")) || (workPhone.equals("")) || (homePhone.equals("")) 
						|| (eContactName.equals("")) || (eContactPhone.equals("")) || (annualIncome == null)) {
					
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
