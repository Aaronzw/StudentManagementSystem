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

import com.action.CourseAction;
import com.action.StudentAction;
import com.action.TeacherAction;
import com.dao.StudentDao;
import com.model.Student;

public class Courseinfo extends JFrame implements ActionListener {
	private JLabel title;
	private JLabel cno1;
	private JTextField cno2;
	private JLabel cname1;
	private JTextField cname2;
	private JLabel credit1;
	private JTextField credit2;
	private JLabel ctime1;
	private JTextField ctime2;
	private JLabel cplace1;
	private JTextField cplace2;
	private JLabel bno1;
	private JTextField bno2;
	private JLabel tno1;
	private JTextField tno2;
	
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
	List<Course> list;
	public Courseinfo() {
		// TODO 自动生成的构造函数存根
		i=0;
		size=0;
		setTitle("课程信息查询界面");
		setLayout(null);
		this.setSize(400, 400);
		Container c1=getContentPane();
		c1.setBackground(Color.white);
		
		title=new JLabel("课程信息");
		cno1=new JLabel("课程号:");
		cno2=new JTextField();
		cname1=new JLabel("课程名:");
		cname2=new JTextField();
		credit1=new JLabel("学分：");
		credit2 =new JTextField();
		ctime1=new JLabel("上课时间:");
		ctime2=new JTextField();
		cplace1=new JLabel("上课地点:");
		cplace2=new JTextField();
		bno1=new JLabel("使用教材:");
		bno2=new JTextField();
		tno1=new JLabel("任课教师:");
		tno2=new JTextField();
		
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
		sfield=new JTextField("请输入待查询课程号或课程名名");
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
		
		title.setBounds(140,0,80,25);
		cno1.setBounds(10,40,50,20);
		cno2.setBounds(75,40,60,20);
		cname1.setBounds(150, 40, 45, 20);
		cname2.setBounds(210, 40, 90, 20);
		credit1.setBounds(285, 70, 40, 20);
		credit2.setBounds(330, 70, 40, 20);
		ctime1.setBounds(10, 70, 60, 20);
		ctime2.setBounds(75, 70, 60, 20);
		cplace1.setBounds(150, 70, 70, 20);
		cplace2.setBounds(210, 70, 70, 20);
		bno1.setBounds(10, 100, 60, 20);
		bno2.setBounds(75, 100, 60, 20);
		tno1.setBounds(150,100,50,20);
		tno2.setBounds(210, 100,70, 20);
		
		
		
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
		c1.add(cno1);
		c1.add(cno2);
		c1.add(cname1);
		c1.add(cname2);
		c1.add(credit1);
		c1.add(credit2);
		c1.add(ctime1);
		c1.add(ctime2);
		c1.add(cplace1);
		c1.add(cplace1);
		c1.add(cplace2);
		c1.add(bno1);
		c1.add(bno2);
		c1.add(tno1);
		c1.add(tno2);
		
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
		CourseAction cd=new CourseAction();
		try {
			list=cd.query();
		} catch (Exception m) {
			// TODO 自动生成的 catch 块
			m.printStackTrace();
		}
		if(list!=null)
		{
				size=list.size();
				Course s1=list.get(i);
				cno2.setText(s1.getCno());
				cname2.setText(s1.getCname());
				credit2.setText(s1.getCredit()+"");
				ctime2.setText(s1.getCtime());
				cplace2.setText(s1.getCplace());
				bno2.setText(s1.getBno());
				tno2.setText(s1.getTno());
				
				no.setText("当前信息是第"+(i+1)+"/"+size+"条");
		}
	}
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		CourseAction ca=new CourseAction();
		Course c1=null;
		if(s.equals("search"))
		{
			
			c1=new Course();
			try {
				c1=ca.queryCno(sfield.getText());
				
			} catch (Exception m) {
				// TODO 自动生成的 catch 块
				m.printStackTrace();
			}
			if(c1!=null)
				{
				cno2.setText(c1.getCno());
				cname2.setText(c1.getCname());
				credit2.setText(c1.getCredit()+"");
				ctime2.setText(c1.getCtime());
				cplace2.setText(c1.getCplace());
				bno2.setText(c1.getBno());
				tno2.setText(c1.getTno());
				}
			else{
				List<Course> c2=new ArrayList<Course>();
				try {
					
					c2=ca.queryCname(sfield.getText());
				} catch (Exception m) {
					// TODO 自动生成的 catch 块
					m.printStackTrace();
				}
				if(c2!=null)
				{
					i=0;
					Course s3=new Course();
					s3=c2.get(i);
					cno2.setText(c1.getCno());
					cname2.setText(c1.getCname());
					credit2.setText(c1.getCredit()+"");
					ctime2.setText(c1.getCtime());
					cplace2.setText(c1.getCplace());
					bno2.setText(c1.getBno());
					tno2.setText(c1.getTno());
					no.setText("当前信息是第1/1条");
				}
			}
			
		}else if(s.equals("edit"))
		{
			Course s4=new Course();
			s4.setCno(cno2.getText());
			s4.setCname(cname2.getText());
			int t=2;
			try {
				t=Integer.parseInt(credit2.getText()) ;
			} catch (Exception e2) {
				new Tips("输入有误");
			}
			s4.setCredit(t);
			s4.setCtime(ctime2.getText());
			s4.setCplace(cplace2.getText());
			s4.setTno(tno2.getText());
			s4.setBno(bno2.getText());
			try {
				
				ca.editC(s4);
				new Tips("更新数据成功");
			} catch (Exception e1) {
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
				c1=list.get(i);
				cno2.setText(c1.getCno());
				cname2.setText(c1.getCname());
				credit2.setText(c1.getCredit()+"");
				ctime2.setText(c1.getCtime());
				cplace2.setText(c1.getCplace());
				bno2.setText(c1.getBno());
				tno2.setText(c1.getTno());
				no.setText("当前信息是第"+(i+1)+"/"+size+"条");
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
				c1=list.get(i);
				cno2.setText(c1.getCno());
				cname2.setText(c1.getCname());
				credit2.setText(c1.getCredit()+"");
				ctime2.setText(c1.getCtime());
				cplace2.setText(c1.getCplace());
				bno2.setText(c1.getBno());
				tno2.setText(c1.getTno());
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
			//System.out.println("hahah");
			Course s4=new Course();
			s4.setCno(cno2.getText());
			s4.setCname(cname2.getText());
			int t=2;
			try {
				t=Integer.parseInt(credit2.getText()) ;
			} catch (Exception e2) {
				new Tips("输入有误");
			}
			s4.setCredit(t);
			s4.setCtime(ctime2.getText());
			s4.setCplace(cplace2.getText());
			s4.setTno(tno2.getText());
			s4.setBno(bno2.getText());
			try {
				
				ca.addCourse(s4);
				new Tips("新增数据成功");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		else if(s.equals("renew"))
		{
			try {
				list=ca.query();
			} catch (Exception m) {
				// TODO 自动生成的 catch 块
				m.printStackTrace();
			}
			if(list!=null)
			{
					i=0;
					size=list.size();
					Course s1=list.get(i);
					cno2.setText(s1.getCno());
					cname2.setText(s1.getCname());
					credit2.setText(s1.getCredit()+"");
					ctime2.setText(s1.getCtime());
					cplace2.setText(s1.getCplace());
					bno2.setText(s1.getBno());
					tno2.setText(s1.getTno());
					
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
			String delcno=cno2.getText();
			
			try {
				ca.delC(delcno);
				new Tips("删除成功");
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			try {
				list=ca.query();
			} catch (Exception m) {
				// TODO 自动生成的 catch 块
				m.printStackTrace();
			}
			if(list!=null)
			{
					i=0;
					size=list.size();
					Course s1=list.get(i);
					cno2.setText(s1.getCno());
					cname2.setText(s1.getCname());
					credit2.setText(s1.getCredit()+"");
					ctime2.setText(s1.getCtime());
					cplace2.setText(s1.getCplace());
					bno2.setText(s1.getBno());
					tno2.setText(s1.getTno());
					
					no.setText("当前信息是第"+(i+1)+"/"+size+"条");
			}
		}
	}
}
