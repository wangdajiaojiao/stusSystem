package com.newer.pojo;

/**
 * Student1 entity. @author MyEclipse Persistence Tools
 */

public class Student1 implements java.io.Serializable {

	// Fields

	private Integer id;
	private String studentNo;
	private String studentName;
	private String studentClass;

	// Constructors

	/** default constructor */
	public Student1() {
	}

	/** full constructor */
	public Student1(String studentNo, String studentName, String studentClass) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentClass = studentClass;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudentNo() {
		return this.studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentClass() {
		return this.studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

}