package cn.edu.zucc.takeaway.model;

import java.util.Date;

public class BeanRiderBooked {
	private int riderid;
	private Date finishtime;
	private String evaluation;
	private double unitincome;
	public int getRiderid() {
		return riderid;
	}
	public void setRiderid(int riderid) {
		this.riderid = riderid;
	}
	public Date getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(Date finishtime) {
		this.finishtime = finishtime;
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	public double getUnitincome() {
		return unitincome;
	}
	public void setUnitincome(double unitincome) {
		this.unitincome = unitincome;
	}

}
