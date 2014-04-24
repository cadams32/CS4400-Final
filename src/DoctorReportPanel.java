
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


public class DoctorReportPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	
	private MedicalFrame parent;
	private String username;
	//private ArrayList<String> specialty;
	//private ArrayList<>
	JButton btnBack;
	DefaultTableModel model;
	
	public DoctorReportPanel(MedicalFrame parent, String username) {
		
		this.parent = parent;
		this.username = username;
		ButtonListener listener = new ButtonListener();
		
		setLayout(new MigLayout("", "[grow]", "[100.00,grow][449.00,grow][50.00,grow]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[200.00][600.00,grow][200.00]", "[][329.00,grow][91.00]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 1 1,grow");
		
		String[] colNames = {"Specialty", "Average Rating", "Number of Surgeries Performed"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(colNames);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 2,grow");
		panel_2.setLayout(new MigLayout("", "[904.00][]", "[]"));
		
		btnBack = new JButton("Back");
		panel_2.add(btnBack, "cell 1 0");
		btnBack.addActionListener(listener);
		
		populateTable();
	}
	
	public void populateTable(){
		ArrayList<Doctor> docList = new ArrayList<Doctor>();
		ArrayList<String> cptList = new ArrayList<String>();
		String[] specialties = {"General Physician", "Heart Specialist", "Eye Physician", "Orthopedics", "Psychiatry", "Gynecologist"};
		int[] surgeries = new int[6];
		double[] numers = new double[6];
		double[] denoms = new double[6];
		int[] avgRating = new int[6];
		for(int j=0; j<6; j++){
			surgeries[j] = 0;
			numers[j] = 0;
			denoms[j] = 0;
			avgRating[j] = 0;
		}
		
		System.out.println("---------------");
		
		for(int i=0; i<6; i++){
			docList = parent.getHandler().getSpecialtyDoctors(specialties[i]);
			for(Doctor d: docList){
				String str = parent.getHandler().getDoctorRating(d.getUsername());
				if(str != null){
					double rating = Double.parseDouble(parent.getHandler().getDoctorRating(d.getUsername()));
					numers[i] += rating;
					System.out.println("RATING FOUND: " + rating);
					denoms[i] += 1;
				}
				cptList = parent.getHandler().getCPTCode(d.getUsername());
				if(cptList != null){
					surgeries[i] += cptList.size();
				}
			}
			System.out.println("numer " + i + " = " + numers[i]);
			System.out.println("denom " + i + " = " + denoms[i]);
		}
		
		for(int k=0; k<6; k++){
			avgRating[k] = (int) Math.round(numers[k] / denoms[k]);
			Object[] nextRow = {specialties[k], avgRating[k], surgeries[k]};
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
