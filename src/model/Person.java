package model;

public class Person {

	
	private String firstname;
	private String lastname;
	private String homephone;
	private String sex;
	private String address;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	
	public Person(String firstname, String lastname, String homephone,
			String address) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.homephone = homephone;
		this.address = address;
	}


	public Person(String firstname, String lastname, String homephone,
			String sex, String address) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.homephone = homephone;
		this.sex = sex;
		this.address = address;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
