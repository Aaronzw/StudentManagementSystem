package com.test;
//测试连接数据库
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.action.CourseAction;
import com.action.SCAction;
import com.action.TeacherAction;
import com.dao.CourseDao;
import com.dao.SCdao;
import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.db.DBUtil;
import com.model.Course;
import com.model.SC;
import com.model.Student;
import com.model.Teacher;

public class test1 {

	public static void main1(String[] args) {
		// TODO 自动生成的方法存根
		CourseAction c=new CourseAction();
		Course s1=new Course();
		s1.setCno("c001");
		s1.setCname("水课");
		s1.setCplace("cplace");
		s1.setCtime("ctime");
		s1.setCredit(4);
		s1.setBno("b001");
		s1.setTno("t0001");
		try {
			c.editC(s1);
			System.out.println("hahahaaaaaa");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		/*CourseAction cd=new CourseAction();
		List<Course> list=new ArrayList<Course>();
		try {
			//list=cd.querySno("031502248");
			//list=cd.query();
			list=cd.query();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(list!=null)
		{
			for(int i=0;i<list.size();i++)
				System.out.println(list.get(i).toString());
			System.out.println(list.size());
		}*/
		/*List<Student> list=null;
		StudentDao cd=new StudentDao();
		try {
			list=cd.query();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(list!=null)
		{
			for(int i=0;i<list.size();i++)
				System.out.println(list.get(i).toString());
		}
		*/
		/*List<Student> list=null;
		StudentDao cd=new StudentDao();
		try {
			list=cd.query();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(list!=null)
		{
			for(int i=0;i<list.size();i++)
				System.out.println(list.get(i).toString());
		}
		
		*/
		
		//Connection con=DBUtil.getConnection();
		//Statement st;
		/*TeacherAction ta = new TeacherAction();
		Teacher t=new Teacher();
		t.setTname("林嘉雯");
		t.setTno("t0004");
		t.setTsex("女");
		t.setTitle("教授");
		List<Teacher> list=null;
		try {
			ta.editT(t);
			list=ta.queryT();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(list!=null)
		{
			for(int i=0;i<list.size();i++)
				System.out.println(list.get(i).toString());
		}
		*/
	}
}
