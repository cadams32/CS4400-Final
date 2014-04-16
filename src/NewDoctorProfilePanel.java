import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	String[] user_opSpecial = {"General Physician", "Heart Specialist", "Eye Physician",
						"Orthopedics", "Psyciatry", "GyneCologist"};
	String[] user_opDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	String[] user_opTime = {"8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", 
							"1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM"};	
	/**
	 * Create the panel.
	 */
	public NewDoctorProfilePanel(MedicalFrame parent) {
		//setLayout(new MigLayout("", "[1000.00,grow]", "[100.00][491.00,grow]"));
		setLayout(new MigLayout("", "[][90.00][372.00,grow][151.00,grow][grow]", "[][][][][][][][][][][][][][][][][][][][]"));
		ButtonListener listener = new ButtonListener();
		this.parent = parent;
		
		add(panel, "cell 0 1,grow");
		/*panel.setLayout(new MigLayout("", "[199.00][][][grow][][][][][][][][23.00][][][][][grow]",
				"[][][][][][][][][][][142.00][36.00]"));*/
		
		licenseLabel = new JLabel("License Numer");
		add(licenseLabel, "cell 1 2");
		
		licenseTextField = new JTextField();
		add(licenseTextField, "cell 2 2,alignx left");
		licenseTextField.setColumns(10);
		
		fnameLabel = new JLabel("First Name");
		add(fnameLabel, "cell 1 3");
		
		FnameTextField = new JTextField();
		add(FnameTextField, "cell 2 3,alignx left");
		FnameTextField.setColumns(10);
		
		lnameLabel = new JLabel("Last Name");
		add(lnameLabel, "cell 1 4");
		
		LnameTextField = new JTextField();
		add(LnameTextField, "cell 2 4,alignx left");
		LnameTextField.setColumns(10);
		
		DOBLabel = new JLabel("Date of Birth");
		add(DOBLabel, "cell 1 5");
		
		DOBTextField = new JTextField();
		add(DOBTextField, "cell 2 5,alignx left");
		DOBTextField.setColumns(10);
		
		wPhoneLabel = new JLabel("Work Phone");
		add(wPhoneLabel, "cell 1 6");
		
		workPhoneTextField = new JTextField();
		add(workPhoneTextField, "cell 2 6,alignx left");
		workPhoneTextField.setColumns(10);
		
		specialtyLabel = new JLabel("Specialty");
		add(specialtyLabel, "cell 1 7");
		
		cbSpecialty = new JComboBox(user_opSpecial);
		add(cbSpecialty, "cell 2 7,alignx left");
		
		addressLabel = new JLabel("Address");
		add(addressLabel, "cell 1 8");
		
		addressTextField = new JTextField();
		add(addressTextField, "cell 2 8,alignx left");
		addressTextField.setColumns(10);
		
		availLabel = new JLabel("Availablity");
		add(availLabel, "cell 1 9,alignx left");
		
		cbDays = new JComboBox(user_opDays);
		add(cbDays, "flowx,cell 2 9,alignx left");
		
		fromLabel = new JLabel("From: ");
		add(fromLabel, "cell 2 9");
		
		cbFromTime = new JComboBox(user_opTime);
		add(cbFromTime, "cell 2 9,alignx trailing");
		
		toLabel = new JLabel("To: ");
		add(toLabel, "cell 2 9");
		
		cbToTime = new JComboBox(user_opTime);
		add(cbToTime, "cell 2 9,alignx trailing");
		
		btnCreateProfile = new JButton("Create Profile");
		add(btnCreateProfile, "cell 3 14");
		
		btnAddAvail = new JButton("+");
		add(btnAddAvail, "cell 2 9");
		btnAddAvail.addActionListener(listener);
		btnCreateProfile.addActionListener(listener);
	}
	
	private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == btnAddAvail){
				cbDays = new JComboBox(user_opDays);
				add(cbDays, "flowx,cell 2 9,alignx left");
				
				fromLabel = new JLabel("From: ");
				add(fromLabel, "cell 2 9");
				
				cbFromTime = new JComboBox(user_opTime);
				add(cbFromTime, "cell 2 9,alignx trailing");
				
				toLabel = new JLabel("To: ");
				add(toLabel, "cell 2 9");
				
				cbToTime = new JComboBox(user_opTime);
				add(cbToTime, "cell 2 9,alignx trailing");
			}
			else if(e.getSource() == btnCreateProfile){

			}
		}
	}
}
