package cn.edu.zucc.takeaway.model;

import java.util.Date;

public class BeanRider {
	public static final String[] tableTitles={"骑手编号","骑手姓名","入职日期","骑手身份"};
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
	public String getCell(int col){
		if(col==0) {
			String riderId = String.valueOf(riderid);
			return riderId;
		}
		else if(col==1) return ridername;
		else if(col==2) 
			{
			java.text.SimpleDateFormat time=new java.text.SimpleDateFormat("yyyy-MM-dd");
			return time.format(inDate);
			}
		else if(col==3) return identity;	
		else return "";
	}
	public static String[] getTabletitles() {
		return tableTitles;
	}

}
