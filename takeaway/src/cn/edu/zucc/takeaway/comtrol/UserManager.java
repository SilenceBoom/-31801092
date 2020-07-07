package cn.edu.zucc.takeaway.comtrol;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.takeaway.itf.IUserManager;
import cn.edu.zucc.takeaway.model.BeanRider;
import cn.edu.zucc.takeaway.model.BeanUser;
import cn.edu.zucc.takeaway.util.BaseException;
import cn.edu.zucc.takeaway.util.BusinessException;
import cn.edu.zucc.takeaway.util.DBUtil;
import cn.edu.zucc.takeaway.util.DbException;

public class UserManager implements IUserManager{
	public static BeanUser currentLoginUser=null;
	public BeanUser reg(String userid, String pwd,String pwd2) throws BaseException{
		return null;
	}
	public BeanUser login(String userid,String pwd)throws BaseException{
		Connection conn=null;
        
		try{
			conn=DBUtil.getConnection();
			String sql="select userId,userPwd from user where userId=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,userid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("µÇÂ½ÕËºÅ²»´æÔÚ");	
			BeanUser user=new BeanUser();
			user.setUserid(userid);
			user.setUserpwd(rs.getString(2));
			if(!pwd.equals(user.getUserpwd())) throw new BusinessException("µÇÂ¼ÃÜÂë´íÎó");
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
	public List<BeanUser> loadall() throws BaseException{
		List<BeanUser> result=new ArrayList<BeanUser>();
		Connection conn=null;
		try {
			
			conn=DBUtil.getConnection();
			String sql="select * from user";
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				 BeanUser p=new BeanUser();
				 p.setUserid(rs.getString(1));
				 p.setUsername(rs.getString(2));
				 p.setUsersex(rs.getString(3));
				 p.setUserpwd(rs.getString(4));
				 p.setUserphonenumber(rs.getString(5));
				 p.setUsermail(rs.getString(6));
				 p.setUsercity(rs.getString(7));
				 p.setRegistertime(rs.getDate(8));
				 p.setIsvip(rs.getInt(9));
				 p.setVipdeadline(rs.getDate(10));
		         result.add(p);
			}
		    rs.close();
		    st.close();
		    return result;
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
	public BeanUser search(String userid)throws BaseException{
		return null;
	}
	public void delete(BeanUser user) throws BaseException{
		
	}

}
