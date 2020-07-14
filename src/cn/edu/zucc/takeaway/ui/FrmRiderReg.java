package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.edu.zucc.takeaway.TakeAwayUtil;
import cn.edu.zucc.takeaway.util.BaseException;

public class FrmRiderReg extends JDialog implements ActionListener{
	private JPanel workPane = new JPanel();
	private JPanel toolBar = new JPanel();
	private JButton btnOk = new JButton("注册");
	private JButton btnCancel = new JButton("取消");
	private JLabel labelName = new JLabel("骑手姓名：");
	private JLabel labelStar = new JLabel("骑手身份：");
	private JComboBox jcb=null;
	String stars[]= {"新      人","正式员工","单      王"};
	private JTextField edtName = new JTextField(20);
    public FrmRiderReg(JDialog f,String s,boolean b) {
    	super(f,s,b);
    	this.jcb=new JComboBox(stars);
    	jcb.setMaximumRowCount(3);
    	toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnOk);
		toolBar.add(this.btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
    	workPane.setLayout(new FlowLayout(FlowLayout.RIGHT));		
		workPane.add(labelName);
		workPane.add(edtName);
		workPane.add(labelStar);
		workPane.add(jcb);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
    	this.setSize(320, 400);
		// 屏幕居中显示
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
		// TODO Auto-generated method stub
		if(e.getSource()==this.btnCancel) {
			this.setVisible(false);
		}
		else if(e.getSource()==this.btnOk) {
			try {
				String name=this.edtName.getText();
				String identity=null;
				switch(jcb.getSelectedIndex()) {
				case 0:identity="新人";break;
				case 1:identity="正式员工";break;
				case 2:identity="单王";break;
				}
				TakeAwayUtil.riderManager.Reg(name, identity);
				this.setVisible(false);
			}catch(BaseException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		}
	

}
