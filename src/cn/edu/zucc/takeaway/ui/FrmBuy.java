package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.takeaway.TakeAwayUtil;
import cn.edu.zucc.takeaway.model.BeanBuy;
import cn.edu.zucc.takeaway.model.BeanMerchant;
import cn.edu.zucc.takeaway.model.BeanOrder1;
import cn.edu.zucc.takeaway.model.BeanPro;
import cn.edu.zucc.takeaway.util.BaseException;

public class FrmBuy extends JDialog implements ActionListener{
	private Button btnSett=new Button("结算");
	private Button btnClear=new Button("清空购物车");
	private Button btnDelete=new Button("删除商品");
	private JPanel toolBar = new JPanel();
	List<BeanBuy> product=null;
	private Object tblTitle[]=BeanBuy.tableTitles;
	private Object tblData[][];
	DefaultTableModel tabModel=new DefaultTableModel();
	private JTable dataTable=new JTable(tabModel);
	public void reloadPro(){
	    try {
				
				product=TakeAwayUtil.merchantManager.loadallPro();
			} catch (BaseException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
	     tblData =  new Object[product.size()][BeanBuy.tableTitles.length];
		 for(int i=0;i<product.size();i++){
			for(int j=0;j<BeanBuy.tableTitles.length;j++)
				tblData[i][j]=product.get(i).getCell(j);
		}
			tabModel.setDataVector(tblData,tblTitle);
			this.dataTable.validate();
			this.dataTable.repaint();
		}
	public FrmBuy(JDialog f,String s,boolean b) {
		super(f,s,b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));		
		toolBar.add(this.btnDelete);
		toolBar.add(this.btnClear);
		toolBar.add(this.btnSett);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		this.setSize(350, 520);
		// 屏幕居中显示
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth())/2+560,
				(int) (height - this.getHeight())/2 );
				
		this.validate();
		this.getContentPane().add(new JScrollPane(this.dataTable), BorderLayout.CENTER);
		this.reloadPro();
		this.btnClear.addActionListener(this);
		this.btnDelete.addActionListener(this);
		this.btnSett.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.btnClear) {
			try{
				TakeAwayUtil.userManager.initBuy();
				this.reloadPro();
			}catch(BaseException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		else if(e.getSource()==this.btnDelete) {
			int i=this.dataTable.getSelectedRow();
    	    if(i<0) {
  				JOptionPane.showMessageDialog(null,  "请选择商品","提示",JOptionPane.ERROR_MESSAGE);
  				return;
  			  }
    	    try {
      		  BeanBuy p=product.get(i);
      		  TakeAwayUtil.userManager.deletePro(p);
  		      this.reloadPro();
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		else if(e.getSource()==this.btnSett) {
			try{
				FrmSettlement dlg=new FrmSettlement(this,"结算页面",true);
				dlg.setVisible(true);
			}catch(BaseException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}
		
	}
	

}
