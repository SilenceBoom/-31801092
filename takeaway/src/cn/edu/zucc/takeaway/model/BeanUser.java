package cn.edu.zucc.takeaway.model;

import java.util.Date;

import cn.edu.zucc.takeaway.model.BeanUser;

public class BeanUser {
	public static BeanUser currentLoginUser=null;
	public static final String[] tableTitles={"用户编号","用户姓名","用户性别","用户手机号码","用户邮箱","用户城市","注册时间","是否为会员","会员截止时间"};
	private String userid;
	private String username;
	private String usersex;
	private String userpwd;
	private String userphonenumber;
	private String usermail;
	private String usercity;
	private Date registertime;
	private int isvip;
	private Date vipdeadline;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUserphonenumber() {
		return userphonenumber;
	}
	public void setUserphonenumber(String userphonenumber) {
		this.userphonenumber = userphonenumber;
	}
	public String getUsermail() {
		return usermail;
	}
	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}
	public String getUsercity() {
		return usercity;
	}
	public void setUsercity(String usercity) {
		this.usercity = usercity;
	}
	public Date getRegistertime() {
		return registertime;
	}
	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}
	public int getIsvip() {
		return isvip;
	}
	public void setIsvip(int isvip) {
		this.isvip = isvip;
	}
	public Date getVipdeadline() {
		return vipdeadline;
	}
	public void setVipdeadline(Date vipdeadline) {
		this.vipdeadline = vipdeadline;
	}
	public String getCell(int col){
		if(col==0) 	return userid;
		else if(col==1) return username;
		else if(col==2) return usersex;
		else if(col==3) return userphonenumber;	
		else if(col==4) return usermail;
		else if(col==5) return usercity;
		else if(col==6) {
			java.text.SimpleDateFormat time=new java.text.SimpleDateFormat("yyyy-MM-dd");
			return time.format(registertime);
		}
		else if(col==7) {
			if(isvip==1) {
				return "是";
			}
			else {
				return "否";
			}
		}
		else if(col==8) {
			if(isvip==1) {
				java.text.SimpleDateFormat time=new java.text.SimpleDateFormat("yyyy-MM-dd");
				return time.format(vipdeadline);
			}
			else 
				return "";
		}
		else return "";
	}
	public static String[] getTabletitles() {
		return tableTitles;
	}


}
