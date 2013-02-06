package impl;

public enum UserType {

	Doctor(1),Nurse(2),Lawyer(3),ItAdmin(4);
	
	int rank;
	UserType(int rank) {
		this.rank=rank;
	}
	
}
