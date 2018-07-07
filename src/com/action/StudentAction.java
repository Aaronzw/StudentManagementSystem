package com.action;

import java.io.DataOutput;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

import com.dao.StudentDao;

import com.model.Student;

public class StudentAction {
	public void addS(Student student) throws Exception {
		StudentDao sDao=new StudentDao();
		sDao.addStudent(student);
	}
	public void delS (String sno) throws Exception{
		StudentDao sdao=new StudentDao();
		sdao.delStudent(sno);
	}
	public void editS(Student s) throws Exception{
		StudentDao aDao=new StudentDao();
		aDao.updateStudent(s);
	}
	public List<Student>  queryS() throws Exception{
		StudentDao dao=new StudentDao();
		return dao.query();
	}
	public Student getS(String sno)throws Exception{
		StudentDao dao=new StudentDao();
		return dao.getStudent(sno);
	}
	public List<Student> getSna(String sname) throws Exception{
		List<Student> list=new ArrayList<Student>();
		StudentDao dao=new StudentDao();
		try {
			list=dao.getSname(sname);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}
}
