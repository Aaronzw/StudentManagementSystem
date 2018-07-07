package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DBUtil;
import com.model.SC;
import com.model.Student;

public class SCdao {
	public void addSC(SC x)throws SQLException
	{
		Connection con=DBUtil.getConnection();
		String sql="insert into sc"+"(sno,cno)"+
		"values("+"?,?)";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ptmt.setString(1, x.getSno());
		ptmt.setString(2, x.getCno());
		ptmt.execute();
	}
	/*public void updateSC (SC newsc,SC oldsc) throws SQLException{
		//修改
		Connection con=DBUtil.getConnection();
		String sql="update  sc "+
				"set sno=?,cno=?"+
				"where sno=?,cno=?";
		PreparedStatement ptmt=con.prepareStatement(sql);
		
		ptmt.setString(1, newsc.getSno());
		ptmt.setString(2, newsc.getCno());
		ptmt.setString(3, oldsc.getSno());
		ptmt.setString(4, oldsc.getCno());
		ptmt.execute();
	}*/
	public void delSC(SC old)throws SQLException
	{
		Connection con=DBUtil.getConnection();
		String sql=" delete from sc "+
		           " where sno= ?,cno= ?";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ptmt.setString(1,old.getSno());
		ptmt.setString(2, old.getCno());
		ptmt.execute();
	}
	public List<SC> querySno(String sno) throws SQLException{
		List<SC> result=new ArrayList<SC>();
		Connection con=DBUtil.getConnection();
		String sql="select * from sc where sno=?";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ptmt.setString(1, sno);
		ResultSet rs=ptmt.executeQuery();
		SC s=new SC();
		while (rs.next()) {
			s=new SC();
			s.setSno(rs.getString("sno"));
			s.setCno(rs.getString("cno"));
			result.add(s);
		}
		return result;
	}
	public List<SC> queryCno(String cno)throws SQLException//根据课程号查询
	{
		List<SC> result=new ArrayList<SC>();
		Connection con=DBUtil.getConnection();
		String sql="select * from sc where cno=?";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ptmt.setString(1, cno);
		ResultSet rs=ptmt.executeQuery();
		SC s=null;
		while (rs.next()) {
			s=new SC();
			s.setSno(rs.getString("sno"));
			s.setCno(rs.getString("cno"));
			result.add(s);
		}
		return result;
	}
	public List<SC> querySCno(String cno,String sno)throws SQLException//根据课程号查询
	{
		List<SC> result=new ArrayList<SC>();
		Connection con=DBUtil.getConnection();
		String sql="select * from sc where cno=? and sno = ?";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ptmt.setString(1, cno);
		ptmt.setString(2, sno);
		ResultSet rs=ptmt.executeQuery();
		SC s=null;
		while(rs.next())
		{
			s=new SC();
			s.setSno(rs.getString("sno"));
			s.setCno(rs.getString("cno"));
			result.add(s);
		}
		return result;
	}
	public List<SC> query()throws SQLException//返回全表
	{
		List<SC> result=new ArrayList<SC>();
		Connection con=DBUtil.getConnection();
		String sql="select * from sc";
		PreparedStatement ptmt=con.prepareStatement(sql);
		ResultSet rs=ptmt.executeQuery();
		SC s=null;
		while (rs.next()) {
			s=new SC();
			s.setSno(rs.getString("sno"));
			s.setCno(rs.getString("cno"));
			result.add(s);
		}
		return result;
	}
}
