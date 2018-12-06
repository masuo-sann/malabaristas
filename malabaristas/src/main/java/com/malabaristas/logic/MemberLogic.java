package com.malabaristas.logic;

import java.util.List;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.malabaristas.dao.MemberDao;
import com.malabaristas.dto.MemberDto;
import com.malabaristas.model.Member;

public class MemberLogic {
	protected static final Logger LOGGER = Logger.getLogger(MemberLogic.class.getName());
	private static MemberDao memberDao = new MemberDao();
	private static Gson gson = new Gson();

	public void add(MemberDto dto) {
		LOGGER.info("[INFO] add member : " + dto.toString());
		Member member = new Member();
		memberDao.add(dto.toModel(member));
		return;
	}

	public String list() {
		LOGGER.info("[INFO] list member");
		List<MemberDto> dtoList = memberDao.dtoList();
		String memberList = gson.toJson(dtoList);
		return memberList;
	}

	public void update(MemberDto dto) {
		LOGGER.info("[INFO] update member : " + dto.toString());
		String strKey = dto.getStrKey();
		Member member = memberDao.selectByStrKey(strKey);
		Member newMember = dto.toModel(member);
		memberDao.add(newMember);
		return;
	}

	public void delete(String strKey) {
		LOGGER.info("[INFO] delete member : " + strKey);
		memberDao.deleteByStrKey(strKey);
	}
}
