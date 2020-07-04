package cn.edu.zucc.takeaway.model;

import java.util.Date;

public class BeanProductDetail {
	private int productid;
	private Date time;
	private String evaluation;
	private double unitincome;
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
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
