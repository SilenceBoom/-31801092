package cn.edu.zucc.takeaway.model;

import java.util.Date;

public class BeanOrderSheet {
	private int orderid;
	private double initamount;
	private double settamount;
	private Date ordertime;
	private Date requiretime;
	private int addressid;
	private int couponid;
	private int riderid;
	private int merchantid;
	private int fullreduid;
	private int userid;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public double getInitamount() {
		return initamount;
	}
	public void setInitamount(double initamount) {
		this.initamount = initamount;
	}
	public double getSettamount() {
		return settamount;
	}
	public void setSettamount(double settamount) {
		this.settamount = settamount;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public Date getRequiretime() {
		return requiretime;
	}
	public void setRequiretime(Date requiretime) {
		this.requiretime = requiretime;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public int getCouponid() {
		return couponid;
	}
	public void setCouponid(int couponid) {
		this.couponid = couponid;
	}
	public int getRiderid() {
		return riderid;
	}
	public void setRiderid(int riderid) {
		this.riderid = riderid;
	}
	public int getMerchantid() {
		return merchantid;
	}
	public void setMerchantid(int merchantid) {
		this.merchantid = merchantid;
	}
	public int getFullreduid() {
		return fullreduid;
	}
	public void setFullreduid(int fullreduid) {
		this.fullreduid = fullreduid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

}
