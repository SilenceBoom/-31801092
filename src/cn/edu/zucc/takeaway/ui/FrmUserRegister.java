package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import cn.edu.zucc.takeaway.TakeAwayUtil;
import cn.edu.zucc.takeaway.model.BeanSystemUser;
import cn.edu.zucc.takeaway.model.BeanUser;
import cn.edu.zucc.takeaway.util.BaseException;

public class FrmUserRegister extends JDialog implements ActionListener {
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private JButton btnOk = new JButton("注册");
	private JButton btnCancel = new JButton("取消");
	
	private JLabel labelUser = new JLabel("用户账号：");
	private JLabel labelName = new JLabel("用户姓名：");
	private JLabel labelPwd = new JLabel("用户密码：");
	private JLabel labelPwd2 = new JLabel("重复密码：");
	private JLabel labelSex = new JLabel("用户性别：          ");
	private JRadioButton man = new JRadioButton("男");
	private JRadioButton woman = new JRadioButton("女");
	private JLabel labelPhone=new JLabel("手机号码：");
	private JLabel labelMail=new JLabel("邮箱地址：");
	private JLabel labelCity=new JLabel("所在城市："); 
	private JLabel labelPs= new JLabel("(默认时长为一个月)");
	private JLabel labelVip=new JLabel("是否办理VIP：   ");
	private JRadioButton yes = new JRadioButton("是");
	private JRadioButton no = new JRadioButton("否");
	private JLabel labelkong=new JLabel("                                    ");
	private JTextField edtUserId = new JTextField(20);
	private JPasswordField edtPwd = new JPasswordField(20);
	private JPasswordField edtPwd2 = new JPasswordField(20);
	private JTextField edtPhone = new JTextField(20);
	private JTextField edtName = new JTextField(20);
	private JTextField edtMail = new JTextField(20);
	private JTextField edtCity = new JTextField(20);
	public FrmUserRegister(Dialog f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelUser);
		workPane.add(edtUserId);
		workPane.add(labelName);
		workPane.add(edtName);
		workPane.add(labelPwd);
		workPane.add(edtPwd);
		workPane.add(labelPwd2);
		workPane.add(edtPwd2);
		workPane.add(labelSex);
		ButtonGroup group =new ButtonGroup();
		group.add(man);
		group.add(woman);
		workPane.add(this.man);
		workPane.add(this.woman);
	    workPane.add(labelkong);
		workPane.add(labelPhone);
		workPane.add(edtPhone);	
		workPane.add(labelMail);
		workPane.add(edtMail);
		workPane.add(labelCity);
		workPane.add(edtCity);
		workPane.add(labelVip);
		ButtonGroup group1 =new ButtonGroup();
		group1.add(yes);
		group1.add(no);
		workPane.add(this.yes);
		workPane.add(this.no);
	    workPane.add(labelPs);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(320, 350);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth())/2,
				(int) (height - this.getHeight())/2 );

		this.validate();
		this.btnCancel.addActionListener(this);
		this.btnOk.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel)
			this.setVisible(false);
		else if(e.getSource()==this.btnOk){
			String userid=this.edtUserId.getText();
		    String name=this.edtName.getText();
			String pwd1=new String(this.edtPwd.getPassword());
			String pwd2=new String(this.edtPwd2.getPassword());
			String sex=null;
			if(this.man.isSelected())
				 sex="男";
			else if(this.woman.isSelected())
				 sex="女";
			String number=this.edtPhone.getText();
			String mail=this.edtMail.getText();
			String city=this.edtCity.getText();
			int vip=2;
			if(this.yes.isSelected())
				vip=1;
			else if(this.no.isSelected())
				vip=0;
			try {
				BeanUser user=TakeAwayUtil.userManager.reg(userid, name,sex,pwd1, pwd2,number,mail,city,vip);
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
			
		
	}


}
