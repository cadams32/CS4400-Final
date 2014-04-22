import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class PaymentInfoPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	MedicalFrame parent;
	String username;
	JButton btnOrder;
	
	/**
	 * Create the panel.
	 */
	public PaymentInfoPanel(MedicalFrame parent, String username) {
		
		this.parent = parent;
		this.username = username;
		setLayout(new MigLayout("", "[grow]", "[100.00,grow][450.00,grow][50.00,grow]"));
		ButtonListener listener = new ButtonListener();
		
		JPanel panel = new JPanel();
		add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[151.00][][70.00,grow][66.00][100.00][156.00][428.00]", "[][][][][][][][][][]"));
		
		JLabel lblCardholdersName = new JLabel("Cardholder's Name");
		panel_1.add(lblCardholdersName, "cell 1 1,alignx leading");
		
		textField = new JTextField();
		panel_1.add(textField, "cell 2 1 4 1,growx");
		textField.setColumns(10);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		panel_1.add(lblCardNumber, "cell 1 3,alignx leading");
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 2 3 4 1,growx");
		textField_1.setColumns(10);
		
		JLabel lblTypeOfCard = new JLabel("Type of Card");
		panel_1.add(lblTypeOfCard, "cell 1 5,alignx leading");
		
		String[] cardTypes = {"Visa", "Discover", "MasterCard", "American Express"};
		JComboBox boxCardType = new JComboBox(cardTypes);
		panel_1.add(boxCardType, "cell 2 5 2 1");
		
		JLabel lblCvv = new JLabel("CVV");
		panel_1.add(lblCvv, "cell 1 7,alignx leading");
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "cell 2 7,growx");
		textField_2.setColumns(10);
		
		JLabel lblDateOfExpiry = new JLabel("Date of Expiry");
		panel_1.add(lblDateOfExpiry, "cell 1 9,alignx leading");
		
		String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		JComboBox boxExpMonth = new JComboBox(months);
		panel_1.add(boxExpMonth, "cell 2 9");
		
		String[] year = {"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"};
		JComboBox boxExpYear = new JComboBox(year);
		panel_1.add(boxExpYear, "cell 3 9");
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 2,grow");
		panel_2.setLayout(new MigLayout("", "[865.00][]", "[]"));
		
		btnOrder = new JButton("Order");
		panel_2.add(btnOrder, "cell 1 0");
		btnOrder.addActionListener(listener);

	}
	
	public void populateFields(){
		//This method needs to populate the fields and make them not editable if there is already payment info for that user.
		
	}
	
	private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == btnOrder){
				//DB Transaction
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				for(int i = 0; i<2; i++){
					parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				}
				cl.last(parent.getContentPane());
			}
		}
	}

}
