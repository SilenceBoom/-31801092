package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.takeaway.TakeAwayUtil;
import cn.edu.zucc.takeaway.model.BeanUser;
import cn.edu.zucc.takeaway.ui.*;

public class FrmMyInf extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnChangePwd = new Button("修改密码");
//	private Button btnChangeAdd = new Button("修改地址");
	private JLabel labelUser = new JLabel("<html><p> 用户编号："+BeanUser.currentLoginUser.getUserid()+"<br>"+"<br>"
	        +"用户姓名："+BeanUser.currentLoginUser.getUsername()+"<br>"+"<br>"
			+"用户性别："+BeanUser.currentLoginUser.getUsersex()+"<br>"+"<br>"
			+"用户电话："+BeanUser.currentLoginUser.getUserphonenumber()+"<br>"+"<br>"
			+"用户邮箱："+BeanUser.currentLoginUser.getUsermail()+"<br>"+"<br>"
			+"用户城市："+BeanUser.currentLoginUser.getUsercity()+"<br>"+"<br>"
			+"注册时间："+BeanUser.currentLoginUser.getRegistertime()+"<p><html>"
			);
	
	
	public FrmMyInf(Frame f,String s,boolean b) {
		super(f,s,b);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEADING));
	//	btnChangeAdd.setFont(new Font("",1,20));
		btnChangePwd.setFont(new Font("",1,20));
		//toolBar.add(btnChangeAdd);
		toolBar.add(btnChangePwd);
		this.getContentPane().add(toolBar,BorderLayout.BEFORE_FIRST_LINE);
		labelUser.setFont(new Font("",1,20));
		workPane.add(labelUser);
		this.getContentPane().add(workPane,BorderLayout.WEST);
		this.setSize(500,600);
		// 屏幕居中显示
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth())/2,
				(int) (height - this.getHeight())/2 );

		this.validate();
	//	this.btnChangeAdd.addActionListener(this);
		this.btnChangePwd.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.btnChangePwd)
		{
			FrmUserPwdCha dlg=new FrmUserPwdCha(null, "密码修改",true);
			dlg.setVisible(true);
			
		}
		
	}

}
