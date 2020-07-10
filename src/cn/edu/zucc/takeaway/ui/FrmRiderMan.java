package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
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
import cn.edu.zucc.takeaway.model.BeanRider;
import cn.edu.zucc.takeaway.util.BaseException;
import cn.edu.zucc.takeaway.util.BusinessException;

public class FrmRiderMan extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnSearch = new Button("查询骑手");
	private Button btnCancel = new Button("删除骑手");
	private Button btnNew = new Button("刷新");
	private JTextField edtName = new JTextField(10);
	private Object tblTitle[]=BeanRider.tableTitles;
	private Object tblData[][];
	DefaultTableModel tabModel=new DefaultTableModel();
	private JTable dataTable=new JTable(tabModel);
	
	List<BeanRider> riders=null;
	private final JScrollPane scroll = new JScrollPane();
	private void reloadTable(){
		try {
			
			riders=TakeAwayUtil.riderManager.loadall();
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblData =  new Object[riders.size()][BeanRider.tableTitles.length];
		for(int i=0;i<riders.size();i++){
			for(int j=0;j<BeanRider.tableTitles.length;j++)
				tblData[i][j]=riders.get(i).getCell(j);
		}
		tabModel.setDataVector(tblData,tblTitle);
		this.dataTable.validate();
		this.dataTable.repaint();
	}
	private void reloadInf()throws BaseException{
		BeanRider rider=null;
		String s=this.edtName.getText().trim();
		if(!"".equals(s)){
			try {
			rider=TakeAwayUtil.riderManager.search(this.edtName.getText());
			if(rider==null)throw new BusinessException("无查询结果");
			tblData =new Object[1][BeanRider.tableTitles.length];
		    for(int i=0;i<BeanRider.tableTitles.length;i++) {
		    	tblData[0][i]=rider.getCell(i);
		    }
			tabModel.setDataVector(tblData,tblTitle);
			this.dataTable.validate();
			this.dataTable.repaint();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	}
	
	public FrmRiderMan(Frame f,String s,boolean b) {
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
		this.btnNew.addActionListener(this);
		this.btnSearch.addActionListener(this);
		this.btnCancel.addActionListener(this);
		JScrollPane scrollPane_1 = new JScrollPane(this.dataTable);
		this.getContentPane().add(scrollPane_1, BorderLayout.AFTER_LAST_LINE);
		scrollPane_1.setColumnHeaderView(scroll);
	    this.reloadTable();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
		  				JOptionPane.showMessageDialog(null,  "请选择骑手","提示",JOptionPane.ERROR_MESSAGE);
		  				return;
		  			  }
              	  try {
		    		  TakeAwayUtil.riderManager.delete(this.riders.get(i));
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
