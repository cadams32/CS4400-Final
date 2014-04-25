package Backend;

public class Prescription {
	
	private int visitID;
	private String medicineName;
	private int dosage;
	private int duration;
	private String notes;
	private String ordered;
	private String patientUsername;
	private String docUsername;
	private String dateOfVisit;
	
	public Prescription(String patientUsername, String docUsername, String dateOfVisit, String medicineName, int dosage, int duration, String notes, String ordered) {
		this.setMedicineName(medicineName);
		this.setDosage(dosage);
		this.setDuration(duration);
		this.setNotes(notes);
		this.setOrdered(ordered);
	}

	public Prescription() {
		// TODO Auto-generated constructor stub
	}
	
	public void setPatientUsername(String patientUsername){
		this.patientUsername = patientUsername;
	}
	
	public String getPatientUsername(){
		return patientUsername;
	}
	
	public void setDocUsername(String docUsername){
		this.docUsername = docUsername;
	}
	
	public String getDocUsername(){
		return docUsername;
	}
	
	public void setDateOfVisit(String dateOfVisit){
		this.dateOfVisit = dateOfVisit;
	}
	
	public String getDateOfVisit(){
		return dateOfVisit;
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
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