package com.malabaristas.dto;

public class ExperienceDto {

	private String stage;
	private String hungingCurtain;
	private String hungingLights;

	public ExperienceDto(String stage, String hungingCurtain, String hungingLights) {
		super();
		this.stage = stage;
		this.hungingCurtain = hungingCurtain;
		this.hungingLights = hungingLights;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getHungingCurtain() {
		return hungingCurtain;
	}

	public void setHungingCurtain(String hungingCurtain) {
		this.hungingCurtain = hungingCurtain;
	}

	public String getHungingLights() {
		return hungingLights;
	}

	public void setHungingLights(String hungingLights) {
		this.hungingLights = hungingLights;
	}
}
