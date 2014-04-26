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
import java.awt.SystemColor;
import java.awt.Font;


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
		setBackground(SystemColor.textHighlight);
		this.setBounds(100, 100, 1000, 600);
		currPatient = new Patient();
		this.cart = cart;
		this.parent = parent;
		this.username = username;
		setLayout(new MigLayout("", "[grow]", "[100.00,grow][450.00,grow][50.00,grow]"));
		ButtonListener listener = new ButtonListener();
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		add(panel, "cell 0 0,grow");
		panel.setLayout(null);
		
		JLabel lblPaymentInformation = new JLabel("Payment Information");
		lblPaymentInformation.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblPaymentInformation.setBounds(337, 18, 424, 36);
		panel.add(lblPaymentInformation);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(null);
		
		JLabel lblCardholdersName = new JLabel("Cardholder's Name");
		lblCardholdersName.setBounds(246, 51, 119, 16);
		panel_1.add(lblCardholdersName);
		
		cardNameTextField = new JTextField();
		cardNameTextField.setBounds(369, 45, 329, 28);
		panel_1.add(cardNameTextField);
		cardNameTextField.setColumns(10);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setBounds(246, 112, 83, 16);
		panel_1.add(lblCardNumber);
		
		cardNoTextField = new JTextField();
		cardNoTextField.setBounds(369, 106, 329, 28);
		panel_1.add(cardNoTextField);
		cardNoTextField.setColumns(10);
		
		JLabel lblTypeOfCard = new JLabel("Type of Card");
		lblTypeOfCard.setBounds(246, 171, 80, 16);
		panel_1.add(lblTypeOfCard);
		
		String[] cardTypes = {"Visa", "Discover", "MasterCard", "American Express"};
		boxCardType = new JComboBox(cardTypes);
		boxCardType.setBounds(369, 167, 168, 27);
		panel_1.add(boxCardType);
		
		JLabel lblCvv = new JLabel("CVV");
		lblCvv.setBounds(246, 233, 25, 16);
		panel_1.add(lblCvv);
		
		cvvTextField = new JTextField();
		cvvTextField.setBounds(369, 227, 76, 28);
		panel_1.add(cvvTextField);
		cvvTextField.setColumns(10);
		
		JLabel lblDateOfExpiry = new JLabel("Date of Expiry");
		lblDateOfExpiry.setBounds(246, 292, 89, 16);
		panel_1.add(lblDateOfExpiry);
		
		String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		boxExpMonth = new JComboBox(months);
		boxExpMonth.setBounds(369, 288, 72, 27);
		panel_1.add(boxExpMonth);
		
		String[] year = {"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"};
		boxExpYear = new JComboBox(year);
		boxExpYear.setBounds(449, 288, 88, 27);
		panel_1.add(boxExpYear);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlight);
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
		 Card card = parent.getHandler().getCard(parent.getHandler().getCardByUsername(currPatient.getUsername()));
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
