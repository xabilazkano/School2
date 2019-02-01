package com.zubiri;

import java.time.LocalDate;
import java.time.Period;

public class Person {
	private String name = "";
	private String birthDate="0000/00/00";
	private String telephone="000000000";
	private String dni="00000000A";
	
	/**
	 * Gets the name
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets a new name
	 * @param newName
	 */
	public void setName(String newName) {
		this.name=newName;
	}
	
	/**
	 * Gets the birth date as string
	 * @return birth date
	 */
	public String getBirthDate() {
		return this.birthDate;
	}
	
	/**
	 * Sets a new birth date
	 * @param newBirthDate
	 */
	public void setBirthDate(String newBirthDate) {
		
			this.birthDate=newBirthDate;
		
	}
	
	/**
	 * Gets the telephone number
	 * @return telephone
	 */
	public String getTelephone() {
		return this.telephone;
	}
	
	/**
	 * Sets a new telephone number
	 * @param newTelephone
	 */
	public void setTelephone(String newTelephone) {
		if (isValidTelephone(newTelephone)) {
			this.telephone=newTelephone;
		}
	}
	
	/**
	 * Gets the DNI
	 * @return DNI
	 */
	public String getDni() {
		return this.dni;
	}
	
	/**
	 * Sets a new DNI
	 * @param newDni
	 */
	public void setDni(String newDni) {
		if (isValidDni(newDni)) {
			this.dni=newDni;
		}
	}
	
	/**
	 * Checks if the format of the DNI is correct
	 * @param dni
	 * @return true if correct,false if not
	 */
	public boolean isValidDni(String dni) {
		if (dni.length()==9) {
			for (int i=0;i<dni.length()-1;i++) {
				if (!Character.isDigit(dni.charAt(i))) {
					return false;
				}
			}
			if (!Character.isLetter(dni.charAt(8))) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if the format of the telephone is correct
	 * @param telephone
	 * @return true if correct,false if not
	 */
	public boolean isValidTelephone(String telephone) {
		if (telephone.length()==9) {
			for (int i=0;i<telephone.length();i++) {
				if (!Character.isDigit(telephone.charAt(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if the format of the date is correct
	 * @param date
	 * @return true if correct,false if not
	 */
	public boolean isValidDate(String date) {
		if (date.length() == 10) {
			String[] dateString = this.birthDate.split("/");
			int[] dateInt = new int[3];
			for (int i = 0; i < dateString.length; i++) {
				dateInt[i] = Integer.parseInt(dateString[i]);
			}
			if (dateInt[0] <= 2019 && dateInt[1] <= 12 || dateInt[2] <= 31) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Calculates the age comparing the birth date whith the current date
	 * @return age
	 */
	public int calculateAge() {
		String[] birthString = this.birthDate.split("/");
		int[] birthInt = new int[3];
		for (int i=0;i<birthString.length;i++) {
			birthInt[i]=Integer.parseInt(birthString[i]);
		}
		LocalDate birthDate = LocalDate.of(birthInt[0], birthInt[1], birthInt[2]);
		LocalDate currentDate = LocalDate.now();
		return Period.between(birthDate, currentDate).getYears();
	}
}