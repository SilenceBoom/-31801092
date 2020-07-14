package cn.edu.zucc.takeaway.itf;

import java.util.List;

import cn.edu.zucc.takeaway.model.BeanAddress;
import cn.edu.zucc.takeaway.model.BeanBuy;
import cn.edu.zucc.takeaway.model.BeanOrder1;
import cn.edu.zucc.takeaway.model.BeanOrder2;
import cn.edu.zucc.takeaway.model.BeanPro;
import cn.edu.zucc.takeaway.model.BeanUser;
import cn.edu.zucc.takeaway.util.BaseException;

public interface IUserManager {
	public BeanUser reg(String userid, String username,String sex,String pwd,String pwd2,String number,String mail,String city,int vip) throws BaseException;
	public BeanUser login(String userid,String pwd)throws BaseException;
	public List<BeanUser> loadall() throws BaseException;
	public BeanUser search(String userid)throws BaseException;
	public void delete(BeanUser user) throws BaseException;
	public void changeAdd(BeanUser user,String address)throws BaseException;
	public void changePwd(BeanUser user ,String old,String new1,String new2) throws BaseException;
	public BeanAddress getAddress(BeanUser user) throws BaseException;
	public void toBeVip()throws BaseException;
	public List<BeanOrder1> loadallorder() throws BaseException;
	public List<BeanOrder2> loadallorder2(BeanOrder1 order) throws BaseException;
	public void Add(BeanPro product)throws BaseException;
	public void changeCount(int n)throws BaseException;
	public void deleteAdd()throws BaseException;
	public void initBuy ()throws BaseException;
	public void deletePro(BeanBuy buy)throws BaseException;
	public double settlement() throws BaseException;
}
