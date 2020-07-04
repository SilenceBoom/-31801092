package cn.edu.zucc.takeaway.model;

public class BeanMerchant {
	private int merchantid;
	private String merchantname;
	private int merchantlevel;
	private double avgConsume;
	private int sumcount;
	public int getMerchantid() {
		return merchantid;
	}
	public void setMerchantid(int merchantid) {
		this.merchantid = merchantid;
	}
	public String getMerchantname() {
		return merchantname;
	}
	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}
	public int getMerchantlevel() {
		return merchantlevel;
	}
	public void setMerchantlevel(int merchantlevel) {
		this.merchantlevel = merchantlevel;
	}
	public double getAvgConsume() {
		return avgConsume;
	}
	public void setAvgConsume(double avgConsume) {
		this.avgConsume = avgConsume;
	}
	public int getSumcount() {
		return sumcount;
	}
	public void setSumcount(int sumcount) {
		this.sumcount = sumcount;
	}

}
