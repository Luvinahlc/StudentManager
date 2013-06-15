package com.stuman.domain;

import java.util.Date;

/**
 * Academicdean entity. @author MyEclipse Persistence Tools
 */

public class Academicdean implements java.io.Serializable {

	// Fields

	private String ano;
	private String aname;
	private Integer agender;
	private Date abirthday;
	private String aidno;
	private String adept;

	// Constructors

	/** default constructor */
	public Academicdean() {
	}

	/** full constructor */
	public Academicdean(String aname, Integer agender, Date abirthday,
			String aidno, String adept) {
		this.aname = aname;
		this.agender = agender;
		this.abirthday = abirthday;
		this.aidno = aidno;
		this.adept = adept;
	}

	// Property accessors

	public String getAno() {
		return this.ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Integer getAgender() {
		return this.agender;
	}

	public void setAgender(Integer agender) {
		this.agender = agender;
	}

	public Date getAbirthday() {
		return this.abirthday;
	}

	public void setAbirthday(Date abirthday) {
		this.abirthday = abirthday;
	}

	public String getAidno() {
		return this.aidno;
	}

	public void setAidno(String aidno) {
		this.aidno = aidno;
	}

	public String getAdept() {
		return this.adept;
	}

	public void setAdept(String adept) {
		this.adept = adept;
	}

}