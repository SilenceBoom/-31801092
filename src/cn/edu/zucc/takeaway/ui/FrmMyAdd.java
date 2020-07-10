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
import javax.swing.JTextField;

import cn.edu.zucc.takeaway.TakeAwayUtil;
import cn.edu.zucc.takeaway.model.BeanAddress;
import cn.edu.zucc.takeaway.model.BeanUser;
import cn.edu.zucc.takeaway.util.BaseException;

public class FrmMyAdd extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnChangeAdd = new Button("修改地址");
	private JTextField edtAddress = new JTextField(20);
	private JLabel labelAdd = new JLabel("<html><p> 我的地址："+"<br>"+TakeAwayUtil.userManager.getAddress(BeanUser.currentLoginUser).getAddress()+"<p><html>");
	public FrmMyAdd(Frame f,String s,boolean b) throws BaseException{
		super(f,s,b);
		toolBar.setLayout(new FlowLayout(FlowLayout.CENTER));
		btnChangeAdd.setFont(new Font("",1,20));
		toolBar.add(this.btnChangeAdd);
		this.getContentPane().add(toolBar,BorderLayout.CENTER);
		labelAdd.setFont(new Font("",1,20));
		workPane.add(labelAdd);
		this.getContentPane().add(workPane,BorderLayout.SOUTH);
		this.setSize(500,200);
		// 屏幕居中显示
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth())/2,
				(int) (height - this.getHeight())/2 );

		this.validate();
		this.btnChangeAdd.addActionListener(this);
	//	this.btnChangePwd.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.btnChangeAdd) {
			 try {
    			 BeanAddress add=new BeanAddress();
    		     add=TakeAwayUtil.userManager.getAddress(BeanUser.currentLoginUser);
    		     FrmAddCha dlg=new FrmAddCha(this,"地址修改",true,add);
    		     dlg.setVisible(true);
    		 }catch(BaseException ex) {
    			 
    		 }
    		 
		}
	}

}
