import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Backend.Doctor;
import Backend.Message;
import Backend.Patient;


public class InboxPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	
	private MedicalFrame parent;
	private String username;
	private DefaultTableModel model;
	private JButton btnBack;
	private String[] colNames = {"Status", "Date", "From", "Message"};
	
	ArrayList<Message> messages;
	
	public InboxPanel(MedicalFrame parent, String username) {
		
		this.parent = parent;
		this.username = username;
		ButtonListener listener = new ButtonListener();
		
		setLayout(new MigLayout("", "[grow]", "[100.00,grow][450.00,grow][50.00,grow]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[89.00][83.00,grow][][71.00][][119.00][][503.00][]", "[][][grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 1 1 7 2,grow");
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(colNames);

		table = new JTable(model);
		scrollPane.setViewportView(table);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		//table.getColumnModel().getColumn(3).setPreferredWidth(400);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 2,grow");
		panel_2.setLayout(new MigLayout("", "[872.00][]", "[]"));
		
		btnBack = new JButton("Back");
		panel_2.add(btnBack, "cell 1 0");
		btnBack.addActionListener(listener);
		
		ArrayList<Doctor> docs;
		
		messages = new ArrayList<Message>();
		if(parent.getHandler().doesPatientExist(username)) {
			messages = parent.getHandler().getSendsMessageToPatient(username);
			Object[] insert = new Object[4];
			for(Message m : messages) {
				Doctor doc = parent.getHandler().getDoctor(m.getSender());
				insert[0] = m.getStatus();
				insert[1] = m.getTime();
				insert[2] = "Dr. " + doc.getfName() + " " + doc.getlName();
				insert[3] = m.getMessage();
				model.addRow(insert);
			}
			model.fireTableDataChanged();

		} else if (parent.getHandler().doesDoctorExist(username)){
			
			messages = parent.getHandler().getSendsMessageToDoc(username);
			messages.addAll(parent.getHandler().getCommunicatesWith(username));
			
			Object[] insert = new Object[4];
			for(Message m : messages) {
				insert[0] = m.getStatus();
				insert[1] = m.getTime();
				if(parent.getHandler().doesPatientExist(m.getSender())) {
					Patient pat = parent.getHandler().getPatient(m.getSender());
					insert[2] = pat.getName();
				} else if (parent.getHandler().doesDoctorExist(m.getSender())) {
					Doctor doc = parent.getHandler().getDoctor(m.getSender());
					insert[2] = "Dr. " + doc.getfName() + " " + doc.getlName();
				}
				insert[3] = m.getMessage();
				model.addRow(insert);
			}
			model.fireTableDataChanged();
			
		}
		

	}
	private class ButtonListener implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnBack) {
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			}
			
		}
	}
}
	
	
