package com.scoreboard.BoardAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="uid")
	private int id;
	@Column(name="username")
	private String username;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="role")
	private String role;
	@Column(name="password")
	private String password;
	public users() {
		
	}
	public int getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "users [id=" + id + ", username=" + username + ", name=" + name + ", email=" + email + ", role=" + role
				+ ", password=" + password + "]";
	}
	public users(String username, String name, String email, String role, String password) {
		super();
		this.username = username;
		this.name = name;
		this.email = email;
		this.role = role;
		this.password = password;
	}
	
	
	
}
