package com.model;

public class Teacher {
	private String  tno;
	private String	tname;
	private String title;
	private String tsex;
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTsex() {
		return tsex;
	}
	public void setTsex(String tsex) {
		this.tsex = tsex;
	}
	public String toString() {
		return "teacher [tno"+tno+",tname="+tname+",tsex="+tsex+
				",title="+title+"]";
	}
}
