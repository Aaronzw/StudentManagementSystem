package com.model;

public class SC {
	private String sno;
	private String cno;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String toString()
	{
		return "sc:"+sno+","+cno;
	}
}
