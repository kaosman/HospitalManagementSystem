package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Schedule {

	private String currentDate;
	private String doctorName;
	
	private Map<String, String> timeSlotpatientName;
	private Map<String, ArrayList<String>> doctorAvailableTimeSlot;
	
	public Schedule() {

		this.timeSlotpatientName = new HashMap<String, String>();
		this.doctorAvailableTimeSlot = new HashMap<String, ArrayList<String>>();
	}

	public Schedule(String currentDate, Map<String, String> timeSlotpatientName) {
		super();
		this.currentDate = currentDate;
		this.timeSlotpatientName = timeSlotpatientName;
	}
	
	public Schedule(String doctorName,ArrayList<String> availableTimeSlot){
		super();
		this.doctorName = doctorName;
		this.doctorAvailableTimeSlot.put(this.doctorName, availableTimeSlot);
		
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Map<String, ArrayList<String>> getDoctorAvailableTimeSlot() {
		return doctorAvailableTimeSlot;
	}

	public void setDoctorAvailableTimeSlot(
			Map<String, ArrayList<String>> doctorAvailableTimeSlot) {
		this.doctorAvailableTimeSlot = doctorAvailableTimeSlot;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public Map<String, String> getTimeSlotpatientName() {
		return timeSlotpatientName;
	}

	public void setTimeSlotpatientName(Map<String, String> timeSlotpatientName) {
		this.timeSlotpatientName = timeSlotpatientName;
	}

}
