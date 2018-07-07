package com.view;
import java.util.*;
import com.model.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.w3c.dom.CDATASection;

import com.action.StudentAction;
import com.action.TeacherAction;
import com.dao.StudentDao;
import com.model.Student;

public class Teainfo extends JFrame implements ActionListener {
	private JLabel title;
	private JLabel tno1;
	private JTextField tno2;
	private JLabel tna1;
	private JTextField tna2;
	private JLabel sex1;
	private JTextField sex2;
	private JLabel titl1;
	private JTextField titl2;
	private JButton next;
	private JButton pre;
	private JButton renew;
	private JButton search;
	private JTextField sfield;
	private JButton edit;
	private JLabel no;
	private JButton menu;
	private JButton add;
	private JButton del;
	
	private int i;
	private int size;
	List<Teacher> list;
	public Teainfo() {
		// TODO �Զ����ɵĹ��캯�����
		i=0;
		size=0;
		setTitle("��ʦ��Ϣ����");
		setLayout(null);
		this.setSize(400, 400);
		Container c1=getContentPane();
		c1.setBackground(Color.white);
		
		title=new JLabel("��ʦ��Ϣ");
		tno1=new JLabel("��ʦ�ţ�");
		tno2=new JTextField();
		tna1=new JLabel("������");
		tna2=new JTextField();
		sex1=new JLabel("�Ա�");
		sex2=new JTextField();
		titl1=new JLabel("ְ�ƣ�");
		titl2=new JTextField();
		pre =new JButton("��һ��");
		pre.addActionListener(this);
		pre.setActionCommand("pre");
		if(i==0)
			pre.setEnabled(false);
		next=new JButton("��һ��");
		next.addActionListener(this);
		next.setActionCommand("next");
		search=new JButton("��ѯ");
		search.addActionListener(this);
		search.setActionCommand("search");
		sfield=new JTextField("���������ѯѧ�Ż�����");
		renew=new JButton("ˢ��");
		renew.addActionListener(this);
		renew.setActionCommand("renew");
		edit=new JButton("�޸ĵ�ǰ��Ϣ");
		edit.addActionListener(this);
		edit.setActionCommand("edit");
		no=new JLabel("��ǰ��Ϣ�ǵ�"+(i+1)+"/"+(size+1)+"��");
		menu=new JButton("�������˵�");
		menu.addActionListener(this);
		menu.setActionCommand("menu");
		add=new JButton("���");
		add.addActionListener(this);
		add.setActionCommand("add");
		del=new JButton("ɾ����ǰ��¼");
		del.addActionListener(this);
		del.setActionCommand("del");
		
		title.setBounds(140, 0, 80, 25);
		tno1.setBounds(10,50,40,25);
		tno2.setBounds(60, 50, 80, 25);
		tna1.setBounds(150, 50, 40, 20);
		tna2.setBounds(200, 50, 80, 25);
		sex1.setBounds(10,100,40,25);
		sex2.setBounds(60,100, 80, 25);
		titl1.setBounds(150,100, 40, 20);
		titl2.setBounds(200, 100, 80, 25);
		search.setBounds(5,200,60,20);
		sfield.setBounds(70, 200, 100, 20);
		renew.setBounds(200, 200, 60, 20);
		edit.setBounds(5, 230, 120, 20);
		del.setBounds(130, 230, 120, 20);
		pre.setBounds(5, 260, 80, 20);
		next.setBounds(100, 260,80, 20);
		no.setBounds(200, 260, 150, 20);
		menu.setBounds(280, 300, 100, 20);
		add.setBounds(270, 200, 60, 20);
		
		
		c1.add(title);
		c1.add(tno1);
		c1.add(tno2);
		c1.add(tna1);
		c1.add(tna2);
		c1.add(sex1);
		c1.add(sex2);
		c1.add(titl1);
		c1.add(titl2);
		c1.add(search);
		c1.add(sfield);
		c1.add(renew);
		c1.add(edit);
		c1.add(pre);
		c1.add(next);
		c1.add(no);
		c1.add(menu);
		c1.add(add);
		c1.add(del);
		
		setVisible(true);  
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
       list=null;
		TeacherAction cd=new TeacherAction();
		try {
			list=cd.queryT();
		} catch (Exception m) {
			// TODO �Զ����ɵ� catch ��
			m.printStackTrace();
		}
		if(list!=null)
		{
				
				size=list.size();
				Teacher s1=list.get(i);
				tno2.setText(s1.getTno());
				tna2.setText(s1.getTname());
				sex2.setText(s1.getTsex());
				titl2.setText(s1.getTitle());
				no.setText("��ǰ��Ϣ�ǵ�"+(i+1)+"/"+size+"��");
		}
        
	}
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		TeacherAction ta=new TeacherAction();
		if(s.equals("search"))
		{
			
			Teacher t1=new Teacher();
			try {
				t1=ta.getT(sfield.getText());
				
			} catch (Exception m) {
				// TODO �Զ����ɵ� catch ��
				m.printStackTrace();
			}
			if(t1!=null)
				{
				tno2.setText(t1.getTno());
				tna2.setText(t1.getTname());
				sex2.setText(t1.getTsex());
				titl2.setText(t1.getTitle());
				}
			else{
				List<Teacher> s2=new ArrayList<Teacher>();
				try {
					
					s2=ta.getTname(sfield.getText());
				} catch (Exception m) {
					// TODO �Զ����ɵ� catch ��
					m.printStackTrace();
				}
				if(s2!=null)
				{
					i=0;
					Teacher s3=new Teacher();
					s3=s2.get(i);
					tno2.setText(s3.getTno());
					tna2.setText(s3.getTname());
					sex2.setText(s3.getTsex());
					titl2.setText(s3.getTitle());
					no.setText("��ǰ��Ϣ�ǵ�1/1��");
				}
				
				
			}
			
		}else if(s.equals("edit"))
		{
			//System.out.println("hahah");
			Teacher s4=new Teacher();
			s4.setTno(tno2.getText());
			s4.setTname(tna2.getText());
			s4.setTitle(titl2.getText());
			s4.setTsex(sex2.getText());
			
			try {
				new Tips("�������ݳɹ�");
				ta.editT(s4);
			} catch (Exception e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
		}else if (s.equals("next"))
		{
			if(i==size-2)
			{
				next.setEnabled(false);
			}
			if(i==0)
			{
				pre.setEnabled(false);
			}
			if(i<size-1)
			{
				pre.setEnabled(true);
				i++;
				Teacher s1=list.get(i);
				tno2.setText(s1.getTno());
				tna2.setText(s1.getTname());
				sex2.setText(s1.getTsex());
				titl2.setText(s1.getTitle());
				no.setText("��ǰ��Ϣ�ǵ�"+(i+1)+"/"+size+"��");
				//System.out.println(list.get(i).toString());
			}
			else{
				next.setEnabled(false);
				
			}
		}
		else if(s.equals("pre"))
		{
			if(i==size-2)
			{
				next.setEnabled(false);
			}
			if(i==0)
			{
				pre.setEnabled(false);
			}
			if(i>=1)
			{
				next.setEnabled(true);
				i--;
				Teacher s1=list.get(i);
				tno2.setText(s1.getTno());
				tna2.setText(s1.getTname());
				sex2.setText(s1.getTsex());
				titl2.setText(s1.getTitle());
				no.setText("��ǰ��Ϣ�ǵ�"+(i+1)+"/"+size+"��");
			}
			else{
				pre.setEnabled(false);
				
			}
		}
		else if(s.equals("menu"))
		{
			setVisible(false);
			new UI();
		}else if(s.equals("add"))
		{
			//System.out.println("hahah");
			Teacher s4=new Teacher();
			s4.setTno(tno2.getText());
			s4.setTname(tna2.getText());
			s4.setTitle(titl2.getText());
			s4.setTsex(sex2.getText());
			
			try {
				new Tips("������ݳɹ�");
				ta.addT(s4);
			} catch (Exception e1) {
				// TODO �Զ����ɵ� catch ��
				new Tips("��Ч����");
			}
			try {
				list=ta.queryT();
			} catch (Exception m) {
				// TODO �Զ����ɵ� catch ��
				m.printStackTrace();
			}
			if(list!=null)
			{
					i=0;
					size=list.size();
					Teacher s1=list.get(i);
					tno2.setText(s1.getTno());
					tna2.setText(s1.getTname());
					sex2.setText(s1.getTsex());
					titl2.setText(s1.getTitle());
					no.setText("��ǰ��Ϣ�ǵ�"+(i+1)+"/"+size+"��");
			}
	        
		}
		else if(s.equals("renew"))
		{
			try {
				list=ta.queryT();
			} catch (Exception m) {
				// TODO �Զ����ɵ� catch ��
				m.printStackTrace();
			}
			if(list!=null)
			{
					i=0;
					size=list.size();
					Teacher s1=list.get(i);
					tno2.setText(s1.getTno());
					tna2.setText(s1.getTname());
					sex2.setText(s1.getTsex());
					titl2.setText(s1.getTitle());
					no.setText("��ǰ��Ϣ�ǵ�"+(i+1)+"/"+size+"��");
					if(i==size-2)
					{
						next.setEnabled(false);
						pre.setEnabled(true);
					}
					if(i==0)
					{
						pre.setEnabled(false);
						next.setEnabled(true);
						
					}
			}
		}else if(s.equals("del"))
		{
			String deltno=tno2.getText();
			
			try {
				ta.delT(deltno);
				new Tips("ɾ���ɹ�");
			} catch (Exception e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
			try {
				list=ta.queryT();
			} catch (Exception m) {
				// TODO �Զ����ɵ� catch ��
				m.printStackTrace();
			}
			if(list!=null)
			{
					i=0;
					size=list.size();
					Teacher s1=list.get(i);
					tno2.setText(s1.getTno());
					tna2.setText(s1.getTname());
					sex2.setText(s1.getTsex());
					titl2.setText(s1.getTitle());
					no.setText("��ǰ��Ϣ�ǵ�"+(i+1)+"/"+size+"��");
			}
		}
		
	}
}