package cn.edu.zucc.takeaway.model;

public class BeanOrder1 {
	public static final String[] tableTitles={"商家名称","消费金额"};
	private String merchantName;
	private double sum;
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public String getCell(int col){
		if(col==0) {
			return merchantName;
		}
		else if(col==1) return String.valueOf(sum);
	
		else return "";
	}
	public static String[] getTabletitles() {
		return tableTitles;
	}
}
