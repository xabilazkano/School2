package com.zubiri;

import java.util.ArrayList;

public class Teacher extends Worker {
	private int teacherID = 0;
	private ArrayList<String> subjects = new ArrayList<String>();
	private String tutor = "";

	/**
	 * 
	 * Teacher full constructor
	 * 
	 * @param name       The name
	 * @param birthDate  The birth date
	 * @param telephone  The telephone
	 * @param dni        The dni
	 * @param absenses   The number of absenses that he/she has made
	 * @param salary     The salary of the teacher
	 * @param joinedDate The date when the teacher was joined
	 * @param tutor      If he/she is a tutor, the classroom where he/she is a
	 *                   tutor. Otherwise, empty.
	 * 
	 */
	public Teacher(String name, String birthDate, String telephone, String dni, int absenses, double salary,
			String joinedDate, String tutor) {
		setName(name);
		setBirthDate(birthDate);
		setTelephone(telephone);
		setDni(dni);
		setAbsenses(absenses);
		setSalary(salary);
		setJoinedDate(joinedDate);
		setTutor(tutor);
	}

	/**
	 * 
	 * Teacher default constructor
	 * 
	 */
	public Teacher() {

	}

	/**
	 * 
	 * teacherID getter method
	 * 
	 * @return The ID of the teacher
	 * 
	 */
	public int getTeacherID() {
		return this.teacherID;
	}

	/**
	 * 
	 * teacherID setter method
	 * 
	 * @param newTeacherID The new ID of the teacher
	 * 
	 */
	public void setTeacherID(int newTeacherID) {
		this.teacherID = newTeacherID;
	}

	/**
	 * 
	 * subjects getter method
	 * 
	 * @return The subjects of the teacher
	 * 
	 */
	public ArrayList<String> getSubjects() {
		return this.subjects;
	}

	/**
	 * 
	 * subjects setter method
	 * 
	 * @param newSubjects The new subjects of the teacher
	 * 
	 */
	public void setSubjects(ArrayList<String> newSubjects) {
		this.subjects = newSubjects;
	}

	/**
	 * 
	 * tutor getter method
	 * 
	 * @return If he/she is a tutor, the classroom where he/she is a tutor.
	 *         Otherwise, empty.
	 * 
	 */
	public String getTutor() {
		return this.tutor;
	}

	/**
	 * 
	 * tutor setter method
	 * 
	 * @param newTutor If he/she is a tutor, the classroom where he/she is a tutor.
	 *                 Otherwise, empty.
	 * 
	 */
	public void setTutor(String newTutor) {
		this.tutor = newTutor;
	}

	/**
	 * 
	 * A method which tells us if the teacher if the teacher is a tutor or not. If he/she is, it returns his/her classroom. Otherwise, it returns an empty string
	 * 
	 * @return If he/she is a tutor, his/her classroom. Otherwise, empty.
	 * 
	 */
	public String isTutor() {
		if (!this.tutor.equals("") && !this.tutor.equals("no")) {
			return this.tutor;
		}
		return "";
	}

	/**
	 * 
	 * A method that adds a subject to the teacher
	 * 
	 * @param newSubject The new subject of the teacher
	 * @return If he/she doesn't have this subject yet and it has been added
	 *         successfully, true. Otherwise, false.
	 * 
	 */
	public boolean addSubject(String newSubject) {
		
		if (findSubject(newSubject) == -1) {
			subjects.add(newSubject);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * A method that deletes a subject of the teacher
	 * 
	 * @param subject The subject of the teacher that will be deleted
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
	 * A method that looks for a subject to the teacher
	 * 
	 * @param subject The subject of the teacher that we want to find
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
		return this.subjects.get(index);
	}
}