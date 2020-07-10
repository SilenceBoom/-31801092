package cn.edu.zucc.takeaway.model;

import java.util.Date;

public class BeanCoupon {
	private int couponid;
	private int merchantid;
	private double couponamount;
	private int requirecount;
	private Date begindate;
	private Date enddate;
	public int getCouponid() {
		return couponid;
	}
	public void setCouponid(int couponid) {
		this.couponid = couponid;
	}
	public int getMerchantid() {
		return merchantid;
	}
	public void setMerchantid(int merchantid) {
		this.merchantid = merchantid;
	}
	public double getCouponamount() {
		return couponamount;
	}
	public void setCouponamount(double couponamount) {
		this.couponamount = couponamount;
	}
	public int getRequirecount() {
		return requirecount;
	}
	public void setRequirecount(int requirecount) {
		this.requirecount = requirecount;
	}
	public Date getBegindate() {
		return begindate;
	}
	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	

}
