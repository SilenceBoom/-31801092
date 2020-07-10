package cn.edu.zucc.takeaway.itf;

import java.util.List;

import cn.edu.zucc.takeaway.model.BeanRider;
import cn.edu.zucc.takeaway.util.BaseException;

public interface IRiderManager {
	public List<BeanRider> loadall() throws BaseException;
	
    public BeanRider search(String name)throws BaseException;
	
	public void delete(BeanRider rider) throws BaseException;

}
