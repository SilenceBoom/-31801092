package cn.edu.zucc.takeaway.comtrol;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.takeaway.itf.IRiderManager;
import cn.edu.zucc.takeaway.model.BeanMerchant;
import cn.edu.zucc.takeaway.model.BeanRider;
import cn.edu.zucc.takeaway.util.BaseException;
import cn.edu.zucc.takeaway.util.DBUtil;
import cn.edu.zucc.takeaway.util.DbException;

public class RiderManager implements IRiderManager{
	public List<BeanRider> loadall() throws BaseException{
		List<BeanRider> result =new ArrayList<BeanRider>();
		Connection conn=null;
		try {
			
			conn=DBUtil.getConnection();
			String sql="select * from rider";
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				 BeanRider p=new BeanRider();
				 p.setRiderid(rs.getInt(1));
				 p.setRidername(rs.getString(2));
				 p.setInDate(rs.getDate(3));
				 p.setIdentity(rs.getString(4));
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
	 public BeanRider search(String name)throws BaseException{
		 BeanRider result=new BeanRider();
		 Connection conn=null;
			try {
				conn=DBUtil.getConnection();
				String sql="select * from rider where riderName=?";
				java.sql.PreparedStatement pst=conn.prepareStatement(sql);
				pst.setString(1, name);
				java.sql.ResultSet rs=pst.executeQuery();
				while(rs.next()) {
					result.setRiderid(rs.getInt(1));
					result.setRidername(rs.getString(2));
					result.setInDate(rs.getDate(3));
					result.setIdentity(rs.getString(4));
				}
				rs.close();
				pst.close();
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
		
	public void delete(BeanRider rider) throws BaseException{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="delete from rider where riderName=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, rider.getRidername());
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

}
