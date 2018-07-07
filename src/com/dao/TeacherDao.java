package com.dao;

import java.util.*;
import java.sql.*;

import com.db.DBUtil;
import com.model.Teacher;;

public class TeacherDao {
	public void addTeacher(Teacher t)throws SQLException
	{
		Connection con=DBUtil.getConnection();
		String sql="insert into teacher"+"(tno,tname,tsex,title)"+
		"values("+"?,?,?,?)";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ptmt.setString(1, t.getTno());
		ptmt.setString(2, t.getTname());
		ptmt.setString(3, t.getTsex());
		ptmt.setString(4, t.getTitle());
		ptmt.execute();
	}
	public void updateTeacher (Teacher t) throws SQLException{
		Connection con=DBUtil.getConnection();
		String sql="update  teacher "+
				"set tname=?,tsex=?,title=? "+
				"where tno=?";
		PreparedStatement ptmt=con.prepareStatement(sql);
		
		ptmt.setString(1, t.getTname());
		ptmt.setString(2, t.getTsex());
		ptmt.setString(3, t.getTitle());
		ptmt.setString(4, t.getTno());
		ptmt.execute();
	}
	public void  delTeacher(String tno) throws SQLException{
		Connection con=DBUtil.getConnection();
		String sql="delete from teacher "+
		           "where tno=?";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ptmt.setString(1,tno);
		ptmt.execute();
		
	}
	public List<Teacher> query() throws SQLException{//返回表格全部内容
		List<Teacher> result=new ArrayList<Teacher>();
		Connection con=DBUtil.getConnection();
		String sql="select * from teacher";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ResultSet rs=ptmt.executeQuery();
		Teacher t=null;
		while(rs.next())
		{
			t=new Teacher();
			t.setTno(rs.getString("tno"));
			t.setTname(rs.getString("tname"));
			t.setTsex(rs.getString("tsex"));
			t.setTitle(rs.getString("title"));
			result.add(t);
		}
		return result;
	}
	public Teacher getTeacher(String tno) throws SQLException{
		//跟据sno查询具体student信息
		Connection con=DBUtil.getConnection();
		String sql="select * from teacher where tno = ? ";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ptmt.setString(1, tno);
		ResultSet rs=ptmt.executeQuery();
		Teacher t=null;
		while(rs.next())
		{
			t=new Teacher();
			t.setTno(rs.getString("tno"));
			t.setTname(rs.getString("tname"));
			t.setTsex(rs.getString("tsex"));
			t.setTitle(rs.getString("title"));
		}
		return t;
	}
	public List<Teacher> getTname(String tname) throws SQLException{
		//跟据sno查询具体student信息
		List<Teacher> list=new ArrayList<Teacher>();
		Connection con=DBUtil.getConnection();
		String sql="select * from teacher where tname = ? ";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ptmt.setString(1, tname);
		ResultSet rs=ptmt.executeQuery();
		Teacher t=null;
		while(rs.next())
		{
			t=new Teacher();
			t.setTno(rs.getString("tno"));
			t.setTname(rs.getString("tname"));
			t.setTsex(rs.getString("tsex"));
			t.setTitle(rs.getString("title"));
			list.add(t);
		}
		return list;
	}
}