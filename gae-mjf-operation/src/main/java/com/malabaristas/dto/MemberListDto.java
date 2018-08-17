package com.malabaristas.dto;

import java.util.List;

public class MemberListDto {

	private List<MemberDto> memberList;

	public MemberListDto() {
	}

	public MemberListDto(List<MemberDto> memberList) {
		super();
		this.memberList = memberList;
	}

	public List<MemberDto> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<MemberDto> memberList) {
		this.memberList = memberList;
	}
}
