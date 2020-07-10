package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.takeaway.ui.FrmLogin;
import cn.edu.zucc.takeaway.model.*;

import cn.edu.zucc.takeaway.util.BaseException;
public class FrmMain extends JFrame implements ActionListener{

	    private FrmLogin dlgLogin=null;	
        public FrmMain() throws IOException{
        	 dlgLogin=new FrmLogin(this,"µÇÂ½",true);
	         dlgLogin.setVisible(true);
        }
	    
	    public void actionPerformed(ActionEvent e) {
	    	
	    	
	    }

}
