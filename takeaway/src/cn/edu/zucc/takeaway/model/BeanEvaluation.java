package cn.edu.zucc.takeaway.model;

import java.util.Date;

public class BeanEvaluation {
	private int userid;
	private int productid;
	private int sortid;
	private String evaword;
	private Date evadate;
	private int evalevel;
	private byte[] evapicture;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getSortid() {
		return sortid;
	}
	public void setSortid(int sortid) {
		this.sortid = sortid;
	}
	public String getEvaword() {
		return evaword;
	}
	public void setEvaword(String evaword) {
		this.evaword = evaword;
	}
	public Date getEvadate() {
		return evadate;
	}
	public void setEvadate(Date evadate) {
		this.evadate = evadate;
	}
	public int getEvalevel() {
		return evalevel;
	}
	public void setEvalevel(int evalevel) {
		this.evalevel = evalevel;
	}
	public byte[] getEvapicture() {
		return evapicture;
	}
	public void setEvapicture(byte[] evapicture) {
		this.evapicture = evapicture;
	}
	

}
