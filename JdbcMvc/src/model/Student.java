package model;

import java.sql.Date;

public class Student {
	private int stid;
	private String name;
	private String sname;
	private Date date;
	private int pay;
	
	public Student() {
	}
	
	public Student(int stid, String name, String sname, Date date, int pay) {
		this.stid = stid;
		this.name = name;
		this.sname = sname;
		this.date = date;
		this.pay = pay;
	}

	public int getId() {
		return stid;
	}
	
	public void setId(int id) {
		this.stid = id;
	}
	
	public String getSname() {
		return sname;
	}
	
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [stid=" + stid + ", name=" + name + ", sname=" + sname + ", date=" + date + ", pay=" + pay
				+ "]";
	}

	public int getStid() {
		return stid;
	}

	public void setStid(int stid) {
		this.stid = stid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}
	
	
	
}
