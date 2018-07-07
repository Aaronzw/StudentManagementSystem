package com.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tips implements ActionListener{
	private JFrame jf;
	private JLabel lb1;
	private JButton b1;
	private JPanel jp1;
	private JPanel jp2;
	public Tips(String s)
	{
		init(s);
	}
	public void init(String s) {
		jf=new JFrame("Tips");
		jf.setLayout(new GridLayout(2, 1));
		lb1=new JLabel(s);
		b1=new JButton("¹Ø±Õ");
		b1.addActionListener(this);
		b1.setActionCommand("tuichu");
		jp1=new JPanel();
		jp2=new JPanel();
		jp1.add(lb1);
		jp2.add(b1);
		jf.add(jp1);
		jf.add(jp2);
		jf.setBackground(Color.white);
		jp1.setBackground(Color.white);
		jp2.setBackground(Color.white);
		jf.pack();
		jf.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		String s=e.getActionCommand();
		if(s.equals("tuichu"))
		{
			
			jf.setVisible(false);
		}
	}
	
}
