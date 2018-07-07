package com.action;

import java.sql.SQLException;
import java.util.List;

import javax.management.Query;

import org.w3c.dom.CDATASection;

import com.dao.CourseDao;
import com.model.Course;

public class CourseAction {
	public void addCourse(Course c)throws SQLException {
		CourseDao cDao=new CourseDao();
		cDao.addCourse(c);
	}
	public void delC(String cno)throws SQLException {
		CourseDao cDao=new CourseDao();
		cDao.delCourse(cno);
	}
	public void editC(Course c)throws SQLException
	{
		CourseDao cDao=new CourseDao();
		cDao.updateCourse(c);
	}
	
	public Course queryCno(String cno)throws SQLException {
		CourseDao cDao=new CourseDao();
		return cDao.getCourse(cno);
	}
	public List<Course> queryCname(String cname)throws SQLException
	{
		CourseDao cDao=new CourseDao();
		return cDao.getCname(cname);
	}
	public List<Course> query()throws SQLException {
		CourseDao cDao=new CourseDao();
		return cDao.query();
	}
}
