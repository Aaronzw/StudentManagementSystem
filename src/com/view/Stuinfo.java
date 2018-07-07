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
import com.dao.StudentDao;
import com.model.Student;

public class Stuinfo extends JFrame implements ActionListener {
	private JLabel title;
	private JLabel sno1;
	private JTextField sno2;
	private JLabel sna1;
	private JTextField sna2;
	private JLabel sex1;
	private JTextField sex2;
	private JLabel smj1;
	private JTextField smj2;
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
	private JButton ex;
	
	private int i;
	private int size;
	List<Student> list;
	public Stuinfo ()
	{
		i=0;
		size=0;
		setTitle("学生信息界面");
		setLayout(null);
		this.setSize(400, 400);
		Container c1=getContentPane();
		c1.setBackground(Color.white);
		
		title=new JLabel("学生信息");
		sno1=new JLabel("学号：");
		sno2=new JTextField();
		sna1=new JLabel("姓名：");
		sna2=new JTextField();
		sex1=new JLabel("性别：");
		sex2=new JTextField();
		smj1=new JLabel("专业：");
		smj2=new JTextField();
		pre =new JButton("上一个");
		pre.addActionListener(this);
		pre.setActionCommand("pre");
		if(i==0)
			pre.setEnabled(false);
		next=new JButton("下一个");
		next.addActionListener(this);
		next.setActionCommand("next");
		search=new JButton("查询");
		search.addActionListener(this);
		search.setActionCommand("search");
		sfield=new JTextField("请输入待查询学号或姓名");
		renew=new JButton("刷新");
		renew.addActionListener(this);
		renew.setActionCommand("renew");
		edit=new JButton("修改当前信息");
		edit.addActionListener(this);
		edit.setActionCommand("edit");
		no=new JLabel("当前信息是第"+(i+1)+"/"+(size+1)+"条");
		menu=new JButton("返回主菜单");
		menu.addActionListener(this);
		menu.setActionCommand("menu");
		add=new JButton("添加");
		add.addActionListener(this);
		add.setActionCommand("add");
		del=new JButton("删除当前记录");
		del.addActionListener(this);
		del.setActionCommand("del");
		ex=new JButton("返回主菜单");
		ex.addActionListener(this);
		ex.setActionCommand("ex");
		
		title.setBounds(140, 0, 80, 25);
		sno1.setBounds(10,50,40,25);
		sno2.setBounds(60, 50, 80, 25);
		sna1.setBounds(150, 50, 40, 20);
		sna2.setBounds(200, 50, 80, 25);
		sex1.setBounds(10,100,40,25);
		sex2.setBounds(60,100, 80, 25);
		smj1.setBounds(150,100, 40, 20);
		smj2.setBounds(200, 100, 80, 25);
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
		c1.add(sno1);
		c1.add(sno2);
		c1.add(sna1);
		c1.add(sna2);
		c1.add(sex1);
		c1.add(sex2);
		c1.add(smj1);
		c1.add(smj2);
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
        
       // list=null;
		StudentDao cd=new StudentDao();
		try {
			list=cd.query();
		} catch (Exception m) {
			// TODO 自动生成的 catch 块
			m.printStackTrace();
		}
		if(list!=null)
		{
				
				size=list.size();
				Student s1=list.get(i);
				sno2.setText(s1.getSno());
				sna2.setText(s1.getSname());
				sex2.setText(s1.getSsex());
				smj2.setText(s1.getSmajor());
				no.setText("当前信息是第"+(i+1)+"/"+size+"条");
		}
        
	}
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		StudentAction sa=new StudentAction();
		if(s.equals("search"))
		{
			
			Student s1=new Student();
			try {
				s1=sa.getS(sfield.getText());
				
			} catch (Exception m) {
				// TODO 自动生成的 catch 块
				m.printStackTrace();
			}
			if(s1!=null)
				{
				sno2.setText(s1.getSno());
				sna2.setText(s1.getSname());
				sex2.setText(s1.getSsex());
				smj2.setText(s1.getSmajor());
				}
			else{
				List<Student> s2=new ArrayList<Student>();
				try {
					
					s2=sa.getSna(sfield.getText());
				} catch (Exception m) {
					// TODO 自动生成的 catch 块
					m.printStackTrace();
				}
				if(s2!=null)
				{
					i=0;
					Student s3=new Student();
					s3=s2.get(i);
					sno2.setText(s3.getSno());
					sna2.setText(s3.getSname());
					sex2.setText(s3.getSsex());
					smj2.setText(s3.getSmajor());
					no.setText("当前信息是第1/1条");
				}
			}
			
		}else if(s.equals("edit"))
		{
			System.out.println("hahah");
			Student s4=new Student();
			s4.setSno(sno2.getText());
			s4.setSname(sna2.getText());
			s4.setSmajor(smj2.getText());
			s4.setSsex(sex2.getText());
			
			try {
				new Tips("更新数据成功");
				sa.editS(s4);
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				new Tips("操作失败");
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
				Student s1=list.get(i);
				sno2.setText(s1.getSno());
				sna2.setText(s1.getSname());
				sex2.setText(s1.getSsex());
				smj2.setText(s1.getSmajor());
				no.setText("当前信息是第"+(i+1)+"/"+size+"条");
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
				Student s1=list.get(i);
				sno2.setText(s1.getSno());
				sna2.setText(s1.getSname());
				sex2.setText(s1.getSsex());
				smj2.setText(s1.getSmajor());
				no.setText("当前信息是第"+(i+1)+"/"+size+"条");
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
			System.out.println("hahah");
			Student s4=new Student();
			s4.setSno(sno2.getText());
			s4.setSname(sna2.getText());
			s4.setSmajor(smj2.getText());
			s4.setSsex(sex2.getText());
			
			try {
				new Tips("添加数据成功");
				sa.addS(s4);
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				new Tips("无效操作");
			}
			try {
				list=sa.queryS();
			} catch (Exception m) {
				// TODO 自动生成的 catch 块
				m.printStackTrace();
			}
			if(list!=null)
			{
					i=0;
					size=list.size();
					Student s1=list.get(i);
					sno2.setText(s1.getSno());
					sna2.setText(s1.getSname());
					sex2.setText(s1.getSsex());
					smj2.setText(s1.getSmajor());
					no.setText("当前信息是第"+(i+1)+"/"+size+"条");
			}
	        
		}
		else if(s.equals("renew"))
		{
			try {
				list=sa.queryS();
			} catch (Exception m) {
				// TODO 自动生成的 catch 块
				m.printStackTrace();
			}
			if(list!=null)
			{
					i=0;
					size=list.size();
					Student s1=list.get(i);
					sno2.setText(s1.getSno());
					sna2.setText(s1.getSname());
					sex2.setText(s1.getSsex());
					smj2.setText(s1.getSmajor());
					no.setText("当前信息是第"+(i+1)+"/"+size+"条");
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
			String delsno=sno2.getText();
			
			try {
				sa.delS(delsno);
				new Tips("删除成功");
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			try {
				list=sa.queryS();
			} catch (Exception m) {
				// TODO 自动生成的 catch 块
				m.printStackTrace();
			}
			if(list!=null)
			{
					i=0;
					size=list.size();
					Student s1=list.get(i);
					sno2.setText(s1.getSno());
					sna2.setText(s1.getSname());
					sex2.setText(s1.getSsex());
					smj2.setText(s1.getSmajor());
					no.setText("当前信息是第"+(i+1)+"/"+size+"条");
			}
		}
		else if(s.equals("ex"))
		{
			new UI();
			setVisible(false);
		}
	}
	
}
