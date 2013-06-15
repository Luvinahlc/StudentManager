package com.stuman.web.jsf.bean;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;

import com.stuman.dao.AcademicDeanDAO;
import com.stuman.dao.DAOFactory;
import com.stuman.domain.Academicdean;

public class AcademicBean {
	
	private String ano;
	
	private String aname;
	
	private Integer agender;
	
	private Date abirthday;
	
	private String aidno;
	
	private String adept;
	
	public AcademicDeanDAO getAcademicDeanDAO() {
		return DAOFactory.getInstance().createAcademicDeanDAOImp();
	}
	
	public String modifyAcademicInfo() throws Exception {
		
		AcademicDeanDAO acaDao = getAcademicDeanDAO();
		
		Academicdean aca = new Academicdean();
		
		BeanUtils.copyProperties(aca, this);
		
		if(acaDao.updateAcademicDean(aca)){
			return "success";
		}	
		
		return null;
	}
	
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Integer getAgender() {
		return agender;
	}
	public void setAgender(Integer agender) {
		this.agender = agender;
	}
	public Date getAbirthday() {
		return abirthday;
	}
	public void setAbirthday(Date abirthday) {
		this.abirthday = abirthday;
	}
	public String getAidno() {
		return aidno;
	}
	public void setAidno(String aidno) {
		this.aidno = aidno;
	}
	public String getAdept() {
		return adept;
	}
	public void setAdept(String adept) {
		this.adept = adept;
	}

	
}
