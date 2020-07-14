package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cn.edu.zucc.takeaway.TakeAwayUtil;
import cn.edu.zucc.takeaway.model.BeanUser;
import cn.edu.zucc.takeaway.util.BaseException;

public class FrmMyVip extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private JButton btnwant=new JButton("成为会员");
	private JButton btncontu=new JButton("续费会员");
	private JButton btntake=new JButton("会员每月领取4张优惠券");
	private JLabel labelInf=new JLabel("<html><p>用户姓名："+BeanUser.currentLoginUser.getUsername()+"<br>"+"会员截止日期："+BeanUser.currentLoginUser.getVipdeadline()+"<p><html>");
	public FrmMyVip(Frame f,String s,boolean b) {
		super(f,s,b);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEADING));
	    btnwant.setFont(new Font("",1,20));
		btncontu.setFont(new Font("",1,20));
		toolBar.add(btnwant);
		toolBar.add(btncontu);
		this.getContentPane().add(toolBar,BorderLayout.BEFORE_FIRST_LINE);
		labelInf.setFont(new Font("",1,20));
		workPane.add(labelInf);
		this.getContentPane().add(workPane,BorderLayout.WEST);
		this.setSize(500,300);
		// 屏幕居中显示
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth())/2,
				(int) (height - this.getHeight())/2 );

		this.validate();
		this.btnwant.addActionListener(this);
		this.btncontu.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.btnwant) {
			try{
				if(BeanUser.currentLoginUser.getIsvip()==1) 
					JOptionPane.showMessageDialog(this,"已成为会员","错误",JOptionPane.INFORMATION_MESSAGE);
				else
				    {
					TakeAwayUtil.userManager.toBeVip();
					JOptionPane.showMessageDialog(this,"开通成功！","提示",JOptionPane.INFORMATION_MESSAGE);
				    }
			}catch(BaseException ex) {
				
			}
		}
		else if(e.getSource()==this.btncontu) {
			try{
				if(BeanUser.currentLoginUser.getIsvip()==0) 
					JOptionPane.showMessageDialog(this,"还未开通会员","错误",JOptionPane.INFORMATION_MESSAGE);
				else
				    {
					TakeAwayUtil.userManager.toBeVip();
					JOptionPane.showMessageDialog(this,"续费成功！","提示",JOptionPane.INFORMATION_MESSAGE);
				    }
			}catch(BaseException ex) {
				
			}
		}
		
	}

}
