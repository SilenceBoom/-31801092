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
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import cn.edu.zucc.takeaway.TakeAwayUtil;
import cn.edu.zucc.takeaway.util.BaseException;

public class FrmMerchantReg extends JDialog implements ActionListener{
	private JPanel workPane = new JPanel();
	private JPanel toolBar = new JPanel();
	private JButton btnOk = new JButton("注册");
	private JButton btnCancel = new JButton("取消");
	private JLabel labelName = new JLabel("商家名称：");
	private JLabel labelStar = new JLabel("商家星级：                      ");
	private JLabel labelx = new JLabel("星                               ");
	private JLabel labelrjxf = new JLabel("人均消费：");
	private JLabel labelSum = new JLabel("总  销  量：");
	private JComboBox jcb=null;
	String stars[]= {"  1  ","  2  ","  3  ","  4  ","  5  "};
	private JTextField edtName = new JTextField(20);
	private JTextField edtSum = new JTextField(20);
	private JTextField edtrjxf = new JTextField(20);
    public FrmMerchantReg(JDialog f,String s,boolean b) {
    	super(f,s,b);
    	this.jcb=new JComboBox(stars);
    	jcb.setMaximumRowCount(5);
    	toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnOk);
		toolBar.add(this.btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
    	workPane.setLayout(new FlowLayout(FlowLayout.RIGHT));		
		workPane.add(labelName);
		workPane.add(edtName);
		workPane.add(labelStar);
		workPane.add(jcb);
		workPane.add(labelx);
		workPane.add(labelrjxf);
		workPane.add(edtrjxf);
		workPane.add(labelSum);
		workPane.add(edtSum);
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
			String name=this.edtName.getText();
			double rjxf=Double.valueOf(this.edtrjxf.getText());
			int sum=Integer.valueOf(this.edtSum.getText());
			int star=0;
			switch(jcb.getSelectedIndex()) {
			case 0 :star =1;break;
			case 1 :star =2;break;
			case 2 :star =3;break;
			case 3 :star =4;break;
			case 4 :star =5;break;
			}
			try{
				TakeAwayUtil.merchantManager.reg(name, star, rjxf, sum);
				this.setVisible(false);
			}catch(BaseException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
	}
	

}
