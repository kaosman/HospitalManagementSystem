package model;

public class Appointment {

	private String doctorName;
	private String patientName;
	private String date;
	private String time;
	private String healthInsuranceNumber;
	

	public Appointment(String doctorName, String patientName, String date,
			String time, String healthInsuranceNumber) {
		super();
		this.doctorName = doctorName;
		this.patientName = patientName;
		this.date = date;
		this.time = time;
		this.healthInsuranceNumber = healthInsuranceNumber;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getHealthInsuranceNumber() {
		return healthInsuranceNumber;
	}
	public void setHealthInsuranceNumber(String healthInsuranceNumber) {
		this.healthInsuranceNumber = healthInsuranceNumber;
	}
	
}
