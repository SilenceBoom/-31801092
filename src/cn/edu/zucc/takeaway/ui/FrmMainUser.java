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
import cn.edu.zucc.takeaway.TakeAwayUtil;
import cn.edu.zucc.takeaway.model.*;

import cn.edu.zucc.takeaway.util.BaseException;
public class FrmMainUser  extends JFrame implements ActionListener{
		private JMenuBar menuber=new JMenuBar();
		private JMenu menu_search=new JMenu("����       ");	                                                                      
		private JMenu menu_order=new JMenu("����       ");
		private JMenu menu_my=new JMenu("�ҵ�       ");
		private JMenuItem menuItem_MyInf=new JMenuItem("�ҵ���Ϣ");
		private JMenuItem menuItem_MyEva=new JMenuItem("�ҵ�����");
		private JMenuItem menuItem_MyVip=new JMenuItem("��Ա����");
		private JMenuItem menuItem_MyAdd=new JMenuItem("�ҵĵ�ַ");
		private JMenuItem menuItem_order=new JMenuItem("�ҵĶ���");
		private JMenuItem menuItem_search=new JMenuItem("������ʳ");
		private JMenuItem menuItem_buy=new JMenuItem("���ﳵ");
		private JPanel statusBar = new JPanel();
		public FrmMainUser() throws IOException{
			this.setExtendedState(Frame.MAXIMIZED_BOTH);
		    this.setTitle("��ߴ����");

		    //�˵�
		    menu_my.add(menuItem_MyInf);
		    menuItem_MyInf.addActionListener(this);
		    menu_my.add(menuItem_MyAdd);
		    menuItem_MyAdd.addActionListener(this);
		    menu_my.add(menuItem_MyEva);
		    menuItem_MyEva.addActionListener(this);
		    menu_my.add(menuItem_MyVip);
		    menuItem_MyVip.addActionListener(this);
		    menu_order.add(menuItem_order);
		    menuItem_order.addActionListener(this);
		    menu_search.add(menuItem_search);
		    menuItem_search.addActionListener(this);
		    menu_search.add(menuItem_buy);
		    menuItem_buy.addActionListener(this);
		    
		    menuber.add(menu_search);
		    menuber.add(menu_order);
		    menuber.add(menu_my);
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
		    	 if(e.getSource()==this.menuItem_MyInf) {
		    		FrmMyInf dlg=new FrmMyInf(this,"�ҵ���Ϣ",true);
		    		dlg.setVisible(true);    		
		    	}
		    	 else if(e.getSource()==this.menuItem_MyAdd) {
		    		 try {
		    	     	 FrmMyAdd dlg=new FrmMyAdd(this,"�ҵĵ�ַ",true);
		    	    	 dlg.setVisible(true);
		    		 }catch(BaseException ex) {
		    			 
		    		 }
		    		 
		    	 }
		    	 else if(e.getSource()==this.menuItem_MyEva) {
		    		 FrmMyEva dlg=new FrmMyEva(this,"�ҵ�����",true);
		    		 dlg.setVisible(true);
		    		 
		    	 }
		    	 else if(e.getSource()==this.menuItem_MyVip) {
		    		 FrmMyVip dlg=new FrmMyVip(this,"��Ա����",true);
		    		 dlg.setVisible(true);
		    	 }
		    	 else if(e.getSource()==this.menuItem_order) {
		    		 FrmOrder dlg=new FrmOrder(this,"�ҵĶ���",true);
		    		 dlg.setVisible(true);
		    	 }
		    	 else if(e.getSource()==this.menuItem_search) {
		    		 FrmSearch dlg=new FrmSearch(this,"������ʳ",true);
		    		 dlg.setVisible(true);
		    	 }
		    }

}


