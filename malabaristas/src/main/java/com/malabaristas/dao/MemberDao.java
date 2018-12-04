package com.malabaristas.dao;

import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.malabaristas.meta.MemberMeta;
import com.malabaristas.model.Member;

public class MemberDao {

	private static MemberMeta MEMBER_META = MemberMeta.get();

	public List<Member> collectMemberList(){
		return Datastore.query(MEMBER_META).asList();
	}

	public Member selectByKey(Key key) {
		return Datastore.get(Member.class, key);
	}
}
