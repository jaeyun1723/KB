package com.air.dto;

public class RemainingSeat {	// remain_seat
	private String airId;	// air_id
	private String seatId;	// seat_id
	private String grade;	// seat_grade
	private int remainSeat;	// rem_seat
	
	public RemainingSeat(String airId, String seatId, String grade, int remainSeat) {
		super();
		this.airId = airId;
		this.seatId = seatId;
		this.grade = grade;
		this.remainSeat = remainSeat;
	}

	public String getAirId() {
		return airId;
	}

	public void setAirId(String airId) {
		this.airId = airId;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getRemainSeat() {
		return remainSeat;
	}

	public void setRemainSeat(int remainSeat) {
		this.remainSeat = remainSeat;
	}

	@Override
	public String toString() {
		return "RemainingSeat [airId=" + airId + ", seatId=" + seatId + ", grade=" + grade + ", remainSeat="
				+ remainSeat + "]";
	}
	
	
	
}
