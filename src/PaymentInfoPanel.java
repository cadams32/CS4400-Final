import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Backend.Card;
import Backend.Patient;
import Backend.Prescription;


public class PaymentInfoPanel extends JPanel {
	private JTextField cardNameTextField;
	private JTextField cardNoTextField;
	private JTextField cvvTextField;
	private Patient currPatient;
	
	private JComboBox boxExpYear;
	private JComboBox boxCardType;
	private JComboBox boxExpMonth;

	MedicalFrame parent;
	String username;
	JButton btnOrder;
	ArrayList<Prescription> cart;
	
	/**
	 * Create the panel.
	 */
	public PaymentInfoPanel(MedicalFrame parent, String username, ArrayList<Prescription> cart) {
		
		currPatient = new Patient();
		this.cart = cart;
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
		
		cardNameTextField = new JTextField();
		panel_1.add(cardNameTextField, "cell 2 1 4 1,growx");
		cardNameTextField.setColumns(10);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		panel_1.add(lblCardNumber, "cell 1 3,alignx leading");
		
		cardNoTextField = new JTextField();
		panel_1.add(cardNoTextField, "cell 2 3 4 1,growx");
		cardNoTextField.setColumns(10);
		
		JLabel lblTypeOfCard = new JLabel("Type of Card");
		panel_1.add(lblTypeOfCard, "cell 1 5,alignx leading");
		
		String[] cardTypes = {"Visa", "Discover", "MasterCard", "American Express"};
		boxCardType = new JComboBox(cardTypes);
		panel_1.add(boxCardType, "cell 2 5 2 1");
		
		JLabel lblCvv = new JLabel("CVV");
		panel_1.add(lblCvv, "cell 1 7,alignx leading");
		
		cvvTextField = new JTextField();
		panel_1.add(cvvTextField, "cell 2 7,growx");
		cvvTextField.setColumns(10);
		
		JLabel lblDateOfExpiry = new JLabel("Date of Expiry");
		panel_1.add(lblDateOfExpiry, "cell 1 9,alignx leading");
		
		String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		boxExpMonth = new JComboBox(months);
		panel_1.add(boxExpMonth, "cell 2 9");
		
		String[] year = {"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"};
		boxExpYear = new JComboBox(year);
		panel_1.add(boxExpYear, "cell 3 9");
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 2,grow");
		panel_2.setLayout(new MigLayout("", "[865.00][]", "[]"));
		
		btnOrder = new JButton("Order");
		panel_2.add(btnOrder, "cell 1 0");
		btnOrder.addActionListener(listener);
		
		populateFields();
	}
	
	public void populateFields(){
		//This method needs to populate the fields and make them not editable if there is already payment info for that user.
		 currPatient = parent.getHandler().getPatient(username);
		 System.out.println("CARDNO: " + currPatient.getCardNumber());
		 Card card = parent.getHandler().getCard(parent.getHandler().getCardByUsername(currPatient.getUsername()));
		 System.out.println("CARDOWNER: " + card.getCardHolderName());
		 if(card != null){
			 cardNameTextField.setText(currPatient.getName());
			 cardNameTextField.setEditable(false);
			 cardNoTextField.setText(card.getCardnumber());
			 cardNoTextField.setEditable(false);
			 boxCardType.setSelectedItem(card.getType());
			 boxCardType.setEditable(false);
			 cvvTextField.setText(card.getCvv());
			 cvvTextField.setEditable(false);
			 //Scanner scan = new Scanner(card.getDateOfExpiry());
			 System.out.println(card.getDateOfExpiry());
			 /*
			 scan.useDelimiter("-");
			 String expYear = scan.next();
			 String expMonth = scan.next();
			 boxExpMonth.setSelectedItem(expMonth);
			 boxExpMonth.setEditable(false);
			 boxExpYear.setSelectedItem(expYear);
			 boxExpYear.setEditable(false);
			 */
			 
		 }
	}
	
	private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == btnOrder){
				//DB Transaction
				String cardName = cardNameTextField.getText();
				String cardNo = cardNoTextField.getText();
				String cvv = cvvTextField.getText();
				String cardType = boxCardType.getSelectedItem().toString();
				String expMonth = boxExpMonth.getSelectedItem().toString();
				String expYear = boxExpYear.getSelectedItem().toString();
				String expirationDate = expYear.concat("-"+expMonth+"-01");
				
				if(cardName.equals("") && cardNo.equals("") && cvv.equals("") && cardType.equals("")) {
					//parent.getHandler().updateUserCardNo(username, cardNo);
					parent.getHandler().addNewPaymentInformation(cardNo, cardName, cvv, expirationDate, cardType);
				}
				
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				for(int i = 0; i<2; i++){
					parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				}
				cl.last(parent.getContentPane());
			}
		}
	}

}
