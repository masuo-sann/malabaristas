package com.malabaristas.logic;

import java.util.logging.Logger;

import com.malabaristas.dto.MemberDto;

public class MemberLogic {
	protected static final Logger LOGGER = Logger.getLogger(MemberLogic.class.getName());

	public void addMember(MemberDto dto) {
		LOGGER.info("add-member!");
		LOGGER.info(dto.toString());
		return;
	}
}
