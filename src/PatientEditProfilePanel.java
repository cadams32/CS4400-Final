
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;


public class PatientEditProfilePanel extends JPanel {
	private JTextField patientNameTextField;
	private JTextField dateOfBirthTextField;
	private JTextField addressTextField;
	private JTextField homePhoneTextField;
	private JTextField workPhoneTextField;
	private JTextField weightTextField;
	private JTextField heightTextField;
	private JTextField allergyTextField;
	
	private MedicalFrame parent;
	private String username;
	
	private JButton btnDone;
	private JButton btnBack;
	private JButton btnAddAllergy;
	
	private ArrayList<String> allergyList;

	/**
	 * Create the panel.
	 */
	public PatientEditProfilePanel(MedicalFrame parent, String username) {
		
		allergyList = new ArrayList<String>();
		
		this.parent = parent;
		this.username = username;
		
		setBackground(SystemColor.textHighlight);
		setLayout(null);
		
		JLabel lblPatientEditProfile = new JLabel("Patient Edit Profile");
		lblPatientEditProfile.setBounds(441, 38, 126, 16);
		add(lblPatientEditProfile);
		
		JLabel lblPatientName = new JLabel("Patient Name : ");
		lblPatientName.setBounds(326, 125, 109, 16);
		add(lblPatientName);
		
		patientNameTextField = new JTextField();
		patientNameTextField.setBounds(431, 119, 134, 28);
		add(patientNameTextField);
		patientNameTextField.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth : ");
		lblDateOfBirth.setBounds(326, 162, 91, 16);
		add(lblDateOfBirth);
		
		dateOfBirthTextField = new JTextField();
		dateOfBirthTextField.setBounds(431, 153, 134, 28);
		add(dateOfBirthTextField);
		dateOfBirthTextField.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender : ");
		lblGender.setBounds(362, 197, 61, 16);
		add(lblGender);
		
		JComboBox genderComboBox = new JComboBox();
		genderComboBox.setBounds(431, 193, 52, 27);
		add(genderComboBox);
		
		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setBounds(356, 232, 79, 16);
		add(lblAddress);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(431, 226, 134, 28);
		add(addressTextField);
		addressTextField.setColumns(10);
		
		JLabel lblHomePhone = new JLabel("Home Phone : ");
		lblHomePhone.setBounds(326, 268, 97, 16);
		add(lblHomePhone);
		
		homePhoneTextField = new JTextField();
		homePhoneTextField.setBounds(431, 260, 134, 28);
		add(homePhoneTextField);
		homePhoneTextField.setColumns(10);
		
		JLabel lblWorkPhone = new JLabel("Work Phone : ");
		lblWorkPhone.setBounds(326, 305, 91, 16);
		add(lblWorkPhone);
		
		workPhoneTextField = new JTextField();
		workPhoneTextField.setBounds(431, 300, 134, 28);
		add(workPhoneTextField);
		workPhoneTextField.setColumns(10);
		
		JLabel lblHeight = new JLabel("Height : ");
		lblHeight.setBounds(362, 380, 61, 16);
		add(lblHeight);
		
		JLabel lblWeight = new JLabel("Weight : ");
		lblWeight.setBounds(356, 341, 61, 16);
		add(lblWeight);
		
		weightTextField = new JTextField();
		weightTextField.setBounds(431, 340, 134, 28);
		add(weightTextField);
		weightTextField.setColumns(10);
		
		heightTextField = new JTextField();
		heightTextField.setBounds(431, 374, 134, 28);
		add(heightTextField);
		heightTextField.setColumns(10);
		
		JLabel lblAnnualIncome = new JLabel("Annual Income : ");
		lblAnnualIncome.setBounds(314, 422, 109, 16);
		add(lblAnnualIncome);
		
		JComboBox annualIncomeComboBox = new JComboBox();
		annualIncomeComboBox.setBounds(431, 414, 205, 27);
		add(annualIncomeComboBox);
		
		JLabel lblAllergies = new JLabel("Allergies : ");
		lblAllergies.setBounds(338, 460, 79, 16);
		add(lblAllergies);
		
		allergyTextField = new JTextField();
		allergyTextField.setBounds(431, 454, 162, 28);
		add(allergyTextField);
		allergyTextField.setColumns(10);
		
		btnAddAllergy = new JButton("Add Allergy");
		btnAddAllergy.setBounds(605, 453, 117, 29);
		add(btnAddAllergy);
		
		btnDone = new JButton("Done");
		btnDone.setBounds(849, 547, 117, 29);
		add(btnDone);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(41, 547, 117, 29);
		add(btnBack);

	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnBack) {
				//Go Back to prev page
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
				
			} else if (e.getSource() == btnDone) {
				
				//update the DB with the changes
				
			} else if (e.getSource() == btnAddAllergy) {
				String allergyName = allergyTextField.getText();
				allergyList.add(allergyName);
			}
			
		}
		
	}

}
