package cn.edu.zucc.takeaway.ui;

import cn.edu.zucc.takeaway.util.BaseException;
import cn.edu.zucc.takeaway.util.BusinessException;
import cn.edu.zucc.takeaway.util.DbException;
import cn.edu.zucc.takeaway.TakeAwayUtil;
import cn.edu.zucc.takeaway.comtrol.MerchantManager;
import cn.edu.zucc.takeaway.model.*;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FrmMerchantMan extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnSearch = new Button("查询商家");
	private Button btnCancel = new Button("删除商家");
	private Button btnNew = new Button("刷新");
	private JTextField edtName = new JTextField(10);
	private Object tblTitle[]=BeanMerchant.tableTitles;
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
	private void reloadInf()throws BaseException{
		BeanMerchant merchant1=null;
		String s=this.edtName.getText().trim();
		if(!"".equals(s)){
			try {
			merchant1=TakeAwayUtil.merchantManager.search(this.edtName.getText());
			if(merchant1==null)throw new BusinessException("无查询结果");
			tblData =new Object[1][BeanMerchant.tableTitles.length];
		    for(int i=0;i<BeanMerchant.tableTitles.length;i++) {
		    	tblData[0][i]=merchant1.getCell(i);
		    }
			tabModel.setDataVector(tblData,tblTitle);
			this.dataTable.validate();
			this.dataTable.repaint();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	}
	
	public FrmMerchantMan(Frame f,String s,boolean b) {
		super(f,s,b);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEADING));
		workPane.add(edtName);
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
		JScrollPane scrollPane_1 = new JScrollPane(this.dataTable);
		this.getContentPane().add(scrollPane_1, BorderLayout.AFTER_LAST_LINE);
		scrollPane_1.setColumnHeaderView(scroll);
	    this.reloadTable();
	}
	public void actionPerformed(ActionEvent e) {
		      if(e.getSource()==this.btnSearch){
				try {
					this.reloadInf();
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		      else if(e.getSource()==this.btnCancel) {
		    	  int i=this.dataTable.getSelectedRow();
		    	    if(i<0) {
		  				JOptionPane.showMessageDialog(null,  "请选择商家","提示",JOptionPane.ERROR_MESSAGE);
		  				return;
		  			  }
                	  try {
		    		  TakeAwayUtil.merchantManager.delete(this.merchant.get(i));
		    		  this.reloadTable();
		  			
					} catch (BaseException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
		    	    
		      }
		      else if(e.getSource()==this.btnNew) {
		    	  this.reloadTable();
		      }
		
	}

}
