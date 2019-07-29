package com.xuzebiao.cms.vo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ImageArticle {
	
	private String path;
	private String desc;
	
	public ImageArticle(String path, String desc) {
		super();
		this.path = path;
		this.desc = desc;
	}
	public String getPath() {
		return path;
	}
	public String getDesc() {
		return desc;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static void main(String[] args) {
		List<ImageArticle> list = new ArrayList<>();
		list.add(new ImageArticle("/upload/1564382535136883.6520673903498.png","白衣尼禄"));
		list.add(new ImageArticle("/upload/1564382549653527.7900574889092.png","尼禄1"));
		list.add(new ImageArticle("/upload/1564382556234334.4927558634442.png","尼禄2"));
		list.add(new ImageArticle("/upload/1564382562955603.7084728510855.png","但丁+LOGO"));
		list.add(new ImageArticle("/upload/1564382571217992.8956648615437.png","但丁"));
		list.add(new ImageArticle("/upload/1564382577968194.96700621563014.png","V"));
		
		
		ObjectMapper ma = new ObjectMapper();
		try {
			System.out.println(ma.writeValueAsString(list));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
