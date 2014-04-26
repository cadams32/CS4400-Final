import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Backend.Prescription;
import Backend.Visit;
import java.awt.SystemColor;
import java.awt.Font;


public class ViewPatientHistoryPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table_1;
	
	private MedicalFrame parent;
	private String username;
	String name="", phone="", patientUsername="";
	JButton btnBack, btnSearch, btnView, btnRecordAVisit, btnSelect;
	DefaultTableModel model, medModel;
	DefaultListModel listModel;
	JList list;
	ArrayList<Visit> visitList;
	private JLabel lblPatientName;
	private JLabel lblPhoneNumber;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel lblViewPatientHistor;

	/**
	 * Create the panel.
	 */
	public ViewPatientHistoryPanel(MedicalFrame parent, String username) {
		setBackground(SystemColor.textHighlight);
		
		this.parent = parent;
		this.username = username;
		ButtonListener listener = new ButtonListener();
		visitList = new ArrayList<Visit>();
		this.setBounds(100, 100, 1000, 600);
		setLayout(new MigLayout("", "[grow]", "[100.00,grow][450.00,grow][50.00,grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		add(panel, "cell 0 0,grow");
		panel.setLayout(null);
		
		lblViewPatientHistor = new JLabel("View Patient History");
		lblViewPatientHistor.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblViewPatientHistor.setBounds(350, 20, 336, 36);
		panel.add(lblViewPatientHistor);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[][189.00,grow][141.00,grow][60.00][28.00,grow][86.00,grow][80.00,grow][90.00][80.00,grow][]", "[][19.00][36.00,grow][48.00][40.00,grow][40.00][40.00][150.00,grow]"));
		
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
		
		btnSearch = new JButton("Search");
		panel_1.add(btnSearch, "cell 7 0");
		btnSearch.addActionListener(listener);
		
		String[] colNames = {"Patient Name", "Phone Number"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(colNames);
		
		lblPatientName = new JLabel("Patient Name");
		panel_1.add(lblPatientName, "cell 1 1");
		
		lblPhoneNumber = new JLabel("Phone Number");
		panel_1.add(lblPhoneNumber, "cell 2 1");
		
		textField_6 = new JTextField();
		panel_1.add(textField_6, "cell 1 2,growx");
		textField_6.setColumns(10);
		textField_6.setEditable(false);
		
		textField_7 = new JTextField();
		panel_1.add(textField_7, "cell 2 2,growx");
		textField_7.setColumns(10);
		textField_7.setEditable(false);
		
		btnView = new JButton("View");
		panel_1.add(btnView, "cell 3 2,alignx right");
		btnView.addActionListener(listener);
		
		btnRecordAVisit = new JButton("Record a visit");
		panel_1.add(btnRecordAVisit, "cell 4 2 2 1");
		btnRecordAVisit.addActionListener(listener);
		
		JLabel lblDatesOfVisits = new JLabel("Dates of Visits");
		panel_1.add(lblDatesOfVisits, "cell 1 3");
		
		listModel = new DefaultListModel();
		list = new JList(listModel);
		panel_1.add(list, "cell 1 4 1 4,grow");
		
		btnSelect = new JButton("Select");
		panel_1.add(btnSelect, "cell 2 4");
		btnSelect.addActionListener(listener);
		
		JLabel lblDateOfVisit = new JLabel("Date of Visit");
		panel_1.add(lblDateOfVisit, "cell 3 4,aligny center");
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "cell 5 4,growx");
		textField_2.setColumns(10);
		textField_2.setEditable(false);
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure");
		panel_1.add(lblBloodPressure, "cell 3 5,aligny center");
		
		JLabel lblSystolic = new JLabel("Systolic");
		lblSystolic.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblSystolic, "cell 5 5,alignx center");
		
		textField_3 = new JTextField();
		panel_1.add(textField_3, "cell 6 5,growx");
		textField_3.setColumns(10);
		textField_3.setEditable(false);
		
		JLabel lblDiastolic = new JLabel("Diastolic");
		panel_1.add(lblDiastolic, "cell 7 5,alignx center");
		
		textField_4 = new JTextField();
		panel_1.add(textField_4, "cell 8 5,growx");
		textField_4.setColumns(10);
		textField_4.setEditable(false);
		
		JLabel lblDiagnosis = new JLabel("Diagnosis");
		panel_1.add(lblDiagnosis, "cell 3 6,alignx leading,aligny center");
		
		textField_5 = new JTextField();
		panel_1.add(textField_5, "cell 5 6 4 1,growx");
		textField_5.setColumns(10);
		textField_5.setEditable(false);
		
		JLabel lblMedicationsPrescribed = new JLabel("Medications Prescribed");
		panel_1.add(lblMedicationsPrescribed, "cell 3 7,aligny top");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, "cell 5 7 4 1,grow");
		
		String[] medColNames = {"Medicine Name", "Dosage", "Duration", "Notes"};
		medModel = new DefaultTableModel();
		medModel.setColumnIdentifiers(medColNames);
		table_1 = new JTable(medModel);
		scrollPane_1.setViewportView(table_1);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(150);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(70);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(70);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(70);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlight);
		add(panel_2, "cell 0 2,grow");
		panel_2.setLayout(new MigLayout("", "[][]", "[]"));
		
		btnBack = new JButton("Back");
		panel_2.add(btnBack, "cell 1 0");
		btnBack.addActionListener(listener);
		

	}
	private class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnBack) {
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			}
			else if(e.getSource() == btnSearch){
				//Get a doctor from the text field info
				name = textField.getText();
				phone = textField_1.getText();
				if(!parent.getHandler().getPatientUsername(name, phone).equals("")){
					patientUsername = parent.getHandler().getPatientUsername(name, phone);
					textField_6.setText(name);
					textField_7.setText(phone);
				}
			}
			else if(e.getSource() == btnView){
				//View visits from the selected doctor
				if(!textField_6.getText().equals("") && !textField_7.getText().equals("")){
					visitList = parent.getHandler().getPatientVisits(patientUsername);
				}
				listModel.removeAllElements();
				for(int i=0; i<visitList.size(); i++){
					listModel.addElement(visitList.get(i).getDateOfVisit());
				}
			}
			else if(e.getSource() == btnRecordAVisit){
				if(!textField.getText().equals("") && !textField_1.getText().equals("")){
					NewVisitPanel nvp = new NewVisitPanel(parent, username, textField.getText(), textField_1.getText());
					parent.getContentPane().add(nvp);
					CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
					cl.last(parent.getContentPane());
				}
				
			}
			else if(e.getSource() == btnSelect){
				//Populate fields based off the selected date
				String date = (String) list.getSelectedValue();
				int index = -1;
				for(int k=0; k<visitList.size(); k++){
					if(visitList.get(k).getDateOfVisit().equals(date)){
						index = k;
					}
				}
				Visit v = visitList.get(index);
				textField_2.setText(date);
				textField_3.setText("" + v.getSystolicPressure());
				textField_4.setText("" + v.getDiastolicPressure());
				textField_5.setText(parent.getHandler().getVisitDiagnosis(v.getPatUsername(), v.getDocUsername(), v.getDateOfVisit()));
				for(int y=0; y<medModel.getRowCount(); y++){
					medModel.removeRow(0);
				}
				ArrayList<Prescription> prescriptionList = parent.getHandler().getVisitPrescriptions(v.getPatUsername(), v.getDocUsername(), v.getDateOfVisit());
				for(int x=0; x<prescriptionList.size(); x++){
					Prescription cur = prescriptionList.get(x);
					Object[] row = {cur.getMedicineName(), cur.getDosage(), cur.getDuration(), cur.getNotes()};
					medModel.addRow(row);
				}
				
			}
		}
	}
}
