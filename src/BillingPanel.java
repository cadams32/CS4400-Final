import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Backend.Surgery;
import Backend.Visit;


public class BillingPanel extends JPanel {
	private JTextField nameTextField;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField costTextField;
	
	private MedicalFrame parent;
	private String username;
	private JButton btnCreateBill, btnBack;
	private DefaultListModel phoneModel, visitModel, surgeryModel;

	/**
	 * Create the panel.
	 */
	public BillingPanel(MedicalFrame parent, String username) {
		
		this.parent = parent;
		this.username = username;
		
		setLayout(new MigLayout("", "[grow]", "[100.00,grow][450.00,grow][50.00,grow]"));
		ButtonListener listener = new ButtonListener();
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[100.00][200.00,grow][200.00,grow][200.00,grow][64.00][106.00,grow]", "[][201.00,grow][122.00]"));
		
		JLabel lblPatientsName = new JLabel("Patient's Name");
		panel_1.add(lblPatientsName, "cell 1 0,alignx trailing");
		
		nameTextField = new JTextField();
		panel_1.add(nameTextField, "cell 2 0,growx");
		nameTextField.setColumns(10);
		
		btnCreateBill = new JButton("Create Bill");
		panel_1.add(btnCreateBill, "cell 3 0");
		btnCreateBill.addActionListener(listener);
		
		JScrollPane patientScrollPane = new JScrollPane();
		panel_1.add(patientScrollPane, "cell 1 1,grow");
		
		String[] colNames = {"Patient Name", "Phone Number"};
		Object[][] data = {};
		table = new JTable(data, colNames);
		//patientScrollPane.setViewportView(table);
		phoneModel = new DefaultListModel();
		patientScrollPane.setViewportView(new JList(phoneModel));
		
		JScrollPane visitScrollPane = new JScrollPane();
		panel_1.add(visitScrollPane, "cell 2 1,grow");
		
		String[] colNames_1 = {"Visits", "Cost"};
		Object[][] data_1 = {};
		table_1 = new JTable(data_1, colNames_1);
		//visitScrollPane.setViewportView(table_1);
		visitModel = new DefaultListModel();
		visitScrollPane.setViewportView(new JList(visitModel));
		
		JScrollPane surgeryScrollPane = new JScrollPane();
		panel_1.add(surgeryScrollPane, "cell 3 1,grow");
		
		String[] colNames_2 = {"Surgery", "Cost"};
		Object[][] data_2 = {};
		table_2 = new JTable(data_2, colNames_2);
		//surgeryScrollPane.setViewportView(table_2);
		surgeryModel = new DefaultListModel();
		surgeryScrollPane.setViewportView(new JList(surgeryModel));

		JLabel lblTotalCost = new JLabel("Total Cost");
		panel_1.add(lblTotalCost, "cell 4 1,alignx trailing");
		
		costTextField = new JTextField();
		panel_1.add(costTextField, "cell 5 1,growx");
		costTextField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 2,grow");
		panel_2.setLayout(new MigLayout("", "[894.00][]", "[]"));
		
		btnBack = new JButton("Back");
		panel_2.add(btnBack, "cell 1 0");
		btnBack.addActionListener(listener);
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
				DecimalFormat df = new DecimalFormat("##.00");
				double total = 0;
				String visit = "";
				String surgery = "";
				String name = nameTextField.getText();
				String phone = parent.getHandler().getPatientPhoneNumber(name);
				String patUsername = parent.getHandler().getPatientUsername(name, phone);
				phoneModel.addElement("       Name       " + "        " + "Phone Number");
				phoneModel.addElement(name + "            " + phone);

				visitModel.addElement("       Date        " + "              " + "Amount");
				ArrayList<Visit> visitList = parent.getHandler().getPatientVisits(patUsername);
				for (Visit s: visitList) {
					visit = s.getDateOfVisit() + "                    " + df.format(s.getBillingAmount());
					total += s.getBillingAmount();
					visitModel.addElement(visit);
				}
				
				ArrayList<String> cptList = parent.getHandler().getCPTCode(patUsername);
				surgeryModel.addElement("     Surgery Type     " + "                     " + "Cost");
				for (String cpt: cptList) {
					for (Surgery s: parent.getHandler().getSurgery(cpt)) {
						surgery = s.getSurgeryType() + "                " + df.format(s.getCostOfSurgery());
						total += s.getCostOfSurgery();
						surgeryModel.addElement(surgery);
					}
				}
				costTextField.setText("$"+String.valueOf(df.format(total)));				
			}	
		}
		
	}

}
