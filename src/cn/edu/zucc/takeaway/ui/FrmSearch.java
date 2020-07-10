package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.takeaway.TakeAwayUtil;
import cn.edu.zucc.takeaway.model.BeanMerchant;
import cn.edu.zucc.takeaway.model.BeanPro;
import cn.edu.zucc.takeaway.model.BeanProduct;
import cn.edu.zucc.takeaway.util.BaseException;

      
public class FrmSearch extends JDialog implements ActionListener{
	List<BeanMerchant> merchant=null;
	private Object tblTitle[]=BeanMerchant.tableTitles;
	private Object tblData[][];
	DefaultTableModel tabModel=new DefaultTableModel();
	private JTable dataTable=new JTable(tabModel);
	
	private Object tblProTitle[]=BeanPro.tableTitles;
	private Object tblProData[][];
	DefaultTableModel tabProModel=new DefaultTableModel();
	private JTable dataTablePro=new JTable(tabProModel);
	
	List<BeanPro> product=null;
	private BeanMerchant curmer=null;
	public void reloadMerchant(){
    try {
			
			merchant=TakeAwayUtil.merchantManager.loadall();
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblData =  new Object[merchant.size()][BeanMerchant.tableTitles.length];
		for(int i=0;i<merchant.size();i++){
			for(int j=0;j<BeanMerchant.tableTitles.length;j++)
				tblData[i][j]=merchant.get(i).getCell(j);
		}
		tabModel.setDataVector(tblData,tblTitle);
		this.dataTable.validate();
		this.dataTable.repaint();
	}
	public void reloadProduct(int merIdx) {
		if(merIdx<0)return;
		curmer=merchant.get(merIdx);
		try {
			product=TakeAwayUtil.merchantManager.loadallP(curmer);
		}catch(BaseException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblProData =new Object[product.size()][BeanPro.tableTitles.length];
		for(int i=0;i<product.size();i++){
			for(int j=0;j<BeanPro.tableTitles.length;j++)
				tblProData[i][j]=product.get(i).getCell(j);
		}
		
		tabProModel.setDataVector(tblProData,tblProTitle);
		this.dataTablePro.validate();
		this.dataTablePro.repaint();
		
	}
	public FrmSearch(Frame f,String s,boolean b) {
		super(f,s,b);
		this.setSize(800, 520);
		// ÆÁÄ»¾ÓÖÐÏÔÊ¾
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth())/2,
				(int) (height - this.getHeight())/2 );
				
		this.validate();
		this.getContentPane().add(new JScrollPane(this.dataTable), BorderLayout.WEST);
		this.dataTable.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				int i=FrmSearch.this.dataTable.getSelectedRow();
				if(i<0) {
					return;
				}
				FrmSearch.this.reloadProduct(i);
			}
	    	
	    });
	    this.getContentPane().add(new JScrollPane(this.dataTablePro), BorderLayout.CENTER);
	    this.reloadMerchant();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
