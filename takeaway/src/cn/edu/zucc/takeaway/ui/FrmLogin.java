package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import cn.edu.zucc.takeaway.model.*;
import cn.edu.zucc.takeaway.util.BaseException;
import cn.edu.zucc.takeaway.comtrol.*;


public class FrmLogin extends JDialog implements ActionListener {
	BufferedImage img=ImageIO.read(new File("./imgs/timg.jpg"));
	private JPanel toolBar = new JPanel();
	private JPanel toolImg = new JPanel();
//	private JPanel workPane = new JPanel();
	private JButton btnUser = new JButton("用户登陆");
	private JButton btnUserReg = new JButton("用户注册");
	private JButton btnSystemUser = new JButton("管理员登录");
	/*private JLabel labelUser = new JLabel("账号：");
	private JLabel labelPwd = new JLabel("密码：");
	private JTextField edtUserId = new JTextField(20);
	private JPasswordField edtPwd = new JPasswordField(20);*/
	private JLabel labelImage =new JLabel(new ImageIcon(img));

	public FrmLogin(Frame f, String s, boolean b) throws IOException{
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.CENTER));
		toolImg.add(labelImage);
		this.getContentPane().add(toolImg, BorderLayout.NORTH);
		toolBar.add(this.btnUserReg);
		toolBar.add(this.btnUser);
		toolBar.add(this.btnSystemUser);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
	/*	workPane.add(labelUser);
		workPane.add(edtUserId);
		workPane.add(labelPwd);
		workPane.add(edtPwd);
		this.getContentPane().add(workPane, BorderLayout.CENTER);*/
		this.setSize(780, 615);
		// 屏幕居中显示
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth())/2,
				(int) (height - this.getHeight())/2 );

		this.validate();

		this.btnUserReg.addActionListener(this);
		this.btnUser.addActionListener(this);
		this.btnSystemUser.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==this.btnUserReg){
			FrmUserRegister dlg=new FrmUserRegister(this,"用户注册",true);
			dlg.setVisible(true);
		}
		else if(e.getSource() == this.btnUser) {
			FrmUser dlg=new FrmUser(this,"用户登录",true);
			dlg.setVisible(true);
		    if(BeanUser.currentLoginUser!=null) {
		    	this.setVisible(false);
		    	try {
		    		new FrmMainUser();
		    	}catch(Exception ex) {
		    		JOptionPane.showMessageDialog(null, ex.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
					return;
		    	}
		    	
		    }
			
			
		} else if (e.getSource() == this.btnSystemUser) {
			try {
				FrmSystemUser dlg=new FrmSystemUser(this,"管理员登录",true);
			    dlg.setVisible(true);	
			    if(BeanSystemUser.currentLoginUser!=null) {
			    	this.setVisible(false);
				    try {
				    	new FrmMainSystemUser();
				    }catch(Exception ex) {
				    	JOptionPane.showMessageDialog(null, ex.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
						return;
				    	}
				    	
				    }
			    }
			catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}
	
	}
	}
