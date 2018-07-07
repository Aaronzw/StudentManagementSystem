package com.dao;

import java.util.*;
import java.sql.*;

import com.db.DBUtil;
import com.model.Course;
import com.model.Student;

public class CourseDao {
	public void addCourse(Course s)throws SQLException
	{
		Connection con=DBUtil.getConnection();
		String sql="insert into course"+"(cno,cname,credit,ctime,cplace,bno,tno)"+
		"values("+"?,?,?,?,?,?,?)";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ptmt.setString(1, s.getCno());
		ptmt.setString(2, s.getCname());
		ptmt.setInt(3, s.getCredit());
		ptmt.setString(4, s.getCtime());
		ptmt.setString(5, s.getCplace());
		ptmt.setString(6, s.getBno());
		ptmt.setString(7, s.getTno());
		
		ptmt.execute();
	}
	public void updateCourse (Course s) throws SQLException{
		Connection con=DBUtil.getConnection();
		String sql="update  course "+
				"set cname=?,credit=?,ctime=? ,cplace=?,bno=?,tno=? "+
				"where cno=?";
		PreparedStatement ptmt=con.prepareStatement(sql);
		
		ptmt.setString(1, s.getCname());
		ptmt.setInt(2, s.getCredit());
		ptmt.setString(3, s.getCtime());
		ptmt.setString(4, s.getCplace());
		ptmt.setString(5, s.getBno());
		ptmt.setString(6, s.getTno());
		ptmt.setString(7, s.getCno());
		ptmt.execute();
	}
	public void  delCourse(String cno) throws SQLException{
		Connection con=DBUtil.getConnection();
		String sql="delete from course "+
		           "where cno=?";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ptmt.setString(1,cno);
		ptmt.execute();
		
	}
	public List<Course> query() throws SQLException{//返回表格全部内容
		List<Course> result=new ArrayList<Course>();
		Connection con=DBUtil.getConnection();
		String sql="select * from course";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ResultSet rs=ptmt.executeQuery();
		Course s=null;
		while(rs.next())
		{
			s=new Course();
			s.setCno(rs.getString("cno"));
			s.setCname(rs.getString("cname"));
			s.setCredit(rs.getInt("credit"));
			s.setCtime(rs.getString("ctime"));
			s.setCplace(rs.getString("cplace"));
			s.setTno(rs.getString("tno"));
			s.setBno(rs.getString("bno"));
			
			result.add(s);
		}
		return result;
	}
	public Course getCourse(String cno) throws SQLException{
		//跟据sno查询具体student信息
		Connection con=DBUtil.getConnection();
		String sql="select * from course where cno = ? ";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ptmt.setString(1, cno);
		ResultSet rs=ptmt.executeQuery();
		Course s=null;
		while(rs.next())
		{
			s=new Course();
			s.setCno(rs.getString("cno"));
			s.setCname(rs.getString("cname"));
			s.setCredit(rs.getInt("credit"));
			s.setCtime(rs.getString("ctime"));
			s.setCplace(rs.getString("cplace"));
			s.setTno(rs.getString("tno"));
			s.setBno(rs.getString("bno"));
		}
		return s;
	}
	public List<Course> getCname(String cname) throws SQLException{
		//跟据sno查询具体student信息
		List<Course> list=new ArrayList<Course>();;
		Connection con=DBUtil.getConnection();
		String sql="select * from course where cname = ? ";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ptmt.setString(1, cname);
		ResultSet rs=ptmt.executeQuery();
		Course s=null;
		while(rs.next())
		{
			s=new Course();
			s.setCno(rs.getString("Cno"));
			s.setCname(rs.getString("Cname"));
			s.setCredit(rs.getInt("credit"));
			s.setCtime(rs.getString("ctime"));
			s.setCplace(rs.getString("cplace"));
			s.setBno(rs.getString("bno"));
			s.setTno(rs.getString("tno"));
			
			list.add(s);
		}
		return list;
	}
}
