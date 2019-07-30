package com.xuzebiao.cms.vo;

import java.util.List;

import com.xuzebiao.cms.domain.Article;
import com.xuzebiao.cms.domain.Category;
import com.xuzebiao.cms.domain.Channel;
import com.xuzebiao.cms.domain.User;

public class ArticleVo extends Article{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Category category;
	private Channel channel;
	private User author;
	private List<?> comments;
	public List<?> getComments() {
		return comments;
	}
	public void setComments(List<?> comments) {
		this.comments = comments;
	}
	public Category getCategory() {
		return category;
	}
	public Channel getChannel() {
		return channel;
	}
	public User getAuthor() {
		return author;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public ArticleVo() {
		super();
	}
	@Override
	public String toString() {
		return super.toString() + "\n ArticleVo [category=" + category + ", channel=" + channel + ", author=" + author + ", comments="
				+ comments +  "]";
	}
	
	
}
