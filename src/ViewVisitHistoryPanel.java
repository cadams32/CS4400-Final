import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Backend.Doctor;
import Backend.Prescription;
import Backend.Visit;

import java.awt.SystemColor;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JComboBox;


public class ViewVisitHistoryPanel extends JPanel {
	private MedicalFrame parent;
	private String username;
	private JTextField consultingDoctorTxtField;
	private JTextField systolicTextField;
	private JTextField diastolicTextField;
	private JTable table;
	private JButton btnBackButton;
	private JButton btnGetVisit;
	private JComboBox comboBox;
	private JTextPane textPane;
	
	private DefaultTableModel model;
	
	private ArrayList<Visit> visitList;
	private ArrayList<String> dates;
	
	/**
	 * Create the panel.
	 */
	public ViewVisitHistoryPanel(MedicalFrame parent, String username) {
		this.parent = parent;
		this.username = username;
		
		setBackground(SystemColor.textHighlight);
		setLayout(null);
		
		JLabel lblDatesOfVisits = new JLabel("Dates of Visits");
		lblDatesOfVisits.setBounds(33, 177, 121, 16);
		add(lblDatesOfVisits);
		
		JLabel lblConsultingDoctor = new JLabel("Consulting Doctor");
		lblConsultingDoctor.setBounds(390, 104, 121, 16);
		add(lblConsultingDoctor);
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure : ");
		lblBloodPressure.setBounds(341, 141, 140, 16);
		add(lblBloodPressure);
		
		JLabel lblSystolic = new JLabel("Systolic");
		lblSystolic.setBounds(462, 141, 61, 16);
		add(lblSystolic);
		
		JLabel lblDiastolic = new JLabel("Diastolic");
		lblDiastolic.setBounds(462, 177, 61, 16);
		add(lblDiastolic);
		
		consultingDoctorTxtField = new JTextField();
		consultingDoctorTxtField.setEditable(false);
		consultingDoctorTxtField.setBounds(523, 98, 134, 28);
		add(consultingDoctorTxtField);
		consultingDoctorTxtField.setColumns(10);
		
		systolicTextField = new JTextField();
		systolicTextField.setEditable(false);
		systolicTextField.setBounds(523, 135, 134, 28);
		add(systolicTextField);
		systolicTextField.setColumns(10);
		
		diastolicTextField = new JTextField();
		diastolicTextField.setEditable(false);
		diastolicTextField.setColumns(10);
		diastolicTextField.setBounds(523, 171, 134, 28);
		add(diastolicTextField);
		
		JLabel lblDiagnosis = new JLabel("Diagnosis");
		lblDiagnosis.setBounds(362, 211, 75, 16);
		add(lblDiagnosis);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(454, 211, 225, 84);
		add(scrollPane_1);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		scrollPane_1.setViewportView(textPane);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(393, 319, 391, 115);
		add(scrollPane_2);
		
		JLabel lblMedications = new JLabel("Medications");
		lblMedications.setBounds(285, 320, 96, 16);
		add(lblMedications);
		
		JLabel lblViewVisitHistory = new JLabel("View Visit History");
		lblViewVisitHistory.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblViewVisitHistory.setBounds(302, 17, 140, 16);
		add(lblViewVisitHistory);
		
		ButtonListener listener = new ButtonListener();
		
		btnBackButton = new JButton("Back");
		
		String[] columnNames = {"Medicine Name", "Dosage", "Duration", "Notes"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table = new JTable(model);
		scrollPane_2.setViewportView(table);
		
		
		btnBackButton.setBounds(16, 499, 121, 28);
		btnBackButton.addActionListener(listener);
		add(btnBackButton);
		
		//Get all visits
		visitList = parent.getHandler().getPatientVisits(username);
		//Fill String of dates
		dates = new ArrayList<String>();
		for(Visit v : visitList) {
			dates.add(v.getDateOfVisit());
		}
		
		comboBox = new JComboBox(dates.toArray());
		comboBox.setBounds(114, 206, 147, 28);
		add(comboBox);
			
		btnGetVisit = new JButton("Get Visit");
		btnGetVisit.setBounds(135, 172, 87, 28);
		btnGetVisit.addActionListener(listener);
		add(btnGetVisit);	

		JLabel lblChooseDate = new JLabel("Choose Date:");
		lblChooseDate.setBounds(18, 211, 96, 16);
		add(lblChooseDate);
		
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnGetVisit) {
				
				Visit v = visitList.get(comboBox.getSelectedIndex());		
				Integer systolic = v.getSystolicPressure();
				Integer diastolic = v.getDiastolicPressure();
				systolicTextField.setText(systolic.toString());
				diastolicTextField.setText(diastolic.toString());
				String diagnosis = parent.getHandler().getVisitDiagnosis(v.getVisitID());
				textPane.setText(diagnosis);
				Doctor doc = parent.getHandler().getDoctor(v.getDocUsername());
				consultingDoctorTxtField.setText("Dr." + doc.getfName() + " " + doc.getlName());
				
				ArrayList<Prescription> prescriptionList = new ArrayList<Prescription>();
				prescriptionList = parent.getHandler().getVisitPrescriptions(v.getVisitID());
				Object[] insert = new Object[4];
				for(Prescription p : prescriptionList) {
					insert[0] = p.getMedicineName();
					insert[1] = p.getDosage();
					insert[2] = p.getDuration();
					insert[3] = p.getNotes();
					model.addRow(insert);
				}
				model.fireTableDataChanged();
	
			}
			
		}
		
	}
}
