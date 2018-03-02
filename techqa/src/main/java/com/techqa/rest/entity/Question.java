package com.techqa.rest.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
public class Question implements Serializable {

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + getTitle() + ", content=" + content + ", views=" + getViews()
				+ ", category=" + getCategory() + ", user=" + user + ", creationDate=" + creationDate
				+ ", lastUpdateDate=" + lastUpdateDate + "]";
	}

	private static final long serialVersionUID = 4235393151425571253L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String title;

	@Column(columnDefinition = "TEXT")
	private String content;

	@Column
	private int views;

	@OneToMany(mappedBy = "question")
	private List<Answer> answers;

	@Column
	private String category;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
	@JsonManagedReference
	private User user;

	public Question(String title, String content, int views, String category, User user, Date creationDate,
			Date lastUpdateDate) {
		super();
		this.setTitle(title);
		this.content = content;
		this.setViews(views);
		this.setCategory(category);
		this.user = user;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
	}

	@Column(updatable = false, nullable = false)
	private Date creationDate;

	@Column(nullable = false)
	private Date lastUpdateDate;

	public Question() {
	}

	@PrePersist
	protected void onCreate() {
		this.creationDate = new Date();
		this.lastUpdateDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.lastUpdateDate = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int idPost) {
		this.id = idPost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastUpdateDate == null) ? 0 : lastUpdateDate.hashCode());
		result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + getViews();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (getCategory() == null) {
			if (other.getCategory() != null)
				return false;
		} else if (!getCategory().equals(other.getCategory()))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (id != other.id)
			return false;
		if (lastUpdateDate == null) {
			if (other.lastUpdateDate != null)
				return false;
		} else if (!lastUpdateDate.equals(other.lastUpdateDate))
			return false;
		if (getTitle() == null) {
			if (other.getTitle() != null)
				return false;
		} else if (!getTitle().equals(other.getTitle()))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (getViews() != other.getViews())
			return false;
		return true;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
