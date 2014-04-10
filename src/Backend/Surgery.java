package Backend;

public class Surgery {
	
	private String CPTCode;
	private String surgeryType;
	private double costOfSurgery;
	
	//surgery start time
	//surgery end time
	//anesthesia start time
	//complitcations
	//no of assistants
	
	//idk about preOpMeds
	private String[] preOpMedication;
	
	public Surgery(String CPTCode, String surgeryType, double costOfSurgery) {
		this.CPTCode = CPTCode;
		this.surgeryType = surgeryType;
		this.costOfSurgery = costOfSurgery;
	}

	public String getCPTCode() {
		return CPTCode;
	}

	public void setCPTCode(String cPTCode) {
		CPTCode = cPTCode;
	}

	public String getSurgeryType() {
		return surgeryType;
	}

	public void setSurgeryType(String surgeryType) {
		this.surgeryType = surgeryType;
	}

	public double getCostOfSurgery() {
		return costOfSurgery;
	}

	public void setCostOfSurgery(double costOfSurgery) {
		this.costOfSurgery = costOfSurgery;
	}

}
