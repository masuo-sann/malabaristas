package com.malabaristas.model;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

@Model
public class Member {

	@Attribute(primaryKey=true)
	private Key key;

	private String name;
	private String nameRubi;
	private int grade;
	private boolean qualificationOfLight;
	private boolean qualificationOfLightManagement;

	private String totalExperience;
	private String thisYearsExperience;
	private String lastYearsExperience;

	private String where;



	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameRubi() {
		return nameRubi;
	}

	public void setNameRubi(String nameRubi) {
		this.nameRubi = nameRubi;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public boolean isQualificationOfLight() {
		return qualificationOfLight;
	}

	public void setQualificationOfLight(boolean qualificationOfLight) {
		this.qualificationOfLight = qualificationOfLight;
	}

	public boolean isQualificationOfLightManagement() {
		return qualificationOfLightManagement;
	}

	public void setQualificationOfLightManagement(boolean qualificationOfLightManagement) {
		this.qualificationOfLightManagement = qualificationOfLightManagement;
	}

	public String getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(String totalExperience) {
		this.totalExperience = totalExperience;
	}

	public String getThisYearsExperience() {
		return thisYearsExperience;
	}

	public void setThisYearsExperience(String thisYearsExperience) {
		this.thisYearsExperience = thisYearsExperience;
	}

	public String getLastYearsExperience() {
		return lastYearsExperience;
	}

	public void setLastYearsExperience(String lastYearsExperience) {
		this.lastYearsExperience = lastYearsExperience;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

}
