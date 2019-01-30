package com.zubiri;

import java.util.ArrayList;

public class Student extends Person {
	private int absenses = 0;
	private double markAverage = 0;
	private String classroom = "";
	private int studentID = 0;
	private ArrayList<String> subjects = new ArrayList<String>();

	/**
	 * 
	 * Student full constructor
	 * 
	 * @param name        The name
	 * @param birthDate   The birth date
	 * @param telephone   The telephone
	 * @param dni         The dni
	 * @param absenses    The number of absenses that he/she has made
	 * @param markAverage The mark average of the student
	 * @param classroom   The classroom where the student studies
	 * 
	 */
	public Student(String name, String birthDate, String telephone, String dni, int absenses, double markAverage,
			String classroom) {
		setName(name);
		setBirthDate(birthDate);
		setTelephone(telephone);
		setDni(dni);
		setAbsenses(absenses);
		setMarkAverage(markAverage);
		setClassroom(classroom);
	}

	/**
	 * 
	 * Student default constructor
	 * 
	 */
	public Student() {
	}

	/**
	 * 
	 * absenses getter method
	 * 
	 * @return The number of absenses the student has made
	 * 
	 */
	public int getAbsenses() {
		return this.absenses;
	}

	/**
	 * 
	 * absenses setter method
	 * 
	 * @param newAbsenses The new number of absenses the student has made
	 * 
	 */
	public void setAbsenses(int newAbsenses) {
		this.absenses = newAbsenses;
	}

	/**
	 * 
	 * markAverage getter method
	 * 
	 * @return The mark average of the student
	 * 
	 */
	public double getMarkAverage() {
		return this.markAverage;
	}

	/**
	 * 
	 * markAverage setter method
	 * 
	 * @param newMarkAverage The new mark average of the student
	 * 
	 */
	public void setMarkAverage(double newMarkAverage) {
		this.markAverage = newMarkAverage;
	}

	/**
	 * 
	 * classroom getter method
	 * 
	 * @return The classroom where the student studies
	 * 
	 */
	public String getClassroom() {
		return this.classroom;
	}

	/**
	 * 
	 * classroom setter method
	 * 
	 * @param newClassroom The new classroom where the student studies
	 * 
	 */
	public void setClassroom(String newClassroom) {
		this.classroom = newClassroom;
	}

	/**
	 * 
	 * studentID getter method
	 * 
	 * @return The ID of the student
	 * 
	 */
	public int getStudentID() {
		return this.studentID;
	}

	/**
	 * 
	 * studentID setter method
	 * 
	 * @param newStudentID The new ID of the student
	 * 
	 */
	public void setStudentID(int newStudentID) {
		this.studentID = newStudentID;
	}

	/**
	 * 
	 * A method to check the number of absenses of the student. If she/he has made
	 * more or equal than 10 and less than 20, his/her mark average will be reduced
	 * %10. If she/he has made more or equal than 20, %20.
	 * 
	 * @return A message that says if the mark average was reduced, and if it was,
	 *         it says how much.
	 * 
	 */
	public String checkAbsenses() {
		if (this.absenses >= 10 && this.absenses < 20) {
			this.markAverage = this.markAverage * 0.9;
			return "The mark average was reduced %10.";
		} else if (this.absenses >= 20) {
			this.markAverage = this.markAverage * 0.8;
			return "The markAverage was reduced %20.";
		}
		return "The mark average was not reduced.";
	}
	
	/**
	 * 
	 * A method that adds a subject to the student
	 * 
	 * @param newSubject The new subject of the student
	 * @return If he/she doesn't have this subject yet and it has been added
	 *         successfully, true. Otherwise, false.
	 * 
	 */
	public boolean addSubject(String newSubject) {
		subjects.add(newSubject);
		if (findSubject(newSubject) != -1) {

			return true;
		}
		return false;
	}

	/**
	 * 
	 * A method that deletes a subject of the student
	 * 
	 * @param subject The subject of the student that will be deleted
	 * @return If he/she has this subject and it has been deleted successfully,
	 *         true. Otherwise, false.
	 * 
	 */
	public boolean deleteSubject(String subject) {
		int index = findSubject(subject);
		if (index != -1) {
			subjects.remove(index);
			return true;
		}
		return false;
	}
	/**
	 * 
	 * A method that looks for a subject to the student
	 * 
	 * @param subject The subject of the student that we want to find
	 * @return If he/she has this subject, the index of the subject in the
	 *         ArrayList. Otherwise, -1.
	 * 
	 */
	public int findSubject(String subject) {
		for (int i = 0; i < subjects.size(); i++) {
			if (subject.equals(subjects.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	public int subjectCounter() {
		return this.subjects.size();
	}
	
	public String getSubject(int index) {
		return subjects.get(index);
	}
	
	
	}
