package com.glarimy.cmad;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Incident {
	@Id
	private Integer id;
	private Integer cid;
	private String cname;
	private String url;
	private String wbrso;
	private String wbrsc;
	private String wbrsth;
	private List<String> webcats;
	private List<String> webcatsth;
	private String dateo;
	private String datec;
	private String timeo;
	private String timec;
	private String usercomment;
	private String admingcomment;
	private String verdict;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getWebcats() {
		return webcats;
	}
	
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWbrso() {
		return wbrso;
	}

	public void setWbrso(String wbrso) {
		this.wbrso = wbrso;
	}

	public String getWbrsc() {
		return wbrsc;
	}

	public void setWbrsc(String wbrsc) {
		this.wbrsc = wbrsc;
	}

	public String getWbrsth() {
		return wbrsth;
	}

	public void setWbrsth(String wbrsth) {
		this.wbrsth = wbrsth;
	}

	public List<String> getWebcatsth() {
		return webcatsth;
	}

	public void setWebcatsth(List<String> webcatsth) {
		this.webcatsth = webcatsth;
	}

	public String getDateo() {
		return dateo;
	}

	public void setDateo(String dateo) {
		this.dateo = dateo;
	}

	public String getDatec() {
		return datec;
	}

	public void setDatec(String datec) {
		this.datec = datec;
	}

	public String getTimeo() {
		return timeo;
	}

	public void setTimeo(String timeo) {
		this.timeo = timeo;
	}

	public String getTimec() {
		return timec;
	}

	public void setTimec(String timec) {
		this.timec = timec;
	}

	public String getUsercomment() {
		return usercomment;
	}

	public void setUsercomment(String usercomment) {
		this.usercomment = usercomment;
	}

	public String getAdmingcomment() {
		return admingcomment;
	}

	public void setAdmingcomment(String admingcomment) {
		this.admingcomment = admingcomment;
	}

	public void setWebcats(List<String> webcats) {
		this.webcats = webcats;
	}
	
	public String getVerdict() {
		return verdict;
	}

	public void setVerdict(String verdict) {
		this.verdict = verdict;
	}

}
