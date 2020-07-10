package cn.edu.zucc.takeaway.ui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.takeaway.TakeAwayUtil;
import cn.edu.zucc.takeaway.model.BeanMerchant;
import cn.edu.zucc.takeaway.util.BaseException;

public class FrmMyEva extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnCancel = new Button("删除评论");
	private Button btnNew = new Button("刷新");
	private Object tblTitle[]= {"商家","商品","评论"};
	private Object tblData[][];
	DefaultTableModel tabModel=new DefaultTableModel();
	private JTable dataTable=new JTable(tabModel);
	
	List<BeanMerchant> merchant=null;
	private final JScrollPane scroll = new JScrollPane();
	private void reloadTable(){
		try {
			
			merchant=TakeAwayUtil.merchantManager.loadall();
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
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
	public FrmMyEva(Frame f,String s,boolean b) {
		super(f,s,b);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
