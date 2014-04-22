import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;


public class SurgeryPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;

	private MedicalFrame parent;
	private String username;
	JButton btnRecord, btnBack;
	
	/**
	 * Create the panel.
	 */
	public SurgeryPanel(MedicalFrame parent, String username) {
		
		this.parent = parent;
		this.username = username;
		
		setLayout(new MigLayout("", "[grow]", "[100.00][450.00,grow][50.00,grow]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 1,grow");
		panel.setLayout(new MigLayout("", "[180.00][179.00,grow][][128.00,grow][382.00,grow]", "[][146.00,grow][][][][grow][][grow][][grow]"));
		
		JLabel lblSearchPatient = new JLabel("Search patient:");
		panel.add(lblSearchPatient, "cell 2 0,alignx trailing");
		
		textField = new JTextField();
		panel.add(textField, "cell 3 0,growx");
		textField.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel.add(scrollPane_2, "cell 1 1 4 1,grow");
		
		JTextPane textPane_2 = new JTextPane();
		scrollPane_2.setViewportView(textPane_2);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		panel.add(lblPatientName, "cell 0 2,alignx trailing");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "cell 1 2,growx");
		textField_1.setColumns(10);
		
		JLabel lblAnesthesiaStartTime = new JLabel("Anesthesia Start Time");
		panel.add(lblAnesthesiaStartTime, "cell 3 2,alignx trailing");
		
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
		JComboBox comboBox_2 = new JComboBox(times);
		panel.add(comboBox_2, "cell 4 2,growx");
		
		JLabel lblSurgeonName = new JLabel("Surgeon Name");
		panel.add(lblSurgeonName, "cell 0 3,alignx trailing");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "cell 1 3,growx");
		textField_2.setColumns(10);
		
		JLabel lblSurgeryStartTime = new JLabel("Surgery Start Time");
		panel.add(lblSurgeryStartTime, "cell 3 3,alignx trailing");
		
		JComboBox comboBox_3 = new JComboBox(times);
		panel.add(comboBox_3, "cell 4 3,growx");
		
		JLabel lblProcedureName = new JLabel("Procedure Name");
		panel.add(lblProcedureName, "cell 0 4,alignx trailing");
		
		String[] procedures = {"Procedure 1", "Procedure 2", "Procedure 3"};
		JComboBox comboBox = new JComboBox(procedures);
		panel.add(comboBox, "cell 1 4,growx");
		
		JLabel lblSurgeryCompletionTime = new JLabel("Surgery Completion Time");
		panel.add(lblSurgeryCompletionTime, "cell 3 4,alignx trailing");
		
		JComboBox comboBox_4 = new JComboBox(times);
		panel.add(comboBox_4, "cell 4 4,growx");
		
		JLabel lblCptCode = new JLabel("CPT Code");
		panel.add(lblCptCode, "cell 0 5,alignx trailing");
		
		textField_4 = new JTextField();
		panel.add(textField_4, "cell 1 5,growx");
		textField_4.setColumns(10);
		
		JLabel lblComplications = new JLabel("Complications");
		panel.add(lblComplications, "cell 3 5");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1, "cell 4 5 1 4,grow");
		
		JTextPane textPane_1 = new JTextPane();
		scrollPane_1.setViewportView(textPane_1);
		
		JLabel lblNumberOfAssistants = new JLabel("Number of Assistants");
		panel.add(lblNumberOfAssistants, "cell 0 6,alignx trailing");
		
		String[] assistants = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
		JComboBox comboBox_1 = new JComboBox(assistants);
		panel.add(comboBox_1, "cell 1 6,growx");
		
		JLabel lblPreoperativeMedications = new JLabel("Pre-operative Medications");
		panel.add(lblPreoperativeMedications, "cell 0 7,alignx trailing");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 7 1 2,grow");
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 2,grow");
		panel_1.setLayout(new MigLayout("", "[405.00][][406.00][]", "[]"));
		
		btnRecord = new JButton("Record");
		panel_1.add(btnRecord, "cell 1 0");
		
		btnBack = new JButton("Back");
		panel_1.add(btnBack, "cell 3 0");

	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnBack) {
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			}
			else if(e.getSource() == btnRecord){
				//DB Transaction
			}
		}
	}

}
