package com.wzx.dto;

import java.util.Date;


public class NewsDto {
	private String id;
	private String newsid;
	private String title;
	private String context;
	private String newsman;
	private Date newsdate;
	private String pic;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNewsid() {
		return newsid;
	}
	public void setNewsid(String newsid) {
		this.newsid = newsid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getNewsman() {
		return newsman;
	}
	public void setNewsman(String newsman) {
		this.newsman = newsman;
	}
	public Date getNewsdate() {
		return newsdate;
	}
	public void setNewsdate(Date newsdate) {
		this.newsdate = newsdate;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		return "NewsDto [id=" + id + ", newsid=" + newsid + ", title=" + title
				+ ", context=" + context + ", newsman=" + newsman
				+ ", newsdate=" + newsdate + ", pic=" + pic + "]";
	}
	
	
}		
