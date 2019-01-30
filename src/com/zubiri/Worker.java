package com.zubiri;

public class Worker extends Person {
	private double salary = 0;
	private String joinedDate = "0000/00/00";
	private int absenses = 0;

	/**
	 * 
	 * salary getter method
	 * 
	 * @return The salary of the worker
	 * 
	 */
	public double getSalary() {
		return this.salary;
	}

	/**
	 * 
	 * salary setter method
	 * 
	 * @param newSalary The new salary of the worker
	 * 
	 */
	public void setSalary(double newSalary) {
		this.salary = newSalary;
	}

	/**
	 * 
	 * joinedDate getter method
	 * 
	 * @return The date when the worker was joined
	 * 
	 */
	public String getJoinedDate() {
		return this.joinedDate;
	}

	/**
	 * 
	 * joinedDate setter method
	 * 
	 * @param newJoinedDate The new date when the worker was joined
	 * 
	 */
	public void setJoinedDate(String newJoinedDate) {
		if (isValidDate(newJoinedDate)) {
			this.joinedDate = newJoinedDate;
		}
	}

	/**
	 * 
	 * absenses getter method
	 * 
	 * @return The number of absenses that the worker has made
	 * 
	 */
	public int getAbsenses() {
		return this.absenses;
	}

	/**
	 * 
	 * absenses setter method
	 * 
	 * @param newAbsenses The new number of absenses that the worker has made
	 * 
	 */
	public void setAbsenses(int newAbsenses) {
		this.absenses = newAbsenses;
	}

	/**
	 * 
	 * A method to check the number of absenses of the worker. If she/he has made
	 * more or equal than 10 and less than 20, his/her salary will be reduced %10.
	 * If she/he has made more or equal than 20, %20.
	 * 
	 * @return A message that says if the salary was reduced, and if it was, it says
	 *         how much.
	 * 
	 */
	public String checkAbsenses() {
		if (this.absenses >= 10 && this.absenses < 20) {
			this.salary = this.salary * 0.9;
			return "The salary was reduced %10.";
		} else if (this.absenses >= 20) {
			this.salary = this.salary * 0.8;
			return "The salary was reduced %20.";
		}
		return "The salary was not reduced.";
	}
}