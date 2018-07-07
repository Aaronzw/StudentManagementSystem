package com.dao;

import java.util.*;
import java.sql.*;

import com.db.DBUtil;
import com.model.Student;

public class StudentDao {
	public void addStudent(Student s)throws SQLException
	{
		Connection con=DBUtil.getConnection();
		String sql="insert into student"+"(sno,sname,ssex,smajor)"+
		"values("+"?,?,?,?)";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ptmt.setString(1, s.getSno());
		ptmt.setString(2, s.getSname());
		ptmt.setString(3, s.getSsex());
		ptmt.setString(4, s.getSmajor());
		ptmt.execute();
	}
	public void updateStudent (Student s) throws SQLException{
		Connection con=DBUtil.getConnection();
		String sql="update  student "+
				"set sname=?,ssex=?,smajor=? "+
				"where sno=?";
		PreparedStatement ptmt=con.prepareStatement(sql);
		
		ptmt.setString(1, s.getSname());
		ptmt.setString(2, s.getSsex());
		ptmt.setString(3, s.getSmajor());
		ptmt.setString(4, s.getSno());
		ptmt.execute();
	}
	public void  delStudent(String sno) throws SQLException{
		Connection con=DBUtil.getConnection();
		String sql="delete from student "+
		           "where sno=?";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ptmt.setString(1,sno);
		ptmt.execute();
		
	}
	public List<Student> query() throws SQLException{//返回表格全部内容
		List<Student> result=new ArrayList<Student>();
		Connection con=DBUtil.getConnection();
		String sql="select * from student";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ResultSet rs=ptmt.executeQuery();
		Student s=null;
		while(rs.next())
		{
			s=new Student();
			s.setSno(rs.getString("sno"));
			s.setSname(rs.getString("sname"));
			s.setSsex(rs.getString("ssex"));
			s.setSmajor(rs.getString("smajor"));
			result.add(s);
		}
		return result;
	}
	public Student getStudent(String sno) throws SQLException{
		//跟据sno查询具体student信息
		Connection con=DBUtil.getConnection();
		String sql="select * from student where sno = ? ";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ptmt.setString(1, sno);
		ResultSet rs=ptmt.executeQuery();
		Student s=null;
		while(rs.next())
		{
			s=new Student();
			s.setSno(rs.getString("sno"));
			s.setSname(rs.getString("sname"));
			s.setSsex(rs.getString("ssex"));
			s.setSmajor(rs.getString("smajor"));
		}
		return s;
	}
	public List<Student> getSname(String sname) throws SQLException{
		
		List<Student> list=new ArrayList<Student>();
		Connection con=DBUtil.getConnection();
		String sql="select * from student where sname = ? ";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ptmt.setString(1, sname);
		ResultSet rs=ptmt.executeQuery();
		Student s=null;
		while(rs.next())
		{
			s=new Student();
			s.setSno(rs.getString("sno"));
			s.setSname(rs.getString("sname"));
			s.setSsex(rs.getString("ssex"));
			s.setSmajor(rs.getString("smajor"));
			list.add(s);
		}
		return list;
	}
}
