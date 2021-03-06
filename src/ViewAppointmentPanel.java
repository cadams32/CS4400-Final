import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Backend.Availability;
import Backend.Doctor;
import java.awt.SystemColor;
import java.awt.Font;


public class ViewAppointmentPanel extends JPanel {

	private MedicalFrame parent;
	private String username;
	JButton btnBack, btnSearch, btnRequestAppointment;
	ArrayList<Doctor> docs;
	DefaultTableModel model;
	private JTable table;
	JScrollPane scrollPane;
	String[] colNames = {"Doctor Name", "Phone Number", "Room Number", "Availability", "Average Rating"};
	JComboBox boxSpecialty;
	private JLabel lblViewAppointments;
	
	/**
	 * 
	 * Create the panel.
	 */
	public ViewAppointmentPanel(MedicalFrame parent, String username) {
		setBackground(SystemColor.textHighlight);
		
		this.parent = parent;
		this.username = username;
		ButtonListener listener = new ButtonListener();
		this.setBounds(100, 100, 1000, 600);
		
		setLayout(new MigLayout("", "[279.00,grow][67.00][145.00][279.00,grow][177.00]", "[100.00,grow][100.00,grow][400.00,grow][]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		add(panel, "cell 0 0 5 1,grow");
		panel.setLayout(null);
		
		lblViewAppointments = new JLabel("View Appointments");
		lblViewAppointments.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblViewAppointments.setBounds(388, 20, 320, 33);
		panel.add(lblViewAppointments);
		
		JLabel lblSpecialty = new JLabel("Specialty:");
		lblSpecialty.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblSpecialty, "cell 1 1");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		add(panel_1, "cell 2 1 2 1,grow");
		panel_1.setLayout(new MigLayout("", "[][61.00][]", "[][]"));
		
		String[] specialties = {"General Physician", "Heart Specialist", "Eye Physician", "Orthopedics", "Psychiatry", "Gynecologist"};
		boxSpecialty = new JComboBox(specialties);
		panel_1.add(boxSpecialty, "cell 0 1");
		
		/*
		String[] available = {};//POPULATE THIS WITH THE AVAILABILITY TIMES ONCE THE DB IS WORKING
		JComboBox boxAvailability = new JComboBox(available);
		panel_2.add(boxAvailability, "cell 1 1");
		*/
		btnSearch = new JButton("Search");
		panel_1.add(btnSearch, "cell 2 1");
		btnSearch.addActionListener(listener);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlight);
		add(panel_2, "cell 0 2 5 1,grow");
		panel_2.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		scrollPane = new JScrollPane();
		panel_2.add(scrollPane, "cell 0 0,grow");

		model = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
		model.setColumnIdentifiers(colNames);
		table = new JTable(model);
		scrollPane.setViewportView(table);

		
		btnRequestAppointment = new JButton("Request Appointment");
		add(btnRequestAppointment, "cell 2 3");
		btnRequestAppointment.addActionListener(listener);
		
		btnBack = new JButton("Back");
		add(btnBack, "cell 3 3");
		btnBack.addActionListener(listener);

	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == btnSearch){
				//DB query to populate doctor names
				//"Doctor Name", "Phone Number", "Room Number", "Availability", "Average Rating"
				String spec = (String) boxSpecialty.getSelectedItem();
				int count = table.getRowCount();
				for(int i=0; i<count; i++){
					model.removeRow(0);
				}
				model.fireTableRowsDeleted(0, count);
				
				ArrayList<Doctor> docList = parent.getHandler().getDoctorsBig();
				int docNum = docList.size();
				for(Doctor d: docList){
					if(d.getSpeciality().equals(spec)){
						ArrayList<Availability> availList= parent.getHandler().getDoctorAvailability(d.getUsername());
						for(Availability a: availList){
							Object[] nextRow = {d.getfName() + " " + d.getlName(), d.getWorkphone(), d.getRoomNo(), a.getDay() + " : " + a.getFrom() + " - " + a.getTo(), parent.getHandler().getDoctorRating(d.getUsername())}; 
							model.addRow(nextRow);
						}
					}
				}
			}
			else if(e.getSource() == btnRequestAppointment){
				//DB quest to request appointment
				String docName = (String) table.getValueAt(table.getSelectedRow(), 0);
				Scanner scan = new Scanner(docName);
				String fName = scan.next();
				String lName = scan.next();
				String docUsername = parent.getHandler().getDoctorUsername(fName, lName);
				
				if(parent.getHandler().getAppointmentsByPair(docUsername, username).size() == 0){
					scan = new Scanner((String) table.getValueAt(table.getSelectedRow(), 3));
					scan.next();
					scan.next();
					String startTime = scan.next();
					parent.getHandler().addNewAppointments(docUsername, username, "2014-04-30", startTime);
				}
				else{
					
				}
			}
			else if(e.getSource() == btnBack){
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			}
		}
	}

}
