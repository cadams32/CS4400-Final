import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
	MedicalFrame parent;
	String username;
	JPanel panel = new JPanel();
	
	private ArrayList<Availability> availableList = new ArrayList<Availability>();;
	
	String[] user_opSpecial = {"General Physician", "Heart Specialist", "Eye Physician",
						"Orthopedics", "Psyciatry", "GyneCologist"};
	String[] user_opDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	String[] user_opTime = {"8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", 
							"1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM"};	
	private JScrollPane scrollPane;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public NewDoctorProfilePanel(MedicalFrame parent, String username) {
		ButtonListener listener = new ButtonListener();
		this.parent = parent;
		this.username = username;
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
		availLabel.setBounds(42, 323, 66, 16);
		add(availLabel);
		
		cbDays = new JComboBox(user_opDays);
		cbDays.setBounds(125, 319, 166, 27);
		add(cbDays);
		
		fromLabel = new JLabel("From: ");
		fromLabel.setBounds(295, 323, 40, 16);
		add(fromLabel);
		
		cbFromTime = new JComboBox(user_opTime);
		cbFromTime.setBounds(339, 319, 116, 27);
		add(cbFromTime);
		
		toLabel = new JLabel("To: ");
		toLabel.setBounds(459, 323, 24, 16);
		add(toLabel);
		
		cbToTime = new JComboBox(user_opTime);
		cbToTime.setBounds(487, 319, 116, 27);
		add(cbToTime);
		
		btnAddAvail = new JButton("+");
		btnAddAvail.setBounds(607, 318, 75, 29);
		add(btnAddAvail);
		btnAddAvail.addActionListener(listener);
		
		btnCreateProfile = new JButton("Create Profile");
		btnCreateProfile.setBounds(698, 412, 128, 29);
		add(btnCreateProfile);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(333, 101, 270, 187);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblAvailability = new JLabel("Availability");
		lblAvailability.setBounds(433, 74, 104, 16);
		add(lblAvailability);
		btnCreateProfile.addActionListener(listener);
	}
	
	private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == btnAddAvail){
				

				
				
			}
			else if(e.getSource() == btnCreateProfile){
				
				//Create the profile and go back to login
				DoctorHomePanel dhp = new DoctorHomePanel(parent, username);
				parent.getContentPane().add(dhp);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
		
			}
		}
	}
}