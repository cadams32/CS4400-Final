import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		ButtonListener listener = new ButtonListener();
		
		setLayout(new MigLayout("", "[grow]", "[100.00,grow][451.00,grow][50.00,grow]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[400.00][200.00]", "[][][][][][][][]"));
		
		btnBilling = new JButton("Billing");
		btnBilling.addActionListener(listener);
		panel_1.add(btnBilling, "cell 1 1,alignx center");
		btnBilling.addActionListener(listener);
		
		btnDoctorPerformanceReport = new JButton("Doctor Performance Report");
		btnDoctorPerformanceReport.addActionListener(listener);
		panel_1.add(btnDoctorPerformanceReport, "cell 1 3,alignx center");
		btnDoctorPerformanceReport.addActionListener(listener);
		
		btnSurgeryReport = new JButton("Surgery Report");
		btnSurgeryReport.addActionListener(listener);
		panel_1.add(btnSurgeryReport, "cell 1 5,alignx center");
		btnSurgeryReport.addActionListener(listener);
		
		btnPatientVisitReport = new JButton("Patient Visit Report");
		btnPatientVisitReport.addActionListener(listener);
		panel_1.add(btnPatientVisitReport, "cell 1 7,alignx center");
		btnPatientVisitReport.addActionListener(listener);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 2,grow");
		panel_2.setLayout(new MigLayout("", "[885.00][]", "[]"));
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnPatientVisitReport) {
				PatientVisitPanel pvp = new PatientVisitPanel(parent, username);
				parent.getContentPane().add(pvp);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
			} else if (e.getSource() == btnSurgeryReport) {
				SurgeryPerformedPanel spp = new SurgeryPerformedPanel(parent, username);
				parent.getContentPane().add(spp);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
			} else if (e.getSource() == btnDoctorPerformanceReport) {
				DoctorReportPanel drp = new DoctorReportPanel(parent, username);
				parent.getContentPane().add(drp);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
			} else if (e.getSource() == btnBilling) {
				BillingPanel bp = new BillingPanel(parent, username);
				parent.getContentPane().add(bp);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
			}
			
		}
		
	}

}
