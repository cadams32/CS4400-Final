
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextPane;


public class DoctorMessagingPanel extends JPanel {

	
	MedicalFrame parent;
	String username;
	
	/**
	 * Create the panel.
	 */
	public DoctorMessagingPanel(MedicalFrame parent, String username) {
		
		this.parent = parent;
		this.username = username;
		
		setLayout(new MigLayout("", "[986px,grow]", "[93px][442px][grow]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0,grow");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[49.00][109.00][][268.00,grow][][102.00][358.00,grow]", "[69.00][][][50.00,grow][247.00][71.00]"));
		
		JLabel lblSelectDoctor = new JLabel("Select Doctor");
		panel_1.add(lblSelectDoctor, "cell 1 1,alignx leading");
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox, "cell 2 1 2 1,growx");
		
		JLabel lblSelectPatient = new JLabel("Select Patient");
		panel_1.add(lblSelectPatient, "cell 5 1,alignx trailing");
		
		JComboBox comboBox_1 = new JComboBox();
		panel_1.add(comboBox_1, "cell 6 1,growx");
		
		JLabel lblMessage = new JLabel("Message");
		panel_1.add(lblMessage, "cell 1 3,alignx leading");
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 2 3 2 2,grow");
		
		JTextPane textPane_1 = new JTextPane();
		scrollPane.setViewportView(textPane_1);
		
		JLabel lblMessage_1 = new JLabel("Message");
		panel_1.add(lblMessage_1, "cell 5 3");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, "cell 6 3 1 2,grow");
		
		JTextPane textPane = new JTextPane();
		scrollPane_1.setViewportView(textPane);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 2,grow");
		panel_2.setLayout(new MigLayout("", "[]", "[]"));

	}

}
