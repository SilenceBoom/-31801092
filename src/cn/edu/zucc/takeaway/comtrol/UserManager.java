package cn.edu.zucc.takeaway.comtrol;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.takeaway.itf.IUserManager;
import cn.edu.zucc.takeaway.model.BeanAddress;
import cn.edu.zucc.takeaway.model.BeanRider;
import cn.edu.zucc.takeaway.model.BeanSystemUser;
import cn.edu.zucc.takeaway.model.BeanUser;
import cn.edu.zucc.takeaway.util.BaseException;
import cn.edu.zucc.takeaway.util.BusinessException;
import cn.edu.zucc.takeaway.util.DBUtil;
import cn.edu.zucc.takeaway.util.DbException;

public class UserManager implements IUserManager{
	public static BeanUser currentLoginUser=null;
	public BeanUser reg(String userid, String pwd,String pwd2) throws BaseException{
           Connection conn=null;
        
		try{
			conn=DBUtil.getConnection();
			String sql="select * from user where userId=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,userid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("µ«¬Ω’À∫≈≤ª¥Ê‘⁄");	
			BeanUser user=new BeanUser();
			user.setUserid(userid);
			user.setUsername(rs.getString(2));
			user.setUsersex(rs.getString(3));
			user.setUserpwd(rs.getString(4));
			user.setUserphonenumber(rs.getString(5));
			user.setUsermail(rs.getString(6));
			user.setUsercity(rs.getString(7));
			user.setRegistertime(rs.getDate(8));
			user.setIsvip(rs.getInt(9));
			user.setVipdeadline(rs.getDate(10));
			
			if(!pwd.equals(user.getUserpwd())) throw new BusinessException("µ«¬º√‹¬Î¥ÌŒÛ");
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
	public BeanUser login(String userid,String pwd)throws BaseException{
		Connection conn=null;
        
		try{
			conn=DBUtil.getConnection();
			String sql="select * from user where userId=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,userid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("µ«¬Ω’À∫≈≤ª¥Ê‘⁄");	
			BeanUser user=new BeanUser();
			user.setUserid(userid);
			user.setUsername(rs.getString(2));
			user.setUsersex(rs.getString(3));
			user.setUserpwd(rs.getString(4));
			user.setUserphonenumber(rs.getString(5));
			user.setUsermail(rs.getString(6));
			user.setUsercity(rs.getString(7));
			user.setRegistertime(rs.getDate(8));
			user.setIsvip(rs.getInt(9));
			user.setVipdeadline(rs.getDate(10));
			
			if(!pwd.equals(user.getUserpwd())) throw new BusinessException("µ«¬º√‹¬Î¥ÌŒÛ");
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
		BeanUser user=new BeanUser();
		Connection conn=null;
		try {	
			conn=DBUtil.getConnection();
			String sql="select * from user where userId='"+userid+"'";
			java.sql.Statement st=conn.createStatement();
		    java.sql.ResultSet rs=st.executeQuery(sql);
		    while(rs.next()) {
		    	user.setUserid(userid);
		    	user.setUsername(rs.getString(2));
		    	user.setUsersex(rs.getString(3));
		    	user.setUserpwd(rs.getString(4));
				user.setUserphonenumber(rs.getString(5));
				user.setUsermail(rs.getString(6));
			    user.setUsercity(rs.getString(7));
			    user.setRegistertime(rs.getDate(8));
		    	user.setIsvip(rs.getInt(9));
				user.setVipdeadline(rs.getDate(10));
		    	
		    }
		    st.close();
		    rs.close();
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
	public void delete(BeanUser user) throws BaseException{
		Connection conn=null;
		try {
			
			conn=DBUtil.getConnection();
			String sql="delete from user where userId='"+user.getUserid()+"'";
			java.sql.Statement st=conn.createStatement();
		    st.execute(sql);
		    st.close();
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
	public void changeAdd(BeanUser user,String address)throws BaseException{
		Connection conn=null;
		try{
			conn=DBUtil.getConnection();
			String sql="update address set address=? where userId=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,address);
			pst.setString(2, user.getUserid());
			pst.execute();
			pst.close();
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
	public void changePwd(BeanUser user,String old,String new1,String new2) throws BaseException{
		Connection conn=null;
		if(old.equals(null)) throw new BusinessException("‘≠ º√‹¬Î≤ªƒ‹Œ™ø’");
		if(!old.equals(user.getUserpwd())) throw new BusinessException("‘≠ º√‹¬Î¥ÌŒÛ");
		if(!new1.equals(new2)) throw new BusinessException("¡Ω¥Œ√‹¬Î ‰»Î≤ª“ª÷¬");
		try{
			conn=DBUtil.getConnection();
			String sql="update user set userPwd=? where userId=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,new1);
			pst.setString(2, user.getUserid());
			pst.execute();
			pst.close();
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
	public BeanAddress getAddress(BeanUser user) throws BaseException{
		BeanAddress add=new BeanAddress();
		Connection conn=null;
		try{
			conn=DBUtil.getConnection();
			String sql="select address from address where userId=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,user.getUserid());
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				add.setAddress(rs.getString(1));
			}
			pst.close();
			return add;
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
	public void toBeVip()throws BaseException{
		Connection conn=null;
		try{
			conn=DBUtil.getConnection();
			String sql="update user set isVIP=1 where userId=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,BeanUser.currentLoginUser.getUserid());
			pst.execute();
		//	sql="update user set VIPdeadline=dateadd()"
			pst.close();
			
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
