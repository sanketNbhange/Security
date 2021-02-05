package com.cybage.security;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column
    private String username;
    @Column
    private String password;
    
	@Column
    private int salary;
    @Column
    private int age;

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="user_roles",
	    joinColumns=@JoinColumn(name="id"))
	@Column(name = "role")
	private List<String> roles = new ArrayList<>();

	@Transient
	private String token;
	
	public User() {
		super();
	}

	public User(long id, String username, String password, int salary, int age, List<String> roles, String token) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.salary = salary;
		this.age = age;
		this.roles = roles;
		this.token = token;
	}
	public User(long id, String username, String password, int salary, int age, List<String> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.salary = salary;
		this.age = age;
		this.roles = roles;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", salary=" + salary + ", age="
				+ age + ", roles=" + roles + ", token=" + token + "]";
	}
 
}
