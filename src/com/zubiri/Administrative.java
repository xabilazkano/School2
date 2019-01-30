package com.zubiri;

import java.util.ArrayList;

public class Administrative extends Worker {
	private ArrayList<String> languages = new ArrayList<String>();
	private int administrativeID = 0;

	/**
	 * Constructor
	 * @param name
	 * @param birthDate in format 'yyyy/mm/dd'
	 * @param telephone
	 * @param dni
	 * @param absenses Number of absences
	 * @param salary
	 * @param joinedDate in format 'yyyy/mm/dd'
	 */
	public Administrative(String name, String birthDate, String telephone, String dni, int absenses, double salary,
			String joinedDate) {
		setName(name);
		setBirthDate(birthDate);
		setTelephone(telephone);
		setDni(dni);
		setAbsenses(absenses);
		setSalary(salary);
		setJoinedDate(joinedDate);
	}

	/**
	 * Default constructor
	 */
	public Administrative() {

	}

	/**
	 * 
	 * @return ArrayList of languages
	 */
	public ArrayList<String> getLanguages() {
		return this.languages;
	}

	/**
	 * Sets a new ArrayList of languages
	 * @param newLanguages
	 */
	public void setLanguages(ArrayList<String> newLanguages) {
		this.languages = newLanguages;
	}

	/**
	 * Gets the administrativeID
	 * @return  administrativeID
	 */
	public int getAdministrativeID() {
		return this.administrativeID;
	}

	/**
	 * Sets a new administrativeID
	 * @param newAdministrativeID
	 */
	public void setAdministrativeID(int newAdministrativeID) {
		this.administrativeID = newAdministrativeID;
	}

	/**
	 * Adds a new language
	 * @param newLanguage
	 * @return True if correctly added, false if not
	 */
	public boolean addLanguage(String newLanguage) {

		languages.add(newLanguage);
		if (findLanguage(newLanguage) != -1) {
			return true;
		}
		return false;
	}

	/**
	 * Finds the index of a language
	 * @param language
	 * @return The index of the language, -1 if not found
	 */
	public int findLanguage(String language) {
		for (int i = 0; i < languages.size(); i++) {
			if (language.equals(languages.get(i))) {
				return i;
			}
		}
		return -1;
	}
}
