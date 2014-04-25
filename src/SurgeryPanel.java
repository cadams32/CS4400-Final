import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;

import Backend.Doctor;
import Backend.Patient;
import Backend.Surgery;

import javax.swing.JSpinner;
import javax.swing.JProgressBar;


public class SurgeryPanel extends JPanel {
	private JTextField searchTextField;
	private JTextField patientTextField;
	private JTextField surgeonTextField;
	private JTextField cptCodeTextField;

	private JList list;
	
	private DefaultTableModel tableModel;
	private DefaultListModel listModel;
	
	private MedicalFrame parent;
	private String username;
	private JButton btnRecord, btnBack, selectBtn, btnSearch, selectButton;
	private JTable table;
	
	private ArrayList<String> preOpMed;
	private ArrayList<Patient> pats;
	private ArrayList<Doctor> docs;
	private ArrayList<String> docNames;
	private ArrayList<Surgery> types;
	
	private JComboBox noAssistantsComboBox;
	private JComboBox procedureNameComboBox;
	private JTextPane complicationsTextField;
	
	Patient currPatient;
	Doctor currDoctor;
	private JTextField anesthesiaStartTimeTextField;
	private JTextField surgeryStartTimeTextField;
	private JTextField surgeryCompletionTimeTextField;
	
	private ArrayList<String> typeNames;
	
