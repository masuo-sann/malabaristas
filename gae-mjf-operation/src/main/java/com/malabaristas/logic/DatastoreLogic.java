package com.malabaristas.logic;

import javax.servlet.http.HttpServletRequest;

import org.slim3.datastore.Datastore;

import com.google.gson.Gson;
import com.malabaristas.dto.ExperienceDto;
import com.malabaristas.model.Member;

public class DatastoreLogic {

	public void addMember(HttpServletRequest req) {
		Member member = new Member();
		member.setName(req.getParameter("name"));
		member.setNameRubi(req.getParameter("nameRubi"));
		member.setGrade(Integer.valueOf(req.getParameter("grade")).intValue());
		member.setQualificationOfLight(Boolean.valueOf(req.getParameter("qualificationOfLight")).booleanValue());
		member.setQualificationOfLightManagement(Boolean.valueOf(req.getParameter("qualificationOfLightManagement")).booleanValue());Datastore.put(member);

		ExperienceDto totalExperienceDto = new ExperienceDto(req.getParameter("stage"), req.getParameter("hangingCurtain"), req.getParameter("hangingLights"));
		member.setTotalExperience(new Gson().toJson(totalExperienceDto));

		Datastore.put(member);
	}
}
