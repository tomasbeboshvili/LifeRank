package com.example.liferank;

import java.io.Serializable;

public class User implements Serializable {
	private int id;
	private String name;
	private int age;
	public User(){};

	public User(int id, String name, int age){
		this.age = age;
		this.name = name;
		this.id = id;
	}

	public int getId(){
		return id;
	}
	public void setID(int id){
		this.id = id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setAge(int age){
		this.age = age;
	}

}
