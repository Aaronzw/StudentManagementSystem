package com.model;

//import java.util.*;

public class Student {
	private String sno;
	private String sname;
	private String ssex;
	private String smajor;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getSmajor() {
		return smajor;
	}
	public void setSmajor(String smajor) {
		this.smajor = smajor;
	}
	public String toString() {
		String rs="student [sno="+sno+",sname="+sname.replace(" ","")+",ssex="+ssex+
				",smajor="+smajor+"]";
		rs=rs.replace(" ","");
		return rs;
	}
}
