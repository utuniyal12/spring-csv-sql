package com.example.springcsvtodbdemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

	public Person() {
	}
	@Id
	String name;
	Integer age;
	Long phone;
	String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Person(String name, Integer age, Long phone, String email) {
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", phone=" + phone + ", email=" + email + "]";
	}
	
	
}
