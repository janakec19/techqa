package com.techqa.rest.entity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@Table(name = "user")
public class User {

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + getUsername() + ", password=" + password + ", introduction="
				+ introduction + ", createdDate=" + createdDate + ", questions=" + questions + "]";
	}

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, length = 10)
	private String username;

	@Column(nullable = false, length = 60)
	private String password;

	@Column(length = 16)
	private String introduction;

	@Column
	private Date createdDate;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@JsonBackReference
	private List<Question> questions;

	public User(String username, String password, String introduction, Date createdDate) {
		super();
		this.setUsername(username);
		this.password = password;
		this.introduction = introduction;
		this.createdDate = createdDate;
	}

	public User() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Optional getIntroduction() {
		return Optional.ofNullable(introduction);
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String displayContentOfOptional() {
		if (Optional.ofNullable(introduction).isPresent())
			return Optional.ofNullable(introduction).get();
		else
			return "";
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
