package dao;
import model.Appointment;
import model.Patient;
import model.Report;
import model.Staff;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 *  This class executes SQL queries.
 * 
 * 
 */
public class DataAccessObject {

	private Connection connectionPatient = null;
	private Connection connectionHospital =  null;
	private ServiceProvider serviceProvider;
	
	public DataAccessObject() {
		
		this.serviceProvider = ServiceProvider.getInstance();
		this.connectionPatient = this.serviceProvider.getPatientConnection();
		this.connectionHospital = this.serviceProvider.getHospitalConnection();
	}
	
	public String checkCredentials(String username,String password){
		
		final String sql = "SELECT Password,Staff_ID FROM authentication_information WHERE Username = ?";
		final String sql1 = "SELECT Type FROM staff_information WHERE Staff_ID = ?";
		try{
			
			PreparedStatement statement = connectionHospital.prepareStatement(sql);
			PreparedStatement statement1 = connectionHospital.prepareStatement(sql1);

			statement.setString(1, username);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.first() != false){
				
				if(password.equals(resultSet.getString("PASSWORD"))){
					statement1.setString(1, resultSet.getString("Staff_ID"));
					ResultSet resultSet1 = statement1.executeQuery();
					
					if(resultSet1.first() != false)	return resultSet1.getString("Type");
				}	
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean populatePatient(Patient patient){
		
		final String sql = "INSERT INTO patient_information(First_Name,Last_Name,Health_Insurance_Number,Date_of_Birth,Gender,Address,City,Province,Postal_Code,Country,Phone_Number," +
				"Family_Doctor_Name,Family_Doctor_Phone_Number,Emergency_Contact_Name,Emergency_Contact_Number,Medical_Hostory,Other,Registration_Date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try{
			
			PreparedStatement statement = connectionPatient.prepareStatement(sql);
			statement.setString(1, patient.getFirstName());
			statement.setString(2, patient.getLastName());
			statement.setString(3, patient.getHealthInsuranceNumber());
			statement.setString(4, patient.getDOB());
			statement.setString(5, patient.getGender());
			statement.setString(6, patient.getAddress());
			statement.setString(7, patient.getCity());
			statement.setString(8, patient.getProvince());
			statement.setString(9, patient.getPostalCode());
			statement.setString(10, patient.getCountry());
			statement.setString(11, patient.getContactNumber());
			statement.setString(12, patient.getFamilyDoctorName());
			statement.setString(13, patient.getFamilyDoctorNumber());
			statement.setString(14, patient.getEmergencyContactName());
			statement.setString(15, patient.getEmergencyContactNumber());
			statement.setString(16, patient.getMedicalHistory());
			statement.setString(17, patient.getOther());
			statement.setString(18, getCurrentDate());
			statement.execute();
			
			return true;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
/*	private Date getDate(String dob) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date inputDate;
		try {
			inputDate = (Date) dateFormat.parse(dob);
			return inputDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	private String dateToString(Date date) {
		
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		return dateFormat.format(date);
	}*/

	public boolean updatePatientPersonalRecord (Patient patient) {
		
		final String sql = "UPDATE patient_information SET First_Name=?,Last_Name=?,Date_of_Birth=?,Gender=?,Address=?,City=?,Province=?,Postal_Code=?,Country=?,Phone_Number=?,Family_Doctor_Name=?," +
				"Family_Doctor_Phone_Number=?,Emergency_Contact_Name=?,Emergency_Contact_Number=? WHERE Health_Insurance_Number=?";
			
			PreparedStatement statement;
			try {
			statement = connectionPatient.prepareStatement(sql);
			statement.setString(1, patient.getFirstName());
			statement.setString(2, patient.getLastName());
			statement.setString(3, patient.getDOB());
			statement.setString(4, patient.getGender());
			statement.setString(5, patient.getAddress());
			statement.setString(6, patient.getCity());
			statement.setString(7, patient.getProvince());
			statement.setString(8, patient.getPostalCode());
			statement.setString(9, patient.getCountry());
			statement.setString(10, patient.getContactNumber());
			statement.setString(11, patient.getFamilyDoctorName());
			statement.setString(12, patient.getFamilyDoctorNumber());
			statement.setString(13, patient.getEmergencyContactName());
			statement.setString(14, patient.getEmergencyContactNumber());
			statement.setString(15, patient.getHealthInsuranceNumber());
			statement.executeUpdate();
			
			return true;
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
	
	}
	
	
	public boolean admitPatient(String healthInsuranceNumber, String bedNumber, String roomNumber){
		
		final String sql = "UPDATE patient_information SET Bed_Number=?,Room_Number=? WHERE Health_Insurance_Number=?";
		try{
			
			PreparedStatement statement = connectionPatient.prepareStatement(sql);
			statement.setString(1, bedNumber);
			statement.setString(2, roomNumber);
			statement.executeUpdate();
			
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public Patient getPatientRecord(String healthInsuranceNumber){
		
		Patient patient = null;
		final String sql = "SELECT * FROM patient_information WHERE Health_Insurance_Number = ?";
		
		try{
			
			PreparedStatement preparedStatement = connectionPatient.prepareStatement(sql);
			preparedStatement.setString(1, healthInsuranceNumber);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.first()!= false) {
				patient = new Patient(resultSet.getString("First_Name"),resultSet.getString("Last_Name"),resultSet.getString("Date_of_Birth"),resultSet.getString("Gender"),
						resultSet.getString("Address"),resultSet.getString("City"),resultSet.getString("Country"),resultSet.getString("Province"),resultSet.getString("Postal_Code"), 
						resultSet.getString("Registration_Date"),resultSet.getString("Phone_Number"),resultSet.getString("Family_Doctor_Name"), 
						resultSet.getString("Family_Doctor_Phone_Number"), resultSet.getString("Health_Insurance_Number"), resultSet.getString("Emergency_Contact_Name"),
						resultSet.getString("Emergency_Contact_Number"), "Anemia", resultSet.getString("Medical_Hostory"));
				
			}
			return patient;
		}catch(Exception e){
			return null;
			}
		}

	public boolean bookAppointment(Appointment bookAppointment) {
	
		final String sql1 = "SELECT Staff_ID FROM staff_information WHERE Last_Name = ?";
		final String sql2 = "INSERT INTO appointment_information(Appointment_ID,Appointment_Date,Appointment_Time,Health_Insurance_Number,Staff_ID) VALUES (?,?,?,?,?)";
		final String sql3 = "SELECT MAX(Appointment_ID) AS maxval FROM appointment_information";
		
		try{
			
			String[] lastname = bookAppointment.getDoctorName().split(" ");

			PreparedStatement statement1 = connectionPatient.prepareStatement(sql1);
			statement1.setString(1, lastname[1]);
			ResultSet resultSet1 = statement1.executeQuery();
			int staffId = 0;
			
			if(resultSet1.first()){
				staffId = resultSet1.getInt("Staff_ID");
			}
			PreparedStatement statement2 = connectionPatient.prepareStatement(sql2);
			PreparedStatement statement3 = connectionPatient.prepareStatement(sql3);
			ResultSet resultSet = statement3.executeQuery();
			
			if(resultSet.first()!= false){
				statement2.setInt(1, resultSet.getInt("maxval")+1);
			}
			
			statement2.setString(2, bookAppointment.getDate());
			statement2.setString(3, bookAppointment.getTime());
			statement2.setString(4, bookAppointment.getHealthInsuranceNumber());
			statement2.setInt(5, staffId);

			statement2.execute();
			return true;
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}

	}
	
	/*private Date getTime(String time) {
		
		try{
		DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		Date toTime = (Date) sdf.parse(time);
		
		return toTime;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	private String timeToString(Date time){
		
		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
		return dateFormat.format(time);
		
	}*/
	
	public boolean checkAppointment(String healthInsuranceNumber,String doctor,String date,String time){
		
		final String sql1 = "SELECT Staff_ID from staff_information where Last_Name = ?";
		final String sql2 = "SELECT Appointment_ID from appointment_information where Staff_ID = ?";
		
		try{
			
			String lastname[] = doctor.split(" ");
			PreparedStatement statement1 = connectionPatient.prepareStatement(sql1);
			statement1.setString(1, lastname[1]);
			ResultSet resultSet1 = statement1.executeQuery();
			if (resultSet1.first() != false) {
				PreparedStatement statement2 = connectionPatient.prepareStatement(sql2);
				int staffId = resultSet1.getInt("Staff_ID");
				statement2.setInt(1, staffId);
				ResultSet resultSet2 = statement2.executeQuery();
				if (resultSet2.first() != false) {
					return true;
				}
			}
			return false;

		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean cancelAppointment(Appointment cancelAppointment){
		
		final String sql = "DELETE FROM appointment_information WHERE Health_Insurance_Number = ? AND Appointment_Date = ? AND Appointment_Time = ?";
		try{
			
			PreparedStatement statement = connectionPatient.prepareStatement(sql);
			statement.setString(1, cancelAppointment.getHealthInsuranceNumber());
			statement.setString(2, cancelAppointment.getDate());
			statement.setString(3, cancelAppointment.getTime());
			statement.execute();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}

		return false;
	}

	public ArrayList<String> getAvailableTimeSlots(String doctorName, String date) {
		
		ArrayList<String> timeslots = new ArrayList<String>();
		timeslots.add("9:00:00");
		timeslots.add("10:00:00");
		timeslots.add("11:00:00");
		timeslots.add("12:00:00");
		timeslots.add("13:00:00");
		timeslots.add("14:00:00");
		timeslots.add("15:00:00");
		timeslots.add("16:00:00");
		
		ArrayList<String> available = new ArrayList<String>();
		available.add("9:00:00");
		available.add("10:00:00");
		available.add("11:00:00");
		available.add("12:00:00");
		available.add("13:00:00");
		available.add("14:00:00");
		available.add("15:00:00");
		available.add("16:00:00");
		
		final String sql1 = "SELECT Staff_ID FROM staff_information WHERE Last_Name = ?";		
		final String sql = "SELECT Appointment_Time FROM appointment_information WHERE Appointment_Date = ? AND Staff_ID = ?";
		try{
			
			PreparedStatement statement1 = connectionPatient.prepareStatement(sql1);
			statement1.setString(1, doctorName);
			ResultSet resultSet1 = statement1.executeQuery();
			String staffID="";
			
			if (resultSet1.first()!=false) staffID = resultSet1.getString("Staff_ID");
			
			PreparedStatement statement = connectionPatient.prepareStatement(sql);
			statement.setString(1, date);
			statement.setString(2, staffID);
			ResultSet resultSet = statement.executeQuery();

			String notAvailable;
			
			if(resultSet.first()!=false){
				while (resultSet.next()){
				notAvailable = resultSet.getString("Appointment_Time");		
				for (int i = 0; i < timeslots.size(); i++) {
					if (timeslots.get(i).equals(notAvailable)) available.remove(notAvailable);
				}}
			}	
			
			return available;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public ArrayList<Appointment> getDoctorSchedule(String doctorName, String date){
		
		final String sql2 = "SELECT Staff_ID FROM staff_information WHERE Last_Name = ?";
		final String sql = "SELECT Health_Insurance_Number,Appointment_Time FROM appointment_information WHERE Staff_ID = ? AND Appointment_Date = ?";
		final String sql1 = "SELECT First_Name, Last_Name FROM patient_information WHERE Health_Insurance_Number = ?";
		try{
			
			PreparedStatement statement2 = connectionPatient.prepareStatement(sql2);
			statement2.setString(1, doctorName);
			ResultSet resultSet2 = statement2.executeQuery();
			int staffid = 0;
			if (resultSet2.first()!= false) {
				staffid = resultSet2.getInt("Staff_ID");
			}
			
			PreparedStatement statement = connectionPatient.prepareStatement(sql);
			statement.setInt(1, staffid);
			statement.setString(2, date);
			ResultSet resultSet = statement.executeQuery();
			
			PreparedStatement statement1 = connectionPatient.prepareStatement(sql1);		

			ArrayList<Appointment> schedule = new ArrayList<Appointment>();
			ArrayList<String> hins = new ArrayList<String>();
			ArrayList<String> times = new ArrayList<String>();
			
			resultSet.first();
			while(resultSet.next()){
				hins.add(resultSet.getString("Health_Insurance_Number"));
				times.add(resultSet.getString("Appointment_Time"));
			} 
			
			for (int i=0; i < hins.size(); i++) {
				statement1.setString(1, hins.get(i));
				ResultSet resultSet1 = statement1.executeQuery();
				if (resultSet1.first()!= false) {
					Appointment app = new Appointment(doctorName, resultSet1.getString("First_Name")+" "+resultSet1.getString("Last_Name"), date, times.get(i), hins.get(i));
					schedule.add(app); }
			}
			
			return schedule;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<String> getDoctorsbyAppointment() {
		
		final String sql1 = "SELECT Staff_ID FROM appointment_information WHERE Appointment_ID IS NOT NULL";
		final String sql2 = "SELECT Last_Name, First_Name FROM staff_information WHERE Staff_ID = ?";
		
		try{
			PreparedStatement statement1 = connectionPatient.prepareStatement(sql1);
			ResultSet resultSet1 = statement1.executeQuery();
			
			Set<Integer> staffids = new HashSet<Integer>();
			while (resultSet1.next()) {
				staffids.add(resultSet1.getInt("Staff_ID"));
			}
			
			ArrayList<String> doctors = new ArrayList<String>();
			PreparedStatement statement2 = connectionPatient.prepareStatement(sql2);
			ResultSet resultSet2 = null;
			for (int i : staffids){
				statement2.setInt(1, i);
				resultSet2 = statement2.executeQuery();
				if (resultSet2.first() != false) {
					doctors.add(resultSet2.getString("First_Name") + " " + resultSet2.getString("Last_Name"));
				}
				
			}

			return doctors;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Report> getAuditTrail(String healthInsuranceNumber, String date) {
		
		final String sql2 = "SELECT Audit_Trail_ID FROM audit_trail_information WHERE Modification_Date = ? AND Health_Insurance_Number = ?";
		final String sql = "SELECT Diagnosis_Description FROM diagnosis_record WHERE Audit_Trail_ID = ?";
		final String sql1 = "SELECT Prescription_Description FROM prescription_record WHERE Audit_Trail_ID = ?";
		try{
			
			PreparedStatement statement = connectionPatient.prepareStatement(sql2);
			statement.setString(2, healthInsuranceNumber);
			statement.setString(1, date);
			ResultSet resultSet = statement.executeQuery();
			String auditID = "";
			
			if (resultSet.first()!= false) 
				auditID = resultSet.getString("Audit_Trail_ID");
			
			PreparedStatement statement1 = connectionPatient.prepareStatement(sql);
			statement1.setString(1,auditID);
			ResultSet resultSet1 = statement1.executeQuery();
			
			PreparedStatement statement2 = connectionPatient.prepareStatement(sql1);
			statement2.setString(1,auditID);
			ResultSet resultSet2 = statement2.executeQuery();
			
			ArrayList<Report> reports = new ArrayList<Report>();
			
			while ((resultSet1.next())&&(resultSet2.next())) {				
				Report report = new Report(resultSet1.getString("Diagnosis_Description"), resultSet2.getString("Prescription_Description"));
				reports.add(report);
			}
			System.out.println(reports);
			return reports;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<String> getAuditTrailDates(String healthInsuranceNumber) {
		final String sql = "SELECT Modification_Date FROM audit_trail_information WHERE Health_Insurance_Number = ?";
		try{
			
			PreparedStatement statement = connectionPatient.prepareStatement(sql);
			statement.setString(1, healthInsuranceNumber);
			ResultSet resultSet = statement.executeQuery();
			
			ArrayList<String> reportdates = new ArrayList<String>();
			while (resultSet.next()) {
				reportdates.add(resultSet.getString("Modification_Date"));
			}
			
			return reportdates;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<String> getCreatedReportDates(String healthInsuranceNumber) {
		
		final String sql = "SELECT Diagnosis_Date FROM diagnosis_record WHERE Health_Insurance_Number = ?";
		try{
			
			PreparedStatement statement = connectionPatient.prepareStatement(sql);
			statement.setString(1, healthInsuranceNumber);
			ResultSet resultSet = statement.executeQuery();
			
			ArrayList<String> reportdates = new ArrayList<String>();
			while (resultSet.next()) {
				reportdates.add(resultSet.getString("Diagnosis_Date"));
			}
			
			return reportdates;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean createAuditTrail(String oldDiagnosis, String newDiagnosis, String oldPrescription, String newPrescription, String healthInsuranceNumber) {
		
		final String sql = "SELECT Audit_Trail_Id FROM diagnosis_record WHERE Diagnosis_Description = ?";
		final String sql7 = "UPDATE audit_trail_information SET Old_Diagnosis=?, Old_Prescription=?, New_Diagnosis=?, New_Prescription=?, Modification_Date=? WHERE Audit_Trail_ID = ?";
		final String sql1 = "INSERT INTO diagnosis_record(Diagnosis_Description,Audit_Trail_ID,Health_Insurance_Number,Diagnosis_Record_ID,Diagnosis_Date) VALUES (?,?,?,?,?)";
		final String sql2 = "INSERT INTO prescription_record(Prescription_Description,Audit_Trail_ID,Health_Insurance_Number,Prescription_Record_ID,Prescription_Date) VALUES (?,?,?,?,?)";
		final String sql3 = "UPDATE diagnosis_record SET Audit_Trail_ID=? WHERE Diagnosis_Description=?";
		final String sql4 = "UPDATE prescription_record SET Audit_Trail_ID=? WHERE Prescription_Description=?";
		final String sql5 = "SELECT MAX(Diagnosis_Record_ID) AS maxval1 FROM diagnosis_record";
		final String sql6 = "SELECT MAX(Prescription_Record_ID) AS maxval2 FROM prescription_record";
		
		try{
			
			PreparedStatement statement = connectionPatient.prepareStatement(sql);
			statement.setString(1, oldDiagnosis);
			ResultSet resultSet = statement.executeQuery();
			int auditid = 0;
			if (resultSet.first()!= false) {
				auditid = resultSet.getInt("Audit_Trail_Id");
			}
			
			PreparedStatement statement5 = connectionPatient.prepareStatement(sql5);
			ResultSet resultSet5 = statement5.executeQuery();
			Integer diagnosisid = 0;
			if(resultSet5.first()!=false){
				diagnosisid  = resultSet5.getInt("maxval1") + 1;
			}
			
			PreparedStatement statement6 = connectionPatient.prepareStatement(sql6);
			ResultSet resultSet6 = statement6.executeQuery();
			Integer prescid = 0;
			if(resultSet6.first()!=false){
				prescid  = resultSet6.getInt("maxval2") + 1;
			}
			
			PreparedStatement statement7 = connectionPatient.prepareStatement(sql7);
			PreparedStatement statement1 = connectionPatient.prepareStatement(sql1);
			PreparedStatement statement2 = connectionPatient.prepareStatement(sql2);
			PreparedStatement statement3 = connectionPatient.prepareStatement(sql3);
			PreparedStatement statement4 = connectionPatient.prepareStatement(sql4);
			
			statement7.setString(1, oldDiagnosis);
			statement7.setString(2, oldPrescription);
			statement7.setString(3, newDiagnosis);
			statement7.setString(4, newPrescription);
			statement7.setString(5, getCurrentDate());
			statement7.setInt(6, auditid);
			statement1.setString(1, newDiagnosis);
			statement1.setInt(2, auditid);
			statement1.setString(3, healthInsuranceNumber);
			statement1.setInt(4, diagnosisid);
			statement1.setString(5, getCurrentDate());
			statement2.setString(1, newPrescription);
			statement2.setInt(2, auditid);
			statement2.setString(3, healthInsuranceNumber);
			statement2.setInt(4, prescid);
			statement2.setString(5, getCurrentDate());
			statement3.setString(2, oldDiagnosis);
			statement3.setInt(1, auditid);
			statement4.setString(2, oldPrescription);
			statement4.setInt(1, auditid);

			statement7.executeUpdate();
			statement1.execute();
			statement2.execute();
			statement3.executeUpdate();
			statement4.executeUpdate();
			
			
			return true;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean createStaffRecord(Staff staff) {
		
		final String sql1 = "SELECT MAX(Staff_ID) AS maxval from staff_information";
		final String sql = "INSERT INTO staff_information(Staff_ID,First_Name,Last_Name,Address,Phone_Number,Type,Status) VALUES (?,?,?,?,?,?,?)";
		try{
			
			PreparedStatement statement = connectionPatient.prepareStatement(sql);
			PreparedStatement statement2 = connectionPatient.prepareStatement(sql1);
			ResultSet resultSet = statement2.executeQuery();
			if(resultSet.first()!=false){
				statement.setInt(1, resultSet.getInt("maxval")+1);
			}
			
			statement.setString(2, staff.getLastname());
			statement.setString(3, staff.getFirstname());
			statement.setString(4, staff.getAddress());
			statement.setInt(5, 2267777);
			statement.setString(6, staff.getDesignation());
			statement.setString(7, staff.getEmployedStatus());
			statement.execute();
			
			return true;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	public Staff getStaffRecord(String firstName) {
		
		final String sql = "SELECT Staff_ID FROM authentication_information WHERE Username = ?";
		final String sql1 = "SELECT * FROM staff_information WHERE Staff_ID = ?";

		try{
			
			PreparedStatement statement = connectionHospital.prepareStatement(sql);
			statement.setString(1, firstName);
			ResultSet resultSet = statement.executeQuery();
			String staffID=""; 
			
			if (resultSet.first()!=false) staffID = resultSet.getString("Staff_ID");
			
			PreparedStatement statement1 = connectionHospital.prepareStatement(sql1);
			statement1.setString(1, staffID);
			ResultSet resultSet1 = statement1.executeQuery();
			
			if (resultSet1.first()!=false){
			Staff staff = new Staff(resultSet1.getString("First_Name"), resultSet1.getString("Last_Name"), resultSet1.getString("Phone_Number"), resultSet1.getString("Address"), resultSet1.getString("Status"), resultSet1.getString("Type"), resultSet1.getString("Staff_ID"), "2011-11-25");
			
			return staff;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}

		return null;
	}

	public boolean changeEmployeeStatus(String staffId) {
		
		final String sql = "UPDATE staff_information SET Type = \"invalid\" WHERE Staff_ID = ?";
		try{
			
			PreparedStatement statement = connectionHospital.prepareStatement(sql);
			statement.setString(1, staffId);
			statement.executeUpdate();
			
			return true;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}

	public int[] getAvailableRoom(){
		
		final String sql = "SELECT Room_Number FROM patient_information";
		try{
			
			PreparedStatement statement = connectionPatient.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			int[] rooms = {1,2,3,4,5};
			
			while(resultSet.next()) {
				int occ = (int)resultSet.getInt("Room_Number");
				rooms[occ] = 0;
			}
			
			return rooms;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<String> getAvailableBed(String roomNumber){
		
		final String sql = "SELECT Bed_Number FROM patient_information WHERE Room_Number = ?";
		
		try{
			
			PreparedStatement statement = connectionPatient.prepareStatement(sql);
			statement.setString(1, roomNumber);
			ResultSet resultSet = statement.executeQuery();
			
			ArrayList<String> beds = new ArrayList<String>();
			for(int i=0;i<5;i++){
				beds.add(""+(i+1));
			}
			while(resultSet.next()) {
				int occ = (Integer.parseInt(resultSet.getString("Bed_Number")));
				beds.remove(occ-1);
			}
			
			return beds;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}
	public boolean createPatientMedicalReport(String healthInsuranceNumber,String prescription, String diagnosis) {
		
		final String sql2 = "INSERT INTO audit_trail_information(Audit_Trail_ID,Modification_Date,Health_Insurance_Number) VALUES (?,?,?)";
		final String sql = "INSERT INTO diagnosis_record(Audit_Trail_ID,Diagnosis_Record_ID,Diagnosis_Date,Diagnosis_Description,Health_Insurance_Number) VALUES (?,?,?,?,?)";
		final String sql1 = "INSERT INTO prescription_record(Audit_Trail_ID,Prescription_Record_ID,Prescription_Date,Prescription_Description,Health_Insurance_Number) VALUES (?,?,?,?,?)";
		final String sql3 = "SELECT MAX(Audit_Trail_ID) AS maxval FROM audit_trail_information";
		final String sql4 = "SELECT MAX(Diagnosis_Record_ID) AS maxval1 FROM diagnosis_record";
		final String sql5 = "SELECT MAX(Prescription_Record_ID) AS maxval2 FROM prescription_record";
		
		try{
			
			PreparedStatement statement3 = connectionPatient.prepareStatement(sql3);
			ResultSet resultSet3 = statement3.executeQuery();
			Integer auditid = 0;
			if(resultSet3.first()!=false){
				auditid  = resultSet3.getInt("maxval") + 1;
			}
			
			PreparedStatement statement4 = connectionPatient.prepareStatement(sql4);
			ResultSet resultSet4 = statement4.executeQuery();
			Integer diagnosisid = 0;
			if(resultSet4.first()!=false){
				diagnosisid  = resultSet4.getInt("maxval1") + 1;
			}
			
			PreparedStatement statement5 = connectionPatient.prepareStatement(sql5);
			ResultSet resultSet5 = statement5.executeQuery();
			Integer prescid = 0;
			if(resultSet5.first()!=false){
				prescid  = resultSet5.getInt("maxval2") + 1;
			}
			
			PreparedStatement statement2 = connectionPatient.prepareStatement(sql2);
			statement2.setInt(1,auditid);
			statement2.setString(2, getCurrentDate());
			statement2.setString(3, healthInsuranceNumber);
			statement2.execute();
			
			PreparedStatement statement = connectionPatient.prepareStatement(sql);
			statement.setInt(1, auditid);
			statement.setInt(2, diagnosisid);
			statement.setString(3, getCurrentDate());
			statement.setString(4, diagnosis);
			statement.setString(5, healthInsuranceNumber);
			statement.execute();
			
			PreparedStatement statement1 = connectionPatient.prepareStatement(sql1);
			statement1.setInt(1, auditid);
			statement1.setInt(2, prescid);
			statement1.setString(3, getCurrentDate());
			statement1.setString(4, prescription);
			statement1.setString(5, healthInsuranceNumber);
			statement1.execute();
			
			return true;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	private String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		return dateFormat.format(date);
	}

	public Report getPatientMedicalReport(String healthInsurance, String date){
		
		final String sql = "SELECT Diagnosis_Description, Audit_Trail_ID FROM diagnosis_record WHERE Health_Insurance_Number = ? AND Diagnosis_Date = ?";
		final String sql1 = "SELECT Prescription_Description FROM prescription_record WHERE Health_Insurance_Number = ? AND Prescription_Date = ?";
		try{
			
			PreparedStatement statement = connectionPatient.prepareStatement(sql);
			statement.setString(1, healthInsurance);
			statement.setString(2, date);
			ResultSet resultSet = statement.executeQuery();
			
			PreparedStatement statement1 = connectionPatient.prepareStatement(sql1);
			statement1.setString(1, healthInsurance);
			statement1.setString(2, date);
			ResultSet resultSet1 = statement1.executeQuery();
			
			if ((resultSet.first()!= false)&&(resultSet1.first()!=false)) {
			Report report = new Report(resultSet.getString("Diagnosis_Description"), resultSet1.getString("Prescription_Description"));
			report.setHealthInsuranceNumber(healthInsurance);
			Integer auditid = resultSet.getInt("Audit_Trail_ID");
			report.setAuditTrailId(auditid.toString());
			
			return report; }
			
		}catch(SQLException e){
			e.printStackTrace();
		}

		return null;
	}
	
	public Report getPatientMedicalReport(String healthInsurance){
		
		final String sql = "SELECT Diagnosis_Description FROM diagnosis_record WHERE Health_Insurance_Number = ?";
		final String sql1 = "SELECT Prescription_Description FROM prescription_record WHERE Health_Insurance_Number = ?";
		try{
			
			PreparedStatement statement = connectionPatient.prepareStatement(sql);
			statement.setString(1, healthInsurance);
			ResultSet resultSet = statement.executeQuery();
			
			PreparedStatement statement1 = connectionPatient.prepareStatement(sql1);
			statement1.setString(1, healthInsurance);
			ResultSet resultSet1 = statement1.executeQuery();
			
			if ((resultSet.first()!= false)&&(resultSet1.first()!=false)) {
			Report report = new Report(resultSet.getString("Diagnosis_Description"), resultSet1.getString("Prescription_Description"));
			report.setHealthInsuranceNumber("healthInsurance");
			
			return report; }
			
		}catch(SQLException e){
			e.printStackTrace();
		}

		return null;
	}
	public ArrayList<String> getAllDoctors() {
		
		final String sql = "SELECT Last_Name,First_Name FROM staff_information WHERE Type = \"Doctor\"";
		try{
			
			PreparedStatement statement = connectionPatient.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			ArrayList<String> doctors = new ArrayList<String>();
			while (resultSet.next()) {
				doctors.add(resultSet.getString("First_Name") + " "+resultSet.getString("Last_Name"));
			}
			return doctors;
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	public Patient getAdmittedPatients(String healthInsuranceNumber) {
		
		final String sql = "SELECT First_Name, Last_Name, Date_of_Birth, Registration_Date, Room_Number, Bed_Number FROM patient_information WHERE Room_Number IS NOT NULL AND Health_Insurance_Number = ?";
		
			try{
				
				PreparedStatement preparedStatement = connectionPatient.prepareStatement(sql);
				preparedStatement.setString(1, healthInsuranceNumber);
				ResultSet resultSet = preparedStatement.executeQuery();
				Patient patient = null; 
				
				if (resultSet.first()!=false){
					patient = new Patient(resultSet.getString("First_Name"), resultSet.getString("Last_Name"), resultSet.getString("Date_of_Birth"), resultSet.getString("Registration_Date"), healthInsuranceNumber);
					
				}
				patient.setBedNumber(((Integer)resultSet.getInt("Bed_Number")).toString());
				patient.setRoomNumber(((Integer)resultSet.getInt("Room_Number")).toString());
				return patient;
			}catch(Exception e){
				
			}
			return null;
	}

	public boolean setRoomBed(String roomNumber, String bed,String healthInsuranceNumber) {

		final String sql = "UPDATE patient_information SET Room_Number = ?, Bed_Number = ? WHERE Health_Insurance_Number = ?";
		
		try{
			
			PreparedStatement preparedStatement = connectionPatient.prepareStatement(sql);
			preparedStatement.setString(1, roomNumber);
			preparedStatement.setString(2, bed);
			preparedStatement.setString(3, healthInsuranceNumber);
			preparedStatement.executeUpdate();

			return true;
		}catch(Exception e){
			
			return false;
		}

	}

	
}
