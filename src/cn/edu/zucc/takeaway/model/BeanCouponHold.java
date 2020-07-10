package cn.edu.zucc.takeaway.model;

import java.util.Date;

public class BeanCouponHold {
	private int userid;
	private int couponid;
	private double couponSum;
	private int couponCount;
	private Date endtime;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getCouponid() {
		return couponid;
	}
	public void setCouponid(int couponid) {
		this.couponid = couponid;
	}
	public double getCouponSum() {
		return couponSum;
	}
	public void setCouponSum(double couponSum) {
		this.couponSum = couponSum;
	}
	public int getCouponCount() {
		return couponCount;
	}
	public void setCouponCount(int couponCount) {
		this.couponCount = couponCount;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

}
