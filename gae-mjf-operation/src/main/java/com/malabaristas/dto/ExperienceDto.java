package com.malabaristas.dto;

public class ExperienceDto {

	private String stage;
	private String hangingCurtain;
	private String hangingLights;


	public ExperienceDto(String stage, String hangingCurtain, String hangingLights) {
		this.setStage(stage);
		this.setHangingCurtain(hangingCurtain);
		this.setHangingLights(hangingLights);
	}


	public String getStage() {
		return stage;
	}


	public void setStage(String stage) {
		this.stage = stage;
	}


	public String getHangingCurtain() {
		return hangingCurtain;
	}


	public void setHangingCurtain(String hangingCurtain) {
		this.hangingCurtain = hangingCurtain;
	}


	public String getHangingLights() {
		return hangingLights;
	}


	public void setHangingLights(String hangingLights) {
		this.hangingLights = hangingLights;
	}


}
