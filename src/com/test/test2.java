package com.test;

import java.sql.SQLException;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.action.StudentAction;
import com.dao.StudentDao;
import com.model.Student;


public class test2 {

	public static void main1(String[] args) {
		StudentAction s=new StudentAction();
		Student a=new Student();
		/*try {
			a=s.get("031502247");
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(a!=null)
			System.out.println(a.toString());*/
		List<Student> list=null;
		StudentDao aDao=new StudentDao();
		try {
			list = aDao.getSname("左文航");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(list!=null)
		{
			for(int i=0;i<list.size();i++)
				System.out.println(list.get(i).toString());
		}
	}
}
	
		
		
		
		
		
		
		
		
		
		
		// TODO 自动生成的方法存根
	/*Student t=new Student();
	t.setSno("031502250");
	t.setSname("ha");
	t.setSmajor("信安");
	t.setSsex("女");
	//System.out.println(t.toString());
	StudentDao aDao=new StudentDao();
	List<Student> list=null;
	try {
		list=aDao.query();
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
	for(int i=0;i<list.size();i++)
		System.out.println(list.get(i).toString());*/


