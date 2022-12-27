package com.nic.newspaper.entity;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "header")
	private String header;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "date")
	private String date;

	public Article() {
		
	}

	public Article(String header, String content, String date) {
		this.header = header;
		this.content = content;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", header=" + header + ", content=" + content + ", date=" + date + "]";
	}
	
}
