package com.malabaristas.model;

import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * Modelの変更はHTML上のフォーム、それを受け取るjs、サーバーサイドのMemberDtoおよびMemberListDtoおよび
 * それらを操作するActionとLogicの全てに変更が加わると考えられる。
 * @author ishino
 *
 */
@Model
public class Member {

	@Attribute(primaryKey=true)
	private Key key;
	private long id;
	private Date updateDate;
	private Date registerDate;
	private int version;

	private String lastName;
	private String firstName;
	private int grade;

	// 資格
	private boolean qualificationOfLight;
	private boolean qualificationOfLightManagement;

	// オペレーション
	private boolean lightOperator;
	private boolean musicOperator;
	private boolean toolPerson;

	// 設営/撤営経験
	private int markingStage;
	private int linoCovering;
	private int stage;
	private int seats;
	private int twistingBind;
	private int tyingBind;
	private int guard;
	private int hungingCurtain;
	private int hungingLights;
	private int shoot;
	private int foldingCurtain;

	private String totalExperience;
	private String thisYearsExperience;
	private String lastYearsExperience;

	private String where;
	private String status;
	private int rest;


	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public int getHungingCurtain() {
		return hungingCurtain;
	}

	public void setHungingCurtain(int hungingCurtain) {
		this.hungingCurtain = hungingCurtain;
	}

	public int getHungingLights() {
		return hungingLights;
	}

	public void setHungingLights(int hungingLights) {
		this.hungingLights = hungingLights;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isLightOperator() {
		return lightOperator;
	}

	public void setLightOperator(boolean lightOperator) {
		this.lightOperator = lightOperator;
	}

	public boolean isMusicOperator() {
		return musicOperator;
	}

	public void setMusicOperator(boolean musicOperator) {
		this.musicOperator = musicOperator;
	}

	public boolean isToolPerson() {
		return toolPerson;
	}

	public void setToolPerson(boolean toolPerson) {
		this.toolPerson = toolPerson;
	}

	public int getMarkingStage() {
		return markingStage;
	}

	public void setMarkingStage(int markingStage) {
		this.markingStage = markingStage;
	}

	public int getLinoCovering() {
		return linoCovering;
	}

	public void setLinoCovering(int linoCovering) {
		this.linoCovering = linoCovering;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getTwistingBind() {
		return twistingBind;
	}

	public void setTwistingBind(int twistingBind) {
		this.twistingBind = twistingBind;
	}

	public int getTyingBind() {
		return tyingBind;
	}

	public void setTyingBind(int tyingBind) {
		this.tyingBind = tyingBind;
	}

	public int getGuard() {
		return guard;
	}

	public void setGuard(int guard) {
		this.guard = guard;
	}

	public int getShoot() {
		return shoot;
	}

	public void setShoot(int shoot) {
		this.shoot = shoot;
	}

	public int getFoldingCurtain() {
		return foldingCurtain;
	}

	public void setFoldingCurtain(int foldingCurtain) {
		this.foldingCurtain = foldingCurtain;
	}

	public int getRest() {
		return rest;
	}

	public void setRest(int rest) {
		this.rest = rest;
	}

}
