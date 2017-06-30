package com.redditclone;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PreUpdate;
import javax.persistence.Id;
import javax.persistence.PrePersist;


@Entity
public class Reddit {
	
	//private static final SimpleDateFormat formatDte = new SimpleDateFormat ("MMM dd, yyyy");
	//private String createdAt = formatDte.format(d);
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String username;
	private String title;
	private String url;
	@Column(name = "created_at")
//	@Column(name = "updated_at")
	private Date createdAt;
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	 @PrePersist
	 void createdAt() {
	//	this.createdAt = this.updatedAt = new Date();
		this.createdAt = new Date();
	}
//	 @PreUpdate
//	void updateAt() {
//		this.updatedAt = new Date();
	}
	