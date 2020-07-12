package cn.edu.zucc.takeaway.model;

public class BeanPro {
	public static final String[] tableTitles={"商品名称","商品类型","商品价格","商品库存"};
	private String productName;	
	private double productPrice;
	private String sortName;
	private int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getCell(int col){
		if(col==0) 	return productName;
		else if(col==1) return sortName;
		else if(col==2) return String.valueOf(productPrice);
		else if(col==3) return String.valueOf(count);
		else return "";
	}
	public static String[] getTabletitles() {
		return tableTitles;
	}

}
