package cn.edu.zucc.takeaway.itf;

import java.util.List;

import cn.edu.zucc.takeaway.model.BeanUser;
import cn.edu.zucc.takeaway.util.BaseException;

public interface IUserManager {
	public BeanUser reg(String userid, String pwd,String pwd2) throws BaseException;
	public BeanUser login(String userid,String pwd)throws BaseException;
	public List<BeanUser> loadall() throws BaseException;
	public BeanUser search(String userid)throws BaseException;
	public void delete(BeanUser user) throws BaseException;
}
