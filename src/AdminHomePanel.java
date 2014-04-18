import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;


public class AdminHomePanel extends JPanel {

	private MedicalFrame parent;
	private String username;
	
	private JButton btnBilling;
	private JButton btnDoctorPerformanceReport;
	private JButton btnSurgeryReport;
	private JButton btnPatientVisitReport;
	private JButton btnBack;
	
	public AdminHomePanel(MedicalFrame parent, String username) {
		
		this.parent = parent;
		this.username = username;
		
		setLayout(new MigLayout("", "[grow]", "[100.00,grow][451.00,grow][50.00,grow]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[400.00][200.00]", "[][][][][][][][]"));
		
		btnBilling = new JButton("Billing");
		panel_1.add(btnBilling, "cell 1 1,alignx center");
		
		btnDoctorPerformanceReport = new JButton("Doctor Performance Report");
		panel_1.add(btnDoctorPerformanceReport, "cell 1 3,alignx center");
		
		btnSurgeryReport = new JButton("Surgery Report");
		panel_1.add(btnSurgeryReport, "cell 1 5,alignx center");
		
		btnPatientVisitReport = new JButton("Patient Visit Report");
		panel_1.add(btnPatientVisitReport, "cell 1 7,alignx center");
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 2,grow");
		panel_2.setLayout(new MigLayout("", "[885.00][]", "[]"));
		
		btnBack = new JButton("Back");
		panel_2.add(btnBack, "cell 1 0");

	}

}
