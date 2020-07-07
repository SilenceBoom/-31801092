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

import cn.edu.zucc.takeaway.util.BaseException;
public class FrmMainUser  extends JFrame implements ActionListener{
		private JMenuBar menuber=new JMenuBar();
		private JMenu menu_merchant=new JMenu("�̼�       ");	                                                                      
		private JMenu menu_rider=new JMenu("����       ");
		private JMenu menu_user=new JMenu("�û�       ");
		private JMenu menu_systemuser=new JMenu("����Ա");
		private JMenuItem menuItem_MerchantReg=new JMenuItem("�̼�ע��");
		private JMenuItem menuItem_MerchantInf=new JMenuItem("�̼ҹ���");
		private JMenuItem menuItem_RiderReg=new JMenuItem("����ע��");
		private JMenuItem menuItem_RiderCan=new JMenuItem("����ע��");
		private JMenuItem menuItem_RiderMan=new JMenuItem("������Ϣ");
		private JMenuItem menuItem_UserInf=new JMenuItem("�û���Ϣ");
		private JMenuItem menuItem_SystemUserCha=new JMenuItem("�����޸�");
		
		private FrmLogin dlgLogin=null;	
		private JPanel statusBar = new JPanel();
		public FrmMainUser() throws IOException{
			this.setExtendedState(Frame.MAXIMIZED_BOTH);
		    this.setTitle("��������");

		    //�˵�
		    menu_merchant.add(menuItem_MerchantReg);
		    menuItem_MerchantReg.addActionListener(this);
		    menu_merchant.add(menuItem_MerchantInf);
		    menuItem_MerchantInf.addActionListener(this);
		    menu_rider.add(menuItem_RiderReg);
		    menuItem_RiderReg.addActionListener(this);
		    menu_rider.add(menuItem_RiderCan);
		    menuItem_RiderCan.addActionListener(this);
		    menu_rider.add(menuItem_RiderMan);
		    menuItem_RiderMan.addActionListener(this);
		    menu_user.add(menuItem_UserInf);
		    menuItem_UserInf.addActionListener(this);
		    menu_systemuser.add(menuItem_SystemUserCha);
		    menuItem_SystemUserCha.addActionListener(this);
		    
		
		    menuber.add(menu_merchant);
		    menuber.add(menu_rider);
		    menuber.add(menu_user);
		    menuber.add(menu_systemuser);
		    this.setJMenuBar(menuber);
		    
		    //״̬��
		    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		    JLabel label=new JLabel("����!");
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
		    		FrmMerchantMan dlg=new FrmMerchantMan(this,"�̼���Ϣ",true);
		    		dlg.setVisible(true);
		    		
		    	}
		    }

}


