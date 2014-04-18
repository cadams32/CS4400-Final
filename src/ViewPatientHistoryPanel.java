import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.SwingConstants;


public class ViewPatientHistoryPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public ViewPatientHistoryPanel() {
		setLayout(new MigLayout("", "[grow]", "[100.00,grow][450.00,grow][50.00,grow]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[][189.00,grow][141.00,grow][60.00][28.00,grow][86.00,grow][80.00,grow][90.00][80.00,grow][]", "[][149.00,grow][][40.00,grow][40.00][40.00][150.00,grow]"));
		
		JLabel lblName = new JLabel("Name");
		panel_1.add(lblName, "cell 1 0,alignx trailing");
		
		textField = new JTextField();
		panel_1.add(textField, "cell 2 0,growx");
		textField.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone");
		panel_1.add(lblPhone, "cell 4 0,alignx trailing");
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 5 0,growx");
		textField_1.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		panel_1.add(btnSearch, "cell 7 0");
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 1 1 2 1,grow");
		
		String[] colNames = {"Patient Name", "Phone Number"};
		Object[][] data = {};
		table = new JTable(data, colNames);
		scrollPane.setViewportView(table);
		
		JButton btnView = new JButton("View");
		panel_1.add(btnView, "cell 3 1,alignx right");
		
		JButton btnRecordAVisit = new JButton("Record a visit");
		panel_1.add(btnRecordAVisit, "cell 4 1 2 1");
		
		JLabel lblDatesOfVisits = new JLabel("Dates of Visits");
		panel_1.add(lblDatesOfVisits, "cell 1 2");
		
		JList list = new JList();
		panel_1.add(list, "cell 1 3 1 4,grow");
		
		JLabel lblDateOfVisit = new JLabel("Date of Visit");
		panel_1.add(lblDateOfVisit, "cell 3 3,aligny top");
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "cell 5 3,growx");
		textField_2.setColumns(10);
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure");
		panel_1.add(lblBloodPressure, "cell 3 4,aligny top");
		
		JLabel lblSystolic = new JLabel("Systolic");
		lblSystolic.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblSystolic, "cell 5 4,alignx center");
		
		textField_3 = new JTextField();
		panel_1.add(textField_3, "cell 6 4,growx");
		textField_3.setColumns(10);
		
		JLabel lblDiastolic = new JLabel("Diastolic");
		panel_1.add(lblDiastolic, "cell 7 4,alignx center");
		
		textField_4 = new JTextField();
		panel_1.add(textField_4, "cell 8 4,growx");
		textField_4.setColumns(10);
		
		JLabel lblDiagnosis = new JLabel("Diagnosis");
		panel_1.add(lblDiagnosis, "cell 3 5,alignx leading,aligny top");
		
		textField_5 = new JTextField();
		panel_1.add(textField_5, "cell 5 5 4 1,growx");
		textField_5.setColumns(10);
		
		JLabel lblMedicationsPrescribed = new JLabel("Medications Prescribed");
		panel_1.add(lblMedicationsPrescribed, "cell 3 6,aligny top");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, "cell 5 6 4 1,grow");
		
		String[] medColNames = {"Medicine Name", "Dosage", "Duration", "Notes"};
		Object[][] medData = {}; 
		table_1 = new JTable(medData, medColNames);
		scrollPane_1.setViewportView(table_1);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(150);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(70);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(70);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(70);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 2,grow");
		panel_2.setLayout(new MigLayout("", "[][]", "[]"));
		
		JButton btnBack = new JButton("Back");
		panel_2.add(btnBack, "cell 1 0");

	}

}
