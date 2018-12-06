package com.malabaristas.dto;

import com.malabaristas.model.Member;

/**
 * jsに返すためにJSONに変換する際に用いるオブジェクト
 * model.Memberと同じ値をもつ。 keyはKey型をlong型として用いる。
 * @author ishino
 *
 */
public class MemberDto extends AbstractDto<Member> {
	private String strKey;
	private long id;
	private String lastName;
	private String firstName;
	private int grade;

	public MemberDto() {}
	public MemberDto(long id, String lastName, String firstName, int grade) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.grade = grade;
	}

	@Override
	public Member toModel(Member member) {
		member.setId(this.id);
		member.setLastName(this.lastName);
		member.setFirstName(this.firstName);
		member.setGrade(this.grade);
		return member;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", grade=" + grade + "]";
	}

	public String getStrKey() {
		return strKey;
	}

	public void setStrKey(String strKey) {
		this.strKey = strKey;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
