package Backend;

public class Prescription {
	
	private String visitID;
	private String medicineName;
	private int dosage;
	private int durationDays;
	private int durationMonths;
	private String notes;
	private String ordered;
	
	public Prescription(String visitID, String medicineName, int dosage, int durationDays, int durationMonths, String notes, String ordered) {
		this.visitID = visitID;
		this.medicineName = medicineName;
		this.dosage = dosage;
		this.durationDays = durationDays;
		this.durationMonths = durationMonths;
		this.notes = notes;
		this.ordered = ordered;
	}
	
	public String getVisitID() {
		return visitID;
	}

	public void setVisitID(String visitID) {
		this.visitID = visitID;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public int getDosage() {
		return dosage;
	}

	public void setDosage(int dosage) {
		this.dosage = dosage;
	}

	public int getDurationDays() {
		return durationDays;
	}

	public void setDurationDays(int durationDays) {
		this.durationDays = durationDays;
	}

	public int getDurationMonths() {
		return durationMonths;
	}

	public void setDurationMonths(int durationMonths) {
		this.durationMonths = durationMonths;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getOrdered() {
		return ordered;
	}

	public void setOrdered(String ordered) {
		this.ordered = ordered;
	}

}
