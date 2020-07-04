package cn.edu.zucc.takeaway.model;

import java.util.Date;

public class BeanRider {
	private int riderid;
	private String ridername;
	private Date inDate;
	private String identity;
	public int getRiderid() {
		return riderid;
	}
	public void setRiderid(int riderid) {
		this.riderid = riderid;
	}
	public String getRidername() {
		return ridername;
	}
	public void setRidername(String ridername) {
		this.ridername = ridername;
	}
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}

}
