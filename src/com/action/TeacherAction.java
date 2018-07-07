package com.action;

import java.io.DataOutput;
import java.io.StreamCorruptedException;
import java.util.List;

import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.model.Student;
import com.model.Teacher;

public class TeacherAction {
	public void addT(Teacher t) throws Exception {
		TeacherDao tDao=new TeacherDao();
		tDao.addTeacher(t);
	}
	public void delT (String tno) throws Exception{
		TeacherDao tdao=new TeacherDao();
		tdao.delTeacher(tno);
	}
	public void editT(Teacher t) throws Exception{
		TeacherDao aDao=new TeacherDao();
		aDao.updateTeacher(t);
	}
	public List<Teacher>  queryT() throws Exception{
		TeacherDao dao=new TeacherDao();
		return dao.query();
	}
	public Teacher getT(String tno)throws Exception{
		TeacherDao dao=new TeacherDao();
		return dao.getTeacher(tno);
	}
	public List<Teacher> getTname(String tname)throws Exception{
		TeacherDao dao=new TeacherDao();
		return dao.getTname(tname);
	}
}
