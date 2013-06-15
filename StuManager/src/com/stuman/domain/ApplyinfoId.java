package com.stuman.domain;

/**
 * ApplyinfoId entity. @author MyEclipse Persistence Tools
 */

public class ApplyinfoId implements java.io.Serializable {

	// Fields

	private String sno;
	private String content;

	// Constructors

	/** default constructor */
	public ApplyinfoId() {
	}

	/** full constructor */
	public ApplyinfoId(String sno, String content) {
		this.sno = sno;
		this.content = content;
	}

	// Property accessors

	public String getSno() {
		return this.sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ApplyinfoId))
			return false;
		ApplyinfoId castOther = (ApplyinfoId) other;

		return ((this.getSno() == castOther.getSno()) || (this.getSno() != null
				&& castOther.getSno() != null && this.getSno().equals(
				castOther.getSno())))
				&& ((this.getContent() == castOther.getContent()) || (this
						.getContent() != null && castOther.getContent() != null && this
						.getContent().equals(castOther.getContent())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSno() == null ? 0 : this.getSno().hashCode());
		result = 37 * result
				+ (getContent() == null ? 0 : this.getContent().hashCode());
		return result;
	}

}