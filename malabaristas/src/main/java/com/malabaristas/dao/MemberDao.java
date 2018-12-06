package com.malabaristas.dao;

import java.util.ArrayList;
import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.malabaristas.dto.MemberDto;
import com.malabaristas.meta.MemberMeta;
import com.malabaristas.model.Member;

public class MemberDao extends AbstractDao<Member> {

	private static MemberMeta MEMBER_META = MemberMeta.get();

	@Override
	public List<Member> list() {
		return Datastore.query(MEMBER_META).asList();
	}

	@Override()
	public Member selectByKey(Key key) {
		return Datastore.get(Member.class, key);
	}

	@Override
	public List<MemberDto> dtoList(){
		List<Member> modelList = list();
		List<MemberDto> dtoList = new ArrayList<>();
		for(Member model: modelList) {
			dtoList.add(model.toDto());
		}
		return dtoList;
	}
}
