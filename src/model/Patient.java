package model;

import impl.MedicalHistory;

import java.util.Date;

public class Patient {
	
	private String firstName;
	private String lastName;
	private String DOB;
	private String gender;
	private String address;
	private String city;
	private String country;
	private String province;
	private String postalCode;
	private String registrationDate;
	private String contactNumber;
	private String familyDoctorName;
	private String familyDoctorNumber;
	private String healthInsuranceNumber;
	private String emergencyContactName;
	private String emergencyContactNumber;
	private String bedNumber;
	private String roomNumber;
	private String medicalHistory;
	private String other;
	
	public Patient() {
		
	}
	public Patient(String firstName, String lastName, String dOB,
			String gender, String address, String city, String country,
			String province, String postalCode, String registrationDate,
			String contactNumber, String familyDoctorName,
			String familyDoctorNumber, String healthInsuranceNumber,
			String emergencyContactName, String emergencyContactNumber,String other,
			String medicalHistory) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		DOB = dOB;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.country = country;
		this.province = province;
		this.postalCode = postalCode;
		this.registrationDate = registrationDate;
		this.contactNumber = contactNumber;
		this.familyDoctorName = familyDoctorName;
		this.familyDoctorNumber = familyDoctorNumber;
		this.healthInsuranceNumber = healthInsuranceNumber;
		this.emergencyContactName = emergencyContactName;
		this.emergencyContactNumber = emergencyContactNumber;
		this.medicalHistory = medicalHistory;
	}
	
	
	public String getOther() {
		return other;
	}


	public void setOther(String other) {
		this.other = other;
	}


	public Patient(String firstName, String lastName, String dOB,
			String registrationDate, String healthInsuranceNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		DOB = dOB;
		this.registrationDate = registrationDate;
		this.healthInsuranceNumber = healthInsuranceNumber;
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getFamilyDoctorName() {
		return familyDoctorName;
	}
	public void setFamilyDoctorName(String familyDoctorName) {
		this.familyDoctorName = familyDoctorName;
	}
	public String getFamilyDoctorNumber() {
		return familyDoctorNumber;
	}
	public void setFamilyDoctorNumber(String familyDoctorNumber) {
		this.familyDoctorNumber = familyDoctorNumber;
	}
	public String getHealthInsuranceNumber() {
		return healthInsuranceNumber;
	}
	public void setHealthInsuranceNumber(String healthInsuranceNumber) {
		this.healthInsuranceNumber = healthInsuranceNumber;
	}
	public String getEmergencyContactName() {
		return emergencyContactName;
	}
	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}
	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}
	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}
	public String getBedNumber() {
		return bedNumber;
	}
	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getMedicalHistory() {
		return medicalHistory;
	}
	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
	
	
}
