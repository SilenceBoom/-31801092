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
import cn.edu.zucc.takeaway.model.BeanUser;
import cn.edu.zucc.takeaway.util.BaseException;
import cn.edu.zucc.takeaway.util.BusinessException;

public class FrmUserMan extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnSearch = new Button("查询用户");
	private Button btnCancel = new Button("删除用户");
	private Button btnNew = new Button("刷新");
	private JTextField edtName = new JTextField(10);
	private Object tblTitle[]=BeanUser.tableTitles;
	private Object tblData[][];
	DefaultTableModel tabModel=new DefaultTableModel();
	private JTable dataTable=new JTable(tabModel);
	
	List<BeanUser> user=null;
	private final JScrollPane scroll = new JScrollPane();
	private void reloadTable(){
		try {
			
			user=TakeAwayUtil.userManager.loadall();
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblData =  new Object[user.size()][BeanUser.tableTitles.length];
		for(int i=0;i<user.size();i++){
			for(int j=0;j<BeanUser.tableTitles.length;j++)
				tblData[i][j]=user.get(i).getCell(j);
		}
		tabModel.setDataVector(tblData,tblTitle);
		this.dataTable.validate();
		this.dataTable.repaint();
	}
	private void reloadInf()throws BaseException{
		BeanUser user1=null;
		String s=this.edtName.getText().trim();
		if(!"".equals(s)){
			try {
			user1=TakeAwayUtil.userManager.search(this.edtName.getText());
			if(user1==null)throw new BusinessException("无查询结果");
			tblData =new Object[1][BeanUser.tableTitles.length];
		    for(int i=0;i<BeanUser.tableTitles.length;i++) {
		    	tblData[0][i]=user1.getCell(i);
		    }
			tabModel.setDataVector(tblData,tblTitle);
			this.dataTable.validate();
			this.dataTable.repaint();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	}
	
	public FrmUserMan(Frame f,String s,boolean b) {
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
		  				JOptionPane.showMessageDialog(null,  "请选择用户","提示",JOptionPane.ERROR_MESSAGE);
		  				return;
		  			  }
                	  try {
		    		  TakeAwayUtil.userManager.delete(this.user.get(i));
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
