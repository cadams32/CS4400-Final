import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.miginfocom.swing.MigLayout;

import Backend.Doctor;
import Backend.Prescription;
import Backend.Visit;
import java.awt.SystemColor;
import java.awt.Font;


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
	private JLabel lblPatientVisits;
	
	/**
	 * Create the panel.
	 */
	
	public PatientVisitPanel(MedicalFrame parent, String username) {
		setBackground(SystemColor.textHighlight);
		
		visitList = new ArrayList<Visit>();
		doctorList = new ArrayList<Doctor>();
		prescriptionList = new ArrayList<Prescription>();
		totalBilling = new ArrayList<Integer>();
		this.setBounds(100, 100, 1000, 600);
		this.parent = parent;
		this.username = username;
		ButtonListener listener = new ButtonListener();
		
		setLayout(new MigLayout("", "[grow]", "[100.00,grow][450.00,grow][50.00,grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		add(panel, "cell 0 0,grow");
		panel.setLayout(null);
		
		lblPatientVisits = new JLabel("Patient Visits");
		lblPatientVisits.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblPatientVisits.setBounds(422, 29, 229, 26);
		panel.add(lblPatientVisits);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
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
		panel_2.setBackground(SystemColor.textHighlight);
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
				
				String year = (String) comboBox_1.getSelectedItem();
				String month = "";
				
				switch(comboBox.getSelectedItem().toString()) {
				case "January": month = "01";
					break;
				case "February": month = "02";
					break;
				case "March": month = "03";
					break;
				case "April": month = "04";
					break;
				case "May": month = "05";
					break;
				case "June": month = "06";
					break;
				case "July": month = "07";
					break;
				case "August": month = "08";
					break;
				case "September": month = "09";
					break;
				case "October": month = "10";
					break;
				case "Novermber": month = "11";
					break;
				case "December": month = "12";
					break;
				}
				String current = year+"-"+month;
				
				visitList = parent.getHandler().getVisits();
				doctorList = parent.getHandler().getDoctors();
				ArrayList<Visit> currentVisitList = new ArrayList<Visit>();
				ArrayList<String> docNames = new ArrayList<String>();
				for(Visit v : visitList){
					Scanner scan = new Scanner(v.getDateOfVisit());
					scan.useDelimiter("-");
					String curYear = scan.next();
					String curMonth = scan.next();
					if((curYear.equals(year)) && (curMonth.equals(month))){
						currentVisitList.add(v);
					}
				}
				
				
				for(Visit cur: currentVisitList){
					if(!docNames.contains(cur.getDocUsername())){
						docNames.add(cur.getDocUsername());
					}
				}
				
				int numDocs = docNames.size();
				int[] patientsSeen = new int[numDocs];
				int[] persWritten = new int[numDocs];
				int[] totalBilling = new int[numDocs];
				
				for(Visit v: currentVisitList){
					for(int i=0; i<docNames.size(); i++){
						if(v.getDocUsername().equals(docNames.get(i))){
							patientsSeen[i] += 1;
							totalBilling[i] += v.getBillingAmount();
						}
					}
				}
				
				for(int j=0; j<docNames.size(); j++){
					ArrayList<Prescription> prescList = new ArrayList<Prescription>();
					prescList.addAll(parent.getHandler().getPrescriptionByUsername(docNames.get(j)));
					persWritten[j] = prescList.size();
				}
				
				ArrayList<String> realNames = new ArrayList<String>();
				for(Doctor d: doctorList){
					if(docNames.contains(d.getUsername())){
						realNames.add("Dr. " + d.getfName() + " " + d.getlName());
					}
				}
				
				for(int k=0; k<docNames.size(); k++){
					Object[] nextRow = {realNames.get(k), patientsSeen[k], persWritten[k], totalBilling[k]};
					model.addRow(nextRow);
				}
				model.fireTableDataChanged();
				
			}
			
		}
		
	}
}