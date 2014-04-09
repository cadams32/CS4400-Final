import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;


public class PatientProfileCreationPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public PatientProfileCreationPanel() {
		setLayout(new MigLayout("", "[][][][151.00,grow][grow]", "[][][][][][][][][][][][][]"));
		
		JLabel lblPatientName = new JLabel("Patient Name");
		add(lblPatientName, "cell 2 1,alignx trailing");
		
		textField = new JTextField();
		add(textField, "cell 3 1");
		textField.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		add(lblDateOfBirth, "cell 2 2,alignx trailing");
		
		JLabel lblGender = new JLabel("Gender");
		add(lblGender, "cell 2 3,alignx trailing");
		
		String[] genderOption = {"Male", "Female"};
		JComboBox comboBox = new JComboBox(genderOption);
		add(comboBox, "cell 3 3");
		
		JLabel lblAddress = new JLabel("Address");
		add(lblAddress, "cell 2 4,alignx trailing");
		
		textField_1 = new JTextField();
		add(textField_1, "cell 3 4");
		textField_1.setColumns(10);
		
		JLabel lblHomePhone = new JLabel("Home Phone");
		add(lblHomePhone, "cell 2 5,alignx trailing");
		
		JLabel lblWorkPhone = new JLabel("Work Phone");
		add(lblWorkPhone, "cell 2 6,alignx trailing");
		
		JLabel lblWeight = new JLabel("Weight");
		add(lblWeight, "cell 2 7,alignx trailing");
		
		JLabel lblHeight = new JLabel("Height");
		add(lblHeight, "cell 2 8,alignx trailing");
		
		JLabel lblAnnualIncome = new JLabel("Annual Income ($)");
		add(lblAnnualIncome, "cell 2 9,alignx trailing");
		
		JLabel lblAllergies = new JLabel("Allergies");
		add(lblAllergies, "cell 2 10,alignx trailing");
		
		textField_2 = new JTextField();
		add(textField_2, "flowx,cell 3 10");
		textField_2.setColumns(10);
		
		JButton button = new JButton("+");
		add(button, "cell 3 10");
		
		JButton btnSubmit = new JButton("Submit");
		add(btnSubmit, "cell 4 12");
		
	}

}
