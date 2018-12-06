package com.malabaristas.model;

import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;
import com.malabaristas.dto.MemberDto;

/**
 * Modelの変更はHTML上のフォーム、それを受け取るjs、サーバーサイドのMemberDtoおよびMemberListDtoおよび
 * それらを操作するActionとLogicの全てに変更が加わると考えられる。
 * @author ishino
 *
 */
@Model
public class Member extends AbstractModel {

	@Attribute(primaryKey=true)
	private Key key;
	private long id;
	private Date updateDate;
	private Date registerDate;
	private int version;

	private String lastName;
	private String firstName;
	private int grade;

	@Override
	public MemberDto toDto() {
		MemberDto memberDto = new MemberDto();
		memberDto.setId(id);
		memberDto.setLastName(lastName);
		memberDto.setFirstName(firstName);
		memberDto.setGrade(grade);
		return memberDto;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}
