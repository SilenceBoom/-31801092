package cn.edu.zucc.takeaway.itf;

import java.util.List;

import cn.edu.zucc.takeaway.model.BeanMerchant;
import cn.edu.zucc.takeaway.util.BaseException;

public interface IMerchantManager {
	
	public List<BeanMerchant> loadall() throws BaseException;
	
	public BeanMerchant search(String name)throws BaseException;
	
	public void delete(BeanMerchant merchant) throws BaseException;
}
