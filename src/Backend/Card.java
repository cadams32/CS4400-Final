package Backend;

public class Card {
	
	private String cardnumber;
	private String cardHolderName;
	private String cvv;
	private String dateOfExpiry;
	private String type;
	
	//possibly need Patient it is attached to.
	
	public Card(String cardnumber, String cardHolderName, String cvv, String dateOfExpiry, String type) {
		this.cardnumber = cardnumber;
		this.cardHolderName = cardHolderName;
		this.cvv = cvv;
		this.dateOfExpiry = dateOfExpiry;
		this.type = type;
	
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(String dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
