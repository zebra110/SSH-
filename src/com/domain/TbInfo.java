package com.domain;


import java.io.Serializable;
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
 * ³É½Ì±í
 */
@Entity
@Table(name = "tb_info")
public class TbInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "t_username")
	private String username;
	@Column(name = "t_pname")
	private String pname;
	@Column(name = "t_office")
	private String office;
	@Column(name = "t_linkman")
	private String linkman;
	@Column(name = "t_linknum")
	private String linknum;
	@Column(name = "t_isGovernmentcommissionedprojects")
	private String isGovernmentcommissionedprojects;
	@Column(name = "t_trainees")
	private String trainees;
	@Column(name = "t_isOutofschoolpersonnelneedtoenterthecampus")
	private String isOutofschoolpersonnelneedtoenterthecampus;		
	@Column(name = "t_partner")
	private String partner;
	@Column(name = "t_content")
	private String content;
	
	@Column(name = "t_starttime")
	private Date starttime;
	@Column(name = "t_endtime")
	private Date endtime;
	@Column(name = "t_uploadTime")
	private Date uploadTime;
	
	private String starttime2;
	private String endtime2;
	public String getStarttime2() {
		return starttime2;
	}
	public void setStarttime2(String starttime2) {
		this.starttime2 = starttime2;
	}
	public String getEndtime2() {
		return endtime2;
	}
	public void setEndtime2(String endtime2) {
		this.endtime2 = endtime2;
	}
	public String getUploadTime2() {
		return uploadTime2;
	}
	public void setUploadTime2(String uploadTime2) {
		this.uploadTime2 = uploadTime2;
	}
	private String uploadTime2;
	
	@Column(name = "t_enrollment")
	private String enrollment;
	@Column(name = "t_trainingexpense")
	private String trainingexpense;
	@Column(name = "t_escrowfee")
	private String escrowfee;
	@Column(name = "t_classunitPercentage")
	private String classunitPercentage;
	@Column(name = "t_classunitmoney")
	private String classunitmoney;
	@Column(name = "t_partnerPercentage")
	private String partnerPercentage;
	@Column(name = "t_partnermoney")
	private String partnermoney;
	@Column(name = "t_statuss")
	private String statuss;
	
	
	@Column(name = "t_totalfund")
	private String totalfund;
	@Column(name = "t_surplusfunds")
	private String surplusfunds;
	@Column(name = "t_filename1")
	private String filename1;
	@Column(name = "t_filename2")
	private String filename2;
	@Column(name = "t_filename3")
	private String filename3;
	@Column(name = "t_filename4")
	private String filename4;
	@Column(name = "t_filename5")
	private String filename5;
	
	private int number;
	
	
	public String getTotalfund() {
		return totalfund;
	}
	public void setTotalfund(String totalfund) {
		this.totalfund = totalfund;
	}
	public String getSurplusfunds() {
		return surplusfunds;
	}
	public void setSurplusfunds(String surplusfunds) {
		this.surplusfunds = surplusfunds;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getStatuss() {
		return statuss;
	}
	public void setStatuss(String statuss) {
		this.statuss = statuss;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getLinknum() {
		return linknum;
	}
	public void setLinknum(String linknum) {
		this.linknum = linknum;
	}
	public String getIsGovernmentcommissionedprojects() {
		return isGovernmentcommissionedprojects;
	}
	public void setIsGovernmentcommissionedprojects(String isGovernmentcommissionedprojects) {
		this.isGovernmentcommissionedprojects = isGovernmentcommissionedprojects;
	}
	public String getTrainees() {
		return trainees;
	}
	public void setTrainees(String trainees) {
		this.trainees = trainees;
	}
	public String getIsOutofschoolpersonnelneedtoenterthecampus() {
		return isOutofschoolpersonnelneedtoenterthecampus;
	}
	public void setIsOutofschoolpersonnelneedtoenterthecampus(String isOutofschoolpersonnelneedtoenterthecampus) {
		this.isOutofschoolpersonnelneedtoenterthecampus = isOutofschoolpersonnelneedtoenterthecampus;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}
	public String getTrainingexpense() {
		return trainingexpense;
	}
	public void setTrainingexpense(String trainingexpense) {
		this.trainingexpense = trainingexpense;
	}
	public String getEscrowfee() {
		return escrowfee;
	}
	public void setEscrowfee(String escrowfee) {
		this.escrowfee = escrowfee;
	}
	public String getClassunitPercentage() {
		return classunitPercentage;
	}
	public void setClassunitPercentage(String classunitPercentage) {
		this.classunitPercentage = classunitPercentage;
	}
	public String getClassunitmoney() {
		return classunitmoney;
	}
	public void setClassunitmoney(String classunitmoney) {
		this.classunitmoney = classunitmoney;
	}
	public String getPartnerPercentage() {
		return partnerPercentage;
	}
	public void setPartnerPercentage(String partnerPercentage) {
		this.partnerPercentage = partnerPercentage;
	}
	public String getPartnermoney() {
		return partnermoney;
	}
	public void setPartnermoney(String partnermoney) {
		this.partnermoney = partnermoney;
	}
	public TbInfo(Integer id, String pname, String office, String linkman, String linknum,
			String isGovernmentcommissionedprojects, String trainees, String isOutofschoolpersonnelneedtoenterthecampus,
			String partner, String content, Date starttime, Date endtime, String enrollment, String trainingexpense,
			String escrowfee, String classunitPercentage, String classunitmoney, String partnerPercentage,
			String partnermoney) {
		super();
		this.id = id;
		this.pname = pname;
		this.office = office;
		this.linkman = linkman;
		this.linknum = linknum;
		this.isGovernmentcommissionedprojects = isGovernmentcommissionedprojects;
		this.trainees = trainees;
		this.isOutofschoolpersonnelneedtoenterthecampus = isOutofschoolpersonnelneedtoenterthecampus;
		this.partner = partner;
		this.content = content;
		this.starttime = starttime;
		this.endtime = endtime;
		this.enrollment = enrollment;
		this.trainingexpense = trainingexpense;
		this.escrowfee = escrowfee;
		this.classunitPercentage = classunitPercentage;
		this.classunitmoney = classunitmoney;
		this.partnerPercentage = partnerPercentage;
		this.partnermoney = partnermoney;
	}
	public TbInfo() {
		super();
	}
	
}
