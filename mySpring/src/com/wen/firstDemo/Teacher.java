package com.wen.firstDemo;

public class Teacher {
	private Student student;

	public void setStudent(Student student) {
		this.student = student;
	}

	public void useS() {
		student.diao();
	}
}
