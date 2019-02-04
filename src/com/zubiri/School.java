package com.zubiri;

import java.util.Collections;

import java.util.ArrayList;

public class School {
	private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Administrative> administratives = new ArrayList<Administrative>();

	/**
	 * Gets the ArrayList of teachers
	 * 
	 * @return ArrayList of teachers
	 */
	public ArrayList<Teacher> getTeachers() {
		return this.teachers;
	}

	/**
	 * Sets a new ArrayList of teachers
	 * 
	 * @param newTeachers
	 */
	public void setTeachers(ArrayList<Teacher> newTeachers) {
		this.teachers = newTeachers;
	}

	/**
	 * Gets the ArrayList of students
	 * 
	 * @return ArrayList of students
	 */
	public ArrayList<Student> getStudents() {
		return this.students;
	}

	/**
	 * Sets a new ArrayList of students
	 * 
	 * @param newStudents
	 */

	public void setStudents(ArrayList<Student> newStudents) {
		this.students = newStudents;
	}

	/**
	 * Gets the ArrayList of administratives
	 * 
	 * @return ArrayList of administrative
	 */
	public ArrayList<Administrative> getAdministratives() {
		return this.administratives;
	}

	/**
	 * Sets a new ArrayList of administratives
	 * 
	 * @param newAdministratives
	 */

	public void setAdministratives(ArrayList<Administrative> newAdministratives) {
		this.administratives = newAdministratives;
	}

