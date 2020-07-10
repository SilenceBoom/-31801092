package cn.edu.zucc.takeaway.itf;


import cn.edu.zucc.takeaway.model.BeanSystemUser;
import cn.edu.zucc.takeaway.util.BaseException;

public interface ISystemUserManager {

	public BeanSystemUser login(String userid,String pwd)throws BaseException;
	
	public void changepwd(BeanSystemUser user,String old,String new1,String new2) throws BaseException;

}
