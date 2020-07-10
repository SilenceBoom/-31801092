package cn.edu.zucc.takeaway;


import cn.edu.zucc.takeaway.comtrol.MerchantManager;
import cn.edu.zucc.takeaway.comtrol.RiderManager;
import cn.edu.zucc.takeaway.comtrol.SystemUserManager;
import cn.edu.zucc.takeaway.comtrol.UserManager;
import cn.edu.zucc.takeaway.itf.IMerchantManager;
import cn.edu.zucc.takeaway.itf.IRiderManager;
import cn.edu.zucc.takeaway.itf.ISystemUserManager;
import cn.edu.zucc.takeaway.itf.IUserManager;

public class TakeAwayUtil {
	public static IUserManager userManager=new UserManager();//��Ҫ����������Ƶ�ʵ����
	public static ISystemUserManager systemManager=new SystemUserManager();//��Ҫ����������Ƶ�ʵ����
	public static IMerchantManager merchantManager=new MerchantManager();//��Ҫ����������Ƶ�ʵ����
	public static IRiderManager riderManager=new RiderManager();//��Ҫ����������Ƶ�ʵ����
	
}
