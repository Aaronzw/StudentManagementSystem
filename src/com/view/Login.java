package com.view;
import com.model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
//登录输密码界面
public class Login implements ActionListener{
	private JLabel title;
	private JFrame f;
	private JLabel pic;
	private JLabel yhm;//用户名：
	private JLabel mima;//密码：
	private JTextField tf;//输入区
	private JPasswordField pwd;
	private JButton login;//确定
	private JButton ex;//取消

	private String usr="admin";
	private String passwd="12345678";
	
	
	public Login() {
		f=new JFrame("学生课程管理系统by庄巍");
		title=new JLabel("学生课程管理系统");
		title.setFont(new Font("宋体",1, 30));
		
		f.setLayout(null);
		f.setSize(400, 300);
		
		Container c1=f.getContentPane();
		c1.setBackground(Color.white);
		yhm=new JLabel("用户名：");
		mima=new JLabel("密码：");
		tf=new JTextField();
		pwd=new JPasswordField();
		
		
		ImageIcon icon=new ImageIcon("2.jpg");
		icon.setImage(icon.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT ));
		pic=new JLabel(icon);
		
		
		login=new JButton("登录");
		login.addActionListener(this);
		login.setActionCommand("login");
		login.setContentAreaFilled(false);
		login.setBorderPainted(false);
		
		ex=new JButton("退出");
		ex.addActionListener(this);
		ex.setActionCommand("ex");
		ex.setContentAreaFilled(false);
		ex.setBorderPainted(false);
		
		pic.setBounds(10, 100, 100, 90);
		title.setBounds(10, 20, 380, 60);
		yhm.setBounds(110,100, 60, 30);
		tf.setBounds(180, 100, 150, 30);
		mima.setBounds(110, 150, 60, 30);
		pwd.setBounds(180,150, 150, 30);
		login.setBounds(150, 200, 80, 20);
		ex.setBounds(240, 200, 80, 20);
		
		c1.add(title);
		c1.add(yhm);
		c1.add(mima);
		c1.add(tf);
		c1.add(pwd);
		c1.add(login);
		c1.add(ex);
		c1.add(pic);
		
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		System.out.println(s);
		if(s.equals("ex"))
		{
			System.exit(0);
		}
		else if(s.equals("login"))
		{
			String username=tf.getText().toString();
			String password=new String(pwd.getPassword());
			if(username.equals(usr)&&password.equals(passwd))
			{
				new UI();
				f.setVisible(false);
			}else if(username==null||username.length()<= 0||password==null||password.length()<=0)
			{
				new Tips("对不起，账号密码信息不能为空");
			}
			else{
				new Tips("对不起，密码错误！");
			}
		}
	}
}
