package com.model;

public class Course {
	private String cno;
	private String cname;
	private int credit;
	private String ctime;
	private String cplace;
	private String tno;
	private String bno;
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public String getCplace() {
		return cplace;
	}
	public void setCplace(String cplace) {
		this.cplace = cplace;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	
	public String toString()
	{
		String string="[course]:cno= "+cno+",cname="+cname+",credit="+credit+",ctime="
				+ctime+",cplace "+cplace+",book="+bno+",tno="+tno;
		string=string.replace(" ", "");
		return string;
	}
	
}
