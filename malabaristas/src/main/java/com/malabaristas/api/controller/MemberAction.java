package com.malabaristas.api.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.malabaristas.controller.AbstractAction;
import com.malabaristas.dto.MemberDto;
import com.malabaristas.logic.MemberLogic;
import com.malabaristas.model.Member;

public class MemberAction extends AbstractAction<Member> {
	private MemberLogic memberLogic;
	private MemberDto memberDto;

	/*
	 * パラメータの定義
	 */
	public static enum Params {
		Id("id"), LastName("lastName"), FirstName("firstName"), Grade("grade");
		private String name;
		private Params(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
	}
	public static enum Methods {
		ADD("add"), LIST("list"), UPDATE("update"), DELETE("delete");
		private String name;
		private Methods(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
	}

	public MemberAction(HttpServletRequest req, HttpServletResponse resp, String method) {
		super(req, resp, method);
	}

	@Override
	public void setUp() {
		memberLogic = new MemberLogic();
		memberDto = createJsonObj();
	}

	@Override
	public void execute() throws IOException {
		setUp();
		if(method==null) {
			LOGGER.info("method is null");
			return;
		} else if(Methods.ADD.getName().equals(method)){
			memberLogic.add(memberDto);
			return;
		} else if(Methods.LIST.getName().equals(method)) {
			String json = memberLogic.list();
			LOGGER.info("[DEBUG] response json = " + json);
			resp.getWriter().println(json);
			return;
		} else if(Methods.UPDATE.getName().equals(method)) {
			memberLogic.update(memberDto);
			return;
		} else if(Methods.DELETE.getName().equals(method)) {
			memberLogic.delete(memberDto.getStrKey());
			return;
		}
	}

	@Override
	public MemberDto createJsonObj() {
		String json = readRequestBody();
		return new Gson().fromJson(json, MemberDto.class);
	}

}
