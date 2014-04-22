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

import javax.swing.JTable;


public class ViewAppointmentPanel extends JPanel {

	private MedicalFrame parent;
	private String username;
	private JTable table;
	JButton btnBack, btnSearch, btnRequestAppointment;
	
	/**
	 * 
	 * Create the panel.
	 */
	public ViewAppointmentPanel(MedicalFrame parent, String username) {
		
		this.parent = parent;
		this.username = username;
		
		setLayout(new MigLayout("", "[279.00][67.00][145.00][279.00,grow][177.00]", "[100.00,grow][100.00,grow][400.00,grow][]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0 5 1,grow");
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JLabel lblSpecialty = new JLabel("Specialty:");
		lblSpecialty.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblSpecialty, "cell 1 1");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 2 1 2 1,grow");
		panel_1.setLayout(new MigLayout("", "[][61.00][]", "[][]"));
		
		String[] specialties = {"General Physician", "Heart Specialist", "Eye Physician", "Orthopedics", "Psychiatry", "Gynecologist"};
		JComboBox boxSpecialty = new JComboBox(specialties);
		panel_1.add(boxSpecialty, "cell 0 1");
		
		/*
		String[] available = {};//POPULATE THIS WITH THE AVAILABILITY TIMES ONCE THE DB IS WORKING
		JComboBox boxAvailability = new JComboBox(available);
		panel_2.add(boxAvailability, "cell 1 1");
		*/
		btnSearch = new JButton("Search");
		panel_1.add(btnSearch, "cell 2 1");
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 2 5 1,grow");
		panel_2.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		String[] colNames = {"Doctor Name", "Phone Number", "Room Number", "Availability", "Average Rating"};
		Object[][] data = {};
		table = new JTable(data, colNames);
		panel_2.add(table, "cell 0 0,grow");
		
		btnRequestAppointment = new JButton("Request Appointment");
		add(btnRequestAppointment, "cell 2 3");
		
		btnBack = new JButton("Back");
		add(btnBack, "cell 3 3");

	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == btnSearch){
				//DB query to populate doctor names
				
			}
			else if(e.getSource() == btnRequestAppointment){
				//DB quest to request appointment
				
			}
			else if(e.getSource() == btnBack){
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			}
		}
	}

}
