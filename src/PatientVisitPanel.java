
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Backend.Doctor;
import Backend.Prescription;
import Backend.Visit;


public class PatientVisitPanel extends JPanel {
	private JTable table;
	
	private MedicalFrame parent;
	private String username;
	JButton btnBack, btnUpdate;
	DefaultTableModel model;
	JComboBox comboBox, comboBox_1;
	ArrayList<Visit> visitList;
	ArrayList<String> doctorNames;
	ArrayList<Doctor> doctorList;
	ArrayList<Prescription> prescriptionList;
	ArrayList<Integer> totalBilling;
	
	/**
	 * Create the panel.
	 */
	
	public PatientVisitPanel(MedicalFrame parent, String username) {
		
		visitList = new ArrayList<Visit>();
		doctorList = new ArrayList<Doctor>();
		prescriptionList = new ArrayList<Prescription>();
		totalBilling = new ArrayList<Integer>();
		
		this.parent = parent;
		this.username = username;
		ButtonListener listener = new ButtonListener();
		
		setLayout(new MigLayout("", "[grow]", "[100.00,grow][450.00,grow][50.00,grow]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[200.00][grow][200.00,grow][200.00,grow][199.00]", "[][][][grow][]"));
		
		JLabel lblSelectMonth = new JLabel("Select Month");
		panel_1.add(lblSelectMonth, "cell 1 1,alignx trailing");
		
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		comboBox = new JComboBox(months);
		panel_1.add(comboBox, "cell 2 1,growx");
		
		String[] years = {"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"};
		comboBox_1 = new JComboBox(years);
		panel_1.add(comboBox_1, "cell 3 1,growx");
		
		btnUpdate = new JButton("Update");
		panel_1.add(btnUpdate, "cell 4 1");
		btnUpdate.addActionListener(listener);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 1 3 3 1,grow");
		
		String[] colNames = {"Doctor Name", "Number of Patients Seen", "Number of Prescriptions Written", "Total Billing"};
		model = new DefaultTableModel(){
			@Override
		    public boolean isCellEditable(int row, int column) {
	        //all cells false
			return false;
			}
	    };
		table = new JTable(model);
		model.setColumnIdentifiers(colNames);
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 2,grow");
		panel_2.setLayout(new MigLayout("", "[863.00][]", "[]"));
		
		btnBack = new JButton("Back");
		panel_2.add(btnBack, "cell 1 0");
		btnBack.addActionListener(listener);
		
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnBack) {
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			}
			else if (e.getSource() == btnUpdate) {
				//DB query to update the table
				//ArrayList<Visit> visitList = parent.getHandler().getVisit();			
				
				String month = (String) comboBox.getSelectedItem();
				String year = (String) comboBox_1.getSelectedItem();
				
				visitList = parent.getHandler().getVisits();
				
				doctorList = parent.getHandler().getDoctors();
				for(Doctor d : doctorList) {
					
				}
				visitList = parent.getHandler().getV
				
				
			}
			
		}
		
	}
}
