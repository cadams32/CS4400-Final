package Backend;

public class Performs {
	
	private String docUsername;
	private String patUsername;
	private String CPTcode;
	private String surgeryStartTime;
	private String surgeryEndTime;
	private String anesthesiaStartTime;
	private String complications;
	private int noOfAssistants;
	
	public Performs(String docUsername, String patUsername, String cPTcode,
			String surgeryStartTime, String surgeryEndTime,
			String anesthesiaStartTime, String complications, int noOfAssistants) {
		super();
		this.docUsername = docUsername;
		this.patUsername = patUsername;
		CPTcode = cPTcode;
		this.surgeryStartTime = surgeryStartTime;
		this.surgeryEndTime = surgeryEndTime;
		this.anesthesiaStartTime = anesthesiaStartTime;
		this.complications = complications;
		this.noOfAssistants = noOfAssistants;
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

	public String getCPTcode() {
		return CPTcode;
	}

	public void setCPTcode(String cPTcode) {
		CPTcode = cPTcode;
	}

	public String getSurgeryStartTime() {
		return surgeryStartTime;
	}

	public void setSurgeryStartTime(String surgeryStartTime) {
		this.surgeryStartTime = surgeryStartTime;
	}

	public String getSurgeryEndTime() {
		return surgeryEndTime;
	}

	public void setSurgeryEndTime(String surgeryEndTime) {
		this.surgeryEndTime = surgeryEndTime;
	}

	public String getAnesthesiaStartTime() {
		return anesthesiaStartTime;
	}

	public void setAnesthesiaStartTime(String anesthesiaStartTime) {
		this.anesthesiaStartTime = anesthesiaStartTime;
	}

	public String getComplications() {
		return complications;
	}

	public void setComplications(String complications) {
		this.complications = complications;
	}

	public int getNoOfAssistants() {
		return noOfAssistants;
	}

	public void setNoOfAssistants(int noOfAssistants) {
		this.noOfAssistants = noOfAssistants;
	}



}
