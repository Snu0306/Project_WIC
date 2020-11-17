package kr.or.wic.dto;

import java.util.Date;

public class ChatroomDTO {
	private int ch_num;
	private String ch_title;
	private String ch_content;
	private Date ch_date;
	private int prd_num;
	private String id;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCh_num() {
		return ch_num;
	}
	public void setCh_num(int ch_num) {
		this.ch_num = ch_num;
	}
	public String getCh_title() {
		return ch_title;
	}
	public void setCh_title(String ch_title) {
		this.ch_title = ch_title;
	}
	public String getCh_content() {
		return ch_content;
	}
	public void setCh_content(String ch_content) {
		this.ch_content = ch_content;
	}
	public Date getCh_date() {
		return ch_date;
	}
	public void setCh_date(Date ch_date) {
		this.ch_date = ch_date;
	}
	public int getPrd_num() {
		return prd_num;
	}
	public void setPrd_num(int prd_num) {
		this.prd_num = prd_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ChatroomDTO [ch_num=" + ch_num + ", ch_title=" + ch_title + ", ch_content=" + ch_content + ", ch_date="
				+ ch_date + ", prd_num=" + prd_num + ", id=" + id + "]";
	}
	
	
	
	
	
}
