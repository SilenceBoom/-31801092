package cn.edu.zucc.takeaway.model;

import java.util.Date;

public class BeanOrder2 {
	public static final String[] tableTitles={"商家名称","原始金额","结算金额","骑手姓名","下单时间","配送地址","用户姓名","联系电话"};
	private String merchantname;
	private double initamount;
	private double settamount;
	private String ridername;
	private Date ordertime;
	private String address;
	
	private String username;
	private String usernumber;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMerchantname() {
		return merchantname;
	}
	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
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
	public String getRidername() {
		return ridername;
	}
	public void setRidername(String ridername) {
		this.ridername = ridername;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}
	public String getCell(int col){
		if(col==0) {
			return merchantname;
		}
		else if(col==1) return String.valueOf(initamount);
		else if(col==2) return String.valueOf(settamount); 
		else if(col==3) return ridername;
		else if(col==4) {
			java.text.SimpleDateFormat time=new java.text.SimpleDateFormat("yyyy-MM-dd");
			return time.format(ordertime);
		}
		else if (col==5) return address;
		else if (col==6) return username;
		else if (col==7) return usernumber;
		
		else return "";
	}
	public static String[] getTabletitles() {
		return tableTitles;
	}

}
