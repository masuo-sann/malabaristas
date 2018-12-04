package com.malabaristas.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slim3.datastore.Datastore;

import com.google.gson.Gson;
import com.malabaristas.dao.MemberDao;
import com.malabaristas.dto.MemberDto;
import com.malabaristas.dto.MemberDto.Parameter;
import com.malabaristas.dto.MemberDto.Status;
import com.malabaristas.dto.MemberDto.Where;
import com.malabaristas.dto.MemberListDto;
import com.malabaristas.model.Member;

public class DatastoreLogic {
	private static final Logger LOGGER = Logger.getLogger(DatastoreLogic.class.getName());
	private static MemberDao MEMBER_DAO = new MemberDao();

	public String collectMemberList(HttpServletResponse resp){
		List<Member> memberList = MEMBER_DAO.collectMemberList();
		ArrayList<MemberDto> memberDtoList = new ArrayList<>();
		for(Member member : memberList) {
			MemberDto memberDto = modelToDto(member);
			memberDtoList.add(memberDto);
		}
		MemberListDto memberListDto = new MemberListDto(memberDtoList);

		String json = new Gson().toJson(memberListDto);
		LOGGER.info("memberList collected : " + json);
		return json;
	}

	private MemberDto modelToDto(Member member) {
		MemberDto memberDto = new MemberDto();
		memberDto.setStrKey(Datastore.keyToString(member.getKey()));
		// memberDto.setId(member.getKey().getId());
		memberDto.setLastName(member.getLastName());
		memberDto.setFirstName(member.getFirstName());
		memberDto.setGrade(member.getGrade());
		memberDto.setQualificationOfLight(member.isQualificationOfLight());
		memberDto.setQualificationOfLightManagement(member.isQualificationOfLightManagement());

		memberDto.setLightOperator(member.isLightOperator());
		memberDto.setMusicOperator(member.isMusicOperator());
		memberDto.setToolPerson(member.isToolPerson());
		memberDto.setMarkingStage(member.getMarkingStage());
		memberDto.setLinoCovering(member.getLinoCovering());
		memberDto.setStage(member.getStage());
		memberDto.setSeats(member.getSeats());
		memberDto.setTwistingBind(member.getTwistingBind());
		memberDto.setTyingBind(member.getTyingBind());
		memberDto.setGuard(member.getGuard());
		memberDto.setHungingCurtain(member.getHungingCurtain());
		memberDto.setHungingLights(member.getHungingLights());
		memberDto.setShoot(member.getShoot());
		memberDto.setFoldingCurtain(member.getFoldingCurtain());

		memberDto.setTotalExperience(member.getTotalExperience());
		memberDto.setThisYearsExperience(member.getThisYearsExperience());
		memberDto.setLastYearsExperience(member.getLastYearsExperience());

		memberDto.setWhere(member.getWhere());
		memberDto.setStatus(member.getStatus());
		memberDto.setRest(member.getRest());

		return memberDto;
	}

	public void addMember(HttpServletRequest req) {
		Member member = assignParams(req, "ADD");
		Datastore.put(member);
	}

	// update対象は profileとして入力できるものに限る。
	public void updateMember(HttpServletRequest req) {
		Member member = assignParams(req, "UPDATE");
		Datastore.put(member);
	}

	private Member assignParams(HttpServletRequest req, String method) {
		Member member;
		if("ADD".equals(method)) {
			member = new Member();
			member.setRegisterDate(new Date());
			member.setVersion(0);
			member.setUpdateDate(new Date());
			member.setWhere(Where.ABSENT.getName());
			member.setStatus(Status.BORED.getName());
			LOGGER.info("add new Member!!");
		} else {
			LOGGER.info("update start : key = " + req.getParameter(Parameter.STR_KEY.getName()));
			member = MEMBER_DAO.selectByKey(Datastore.stringToKey(req.getParameter(Parameter.STR_KEY.getName())));
			member.setVersion(member.getVersion()+1);
			member.setUpdateDate(new Date());
			LOGGER.info("update Member!! id = " + member.getKey().getId());
		}

		member.setLastName(req.getParameter(Parameter.LAST_NAME.getName()));
		member.setFirstName(req.getParameter(Parameter.FIRST_NAME.getName()));
		member.setGrade(Integer.valueOf(req.getParameter(Parameter.GRADE.getName())).intValue());
		member.setQualificationOfLight(Boolean.valueOf(req.getParameter(Parameter.QUALIFICATION_OF_LIGHT.getName())).booleanValue());
		member.setQualificationOfLightManagement(Boolean.valueOf(req.getParameter(Parameter.QUALIFICATION_OF_LIGHT_MANAGEMENT.getName())).booleanValue());Datastore.put(member);

		member.setLightOperator(Boolean.valueOf(req.getParameter(Parameter.LIGHT_OPERATOR.getName())).booleanValue());
		member.setMusicOperator(Boolean.valueOf(req.getParameter(Parameter.MUSIC_OPERATOR.getName())).booleanValue());
		member.setToolPerson(Boolean.valueOf(req.getParameter(Parameter.TOOL_PERSON.getName())).booleanValue());
		member.setMarkingStage(Integer.valueOf(req.getParameter(Parameter.MARKING_STAGE.getName())));
		member.setLinoCovering(Integer.valueOf(req.getParameter(Parameter.LINO_COVERING.getName())));
		member.setStage(Integer.valueOf(req.getParameter(Parameter.STAGE.getName())));
		member.setSeats(Integer.valueOf(req.getParameter(Parameter.SEATS.getName())));
		member.setTwistingBind(Integer.valueOf(req.getParameter(Parameter.TWISTING_BIND.getName())));
		member.setTyingBind(Integer.valueOf(req.getParameter(Parameter.TYING_BIND.getName())));
		member.setGuard(Integer.valueOf(req.getParameter(Parameter.GUARD.getName())));
		member.setHungingCurtain(Integer.valueOf(req.getParameter(Parameter.HUNGING_CURTAIN.getName())));
		member.setHungingLights(Integer.valueOf(req.getParameter(Parameter.HUNGING_LIGHTS.getName())));
		member.setShoot(Integer.valueOf(req.getParameter(Parameter.SHOOT.getName())));
		member.setFoldingCurtain(Integer.valueOf(req.getParameter(Parameter.FOLDING_CURTAIN.getName())));

		return member;
	}

}
