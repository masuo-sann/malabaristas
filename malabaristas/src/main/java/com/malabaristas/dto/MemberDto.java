package com.malabaristas.dto;

import com.malabaristas.model.AbstractModel;
import com.malabaristas.model.Member;

/**
 * jsに返すためにJSONに変換する際に用いるオブジェクト
 * model.Memberと同じ値をもつ。 keyはKey型をlong型として用いる。
 * @author ishino
 *
 */
public class MemberDto extends AbstractDto {
	private String strKey;
	private long id;

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

	public static enum Where {
		ONE("ONE"), TWO("TWO"), THREE("THREE"), PRESENT("PRESENT"), ABSENT("ABSENT");

		private String name;

		private Where(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	public static enum Status {
		WORKING("WORKING"), BORED("BORED"), SABORI("SABORI");

		private String name;

		private Status(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	public static enum Parameter {
		METHOD("method"), STR_KEY("strKey"), ID("id"),
		LAST_NAME("lastName"), FIRST_NAME("firstName"), GRADE("grade"),
		QUALIFICATION_OF_LIGHT("qualificationOfLight"), QUALIFICATION_OF_LIGHT_MANAGEMENT("qualificationOfLightManagement"),
		LIGHT_OPERATOR("lightOperator"), MUSIC_OPERATOR("musicOperator"), TOOL_PERSON("toolPerson"),
		MARKING_STAGE("markingStage"), LINO_COVERING("linoCovering"), STAGE("stage"), SEATS("seats"),
		TWISTING_BIND("twistingBind"), TYING_BIND("tyingBind"), GUARD("guard"),
		HUNGING_CURTAIN("hungingCurtain"), HUNGING_LIGHTS("hungingLights"), SHOOT("shoot"), FOLDING_CURTAIN("foldingCurtain"),
		TOTAL_EXPERIENCE("totalExperience"),THIS_YEARS_EXPERIENCE("thisYearsExperience"), LAST_YEARS_EXPERIENCE("lastYearsExperience"),
		WHERE("where"), STATUS("status"), REST("rest");

		private String name;

		private Parameter(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	public MemberDto() {};

	public MemberDto(long id, String lastName, String firstName, int grade) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.grade = grade;
	}


	@Override
	public AbstractModel toModel() {
		Member member = new Member();
		member.setId(this.id);
		member.setLastName(this.lastName);
		member.setFirstName(this.firstName);
		member.setGrade(this.grade);
		return member;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", grade=" + grade + "]";
	}

	public String getStrKey() {
		return strKey;
	}

	public void setStrKey(String strKey) {
		this.strKey = strKey;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
