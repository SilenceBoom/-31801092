package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.takeaway.ui.FrmLogin;
import cn.edu.zucc.takeaway.model.*;
import cn.edu.zucc.takeaway.ui.FrmRiderMan;
import cn.edu.zucc.takeaway.util.BaseException;

public class FrmMainSystemUser extends JFrame implements ActionListener{

		private JMenuBar menuber=new JMenuBar();
		private JMenu menu_merchant=new JMenu("商家       ");	                                                                      
		private JMenu menu_rider=new JMenu("骑手       ");
		private JMenu menu_user=new JMenu("用户       ");
		private JMenu menu_coupon=new JMenu("优惠券     ");
		private JMenu menu_systemuser=new JMenu("管理员");
		private JMenuItem menuItem_MerchantInf=new JMenuItem("商家管理");
		private JMenuItem menuItem_Coupon=new JMenuItem("优惠券管理");
		private JMenuItem menuItem_RiderMan=new JMenuItem("骑手管理");
		private JMenuItem menuItem_RiderInf=new JMenuItem("骑手接单");
		private JMenuItem menuItem_UserInf=new JMenuItem("用户管理");
		private JMenuItem menuItem_SystemUserCha=new JMenuItem("密码修改");
		
		private FrmLogin dlgLogin=null;	
		private JPanel statusBar = new JPanel();
		public FrmMainSystemUser() throws IOException{
			this.setExtendedState(Frame.MAXIMIZED_BOTH);
		    this.setTitle("外卖管理员助手");
	

		    //菜单
		    menu_merchant.add(menuItem_MerchantInf);
		    menuItem_MerchantInf.addActionListener(this);
		    menu_rider.add(menuItem_RiderMan);
		    menuItem_RiderMan.addActionListener(this);
		    menu_rider.add(menuItem_RiderInf);
		    menuItem_RiderInf.addActionListener(this);
		    menu_user.add(menuItem_UserInf);
		    menuItem_UserInf.addActionListener(this);
		    menu_coupon.add(menuItem_Coupon);
		    menuItem_Coupon.addActionListener(this);
		    menu_systemuser.add(menuItem_SystemUserCha);
		    menuItem_SystemUserCha.addActionListener(this);
		    
		
		    menuber.add(menu_merchant);
		    menuber.add(menu_rider);
		    menuber.add(menu_coupon);
		    menuber.add(menu_user);
		    menuber.add(menu_systemuser);
		    this.setJMenuBar(menuber);
		    
		    //状态栏
		    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		    JLabel label=new JLabel("您好!");
		    statusBar.add(label);
		    this.getContentPane().add(statusBar,BorderLayout.SOUTH);
		    this.addWindowListener(new WindowAdapter(){   
		    	public void windowClosing(WindowEvent e){ 
		    		System.exit(0);
	             }
	        });
		    this.setVisible(true);
		}
		    
		    public void actionPerformed(ActionEvent e) {
		         if(e.getSource()==this.menuItem_MerchantInf) {
		    		FrmMerchantMan dlg=new FrmMerchantMan(this,"商家管理",true);
		    		dlg.setVisible(true);		    		
		    	}
		    	else if(e.getSource()==this.menuItem_RiderMan) {
		    		FrmRiderMan dlg=new FrmRiderMan(this,"骑手管理",true);
		    		dlg.setVisible(true);		    		
		    	}
		    	else if(e.getSource()==this.menuItem_UserInf) {
		    		FrmUserMan dlg=new FrmUserMan(this,"用户管理",true);
		    		dlg.setVisible(true);
		    	}
		    	else if(e.getSource()==this.menuItem_SystemUserCha) {
		    		FrmSystemUserCha dlg=new FrmSystemUserCha(this,"密码修改",true);
		    		dlg.setVisible(true);
		    		
		    	}
		    	else if(e.getSource()==this.menuItem_RiderInf) {
		    		FrmRiderGet dlg=new FrmRiderGet(this,"骑手接单",true);
		    		dlg.setVisible(true);
		    	}
		    }

	

}
