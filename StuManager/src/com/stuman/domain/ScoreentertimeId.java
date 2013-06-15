package com.stuman.domain;

import java.util.Date;

/**
 * ScoreentertimeId entity. @author MyEclipse Persistence Tools
 */

public class ScoreentertimeId implements java.io.Serializable {

	// Fields

	private Date startTime;
	private Date endTime;

	// Constructors

	/** default constructor */
	public ScoreentertimeId() {
	}

	/** full constructor */
	public ScoreentertimeId(Date startTime, Date endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	// Property accessors

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ScoreentertimeId))
			return false;
		ScoreentertimeId castOther = (ScoreentertimeId) other;

		return ((this.getStartTime() == castOther.getStartTime()) || (this
				.getStartTime() != null && castOther.getStartTime() != null && this
				.getStartTime().equals(castOther.getStartTime())))
				&& ((this.getEndTime() == castOther.getEndTime()) || (this
						.getEndTime() != null && castOther.getEndTime() != null && this
						.getEndTime().equals(castOther.getEndTime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getStartTime() == null ? 0 : this.getStartTime().hashCode());
		result = 37 * result
				+ (getEndTime() == null ? 0 : this.getEndTime().hashCode());
		return result;
	}

}