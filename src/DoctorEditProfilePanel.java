
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

import Backend.Availability;


public class DoctorEditProfilePanel extends JPanel {
	
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
	
	private JList list;
	private DefaultListModel model;
	
	private JButton btnBack;
	private JButton btnSubmit;
	private JButton btnAddAvail;
	private JTextField roomNoTextField;
	
	private ArrayList<Availability> availableList = new ArrayList<Availability>();;
	
	public DoctorEditProfilePanel(MedicalFrame parent, String username) {
		setBackground(SystemColor.textHighlight);
		
		this.parent = parent;
		this.username = username;
		setLayout(null);
		ButtonListener listener = new ButtonListener();
		
		JLabel lblDoctorEditProfile = new JLabel("Doctor Edit Profile");
		lblDoctorEditProfile.setBounds(478, 37, 162, 16);
		add(lblDoctorEditProfile);
		
		JLabel lblLicenseNo = new JLabel("License Number : ");
		lblLicenseNo.setBounds(365, 98, 117, 16);
		add(lblLicenseNo);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setBounds(388, 136, 80, 16);
		add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name : ");
		lblLastName.setBounds(385, 163, 83, 16);
		add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth : ");
		lblDateOfBirth.setBounds(376, 199, 92, 16);
		add(lblDateOfBirth);
		
		JLabel lblWorkPhone = new JLabel("Work Phone : ");
		lblWorkPhone.setBounds(376, 232, 92, 16);
		add(lblWorkPhone);
		
		JLabel lblSpecialty = new JLabel("Specialty : ");
		lblSpecialty.setBounds(388, 259, 72, 30);
		add(lblSpecialty);
		
		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setBounds(394, 300, 88, 16);
		add(lblAddress);
		
		JLabel lblAvailability = new JLabel("Availability:");
		lblAvailability.setBounds(388, 373, 77, 16);
		add(lblAvailability);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setBounds(610, 373, 42, 16);
		add(lblFrom);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(748, 373, 31, 16);
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
		lastNameTextField.setBounds(478, 157, 134, 28);
		add(lastNameTextField);
		lastNameTextField.setColumns(10);
		
		dateOfBirthTextField = new JTextField();
		dateOfBirthTextField.setBounds(478, 193, 134, 28);
		add(dateOfBirthTextField);
		dateOfBirthTextField.setColumns(10);
		
		workPhoneTextField = new JTextField();
		workPhoneTextField.setBounds(478, 226, 134, 28);
		add(workPhoneTextField);
		workPhoneTextField.setColumns(10);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(478, 294, 134, 28);
		add(addressTextField);
		addressTextField.setColumns(10);
		
		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		
		dayComboBox = new JComboBox(days);
		dayComboBox.setBounds(478, 368, 106, 27);
		add(dayComboBox);
		
		String[] specialty = {"General Physician", "Heart Specialist", "Eye Physician",
				"Orthopedics", "Psyciatry", "GyneCologist"};
		
		specialtyComboBox = new JComboBox(specialty);
		specialtyComboBox.setBounds(478, 262, 134, 27);
		add(specialtyComboBox);
		
		/*String[] times = {"12:00 am", "12:15 am", "12:30 am", "12:45 am", "1:00 am", "1:15 am", "1:30 am", "1:45am",
				"2:00 am", "2:15 am", "2:30 am", "2:45 am", "3:00 am", "3:15 am", "3:30 am", "3:45 am", "4:00 am",
				"4:15 am", "4:30 am", "4:45 am", "5:00 am", "5:15 am", "5:30 am", "5:45 am", "6:00 am", "6:15 am",
				"6:30 am", "6:45 am", "7:00 am", "7:15 am", "7:30 am", "7:45 am", "8:00 am", "8:15 am", "8:30 am",
				"8:45 am", "9:00 am", "9:15 am", "9:30 am", "9:45 am", "10:00 am", "10:15 am", "10:30 am", "10:45 am",
				"11:00 am", "11:15 am", "11:30 am", "11:45 am", "12:00 pm", "12:15 pm", "12:30 pm", "12:45 pm", "1:00 pm",
				"1:15 pm", "1:30 pm", "1:45 pm", "2:00 pm", "2:15 pm", "2:30 pm", "2:45 pm", "3:00 pm", "3:15 pm",
				"3:30 pm", "3:45 pm", "4:00 pm", "4:15 pm", "4:30 pm", "4:45 pm", "5:00 pm", "5:15 pm", "5:30 pm",
				"5:45 pm", "6:00 pm", "6:15 pm", "6:30 pm", "6:45 pm", "7:00 pm", "7:15 pm", "7:30 pm", "7:45 pm",
				"8:00 pm", "8:15 pm", "8:30 pm", "8:45 pm", "9:00 pm", "9:15 pm", "9:30 pm", "9:45 pm", "10:00 pm",
				"10:15 pm", "10:30 pm", "10:45 pm", "11:00 pm", "11:15 pm", "11:30 pm", "11:45 pm"};*/
		String[] times = {"00:00", "00:15", "00:30", "00:45", "01:00", "01:15", "01:30", "01:45",
				"02:00", "02:15", "02:30", "02:45", "03:00", "03:15", "03:30", "03:45", "04:00",
				"04:15", "04:30", "04:45", "05:00", "05:15", "05:30", "05:45", "06:00", "06:15",
				"06:30", "06:45", "07:00", "07:15", "07:30", "07:45", "08:00", "08:15", "08:30",
				"08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45",
				"11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00",
				"13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15",
				"15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30",
				"17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45",
				"20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00",
				"22:15", "22:30", "22:45", "23:00", "23:15", "23:30", "23:45"};
		
		fromComboBox = new JComboBox(times);
		fromComboBox.setBounds(647, 368, 77, 27);
		add(fromComboBox);
		
		toComboBox = new JComboBox(times);
		toComboBox.setBounds(778, 368, 61, 27);
		add(toComboBox);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(117, 550, 117, 29);
		add(btnBack);
		btnBack.addActionListener(listener);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(860, 550, 117, 29);
		add(btnSubmit);
		
		btnAddAvail = new JButton("+");
		btnAddAvail.setBounds(860, 370, 42, 23);
		add(btnAddAvail);
		btnSubmit.addActionListener(listener);
		btnAddAvail.addActionListener(listener);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(478, 419, 367, 73);
		add(scrollPane);
		model = new DefaultListModel();
		list = new JList(model);
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel = new JLabel("RoomNo:");
		lblNewLabel.setBounds(396, 335, 72, 14);
		add(lblNewLabel);
		
		roomNoTextField = new JTextField();
		roomNoTextField.setBounds(478, 327, 134, 30);
		add(roomNoTextField);
		roomNoTextField.setColumns(10);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnBack) {
				
				//go back
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
				
			} else if (e.getSource() == btnAddAvail) {
				availableList.add(new Availability((String)dayComboBox.getSelectedItem(), (String)fromComboBox.getSelectedItem(), (String)toComboBox.getSelectedItem()));
				model.addElement((String)dayComboBox.getSelectedItem()+"       From: "+(String)fromComboBox.getSelectedItem()+"       To: "+(String)toComboBox.getSelectedItem());
				//list = new JList(model);
				
			} else if (e.getSource() == btnSubmit) {
				//update the database
				String licenseNo = licenseNumberTextField.getText();
				String fName = firstNameTextField.getText();
				String lName = lastNameTextField.getText();
				String DOB = dateOfBirthTextField.getText();
				String workPhone = workPhoneTextField.getText();
				String specialty = (String) specialtyComboBox.getSelectedItem();
				String address = addressTextField.getText();
				
				if ((!parent.numTest(licenseNo)) && (!parent.firstNameTest(fName)) && (!parent.lastNameTest(lName))
						&& (!parent.dateTest(DOB)) && (!parent.phoneNumberTest(workPhone)) && (!parent.numTest(roomNoTextField.getText()))) {
					
					JOptionPane.showMessageDialog(null, "Incorrect value, please try again.");
				} else {
					if(parent.getHandler().updateDoctorProfile(username, licenseNo, fName, lName ,DOB, 
							workPhone, address, specialty, Integer.parseInt(roomNoTextField.getText()))) {
						
						for(Availability a : availableList) {
							parent.getHandler().addNewDoctorAvailable(username, (String)a.getTo(), (String)a.getFrom(), (String)a.getDay());
						}
					}
					
					DoctorHomePanel dhp = new DoctorHomePanel(parent, username);
					parent.getContentPane().add(dhp);
					CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
					cl.next(parent.getContentPane());
				}
			}	
		}	
	}
}
