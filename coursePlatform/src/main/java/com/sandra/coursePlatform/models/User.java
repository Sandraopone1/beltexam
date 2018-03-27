package com.sandra.coursePlatform.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class User {
	

	@Id
    @GeneratedValue
    private Long id;
	
	@Email
	private String email;
	@Size(min=3)
    private String username;
	@Size(min=3)
	private String name;
	@Size(min=8)
    private String password;
    @Transient
    private String confirm;
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
 
    
    
  //------------------------------------------------------------------
    
   
    
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "users_courses",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses;
    
    public User() {
    }
    
    
    public User(String email,String password,String name){
		this.email = email;
		this.password = password;
		this.name = name;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
    
//------------------------------------------------------------------
   
    
   
    
  
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirm() {
		return confirm;
	}


	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	

	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
//    public boolean isAdmin(){
//		for(Role role:this.roles){			
//			if(role.getName().equals("ROLE_ADMIN")){return true;}
//		}
//		return false;
//	}
//	public boolean isSuperAdmin(){
//		for(Role role:this.roles){			
//			if(role.getName().equals("ROLE_SUPERADMIN")){return true;}
//		}
//		return false;
//	}

}

