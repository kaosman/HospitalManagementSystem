package model;

import java.util.Date;

public class Staff extends Person{

	private String employedStatus;
	private String designation;
	private String staffid;
	private String hiredDate;
	
	public Staff() {
		// TODO Auto-generated constructor stub
	}

	
	public Staff(String firstname, String lastname, String homephone,
			String address, String employedStatus,
			String designation, String staffid, String hiredDate) {
		super(firstname, lastname, homephone, address);
		this.employedStatus = employedStatus;
		this.designation = designation;
		this.staffid = staffid;
		this.hiredDate = hiredDate;
	}

	public String getEmployedStatus() {
		return employedStatus;
	}

	public void setEmployedStatus(String employedStatus) {
		this.employedStatus = employedStatus;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getStaffid() {
		return staffid;
	}

	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}

	public String getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(String hiredDate) {
		this.hiredDate = hiredDate;
	}

	
}
