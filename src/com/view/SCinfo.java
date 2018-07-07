package com.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.css.ElementCSSInlineStyle;

import com.action.SCAction;
import com.model.SC;

public class SCinfo implements ActionListener{
	private JFrame frame;
	private JTable table;
	DefaultTableModel datamodel;
	private JScrollPane jScrollPane;
	private JPanel p1;
	private JButton ex;
	private JButton add;
	private JButton del;
	private JButton search;
	private JButton renew;
	private JTextField cnofield;
	private JLabel cno1;
	private JLabel sno1;
	private JTextField snofield;
	public SCinfo() {
		frame=new JFrame("ѡ����Ϣ����");
		ex=new JButton("�������˵�");
		ex.addActionListener(this);
		ex.setActionCommand("ex");
		add=new JButton("��Ӽ�¼");
		add.addActionListener(this);
		add.setActionCommand("add");
		renew=new JButton("ˢ��");
		renew.addActionListener(this);
		renew.setActionCommand("renew");
		del=new JButton("ɾ��");
		del.addActionListener(this);
		del.setActionCommand("del");
		search=new JButton("��ѯ");
		search.addActionListener(this);
		search.setActionCommand("search");
		sno1=new JLabel("������ѧ�ţ�");
		snofield=new JTextField();
		cnofield=new JTextField();
		cno1=new JLabel("�������γ̺ţ�");
		
		ex.setBounds(240, 420, 100, 20);
		add.setBounds(10, 380, 90, 20);
		renew.setBounds(110, 380, 80, 20);
		del.setBounds(200, 380, 80, 20);
		search.setBounds(310, 380, 80,20);
		cno1.setBounds(10, 350, 80, 20);
		cnofield.setBounds(95, 350, 80, 20);
		sno1.setBounds(180, 350, 80, 20);
		snofield.setBounds(265, 350, 80, 20);
		
		Container c1=frame.getContentPane();
		c1.setBackground(Color.white);
		c1.add(ex);
		c1.add(add);
		c1.add(del);
		c1.add(add);
		c1.add(renew);
		c1.add(search);
		c1.add(snofield);
		c1.add(sno1);
		c1.add(cno1);
		c1.add(cnofield);
		
		frame.setLayout(null);
		String head[]={"Cno","Sno"};
		table=new JTable(0,2);
		datamodel=new DefaultTableModel(head, 0);
		int count=datamodel.getRowCount();
		table.setModel(datamodel);
		jScrollPane=new JScrollPane(table);
		
		
		jScrollPane.setBounds(10,10,350,300);
		
		frame.add(jScrollPane);
		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		List<SC> scList=new ArrayList<SC>();
		Vector<String> newsc=null;
		
		SC sc=null;
		SCAction sa=new SCAction();
		try {
			scList=sa.query();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			new Tips("�����쳣");
		}
		if(scList!=null)
		for(int i=0;i<scList.size();i++)
		{
			sc=new SC();
			sc=scList.get(i);
			newsc=new Vector<String>();
			newsc.add(sc.getCno());
			newsc.add(sc.getSno());
			datamodel.addRow(newsc);
			
		}
	}
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		SCAction sa=new SCAction();
		String c1=null;
		String s1=null;
		SC sc=null;
		Vector<String> newsc=null;
		List<SC> scList=null;
		if(s.equals("ex"))
		{
			new UI();
			frame.setVisible(false);
		}
		else if(s.equals("renew"))
		{
			
			snofield.setText("");
			cnofield.setText("");
			scList=new ArrayList<SC>();
			newsc=new Vector<String>();
			sc=null;
			try {
				scList=sa.query();
			} catch (SQLException m) {
				// TODO �Զ����ɵ� catch ��
				m.printStackTrace();
				new Tips("�����쳣");
			}
			if(scList!=null)
			{
				datamodel.setRowCount(0);
				for(int i=0;i<scList.size();i++)
				{
				sc=new SC();
				sc=scList.get(i);
				newsc=new Vector<String>();
				newsc.add(sc.getCno());
				newsc.add(sc.getSno());
				datamodel.addRow(newsc);
				
				}
			}
		}
		else if(s.equals("add"))
		{
			
			c1=cnofield.getText().toString();
			s1=snofield.getText().toString();
			
			if(cnofield.getText().toString().equals("")|| snofield.getText().toString().equals(""))
			{
				new Tips("�������Բ���Ϊ�գ���Ч����");
			}else{
				
				System.out.println("hahahah");
				sc=new SC();
				sc.setCno(c1);
				sc.setSno(s1);
				try {
					sa.addSC(sc);
					new Tips("��ӳɹ�");
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					new Tips("��Ч����");
					e1.printStackTrace();
				}
				//��Ӻ�ˢ��
				scList=new ArrayList<SC>();
				newsc=null;
				sc=null;
				try {
					scList=sa.query();
				} catch (SQLException m) {
					// TODO �Զ����ɵ� catch ��
					m.printStackTrace();
					new Tips("�����쳣");
				}
				if(scList!=null)
				{
					datamodel.setRowCount(0);
					for(int i=0;i<scList.size();i++)
					{
					sc=new SC();
					sc=scList.get(i);
					newsc=new Vector<String>();
					newsc.add(sc.getCno());
					newsc.add(sc.getSno());
					datamodel.addRow(newsc);
					
					}
				}
				
			}
		}else if(s.equals("search"))
		{
			
			
			c1=null;
			s1=null;
			c1=cnofield.getText().toString();
			s1=snofield.getText().toString();
			
			
			if(cnofield.getText().toString().equals("") && snofield.getText().toString().equals(""))
			{
				new Tips("�������Բ���Ϊ�գ���Ч����");
			}else if(cnofield.getText().toString().equals("") && (!snofield.getText().toString().equals("")))
			{
				
				try {
					scList=sa.querySno(s1);
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					new Tips("��Ч����");
					e1.printStackTrace();
				}
				if(scList!=null)
				{
					datamodel.setRowCount(0);
					for(int i=0;i<scList.size();i++)
					{
					sc=new SC();
					sc=scList.get(i);
					newsc=new Vector<String>();
					newsc.add(sc.getCno());
					newsc.add(sc.getSno());
					datamodel.addRow(newsc);
					
					}
				}else {
					new Tips("�޸���ѡ�ν������ȷ���Ƿ��и�ѧ����");
				}
			} else if(!cnofield.getText().toString().equals("") && snofield.getText().toString().equals(""))
			{
				try {
					scList=sa.queryCno(c1);
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					new Tips("��Ч����");
					e1.printStackTrace();
				}
				if(scList!=null)
				{
					datamodel.setRowCount(0);
					for(int i=0;i<scList.size();i++)
					{
					sc=new SC();
					sc=scList.get(i);
					newsc=new Vector<String>();
					newsc.add(sc.getCno());
					newsc.add(sc.getSno());
					datamodel.addRow(newsc);
					
					}
				}else {
					new Tips("�޸���ѡ�ν������ȷ���Ƿ��и�ѧ����");
				}
			}else if (!cnofield.getText().toString().equals("") && !snofield.getText().toString().equals(""))
			{
				try {
					scList=sa.querySCno(c1, s1);
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					new Tips("��Ч����");
					e1.printStackTrace();
				}
				if(scList!=null)
				{
					datamodel.setRowCount(0);
					for(int i=0;i<scList.size();i++)
					{
					sc=new SC();
					sc=scList.get(i);
					newsc=new Vector<String>();
					newsc.add(sc.getCno());
					newsc.add(sc.getSno());
					datamodel.addRow(newsc);
					
					}
				}else {
					new Tips("�޸�ѡ�μ�¼");
				}
			}
		}
		else if(s.equals("del"))
		{
			c1=null;
			s1=null;
			c1=cnofield.getText().toString();
			s1=snofield.getText().toString();
			
			if (!cnofield.getText().toString().equals("") && !snofield.getText().toString().equals(""))
			{
				sc=new SC();
				sc.setCno(c1);
				sc.setSno(c1);
				try {
					sa.delSC(sc);
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				try {
					scList=sa.query();
				} catch (SQLException m) {
					// TODO �Զ����ɵ� catch ��
					m.printStackTrace();
					new Tips("�����쳣");
				}
				if(scList!=null)
				{
					datamodel.setRowCount(0);
					for(int i=0;i<scList.size();i++)
					{
					sc=new SC();
					sc=scList.get(i);
					newsc=new Vector<String>();
					newsc.add(sc.getCno());
					newsc.add(sc.getSno());
					datamodel.addRow(newsc);
					}
				}
				
			}else{
				new Tips("ɾ���������Բ���Ϊ�գ���Ч����");
			}
		}
	}
}

