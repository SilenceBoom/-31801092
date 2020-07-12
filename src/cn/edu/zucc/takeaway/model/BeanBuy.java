package cn.edu.zucc.takeaway.model;

public class BeanBuy {
	public static final String[] tableTitles={"商品名称","商品类型","单价","数量"};
	private String productName;
	private String productSort;
	private double unitPrice;
	private int buyCount;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductSort() {
		return productSort;
	}
	public void setProductSort(String productSort) {
		this.productSort = productSort;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	public String getCell(int col){
		if(col==0) {
			return productName;
		}
		else if(col==1) return productSort;
		else if(col==2) return String.valueOf(unitPrice);
		else if(col==3) return String.valueOf(buyCount);
	
		else return "";
	}
	public static String[] getTabletitles() {
		return tableTitles;
	}

}
