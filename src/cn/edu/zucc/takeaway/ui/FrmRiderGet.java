package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.takeaway.TakeAwayUtil;
import cn.edu.zucc.takeaway.model.BeanOrder2;
import cn.edu.zucc.takeaway.util.BaseException;

public class FrmRiderGet extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JButton btnCancel=new JButton("接单");
	private JButton btnNew=new JButton("刷新");
	List<BeanOrder2> order=null;
	private Object tblTitle[]=BeanOrder2.tableTitles;
	private Object tblData[][];
	DefaultTableModel tabModel=new DefaultTableModel();
	private JTable dataTable=new JTable(tabModel);
	
	
	public void reloadOrder(){
	    try {
				
				order=TakeAwayUtil.userManager.loadallorder();
			} catch (BaseException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
	     tblData =  new Object[order.size()][BeanOrder2.tableTitles.length];
		 for(int i=0;i<order.size();i++){
			for(int j=0;j<BeanOrder2.tableTitles.length;j++)
				tblData[i][j]=order.get(i).getCell(j);
		}
			tabModel.setDataVector(tblData,tblTitle);
			this.dataTable.validate();
			this.dataTable.repaint();
		}
	public FrmRiderGet(Frame f,String s,boolean b) {
		super(f,s,b);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEADING));
		toolBar.add(this.btnCancel);
		toolBar.add(this.btnNew);
		this.getContentPane().add(toolBar,BorderLayout.BEFORE_FIRST_LINE);
		this.setSize(925, 520);
		// 屏幕居中显示
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth())/2,
				(int) (height - this.getHeight())/2 );

		this.validate();
		this.btnCancel.addActionListener(this);
		this.btnNew.addActionListener(this);
		this.getContentPane().add(new JScrollPane(this.dataTable), BorderLayout.CENTER);
		
		this.reloadOrder();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
