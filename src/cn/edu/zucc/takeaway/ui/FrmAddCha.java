package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.edu.zucc.takeaway.util.BaseException;
import cn.edu.zucc.takeaway.comtrol.UserManager;
import cn.edu.zucc.takeaway.model.BeanAddress;
import cn.edu.zucc.takeaway.model.BeanUser;

public class FrmAddCha extends JDialog implements ActionListener{
	private BeanAddress add=null;
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	private JTextField edtAddress = new JTextField(20);
	private JLabel labelAddress = new JLabel("我的地址：");
	public FrmAddCha(JDialog f,String s,boolean b,BeanAddress add) {
		super(f,s,b);
		this.add=add;
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelAddress);
		this.edtAddress.setText(add.getAddress());
		workPane.add(edtAddress);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(360, 140);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();
		this.btnOk.addActionListener(this);
		this.btnCancel.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				FrmAddCha.this.add=null;
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.btnCancel) {
			this.setVisible(false);
			this.add=null;
			return;
		}
		else if(e.getSource()==this.btnOk){
			String address=this.edtAddress.getText();
			this.add.setAddress(address);
			try {
				(new UserManager()).changeAdd(BeanUser.currentLoginUser, address);
				this.setVisible(false);
			} catch (BaseException e1) {
				this.add=null;
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
