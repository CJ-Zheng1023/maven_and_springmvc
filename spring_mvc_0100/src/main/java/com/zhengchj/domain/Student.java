package com.zhengchj.domain;

public class Student {
	private String id;
	private String name;
	private String sex;
	private String favorite;
	
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getFavorite() {
		return favorite;
	}
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	public Student(String id,String name,String sex,String favorite){
		this.id=id;
		this.name=name;
		this.sex=sex;
		this.favorite=favorite;
	}
	public Student(){
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
