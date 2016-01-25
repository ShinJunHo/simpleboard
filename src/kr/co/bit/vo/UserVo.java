package kr.co.bit.vo;

import java.io.Serializable;

public class UserVo implements Serializable{
	
	
	private String id;
	private String password;
	private String email;
	private String phone;
	private int age;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", password=" + password + ", email="
				+ email + ", phone=" + phone + ", age=" + age + "]";
	}
	
}
