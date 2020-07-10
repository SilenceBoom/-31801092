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
	public static IUserManager userManager=new UserManager();//需要换成自行设计的实现类
	public static ISystemUserManager systemManager=new SystemUserManager();//需要换成自行设计的实现类
	public static IMerchantManager merchantManager=new MerchantManager();//需要换成自行设计的实现类
	public static IRiderManager riderManager=new RiderManager();//需要换成自行设计的实现类
	
}
