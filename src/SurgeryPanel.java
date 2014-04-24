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
	private JButton btnRecord, btnBack, btnAdd, btnSearch;
	private JTable table;
	private JTextField preOpMedTextField;
	
	private ArrayList<String> preOpMed;
	private ArrayList<Patient> pats;
	private ArrayList<Doctor> docs;
	private ArrayList<String> docNames;
	
	private JComboBox noAssistantsComboBox;
	private JComboBox surgeryStartComboBox;
	private JComboBox surgeryCompletionComboBox;
	private JComboBox procedureNameComboBox;
	private JComboBox anesthesiaStartComboBox;
	private JTextPane complicationsTextField;
	
	
	
	/**
	 * Create the panel.
	 */
	public SurgeryPanel(MedicalFrame parent, String username) {
		
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
		scrollPane_2.setBounds(185, 48, 618, 126);
		panel.add(scrollPane_2);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setBounds(98, 184, 83, 16);
		panel.add(lblPatientName);
		
		patientTextField = new JTextField();
		patientTextField.setBounds(185, 178, 130, 28);
		panel.add(patientTextField);
		patientTextField.setColumns(10);
		
		JLabel lblAnesthesiaStartTime = new JLabel("Anesthesia Start Time");
		lblAnesthesiaStartTime.setBounds(545, 184, 137, 16);
		panel.add(lblAnesthesiaStartTime);
		
		String[] times = {"12:00 am", "12:15 am", "12:30 am", "12:45 am", "1:00 am", "1:15 am", "1:30 am", "1:45 am",
				"2:00 am", "2:15 am", "2:30 am", "2:45 am", "3:00 am", "3:15 am", "3:30 am", "3:45 am", "4:00 am",
				"4:15 am", "4:30 am", "4:45 am", "5:00 am", "5:15 am", "5:30 am", "5:45 am", "6:00 am", "6:15 am",
				"6:30 am", "6:45 am", "7:00 am", "7:15 am", "7:30 am", "7:45 am", "8:00 am", "8:15 am", "8:30 am",
				"8:45 am", "9:00 am", "9:15 am", "9:30 am", "9:45 am", "10:00 am", "10:15 am", "10:30 am", "10:45 am",
				"11:00 am", "11:15 am", "11:30 am", "11:45 am", "12:00 pm", "12:15 pm", "12:30 pm", "12:45 pm", "1:00 pm",
				"1:15 pm", "1:30 pm", "1:45 pm", "2:00 pm", "2:15 pm", "2:30 pm", "2:45 pm", "3:00 pm", "3:15 pm",
				"3:30 pm", "3:45 pm", "4:00 pm", "4:15 pm", "4:30 pm", "4:45 pm", "5:00 pm", "5:15 pm", "5:30 pm",
				"5:45 pm", "6:00 pm", "6:15 pm", "6:30 pm", "6:45 pm", "7:00 pm", "7:15 pm", "7:30 pm", "7:45 pm",
				"8:00 pm", "8:15 pm", "8:30 pm", "8:45 pm", "9:00 pm", "9:15 pm", "9:30 pm", "9:45 pm", "10:00 pm",
				"10:15 pm", "10:30 pm", "10:45 pm", "11:00 pm", "11:15 pm", "11:30 pm", "11:45 pm"};
		anesthesiaStartComboBox = new JComboBox(times);
		anesthesiaStartComboBox.setBounds(694, 180, 109, 27);
		panel.add(anesthesiaStartComboBox);
		
		JLabel lblSurgeonName = new JLabel("Surgeon Name");
		lblSurgeonName.setBounds(90, 217, 91, 16);
		panel.add(lblSurgeonName);
		
		surgeonTextField = new JTextField();
		surgeonTextField.setBounds(185, 211, 130, 28);
		panel.add(surgeonTextField);
		surgeonTextField.setColumns(10);
		
		JLabel lblSurgeryStartTime = new JLabel("Surgery Start Time");
		lblSurgeryStartTime.setBounds(579, 217, 115, 16);
		panel.add(lblSurgeryStartTime);
		
		surgeryStartComboBox = new JComboBox(times);
		surgeryStartComboBox.setBounds(694, 213, 109, 27);
		panel.add(surgeryStartComboBox);
		
		JLabel lblProcedureName = new JLabel("Procedure Name");
		lblProcedureName.setBounds(79, 248, 102, 16);
		panel.add(lblProcedureName);
		
		String[] procedures = {"Procedure 1", "Procedure 2", "Procedure 3"};
		procedureNameComboBox = new JComboBox(procedures);
		procedureNameComboBox.setBounds(185, 244, 130, 27);
		panel.add(procedureNameComboBox);
		
		JLabel lblSurgeryCompletionTime = new JLabel("Surgery Completion Time");
		lblSurgeryCompletionTime.setBounds(531, 248, 159, 16);
		panel.add(lblSurgeryCompletionTime);
		
		surgeryCompletionComboBox = new JComboBox(times);
		surgeryCompletionComboBox.setBounds(694, 244, 109, 27);
		panel.add(surgeryCompletionComboBox);
		
		JLabel lblCptCode = new JLabel("CPT Code");
		lblCptCode.setBounds(121, 281, 60, 16);
		panel.add(lblCptCode);
		
		cptCodeTextField = new JTextField();
		cptCodeTextField.setBounds(185, 275, 130, 28);
		panel.add(cptCodeTextField);
		cptCodeTextField.setColumns(10);
		
		JLabel lblComplications = new JLabel("Complications");
		lblComplications.setBounds(541, 276, 91, 16);
		panel.add(lblComplications);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(632, 275, 171, 89);
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
		
		preOpMedTextField = new JTextField();
		preOpMedTextField.setBounds(185, 332, 134, 28);
		panel.add(preOpMedTextField);
		preOpMedTextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(348, 217, 151, 102);
		panel.add(scrollPane);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(326, 335, 93, 29);
		panel.add(btnAdd);
		
		JLabel lblPreopMeds = new JLabel("PreOp Meds");
		lblPreopMeds.setBounds(391, 197, 83, 16);
		panel.add(lblPreopMeds);
		
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
				for(Patient p : pats) {
					insert[0] = p.getName();
					insert[1] = p.getHomephone();
					
				}
			}
			else if(e.getSource() == btnAdd) {
				
			}	
			else if(e.getSource() == btnRecord){
				//DB Transaction
			}
		}
	}
}
