import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Backend.Doctor;
import Backend.Performs;
import Backend.Surgery;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;


public class SurgeryPerformedPanel extends JPanel {
	private JTable table;
	private MedicalFrame parent;
	private String username;
	JButton btnBack;
	DefaultTableModel model;
	
	/**
	 * Create the panel.
	 */
	public SurgeryPerformedPanel(MedicalFrame parent, String username) {
		setBackground(SystemColor.textHighlight);
		
		this.parent = parent;
		this.username = username;
		ButtonListener listener = new ButtonListener();
		this.setBounds(100, 100, 1000, 600);
		setLayout(new MigLayout("", "[grow]", "[100.00,grow][450.00,grow][50.00,grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		add(panel, "cell 0 0,grow");
		panel.setLayout(null);
		
		JLabel lblSurgeryPerformed = new JLabel("Surgery Performed");
		lblSurgeryPerformed.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblSurgeryPerformed.setBounds(345, 28, 331, 28);
		panel.add(lblSurgeryPerformed);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[200.00][600.00,grow][200.00]", "[][304.00,grow][96.00]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 1 1,grow");
		
		String[] colNames = {"Surgery Type", "CPT code", "Number of Procedures", "No. of Doctors Performing the Procedure", "Total Billing ($)"};
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
		panel_2.setLayout(new MigLayout("", "[880.00][]", "[]"));
		
		btnBack = new JButton("Back");
		panel_2.add(btnBack, "cell 1 0");
		btnBack.addActionListener(listener);
		
		populateTable();
	}
	
	public void populateTable(){
		ArrayList<Surgery> surgList = parent.getHandler().getSurgery();
		ArrayList<Performs> perfList = parent.getHandler().getPerforms();
		ArrayList<String> docList = new ArrayList<String>();
		ArrayList<Surgery> curSurg = new ArrayList<Surgery>();
		int numSurgs = surgList.size();
		String[] surgName = new String[numSurgs];
		String[] CPTCodes = new String[numSurgs];
		int[] numProcedures = new int[numSurgs];
		int[] numDocs = new int[numSurgs];
		double[] totalBilling = new double[numSurgs];
		for(int i=0; i<numSurgs; i++){
			docList = new ArrayList<String>();
			curSurg = new ArrayList<Surgery>();
			surgName[i] = surgList.get(i).getSurgeryType();
			CPTCodes[i] = surgList.get(i).getCPTCode();
			for(Performs p: perfList){
				if(CPTCodes[i].equals(p.getCPTcode())){
					numProcedures[i] += 1;
					curSurg = parent.getHandler().getSurgery(p.getCPTcode());
					totalBilling[i] += curSurg.get(0).getCostOfSurgery();
					if(!docList.contains(p.getDocUsername())){
						docList.add(p.getDocUsername());
					}
					numDocs[i] = docList.size();
				}
			}
			docList.removeAll(docList);
		}
		for(int j=0; j<numSurgs; j++){
			Object[] nextRow = {surgName[j], CPTCodes[j], numProcedures[j], numDocs[j], totalBilling[j]};
			model.addRow(nextRow);
		}
		
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnBack) {
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			}
			
		}
		
	}
}
