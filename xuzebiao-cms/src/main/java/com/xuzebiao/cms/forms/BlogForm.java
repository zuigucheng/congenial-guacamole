package com.xuzebiao.cms.forms;

import com.xuzebiao.cms.domain.Category;


/**
 * @author xuzebiao
 * 博客编译表单
 * 
 * 
 */
public class BlogForm {
	private Integer id;
	private String title;
	private String content;
	private String summary;
	private Category category;
	private String cover;
	public BlogForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getSummary() {
		return summary;
	}
	public Category getCategory() {
		return category;
	}
	public String getCover() {
		return cover;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	@Override
	public String toString() {
		return "BlogForm [id=" + id + ", title=" + title + ", content=" + content + ", summary=" + summary
				+ ", category=" + category + ", cover=" + cover + "]";
	}
	
	
}
