import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;


public class OrderMedicationPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	private MedicalFrame parent;
	private String username;
	
	JButton btnAddToCart, btnCheckout, btnBack;
	JComboBox boxDosage, boxDurationMonths, boxDurationDays, boxDay, boxMonth, boxYear;
	ArrayList<String[]> cart;
	
	/**
	 * Create the panel.
	 */
	public OrderMedicationPanel(MedicalFrame parent, String username) {
		
		this.parent = parent;
		this.username = username;
		cart = new ArrayList<String[]>();
		ButtonListener listener = new ButtonListener();
		
		setLayout(new MigLayout("", "[1000.00,grow]", "[100.00,grow][436.00,grow][50.00,grow]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 1,alignx leading,growy");
		panel_1.setLayout(new MigLayout("", "[180.00][138.00][49.00,grow][][][96.00,grow][460.00]", "[][][][][][][][][][]"));
		
		JLabel lblMedicineName = new JLabel("Medicine Name");
		panel_1.add(lblMedicineName, "cell 1 1,alignx leading");
		
		textField = new JTextField();
		panel_1.add(textField, "cell 2 1 4 1,growx");
		textField.setColumns(10);
		
		JLabel lblDosage = new JLabel("Dosage");
		panel_1.add(lblDosage, "cell 1 3");
		
		String[] dosage = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		boxDosage = new JComboBox(dosage);
		panel_1.add(boxDosage, "cell 2 3");
		
		JLabel lblPerDay = new JLabel("Per Day");
		panel_1.add(lblPerDay, "cell 3 3");
		
		JLabel lblDuration = new JLabel("Duration");
		panel_1.add(lblDuration, "cell 1 5");
		
		String[] durationMonths = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
		boxDurationMonths = new JComboBox(durationMonths);
		panel_1.add(boxDurationMonths, "cell 2 5");
		
		JLabel lblMonths = new JLabel("Months");
		panel_1.add(lblMonths, "cell 3 5");
		
		String[] durationDays = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
				"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		boxDurationDays = new JComboBox(durationDays);
		panel_1.add(boxDurationDays, "cell 4 5");
		
		JLabel lblDays = new JLabel("Days");
		panel_1.add(lblDays, "cell 5 5");
		
		JLabel lblConsultingDoctor = new JLabel("Consulting Doctor");
		panel_1.add(lblConsultingDoctor, "cell 1 7,alignx leading");
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 2 7 4 1,growx");
		textField_1.setColumns(10);
		
		JLabel lblDateOfPrescription = new JLabel("Date of Prescription");
		panel_1.add(lblDateOfPrescription, "cell 1 9");
		
		String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		boxMonth = new JComboBox(months);
		panel_1.add(boxMonth, "cell 2 9");
		
		String[] days = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
			"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		boxDay = new JComboBox(days);
		panel_1.add(boxDay, "cell 3 9");
		
		String[] year = {"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"};
		boxYear = new JComboBox(year);
		panel_1.add(boxYear, "cell 4 9");
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 2,grow");
		panel_2.setLayout(new MigLayout("", "[641.00][][][][][]", "[]"));
		
		btnAddToCart = new JButton("Add to Cart");
		panel_2.add(btnAddToCart, "cell 1 0");
		btnAddToCart.addActionListener(listener);
		
		btnCheckout = new JButton("Checkout");
		panel_2.add(btnCheckout, "cell 3 0");
		btnCheckout.addActionListener(listener);
		
		btnBack = new JButton("Back");
		panel_2.add(btnBack, "cell 5 0");
		btnBack.addActionListener(listener);

	}

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnAddToCart){
				String[] str = {(String) textField.getText(),(String) boxDosage.getSelectedItem(),(String) boxDurationMonths.getSelectedItem(),(String) boxDurationDays.getSelectedItem(),
						(String) textField_1.getText(),(String) boxMonth.getSelectedItem(),(String) boxDay.getSelectedItem(),(String) boxYear.getSelectedItem()};
				cart.add(str);
			}
			else if(e.getSource() == btnCheckout){
				//Need to send the whole cart to DB here
				
				PaymentInfoPanel pip = new PaymentInfoPanel(parent, username);
				parent.getContentPane().add(pip);
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				cl.next(parent.getContentPane());
			}
			else if(e.getSource() == btnBack){
				//Go Back
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			}
		}
	}
}
