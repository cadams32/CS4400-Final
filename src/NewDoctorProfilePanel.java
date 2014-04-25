import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import net.miginfocom.swing.MigLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Backend.Availability;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
	private JLabel toLabel;
	private JLabel fromLabel;
	private JComboBox cbSpecialty;
	private JComboBox cbDays;
	private JComboBox cbFromTime;
	private JComboBox cbToTime; 
	JButton btnAddAvail, btnCreateProfile;
	private MedicalFrame parent;
	private String username;
	private String password;
	private JPanel panel = new JPanel();
	
	private JList list;
	private DefaultListModel model;

	private ArrayList<Availability> availableList = new ArrayList<Availability>();;
	
	String[] user_opSpecial = {"General Physician", "Heart Specialist", "Eye Physician",
						"Orthopedics", "Psyciatry", "GyneCologist"};
	String[] user_opDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	String[] user_opTime = {"00:00", "00:15", "00:30", "00:45", "01:00", "01:15", "01:30", "01:45",
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
	private JLabel lblRoomNo;
	private JTextField roomNoTextField;
	/**
	 * Create the panel.
	 */
	public NewDoctorProfilePanel(MedicalFrame parent, String username, String password) {
		ButtonListener listener = new ButtonListener();
		this.parent = parent;
		this.username = username;
		this.password = password;
		
		setLayout(null);
		
		licenseLabel = new JLabel("License Numer");
		licenseLabel.setBounds(22, 101, 93, 16);
		add(licenseLabel);
		
		licenseTextField = new JTextField();
		licenseTextField.setBounds(125, 95, 166, 28);
		add(licenseTextField);
		licenseTextField.setColumns(10);
		
		fnameLabel = new JLabel("First Name");
		fnameLabel.setBounds(41, 133, 68, 16);
		add(fnameLabel);
		
		FnameTextField = new JTextField();
		FnameTextField.setBounds(125, 127, 166, 28);
		add(FnameTextField);
		FnameTextField.setColumns(10);
		
		lnameLabel = new JLabel("Last Name");
		lnameLabel.setBounds(42, 165, 66, 16);
		add(lnameLabel);
		
		LnameTextField = new JTextField();
		LnameTextField.setBounds(125, 159, 166, 28);
		add(LnameTextField);
		LnameTextField.setColumns(10);
		
		DOBLabel = new JLabel("Date of Birth");
		DOBLabel.setBounds(35, 197, 79, 16);
		add(DOBLabel);
		
		DOBTextField = new JTextField();
		DOBTextField.setBounds(125, 191, 166, 28);
		add(DOBTextField);
		DOBTextField.setColumns(10);
		
		wPhoneLabel = new JLabel("Work Phone");
		wPhoneLabel.setBounds(38, 229, 74, 16);
		add(wPhoneLabel);
		
		workPhoneTextField = new JTextField();
		workPhoneTextField.setBounds(125, 223, 166, 28);
		add(workPhoneTextField);
		workPhoneTextField.setColumns(10);
		
		specialtyLabel = new JLabel("Specialty");
		specialtyLabel.setBounds(47, 259, 56, 16);
		add(specialtyLabel);
		
		cbSpecialty = new JComboBox(user_opSpecial);
		cbSpecialty.setBounds(125, 255, 166, 27);
		add(cbSpecialty);
		
		addressLabel = new JLabel("Address");
		addressLabel.setBounds(49, 292, 51, 16);
		add(addressLabel);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(125, 286, 166, 28);
		add(addressTextField);
		addressTextField.setColumns(10);
		
		availLabel = new JLabel("Availablity");
		availLabel.setBounds(49, 360, 66, 16);
		add(availLabel);
		
		cbDays = new JComboBox(user_opDays);
		cbDays.setBounds(125, 356, 166, 27);
		add(cbDays);
		
		fromLabel = new JLabel("From: ");
		fromLabel.setBounds(295, 360, 40, 16);
		add(fromLabel);
		
		cbFromTime = new JComboBox(user_opTime);
		cbFromTime.setBounds(339, 356, 116, 27);
		add(cbFromTime);
		
		toLabel = new JLabel("To: ");
		toLabel.setBounds(459, 360, 24, 16);
		add(toLabel);
		
		cbToTime = new JComboBox(user_opTime);
		cbToTime.setBounds(487, 356, 116, 27);
		add(cbToTime);
		
		btnAddAvail = new JButton("+");
		btnAddAvail.setBounds(615, 355, 75, 29);
		add(btnAddAvail);
		btnAddAvail.addActionListener(listener);
		
		btnCreateProfile = new JButton("Create Profile");
		btnCreateProfile.setBounds(795, 468, 128, 29);
		add(btnCreateProfile);
		
		lblRoomNo = new JLabel("Room No");
		lblRoomNo.setBounds(54, 320, 61, 16);
		add(lblRoomNo);
		
		roomNoTextField = new JTextField();
		roomNoTextField.setColumns(10);
		roomNoTextField.setBounds(125, 316, 166, 28);
		add(roomNoTextField);
		btnCreateProfile.addActionListener(listener);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 412, 478, 85);
		add(scrollPane);
		
		model = new DefaultListModel();
		list = new JList(model);
		scrollPane.setViewportView(list);
	}
	
	private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == btnAddAvail){
					
				//day from to
				availableList.add(new Availability((String)cbDays.getSelectedItem(), (String)cbFromTime.getSelectedItem(), (String)cbToTime.getSelectedItem()));
				model.addElement((String)cbDays.getSelectedItem()+"       From: "+(String)cbFromTime.getSelectedItem()+"       To: "+(String)cbToTime.getSelectedItem());
				list = new JList(model);
			}
			else if(e.getSource() == btnCreateProfile){
				
				String licenseNo = licenseTextField.getText();
				String fName = FnameTextField.getText();
				String lName = LnameTextField.getText();
				String DOB = DOBTextField.getText();
				String workPhone = workPhoneTextField.getText();
				String specialty = (String) cbSpecialty.getSelectedItem();
				String address = addressTextField.getText();
				int roomNo = Integer.parseInt(roomNoTextField.getText());
				
				if ((!parent.numTest(licenseNo)) && (!parent.firstNameTest(fName)) && (!parent.lastNameTest(lName))
						&& (!parent.dateTest(DOB)) && (!parent.phoneNumberTest(workPhone)) && (!parent.numTest(roomNoTextField.getText()))) {
					
					JOptionPane.showMessageDialog(null, "Incorrect value, please try again.");
				} else {
					if(parent.getHandler().addNewDoctor(username, password, licenseNo, fName, lName, DOB, workPhone, address, specialty, roomNo)) {
						
						for(Availability a : availableList) {
							parent.getHandler().addNewDoctorAvailable(username, (String)a.getTo(), (String)a.getFrom(), (String)a.getDay());
						}
					}
					
					DoctorHomePanel dhp = new DoctorHomePanel(parent, username);
					parent.getContentPane().add(dhp);
					CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
					cl.next(parent.getContentPane());
					/*parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
					DoctorHomePanel dhp = new DoctorHomePanel(parent, username);
					parent.getContentPane().add(dhp);
					CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
					cl.last(parent.getContentPane());*/	
				}
			}
		}
	}
}