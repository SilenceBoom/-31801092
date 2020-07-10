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
	private Button btnChangePwd = new Button("�޸�����");
//	private Button btnChangeAdd = new Button("�޸ĵ�ַ");
	private JLabel labelUser = new JLabel("<html><p> �û���ţ�"+BeanUser.currentLoginUser.getUserid()+"<br>"+"<br>"
	        +"�û�������"+BeanUser.currentLoginUser.getUsername()+"<br>"+"<br>"
			+"�û��Ա�"+BeanUser.currentLoginUser.getUsersex()+"<br>"+"<br>"
			+"�û��绰��"+BeanUser.currentLoginUser.getUserphonenumber()+"<br>"+"<br>"
			+"�û����䣺"+BeanUser.currentLoginUser.getUsermail()+"<br>"+"<br>"
			+"�û����У�"+BeanUser.currentLoginUser.getUsercity()+"<br>"+"<br>"
			+"ע��ʱ�䣺"+BeanUser.currentLoginUser.getRegistertime()+"<p><html>"
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
		// ��Ļ������ʾ
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
			FrmUserPwdCha dlg=new FrmUserPwdCha(null, "�����޸�",true);
			dlg.setVisible(true);
			
		}
		
	}

}
