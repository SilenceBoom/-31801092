package cn.edu.zucc.takeaway.model;

public class BeanMerchant {
	public static final String[] tableTitles={"商家编号","商家名称","商家星级","人均消费","总销量"};
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
	public String getCell(int col){
		if(col==0) {
			String merchantId = String.valueOf(merchantid);
			return merchantId;
		}
		else if(col==1) return merchantname;
		else if(col==2) 
			{
			String level=String.valueOf(merchantlevel);
			return level+"星";
			}
		else if(col==3) {
			String cunsume=String.valueOf(avgConsume);
			return cunsume;
		}
		else if(col==4) {
			String count=String.valueOf(sumcount);
			return count;
		}
		else return "";
	}
	public static String[] getTabletitles() {
		return tableTitles;
	}

}
