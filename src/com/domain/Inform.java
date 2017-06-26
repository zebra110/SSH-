package com.domain;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * ¿Í»§
 */
@Entity
@Table(name = "inform")
public class Inform {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	@Column(name = "t_title")
	 private String title;
	@Column(name = "t_content")
	 private String content;
	@Column(name = "t_picture_name")
	 private String pictureName;
	@Column(name = "t_upload_time")
	private Date uploadTime;
	private int number;
	private String uploadTime2;
	
	
	
	
	public String getUploadTime2() {
		return uploadTime2;
	}
	public void setUploadTime2(String uploadTime2) {
		this.uploadTime2 = uploadTime2;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		
		this.uploadTime = uploadTime;
	}
	public Inform() {
		super();
	}
	public Inform(String title, String content, String pictureName) {
		super();
		this.title = title;
		this.content = content;
		this.pictureName = pictureName;
	}
	public Inform(int id, String title, String content, String pictureName) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.pictureName = pictureName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	 
	@Override
	public String toString() {
		
		return id+title+content+pictureName+uploadTime;
	}


}
