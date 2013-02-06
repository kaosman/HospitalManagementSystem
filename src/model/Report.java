package model;

public class Report {

	private String diagnosis;
	private String prescription;
	private String auditTrailId;
	private String healthInsuranceNumber;
	
	public Report(String diagnosis, String prescription) {
		super();
		this.diagnosis = diagnosis;
		this.prescription = prescription;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public String getAuditTrailId() {
		return auditTrailId;
	}
	public void setAuditTrailId(String auditTrailId) {
		this.auditTrailId = auditTrailId;
	}
	public String getHealthInsuranceNumber() {
		return healthInsuranceNumber;
	}
	public void setHealthInsuranceNumber(String healthInsuranceNumber) {
		this.healthInsuranceNumber = healthInsuranceNumber;
	}
	
}
