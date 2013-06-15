package com.stuman.domain;


public class Courseinfo implements java.io.Serializable {

	// Fields

	private String cno;
	
	private String cname;
	
	private Integer credit;
	
	private Integer hour;
	
	private String cdept;

	// Constructors

	/** default constructor */
	public Courseinfo() {
	}

	/** full constructor */
	public Courseinfo(String cname, Integer credit, Integer hour, String cdept) {
		this.cname = cname;
		this.credit = credit;
		this.hour = hour;
		this.cdept = cdept;
	}

	// Property accessors

	public String getCno() {
		return this.cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Integer getHour() {
		return this.hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public String getCdept() {
		return this.cdept;
	}

	public void setCdept(String cdept) {
		this.cdept = cdept;
	}

}