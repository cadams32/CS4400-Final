package Backend;

public class Visit {
	
	private String visitID;
	private String dateOfVisit;
	private String diastolicPressure;
	private String systolicPressure;
	private double billingAmount;
	
	private String docUsername;
	private String patUsername;
	
	public Visit(String visitID, String docUsername, String patUsername, String dateOfVisit, String diastolicPressure, String systolicPressure, double billingAmount) {
		this.visitID = visitID;
		this.docUsername = docUsername;
		this.patUsername = patUsername;
		this.dateOfVisit = dateOfVisit;
		this.diastolicPressure = diastolicPressure;
		this.systolicPressure = systolicPressure;
		this.billingAmount = billingAmount;
	}

	public String getVisitID() {
		return visitID;
	}

	public void setVisitID(String visitID) {
		this.visitID = visitID;
	}

	public String getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public String getDiastolicPressure() {
		return diastolicPressure;
	}

	public void setDiastolicPressure(String diastolicPressure) {
		this.diastolicPressure = diastolicPressure;
	}

	public String getSystolicPressure() {
		return systolicPressure;
	}

	public void setSystolicPressure(String systolicPressure) {
		this.systolicPressure = systolicPressure;
	}

	public double getBillingAmount() {
		return billingAmount;
	}

	public void setBillingAmount(double billingAmount) {
		this.billingAmount = billingAmount;
	}

	public String getDocUsername() {
		return docUsername;
	}

	public void setDocUsername(String docUsername) {
		this.docUsername = docUsername;
	}

	public String getPatUsername() {
		return patUsername;
	}

	public void setPatUsername(String patUsername) {
		this.patUsername = patUsername;
	}
	
	

}
