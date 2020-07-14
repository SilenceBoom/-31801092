package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cn.edu.zucc.takeaway.TakeAwayUtil;
import cn.edu.zucc.takeaway.util.BaseException;

public class FrmSettlement extends JDialog implements ActionListener {
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private JLabel labelInit = new JLabel("原价："+TakeAwayUtil.userManager.settlement());
//	private JLabel labelUse = new JLabel("  使用优惠券：");
//	private JLabel labelSett = new JLabel("结算：");
	private JButton btnOk = new JButton("确认支付");
	private JButton btnCancel = new JButton("取消");
	public FrmSettlement(JDialog f,String s,boolean b) throws BaseException{
		super(f,s,b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnOk);
		toolBar.add(this.btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		labelInit.setFont(new Font("",1,20));
		workPane.add(labelInit);
//		workPane.add(labelUse);
//		workPane.add(labelSett);
		this.getContentPane().add(workPane, BorderLayout.WEST);
		this.setSize(320, 200);
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
		if(e.getSource()==this.btnOk) {
			try{
				TakeAwayUtil.userManager.initBuy();
				this.setVisible(false);
			}catch(BaseException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
		}
		else if(e.getSource()==this.btnCancel) {
			this.setVisible(false);
		}

	}

}