	Surgery currSurgery;
	
	
	/**
	 * Create the panel.
	 */
	public SurgeryPanel(MedicalFrame parent, String username) {
		
		typeNames = new ArrayList<String>();
		types = parent.getHandler().getSurgery();
		for(Surgery s : types) {
			typeNames.add(s.getSurgeryType());
		}
		
		preOpMed = new ArrayList<String>();
		pats = new ArrayList<Patient>();
		docs = new ArrayList<Doctor>();
		docNames = new ArrayList<String>();
		
		this.parent = parent;
		this.username = username;
		ButtonListener listener = new ButtonListener();
		
		setLayout(new MigLayout("", "[grow]", "[100.00][450.00,grow][50.00,grow]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 1,grow");
		panel.setLayout(null);
		
		JLabel lblSearchPatient = new JLabel("Search patient:");
		lblSearchPatient.setBounds(319, 22, 93, 16);
		panel.add(lblSearchPatient);
		
		searchTextField = new JTextField();
		searchTextField.setBounds(416, 16, 159, 28);
		panel.add(searchTextField);
		searchTextField.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(98, 46, 535, 126);
		panel.add(scrollPane_2);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setBounds(98, 184, 83, 16);
		panel.add(lblPatientName);
		
		patientTextField = new JTextField();
		patientTextField.setEditable(false);
		patientTextField.setBounds(185, 178, 130, 28);
		panel.add(patientTextField);
		patientTextField.setColumns(10);
		
		JLabel lblAnesthesiaStartTime = new JLabel("Anesthesia Start Time");
		lblAnesthesiaStartTime.setBounds(400, 184, 137, 16);
		panel.add(lblAnesthesiaStartTime);

		JLabel lblSurgeonName = new JLabel("Surgeon Name");
		lblSurgeonName.setBounds(90, 217, 91, 16);
		panel.add(lblSurgeonName);
		
		surgeonTextField = new JTextField();
		surgeonTextField.setEditable(false);
		surgeonTextField.setBounds(185, 211, 130, 28);
		panel.add(surgeonTextField);
		surgeonTextField.setColumns(10);
		
		JLabel lblSurgeryStartTime = new JLabel("Surgery Start Time");
		lblSurgeryStartTime.setBounds(416, 217, 115, 16);
		panel.add(lblSurgeryStartTime);
		
		JLabel lblProcedureName = new JLabel("Procedure Name");
		lblProcedureName.setBounds(6, 248, 102, 16);
		panel.add(lblProcedureName);
		
		procedureNameComboBox = new JComboBox(typeNames.toArray());
		procedureNameComboBox.setBounds(113, 244, 151, 27);
		panel.add(procedureNameComboBox);
		
		JLabel lblSurgeryCompletionTime = new JLabel("Surgery Completion Time");
		lblSurgeryCompletionTime.setBounds(372, 245, 159, 16);
		panel.add(lblSurgeryCompletionTime);
		
		JLabel lblCptCode = new JLabel("CPT Code");
		lblCptCode.setBounds(121, 281, 60, 16);
		panel.add(lblCptCode);
		
		cptCodeTextField = new JTextField();
		cptCodeTextField.setEditable(false);
		cptCodeTextField.setBounds(185, 275, 130, 28);
		panel.add(cptCodeTextField);
		cptCodeTextField.setColumns(10);
		
		JLabel lblComplications = new JLabel("Complications");
		lblComplications.setBounds(438, 281, 91, 16);
		panel.add(lblComplications);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(541, 275, 262, 89);
		panel.add(scrollPane_1);
		
		complicationsTextField = new JTextPane();
		scrollPane_1.setViewportView(complicationsTextField);
		
		JLabel lblNumberOfAssistants = new JLabel("Number of Assistants");
		lblNumberOfAssistants.setBounds(44, 311, 137, 16);
		panel.add(lblNumberOfAssistants);
		
		String[] assistants = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
		noAssistantsComboBox = new JComboBox(assistants);
		noAssistantsComboBox.setBounds(185, 307, 130, 27);
		panel.add(noAssistantsComboBox);
		
		JLabel lblPreoperativeMedications = new JLabel("Pre-operative Medications");
		lblPreoperativeMedications.setBounds(16, 338, 165, 16);
		panel.add(lblPreoperativeMedications);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(185, 336, 175, 47);
		panel.add(scrollPane);
		
		selectBtn = new JButton("Select");
		selectBtn.setBounds(267, 243, 93, 29);
		panel.add(selectBtn);
		selectBtn.addActionListener(listener);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 2,grow");
		panel_1.setLayout(new MigLayout("", "[405.00][][406.00][]", "[]"));
		
		btnRecord = new JButton("Record");
		panel_1.add(btnRecord, "cell 1 0");
		btnRecord.addActionListener(listener);
		
		btnBack = new JButton("Back");
		panel_1.add(btnBack, "cell 3 0");
		btnBack.addActionListener(listener);
		
		tableModel = new DefaultTableModel();
		String[] colNames = {"Name", "Phone Number"};
		tableModel.setColumnIdentifiers(colNames);
		table = new JTable(tableModel);
		scrollPane_2.setViewportView(table);
		
		listModel = new DefaultListModel();
		JList list = new JList(listModel);
		scrollPane.setViewportView(list);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(577, 17, 117, 29);
		panel.add(btnSearch);
		
		selectButton = new JButton("Select");
		selectButton.setBounds(645, 93, 117, 29);
		panel.add(selectButton);
		
		anesthesiaStartTimeTextField = new JTextField();
		anesthesiaStartTimeTextField.setBounds(546, 178, 229, 28);
		panel.add(anesthesiaStartTimeTextField);
		anesthesiaStartTimeTextField.setColumns(10);
		
		surgeryStartTimeTextField = new JTextField();
		surgeryStartTimeTextField.setBounds(546, 211, 229, 28);
		panel.add(surgeryStartTimeTextField);
		surgeryStartTimeTextField.setColumns(10);
		
		surgeryCompletionTimeTextField = new JTextField();
		surgeryCompletionTimeTextField.setBounds(543, 242, 236, 28);
		panel.add(surgeryCompletionTimeTextField);
		surgeryCompletionTimeTextField.setColumns(10);
		btnSearch.addActionListener(listener);
		selectButton.addActionListener(listener);
		
		currPatient = new Patient();
		currDoctor = parent.getHandler().getDoctor(username);
		
		types = parent.getHandler().getSurgery();
		currSurgery = new Surgery();

	}
	
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnBack) {
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			}
			else if(e.getSource() == btnSearch) {
				String name = searchTextField.getText();
				pats = parent.getHandler().getPatientFromName(name);
				Object[] insert = new Object[2];
				for (int i = 0; i < table.getRowCount(); i++) {
					tableModel.removeRow(i);
				}
				for(Patient p : pats) {
					insert[0] = p.getName();
					insert[1] = p.getHomephone();
					tableModel.addRow(insert);
				}
				tableModel.fireTableDataChanged();
			}
			else if (e.getSource() == selectButton) {
				int row = table.getSelectedRow();
				currPatient = pats.get(row);
				patientTextField.setText(currPatient.getName());
				surgeonTextField.setText("Dr. " + currDoctor.getfName() + " " + currDoctor.getlName());
			}
			else if (e.getSource() == selectBtn) {
				String type = procedureNameComboBox.getSelectedItem().toString();
				for(Surgery s : types) {
					if(s.getSurgeryType().equals(type)) {
						currSurgery = s;
						break;
					}
				}
				cptCodeTextField.setText(currSurgery.getCPTCode());
				ArrayList<String> preopmed = parent.getHandler().getSurgeryPreOpMed(currSurgery.getCPTCode());
				listModel.removeAllElements();
				for(String s : preopmed) {
					listModel.addElement(s);
				}
						
			}
			else if(e.getSource() == btnRecord){

				int row = table.getSelectedRow();
				currPatient = pats.get(row);
				String patientName = currPatient.getName();
				String surgeonName = surgeonTextField.getText();
				int noAssistants = Integer.parseInt(noAssistantsComboBox.getSelectedItem().toString());
				String complications = complicationsTextField.getText();
				String cptCode = cptCodeTextField.getText();
				String procedureType = procedureNameComboBox.getSelectedItem().toString();
				String anesthesiaStart = anesthesiaStartTimeTextField.getText();
				String surgeryStartTime = surgeryStartTimeTextField.getText();
				String surgeryEndTime = surgeryCompletionTimeTextField.getText();
				if(currPatient.getAnnualIncome().equals("10000-25000")) {
					//costOfSurgery *= 0.5;
				}
				//parent.getHandler().addNewSurgery(cptCode, procedureType, costOfSurgery);
				//parent.getHandler().addNewPerforms(username, currPatient.getUsername(), cptCode, surgeryStartTime, surgeryEndTime, anesthesiaStart, complications, noAssistants);
				for(String s : preOpMed) {
					parent.getHandler().addNewSurgeryPreOpMeds(cptCode, s);
				}

			}
		}
	}
}
