package model;

import java.util.Date;

public class Doctor extends Staff{
	
	private String specialization;
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public Doctor(String firstname, String lastname, String homephone,
			 String address, String employedStatus,
			String designation, String staffid, String hiredDate,
			String specialization) {
		super(firstname, lastname, homephone, address, employedStatus,
				designation, staffid, hiredDate);
		this.specialization = specialization;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	
}
