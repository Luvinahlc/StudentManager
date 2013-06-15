package com.stuman.domain;

/**
 * Scoreentertime entity. @author MyEclipse Persistence Tools
 */

public class Scoreentertime implements java.io.Serializable {

	// Fields

	private ScoreentertimeId id;

	// Constructors

	/** default constructor */
	public Scoreentertime() {
	}

	/** full constructor */
	public Scoreentertime(ScoreentertimeId id) {
		this.id = id;
	}

	// Property accessors

	public ScoreentertimeId getId() {
		return this.id;
	}

	public void setId(ScoreentertimeId id) {
		this.id = id;
	}

}