	/**
	 * Finds the index of a teacher
	 * 
	 * @param name
	 * @return index in the ArrayList, -1 if not found
	 */
	public int findTeacherID(String name) {
		for (int i = 0; i < teachers.size(); i++) {
			if (name.equals(teachers.get(i).getName())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Finds the index of a student
	 * 
	 * @param name
	 * @return index in the ArrayList, -1 if not found
	 */
	public int findStudentID(String name) {
		for (int i = 0; i < students.size(); i++) {
			if (name.equals(students.get(i).getName())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Finds the index of an administrative
	 * 
	 * @param name
	 * @return index in the ArrayList, -1 if not found
	 */
	public int findAdministrativeID(String name) {
		for (int i = 0; i < administratives.size(); i++) {
			if (name.equals(administratives.get(i).getName())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Adds a new teacher to the ArrayList
	 * 
	 * @param newTeacher
	 * @return true if correctly added, false if not
	 */
	public boolean addTeacher(Teacher newTeacher) {

		teachers.add(newTeacher);
		if (findTeacherID(newTeacher.getName()) != -1) {
			return true;
		}
		return false;

	}

	/**
	 * Adds a new student to the ArrayList
	 * 
	 * @param newStudent
	 * @return true if correctly added, false if not
	 */
	public boolean addStudent(Student newStudent) {

		students.add(newStudent);
		if (findStudentID(newStudent.getName()) != -1) {
			return true;
		}
		return false;

	}

	/**
	 * Adds a new administrative to the ArrayList
	 * 
	 * @param newAdministrative
	 * @return true if correctly added, false if not
	 */
	public boolean addAdministrative(Administrative newAdministrative) {

		administratives.add(newAdministrative);
		if (findAdministrativeID(newAdministrative.getName()) != -1) {
			return true;
		}
		return false;
	}

	/**
	 * Deletes a teacher
	 * 
	 * @param name
	 * @return true if correctly deleted, false if not
	 */
	public boolean deleteTeacher(String name) {
		int index = findTeacherID(name);
		if (index != -1) {
			teachers.remove(index);
			return true;
		}
		return false;
	}

	/**
	 * Deletes a student
	 * 
	 * @param name
	 * @return true if correctly deleted, false if not
	 */
	public boolean deleteStudent(String name) {
		int index = findStudentID(name);
		if (index != -1) {
			students.remove(index);
			return true;
		}
		return false;
	}

	/**
	 * Deletes an administrative
	 * 
	 * @param name
	 * @return true if correctly deleted, false if not
	 */
	public boolean deleteAdministrative(String name) {
		int index = findAdministrativeID(name);
		if (index != -1) {
			administratives.remove(index);
			return true;
		}
		return false;
	}

	/**
	 * Gets an specific teacher
	 * 
	 * @param name
	 * @return teacher object
	 */
	public Teacher getTeacher(String name) {
		int index = findTeacherID(name);
		return teachers.get(index);
	}

	/**
	 * Gets an specific student
	 * 
	 * @param name
	 * @return student object
	 */
	public Student getStudent(String name) {
		int index = findStudentID(name);
		return students.get(index);
	}

	/**
	 * Gets an specific administrative
	 * 
	 * @param name
	 * @return administrative object
	 */
	public Administrative getAdministrative(String name) {
		int index = findAdministrativeID(name);
		return administratives.get(index);
	}

	/**
	 * 
	 * A method to check the number of absenses of a student. If she/he has made
	 * more or equal than 10 and less than 20, his/her mark average will be reduced
	 * %10. If she/he has made more or equal than 20, %20.
	 * 
	 * @return A message that says if the mark average was reduced, and if it was,
	 *         it says how much.
	 * 
	 */
	public int checkStudentAbsenses(String name) {
		int index = findStudentID(name);
		if (findStudentID(name) != -1) {
			int absenses = students.get(index).getAbsenses();
			double markAverage = students.get(index).getMarkAverage() * 0.9;
			if (absenses >= 10 && absenses < 20) {
				students.get(index).setMarkAverage(markAverage * 0.9);
			} else if (absenses >= 20) {
				students.get(index).setMarkAverage(markAverage * 0.8);
			}
			return absenses;
		}
		return -1;
	}

	/**
	 * 
	 * A method to check the number of absenses of a teacher. If she/he has made
	 * more or equal than 10 and less than 20, his/her salary will be reduced %10.
	 * If she/he has made more or equal than 20, %20.
	 * 
	 * @return A message that says if the salary was reduced, and if it was, it says
	 *         how much.
	 * 
	 */
	public int checkTeacherAbsenses(String name) {
		int index = findTeacherID(name);
		if (findTeacherID(name) != -1) {
			int absenses = teachers.get(index).getAbsenses();
			double salary = teachers.get(index).getSalary() * 0.9;
			if (absenses >= 10 && absenses < 20) {
				teachers.get(index).setSalary(salary * 0.9);
			} else if (absenses >= 20) {
				teachers.get(index).setSalary(salary * 0.8);
			}
			return absenses;
		}
		return -1;
	}

	/**
	 * 
	 * A method to check the number of absenses of an administrative. If she/he has
	 * made more or equal than 10 and less than 20, his/her salary will be reduced
	 * %10. If she/he has made more or equal than 20, %20.
	 * 
	 * @return A message that says if the salary was reduced, and if it was, it says
	 *         how much.
	 * 
	 */
	public int checkAdministrativeAbsenses(String name) {
		int index = findAdministrativeID(name);
		if (findAdministrativeID(name) != -1) {
			int absenses = administratives.get(index).getAbsenses();
			double salary = administratives.get(index).getSalary() * 0.9;
			if (absenses >= 10 && absenses < 20) {
				administratives.get(index).setSalary(salary * 0.9);
			} else if (absenses >= 20) {
				administratives.get(index).setSalary(salary * 0.8);
			}
			return absenses;
		}
		return -1;
	}

	/**
	 * Prints the list of students of a tutor
	 * 
	 * @param name
	 */
	public void getStudentsByTutor(String name) {
		boolean check = false;
		if (findTeacherID(name) != -1) {
			String classroom = getTeacher(name).getTutor();
			if (!classroom.equals("no") && !classroom.equals("")) {
				for (int i = 0; i < students.size(); i++) {
					if (students.get(i).getClassroom().equals(classroom)) {
						System.out.println(students.get(i).getName());
						check = true;
					}
				}
				if (check = false)
					System.out.println("Students not found");
			} else {
				System.out.println("This teacher is not tutor");
			}
		} else {
			System.out.println("Teacher not found");
		}
	}

	/**
	 * Prints all the teachers of a student
	 * @param name Name of the student
	 */
	public void getTeachersByStudent(String name) {

		for (int i = 0; i < getStudent(name).subjectCounter(); i++) {
			for (int j = 0; j < teachers.size(); j++) {
				for (int k = 0; k < teachers.get(j).subjectCounter(); k++) {
					if (getStudent(name).getSubject(i).equals(teachers.get(j).getSubject(k))) {
						System.out.println(teachers.get(j).getName());
					}
				}
			}
		}
	}

	/**
	 * Prints all the students of a teacher
	 * @param name Name of the teacher
	 */
	public void getStudentsByTeacher(String name) {
		for (int i = 0; i < getTeacher(name).subjectCounter(); i++) {
			for (int j = 0; j < students.size(); j++) {
				for (int k = 0; k < students.get(j).subjectCounter(); k++) {
					if (getTeacher(name).getSubject(i).equals(students.get(j).getSubject(k))) {
						System.out.println(students.get(j).getName());
					}
				}
			}
		}
	}

	/**
	 * Returns the ArrayList of students ordered by name
	 * @return Ordered ArrayList
	 */
	public ArrayList<Student> orderStudents() {

		for (int i = 0; i < students.size(); i++) {

			for (int j = 0; j < students.size(); j++) {
				if (students.get(i).getName().charAt(0) > students.get(j).getName().charAt(0)) {
					Collections.swap(students, i, j);
				}

			}
		}
		return this.students;
	}

	/**
	 * Returns the ArrayList of teachers ordered by name
	 * @return Ordered ArrayList
	 */
	public ArrayList<Teacher> orderTeachers() {

		for (int i = 0; i < teachers.size(); i++) {

			for (int j = 0; j < teachers.size(); j++) {
				if (teachers.get(i).getName().charAt(0) > teachers.get(j).getName().charAt(0)) {
					Collections.swap(teachers, i, j);
				}

			}
		}
		return this.teachers;
	}

	/**
	 * Returns the ArrayList of administratives ordered by name
	 * @return Ordered ArrayList
	 */
	public ArrayList<Administrative> orderAdministratives() {

		for (int i = 0; i < administratives.size(); i++) {

			for (int j = 0; j < administratives.size(); j++) {
				if (administratives.get(i).getName().charAt(0) > administratives.get(j).getName().charAt(0)) {
					Collections.swap(administratives, i, j);
				}

			}
		}
		return this.administratives;
	}

}