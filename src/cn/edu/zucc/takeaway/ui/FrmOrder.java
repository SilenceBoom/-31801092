package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.takeaway.TakeAwayUtil;
import cn.edu.zucc.takeaway.model.BeanOrder1;
import cn.edu.zucc.takeaway.model.BeanOrder2;
import cn.edu.zucc.takeaway.model.BeanPro;
import cn.edu.zucc.takeaway.util.BaseException;

public class FrmOrder extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JButton btnCancel=new JButton("ɾ������");
	private JButton btnNew=new JButton("ˢ��");
	List<BeanOrder2> order=null;
	private Object tblTitle[]=BeanOrder2.tableTitles;
	private Object tblData[][];
	DefaultTableModel tabModel=new DefaultTableModel();
	private JTable dataTable=new JTable(tabModel);
	
	
	public void reloadOrder(){
	    try {
				
				order=TakeAwayUtil.userManager.loadallorder2();
			} catch (BaseException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "����",JOptionPane.ERROR_MESSAGE);
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
//	public void reloadOrder2(int merIdx) {
//		if(merIdx<0)return;
//		curorder=order1.get(merIdx);
//		try {
//			order2=TakeAwayUtil.userManager.loadallorder2(curorder);
//		}catch(BaseException e1) {
//			JOptionPane.showMessageDialog(null, e1.getMessage(), "����",JOptionPane.ERROR_MESSAGE);
//			return;
//		}
//		tblData2 =new Object[order2.size()][BeanOrder2.tableTitles.length];
//		for(int i=0;i<order2.size();i++){
//			for(int j=0;j<BeanOrder2.tableTitles.length;j++)
//				tblData2[i][j]=order2.get(i).getCell(j);
//		}
//		
//		tabModel2.setDataVector(tblData2,tblTitle2);
//		this.dataTable2.validate();
//		this.dataTable2.repaint();
//		
//	}
	public FrmOrder(Frame f,String s,boolean b) {
		super(f,s,b);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEADING));
		toolBar.add(this.btnCancel);
		toolBar.add(this.btnNew);
		this.getContentPane().add(toolBar,BorderLayout.BEFORE_FIRST_LINE);
		this.setSize(925, 520);
		// ��Ļ������ʾ
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
		if(e.getSource()==this.btnNew) {
			this.reloadOrder();
		}
		else if(e.getSource()==this.btnCancel) {
			int i=this.dataTable.getSelectedRow();
    	    if(i<0) {
  				JOptionPane.showMessageDialog(null,  "��ѡ���̼�","��ʾ",JOptionPane.ERROR_MESSAGE);
  				return;
  			  }
        	  try {
    		  TakeAwayUtil.merchantManager.deleteOrder(order.get(i));
    		  this.reloadOrder();
  			
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "����",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
	
		
	}

}
