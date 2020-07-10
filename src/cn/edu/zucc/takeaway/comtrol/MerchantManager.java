package cn.edu.zucc.takeaway.comtrol;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.takeaway.itf.IMerchantManager;
import cn.edu.zucc.takeaway.model.*;
import cn.edu.zucc.takeaway.util.BaseException;
import cn.edu.zucc.takeaway.util.BusinessException;
import cn.edu.zucc.takeaway.util.DBUtil;
import cn.edu.zucc.takeaway.util.DbException;

public class MerchantManager implements IMerchantManager{
	public List<BeanMerchant> loadall()throws BaseException{
		List<BeanMerchant> result=new ArrayList<BeanMerchant>();
		Connection conn=null;
		try {
			
			conn=DBUtil.getConnection();
			String sql="select * from merchant";
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				 BeanMerchant p=new BeanMerchant();
				 p.setMerchantid(rs.getInt(1));
				 p.setMerchantname(rs.getString(2));
				 p.setMerchantlevel(rs.getInt(3));
				 p.setAvgConsume(rs.getDouble(4));
				 p.setSumcount(rs.getInt(5));
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
	public BeanMerchant search(String name)throws BaseException{
		BeanMerchant result=new BeanMerchant();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from merchant where merchantName=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, name);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				result.setMerchantid(rs.getInt(1));
				result.setMerchantname(rs.getString(2));
				result.setMerchantlevel(rs.getInt(3));
				result.setAvgConsume(rs.getDouble(4));
				result.setSumcount(rs.getInt(5));
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
	public void delete(BeanMerchant merchant) throws BaseException{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="delete from merchant where merchantName=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, merchant.getMerchantname());
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
