import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class BillingPanel extends JPanel {
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField_1;
	
	private MedicalFrame parent;
	private String username;
	JButton btnCreateBill, btnBack;

	/**
	 * Create the panel.
	 */
	public BillingPanel(MedicalFrame parent, String username) {
		
		this.parent = parent;
		this.username = username;
		
		setLayout(new MigLayout("", "[grow]", "[100.00,grow][450.00,grow][50.00,grow]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[100.00][200.00,grow][200.00,grow][200.00,grow][64.00][106.00,grow]", "[][201.00,grow][122.00]"));
		
		JLabel lblPatientsName = new JLabel("Patient's Name");
		panel_1.add(lblPatientsName, "cell 1 0,alignx trailing");
		
		textField = new JTextField();
		panel_1.add(textField, "cell 2 0,growx");
		textField.setColumns(10);
		
		btnCreateBill = new JButton("Create Bill");
		panel_1.add(btnCreateBill, "cell 3 0");
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 1 1,grow");
		
		String[] colNames = {"Patient Name", "Phone Number"};
		Object[][] data = {};
		table = new JTable(data, colNames);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, "cell 2 1,grow");
		
		String[] colNames_1 = {"Visits", "Cost"};
		Object[][] data_1 = {};
		table_1 = new JTable(data_1, colNames_1);
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_1.add(scrollPane_2, "cell 3 1,grow");
		
		String[] colNames_2 = {"Surgery", "Cost"};
		Object[][] data_2 = {};
		table_2 = new JTable(data_2, colNames_2);
		scrollPane_2.setViewportView(table_2);
		
		JLabel lblTotalCost = new JLabel("Total Cost");
		panel_1.add(lblTotalCost, "cell 4 1,alignx trailing");
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 5 1,growx");
		textField_1.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 2,grow");
		panel_2.setLayout(new MigLayout("", "[894.00][]", "[]"));
		
		btnBack = new JButton("Back");
		panel_2.add(btnBack, "cell 1 0");

	}
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnBack) {
				//go back
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
				
			} else if (e.getSource() == btnCreateBill) {
				//DB transaction
				
			}	
		}
		
	}

}
