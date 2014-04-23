import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import Backend.Appointment;


public class ViewAppointmentDatePanel extends JPanel {

	private JComboBox monthsComboBox;
	private JComboBox yearsComboBox;
	private JComboBox daysComboBox;
	private JScrollPane scrollPane;
	private JTable table;

	private MedicalFrame parent;
	private String username;
	private JButton btnBack;
	private JButton btnGo;
	
	private DefaultTableModel model;
	private String[] columnNames = {"Sno", "Patient Name", "Scheduled Time"};
	
	/**
	 * Create the panel.
	 */
	public ViewAppointmentDatePanel(MedicalFrame parent, String username,Integer day,String month,Integer year) {
		
		this.parent = parent;
		this.username = username;
		
		setBackground(SystemColor.textHighlight);
		setLayout(null);
		
		JLabel lblAppointmentCalendar = new JLabel("Appointment Calendar");
		lblAppointmentCalendar.setBounds(395, 19, 199, 16);
		add(lblAppointmentCalendar);
	
		String[] days = {"-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		String[] years = {"1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014"};
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		monthsComboBox = new JComboBox(months);
		monthsComboBox.setBounds(478, 48, 130, 27);
		add(monthsComboBox);
		monthsComboBox.setSelectedItem(month);
		
		yearsComboBox = new JComboBox(years);
		yearsComboBox.setBounds(630, 48, 98, 27);
		add(yearsComboBox);
		yearsComboBox.setSelectedItem(year.toString());
		
		daysComboBox = new JComboBox(days);
		daysComboBox.setBounds(376, 48, 72, 27);
		add(daysComboBox);
		daysComboBox.setSelectedItem(day.toString());
		
		JLabel label = new JLabel("Date:");
		label.setBounds(284, 52, 61, 16);
		add(label);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 131, 799, 335);
		add(scrollPane);
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		ButtonListener listener = new ButtonListener();
		
		btnBack = new JButton("Back");
		btnBack.setBounds(891, 562, 97, 25);
		btnBack.addActionListener(listener);
		add(btnBack);
		
		btnGo = new JButton("Go");
		btnGo.setBounds(773, 48, 104, 27);
		btnGo.addActionListener(listener);
		add(btnGo);
		
		btnGo.doClick();

	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnBack){
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			} else if (e.getSource() == btnGo) {
				if(daysComboBox.getSelectedItem().equals("-")) {
					CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
					parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
					cl.last(parent.getContentPane());
				} else {
					model = new DefaultTableModel();
					model.setColumnIdentifiers(columnNames);
					table.setModel(model);
					int day = Integer.parseInt(daysComboBox.getSelectedItem().toString());
					int month = monthsComboBox.getSelectedIndex();
					int year = Integer.parseInt(yearsComboBox.getSelectedItem().toString()) - 1900;
					Date date = new Date(year, month, day);
					ArrayList<Appointment> appt = parent.getHandler().getAppointmentsForDoctor(username);
					Object[] insert = new Object[3];
					int i = 1;
					for(Appointment a : appt) {
						System.out.println("Hi");
						System.out.print(a.getDate() + " " + date);
						if(a.getDate().equals(date)) {
						insert[0] = i;
						insert[1] = parent.getHandler().getPatient(a.getPatUsername()).getName();
						insert[2] = a.getTime();
						System.out.println(insert[0] + " " + insert[1] + " " + insert[2]);
						model.addRow(insert);
						i++;
						}
					}
					model.fireTableDataChanged();
				}
			}
		}
	}

}
