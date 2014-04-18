import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ViewAppointmentDatePanel extends JPanel {

	private JComboBox monthsComboBox;
	private JComboBox yearsComboBox;
	private JComboBox daysComboBox;
	private JScrollPane scrollPane;
	private JTable table;

	private MedicalFrame parent;
	private String username;
	
	/**
	 * Create the panel.
	 */
	public ViewAppointmentDatePanel(MedicalFrame parent, String username) {
		
		this.parent = parent;
		this.username = username;
		
		setBackground(SystemColor.textHighlight);
		setLayout(null);
		
		JLabel lblAppointmentCalendar = new JLabel("Appointment Calendar");
		lblAppointmentCalendar.setBounds(395, 19, 199, 16);
		add(lblAppointmentCalendar);
	
		String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		String[] years = {"1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014"};
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		monthsComboBox = new JComboBox(months);
		monthsComboBox.setBounds(478, 48, 130, 27);
		add(monthsComboBox);
		
		yearsComboBox = new JComboBox(years);
		yearsComboBox.setBounds(630, 48, 98, 27);
		add(yearsComboBox);
		
		daysComboBox = new JComboBox(days);
		daysComboBox.setBounds(376, 48, 72, 27);
		add(daysComboBox);
		
		JLabel label = new JLabel("Date:");
		label.setBounds(284, 52, 61, 16);
		add(label);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 131, 799, 335);
		add(scrollPane);
		
		String[] columnNames = {"Sno", "Patient Name", "Scheduled Time"};
		Object[][] data = {};
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);

	}

}
