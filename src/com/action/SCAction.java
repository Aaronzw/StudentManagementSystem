package com.action;

import java.sql.SQLException;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.dao.SCdao;
import com.model.SC;

public class SCAction {
	public void addSC(SC sc) throws SQLException{
		SCdao sCdao=new SCdao();
		sCdao.addSC(sc);
		
	}
	public void delSC(SC sc) throws SQLException{
		SCdao sCdao=new SCdao();
		sCdao.delSC(sc);
		
	}
	/*public void editSC(SC newsc ,SC oldsc) throws SQLException{
		SCdao sCdao=new SCdao();
		sCdao.updateSC(newsc, oldsc);
	}*/
	public List<SC> query() throws SQLException{
		SCdao sCdao=new SCdao();
		return sCdao.query();
	}
	public List<SC> querySCno(String cno,String sno)throws SQLException
	{
		SCdao sCdao=new SCdao();
		return sCdao.querySCno(cno, sno);
	}
	public List<SC> querySno(String sno) throws SQLException{
		SCdao sCdao=new SCdao();
		return sCdao.querySno(sno);
	}
	public List<SC> queryCno(String cno) throws SQLException{
		SCdao sCdao=new SCdao();
		return sCdao.queryCno(cno);
	}
	
}
