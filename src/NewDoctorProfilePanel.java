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
	JPanel panel = new JPanel();
	
	private ArrayList<Availability> availableList = new ArrayList<Availability>();;
	
	String[] user_opSpecial = {"General Physician", "Heart Specialist", "Eye Physician",
						"Orthopedics", "Psyciatry", "GyneCologist"};
	String[] user_opDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	String[] user_opTime = {"8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", 
							"1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM"};	
	/**
	 * Create the panel.
	 */
	public NewDoctorProfilePanel(MedicalFrame parent) {
		setLayout(new MigLayout("", "[][75.00][12.00,grow][123.00][][][][][50.00][50.00,grow][][45.00][][grow]", "[][90.00][30.00][30.00][30.00][30.00][30.00][30.00][30.00][31.00][][65.00][][][]"));
		ButtonListener listener = new ButtonListener();
		this.parent = parent;
		
		licenseLabel = new JLabel("License Numer");
		add(licenseLabel, "cell 2 2,alignx center");
		
		licenseTextField = new JTextField();
		add(licenseTextField, "cell 3 2,growx");
		licenseTextField.setColumns(10);
		
		fnameLabel = new JLabel("First Name");
		add(fnameLabel, "cell 2 3,alignx center");
		
		FnameTextField = new JTextField();
		add(FnameTextField, "cell 3 3,growx");
		FnameTextField.setColumns(10);
		
		lnameLabel = new JLabel("Last Name");
		add(lnameLabel, "cell 2 4,alignx center");
		
		LnameTextField = new JTextField();
		add(LnameTextField, "cell 3 4,growx");
		LnameTextField.setColumns(10);
		
		DOBLabel = new JLabel("Date of Birth");
		add(DOBLabel, "cell 2 5,alignx center");
		
		DOBTextField = new JTextField();
		add(DOBTextField, "cell 3 5,growx");
		DOBTextField.setColumns(10);
		
		wPhoneLabel = new JLabel("Work Phone");
		add(wPhoneLabel, "cell 2 6,alignx center");
		
		workPhoneTextField = new JTextField();
		add(workPhoneTextField, "cell 3 6,growx");
		workPhoneTextField.setColumns(10);
		
		specialtyLabel = new JLabel("Specialty");
		add(specialtyLabel, "cell 2 7,alignx center");
		
		cbSpecialty = new JComboBox(user_opSpecial);
		add(cbSpecialty, "cell 3 7,growx");
		
		addressLabel = new JLabel("Address");
		add(addressLabel, "cell 2 8,alignx center");
		
		addressTextField = new JTextField();
		add(addressTextField, "cell 3 8,growx");
		addressTextField.setColumns(10);
		
		availLabel = new JLabel("Availablity");
		add(availLabel, "cell 2 9,alignx center");
		
		cbDays = new JComboBox(user_opDays);
		add(cbDays, "flowx,cell 3 9,growx");
		
		fromLabel = new JLabel("From: ");
		add(fromLabel, "cell 4 9");
		
		cbFromTime = new JComboBox(user_opTime);
		add(cbFromTime, "flowx,cell 5 9");
		
		toLabel = new JLabel("To: ");
		add(toLabel, "cell 6 9");
		
		cbToTime = new JComboBox(user_opTime);
		add(cbToTime, "flowx,cell 7 9,alignx trailing");
		
		btnAddAvail = new JButton("+");
		add(btnAddAvail, "cell 8 9,alignx right");
		btnAddAvail.addActionListener(listener);
		
		btnCreateProfile = new JButton("Create Profile");
		add(btnCreateProfile, "cell 12 13,alignx center");
		btnCreateProfile.addActionListener(listener);
	}
	
	private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == btnAddAvail){
				
				String day = (String) cbDays.getSelectedItem();
				String from = (String) cbFromTime.getSelectedItem();
				String to = (String) cbToTime.getSelectedItem();

				Availability avail = new Availability(day, from, to);
				availableList.add(avail);
				
				
			}
			else if(e.getSource() == btnCreateProfile){
				
				//Create the profile and go back to login
				
		
			}
		}
	}
}