package com.view;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.w3c.dom.css.ElementCSSInlineStyle;

import com.dao.StudentDao;
import com.model.Course;
import com.model.Student;

public class UI extends JFrame implements ActionListener{
	private Panel p1;
	private JLabel wel;
	private JLabel cho;
	private JButton stu;
	private JButton tea;
	private JButton cour;
	private JButton sc;
	private JButton ex;
	public  UI() {
		setTitle("欢迎使用学生课程管理系统");
		stu=new JButton("学生信息");
		tea=new JButton("教师信息");
		cour=new JButton("课程信息");
		sc=new JButton("选课信息");
		ex=new JButton("注销登录");
		wel=new JLabel("欢迎您，用户User1:");
		cho=new JLabel("请选择要查看的信息(主菜单)：");
		
		setLayout(null);
		this.setSize(400,300);
		Container c1=getContentPane();
		c1.setBackground(Color.white);
		
		stu.addActionListener(this);
		stu.setActionCommand("stu");
		tea.addActionListener(this);
		tea.setActionCommand("tea");
		sc.addActionListener(this);
		sc.setActionCommand("sc");
		ex.addActionListener(this);
		ex.setActionCommand("ex");
		cour.addActionListener(this);
		cour.setActionCommand("cour");
		
		
		wel.setBounds(0, 0, 150, 20);
		cho.setBounds(10, 40, 200, 20);
		stu.setBounds(30, 80, 100, 20);
		tea.setBounds(30, 120, 100, 20);
		cour.setBounds(30, 160, 100, 20);
		sc.setBounds(30, 200, 100, 20);
		ex.setBounds(250,220,80, 20);
		
		c1.add(wel);
		c1.add(cho);
		c1.add(stu);
		c1.add(tea);
		c1.add(cour);
		c1.add(sc);
		c1.add(ex);
		
		setVisible(true);  
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		if (s.equals("ex"))
		{
			setVisible(false);
			new Login();//注销登录
			setVisible(false);
		}
		else if(s.equals("stu"))
		{
			new Tips("正在为你查询学生信息。。。");
			new Stuinfo();
			setVisible(false);
		}
		else if(s.equals("tea"))
		{
			new Tips("正在为你查询教师信息。。。");
			new Teainfo();
			setVisible(false);
		}
		else if(s.equals("sc"))
		{
			new Tips("正在完善中");
			new SCinfo();
			setVisible(false);
		}
		else if(s.equals("cour"))
		{
			new Tips("正在为您查询。。。");
			new Courseinfo();
			setVisible(false);
		}
		
	}
}
