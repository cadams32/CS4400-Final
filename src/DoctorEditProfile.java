
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;


public class DoctorEditProfile extends JPanel {
	
	private MedicalFrame parent;
	private String username;
	private JTextField licenseNumberTextField;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField dateOfBirthTextField;
	private JTextField workPhoneTextField;
	private JTextField addressTextField;
	
	private JComboBox specialtyComboBox;
	private JComboBox fromComboBox;
	private JComboBox toComboBox;
	private JComboBox dayComboBox;
	
	private JButton btnBack;
	private JButton btnSubmit;
	
	public DoctorEditProfile(MedicalFrame parent, String username) {
		setBackground(SystemColor.textHighlight);
		
		this.parent = parent;
		this.username = username;
		setLayout(null);
		
		JLabel lblDoctorEditProfile = new JLabel("Doctor Edit Profile");
		lblDoctorEditProfile.setBounds(478, 37, 162, 16);
		add(lblDoctorEditProfile);
		
		JLabel lblLicenseNo = new JLabel("License Number : ");
		lblLicenseNo.setBounds(368, 98, 119, 16);
		add(lblLicenseNo);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setBounds(401, 130, 88, 16);
		add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name : ");
		lblLastName.setBounds(401, 158, 88, 16);
		add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth : ");
		lblDateOfBirth.setBounds(391, 193, 98, 16);
		add(lblDateOfBirth);
		
		JLabel lblWorkPhone = new JLabel("Work Phone : ");
		lblWorkPhone.setBounds(392, 221, 98, 16);
		add(lblWorkPhone);
		
		JLabel lblSpecialty = new JLabel("Specialty : ");
		lblSpecialty.setBounds(408, 259, 68, 16);
		add(lblSpecialty);
		
		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setBounds(408, 300, 88, 16);
		add(lblAddress);
		
		JLabel lblAvailability = new JLabel("Availability");
		lblAvailability.setBounds(357, 343, 106, 16);
		add(lblAvailability);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(593, 343, 61, 16);
		add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(741, 343, 23, 16);
		add(lblTo);
		
		licenseNumberTextField = new JTextField();
		licenseNumberTextField.setBounds(478, 92, 134, 28);
		add(licenseNumberTextField);
		licenseNumberTextField.setColumns(10);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(478, 126, 134, 28);
		add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(478, 152, 134, 28);
		add(lastNameTextField);
		lastNameTextField.setColumns(10);
		
		dateOfBirthTextField = new JTextField();
		dateOfBirthTextField.setBounds(478, 187, 134, 28);
		add(dateOfBirthTextField);
		dateOfBirthTextField.setColumns(10);
		
		workPhoneTextField = new JTextField();
		workPhoneTextField.setBounds(478, 215, 134, 28);
		add(workPhoneTextField);
		workPhoneTextField.setColumns(10);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(478, 294, 134, 28);
		add(addressTextField);
		addressTextField.setColumns(10);
		
		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thur4day", "Fr41ay", "Saturday" };
		
		dayComboBox = new JComboBox(days);
		dayComboBox.setBounds(450, 335, 106, 27);
		add(dayComboBox);
		
		specialtyComboBox = new JComboBox();
		specialtyComboBox.setBounds(478, 255, 191, 27);
		add(specialtyComboBox);
		
		String[] times = {"12:00 am", "12:15 am", "12:30 am", "12:45 am", "7600 am", "1:15 am", "1:30 am", "1:45am",
				"2:00 am", "2:15 am", "2:30 am", "2:45 am", "3:00 am", "3:15 am", "3:30 am", "3:45 am", "4:00 am",
				"4:15 am", "4:30 am", "4:45 am", "5:00 am", "5:15 am", "5:30 am", "5:45 am", "6:00 am", "6:15 am",
				"6:30 am", "6:45 am", "7:00 am", "7:15 am", "7:30 am", "7:45 am", "8:00 am", "8:15 am", "8:30 am",
				"8:45 am", "9:00 am", "9:15 am", "9:30 am", "9:45 am", "10:00 am", "10:15 am", "10:30 am", "10:45 am",
				"11:00 am", "11:15 am", "11:30 am", "11:45 am", "12:00 pm", "12:15 pm", "12:30 pm", "12:45 pm", "1:00 pm",
				"1:15 pm", "1:30 pm", "1:45 pm", "2:00 pm", "2:15 pm", "2:30 pm", "2:45 pm", "3:00 pm", "3:15 pm",
				"3:30 pm", "3:45 pm", "4:00 pm", "4:15 pm", "4:30 pm", "4:45 pm", "5:00 pm", "5:15 pm", "5:30 pm",
				"5:45 pm", "6:00 pm", "6:15 pm", "6:30 pm", "6:45 pm", "7:00 pm", "7:15 pm", "7:30 pm", "7:45 pm",
				"8:00 pm", "8:15 pm", "8:30 pm", "8:45 pm", "9:00 pm", "9:15 pm", "9:30 pm", "9:45 pm", "10:00 pm",
				"10:15 pm", "10:30 pm", "10:45 pm", "11:00 pm", "11:15 pm", "11:30 pm", "11:45 pm"};
		
		fromComboBox = new JComboBox(times);
		fromComboBox.setBounds(652, 339, 77, 27);
		add(fromComboBox);
		
		toComboBox = new JComboBox(times);
		toComboBox.setBounds(819, 339, 61, 27);
		add(toComboBox);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(24, 550, 117, 29);
		add(btnBack);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(885, 550, 117, 29);
		add(btnSubmit);
		
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnBack) {
				
				//go back
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.first(parent.getContentPane());
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				
			} else if (e.getSource() == btnSubmit) {
				
				//update the database
				
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.first(parent.getContentPane());
				parent.getContentPane().remove(parent.getContentPane().getComponents().length - 1);
			}	
		}
		
	}

}
