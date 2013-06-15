package com.stuman.domain;

public class EnrolId implements java.io.Serializable {

	// Fields

	private Classes classes;

	private Student student;

	// Constructors

	/** default constructor */
	public EnrolId() {
	}

	// Property accessors

	public Classes getClasses() {
		return this.classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EnrolId))
			return false;
		EnrolId castOther = (EnrolId) other;

		return ((this.getClasses() == castOther.getClasses()) || (this
				.getClasses() != null
				&& castOther.getClasses() != null && this.getClasses().equals(
				castOther.getClasses())))

				&& ((this.getStudent() == castOther.getStudent()) || (this
						.getStudent() != null
						&& castOther.getStudent() != null && this.getStudent()
						.equals(castOther.getStudent())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getClasses() == null ? 0 : this.getClasses().hashCode());
		result = 37 * result
				+ (getStudent() == null ? 0 : this.getStudent().hashCode());

		return result;
	}

}