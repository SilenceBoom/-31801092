package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import cn.edu.zucc.takeaway.TakeAwayUtil;
import cn.edu.zucc.takeaway.util.BaseException;

public class FrmOrder extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private JButton btnCancel=new JButton("删除订单");
	private JButton btnSearch=new JButton("查询订单");
	private JButton btnNew=new JButton("刷新");
	private JTextField edtOrder = new JTextField(20);
	public void reloadInf() throws BaseException{
		
	}
	public FrmOrder(Frame f,String s,boolean b) {
		super(f,s,b);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEADING));
		workPane.add(edtOrder);
		this.getContentPane().add(workPane,BorderLayout.WEST);
		toolBar.add(this.btnSearch);
		toolBar.add(this.btnCancel);
		toolBar.add(this.btnNew);
		this.getContentPane().add(toolBar);
		this.setSize(800, 520);
		// 屏幕居中显示
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth())/2,
				(int) (height - this.getHeight())/2 );

		this.validate();
		this.btnSearch.addActionListener(this);
		this.btnCancel.addActionListener(this);
		this.btnNew.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnNew) {
			
		}
		else if(e.getSource()==this.btnCancel) {
//			int i=this.dataTable.getSelectedRow();
//    	    if(i<0) {
//  				JOptionPane.showMessageDialog(null,  "请选择商家","提示",JOptionPane.ERROR_MESSAGE);
//  				return;
//  			  }
//        	  try {
//    		  TakeAwayUtil.merchantManager.delete(this.merchant.get(i));
//    		  this.reloadTable();
//  			
//			} catch (BaseException e1) {
//				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
//				return;
//			}
		}
		else if(e.getSource()==this.btnSearch) {
			try {
				this.reloadInf();
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
	
		
	}

}
