package cn.edu.zucc.takeaway.comtrol;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import cn.edu.zucc.takeaway.util.BusinessException;
import cn.edu.zucc.takeaway.util.DBUtil;
import cn.edu.zucc.takeaway.util.DbException;
import cn.edu.zucc.takeaway.itf.ISystemUserManager;
import cn.edu.zucc.takeaway.model.BeanSystemUser;
import cn.edu.zucc.takeaway.util.DBUtil;
import cn.edu.zucc.takeaway.util.BaseException;

public class SystemUserManager implements ISystemUserManager{
	
	@Override
	public BeanSystemUser login(String userid, String pwd) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;

		try{
			conn=DBUtil.getConnection();
			String sql="select sysUserId,sysUserPwd from systemuser where sysUserId=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,userid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("登陆账号不存在");	
			BeanSystemUser user=new BeanSystemUser();
			user.setSysuserid(rs.getString(1));
			user.setSysuserpwd(rs.getString(2));
			if(!pwd.equals(user.getSysuserpwd())) throw new BusinessException("登录密码错误");
			rs.close();
			pst.close();	
			return user;
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	public void changepwd(BeanSystemUser user,String old,String new1,String new2) throws BaseException{
		Connection conn=null;
		if(old.equals(null)) throw new BusinessException("原始密码不能为空");
		if(!old.equals(user.getSysuserpwd())) throw new BusinessException("原始密码错误");
		if(!new1.equals(new2)) throw new BusinessException("两次密码输入不一致");
		try{
			conn=DBUtil.getConnection();
			String sql="";
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	

}
