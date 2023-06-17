package com.air.dto;

public class SeatReservation { // res_seat
	private int resId; // res_id
	private String airId; // air_id
	private String seatId; // seat_id

	public SeatReservation(int resId, String airId, String seatId) {
		super();
		this.resId = resId;
		this.airId = airId;
		this.seatId = seatId;
	}

	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
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

	@Override
	public String toString() {
		return "SeatReservation [resId=" + resId + ", airId=" + airId + ", seatId=" + seatId + "]";
	}

}
