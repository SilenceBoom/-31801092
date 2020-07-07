package cn.edu.zucc.takeaway.model;


public class BeanSystemUser {
	public static BeanSystemUser currentLoginUser=null;
	private String sysuserid;
	private String sysusername;
	private String sysuserpwd;
	public String getSysuserid() {
		return sysuserid;
	}
	public void setSysuserid(String sysuserid) {
		this.sysuserid = sysuserid;
	}
	public String getSysusername() {
		return sysusername;
	}
	public void setSysusername(String sysusername) {
		this.sysusername = sysusername;
	}
	public String getSysuserpwd() {
		return sysuserpwd;
	}
	public void setSysuserpwd(String sysuserpwd) {
		this.sysuserpwd = sysuserpwd;
	}

}
