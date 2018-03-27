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
import javax.validation.constraints.Size;

@Entity
public class Course {
	@Id
 	@GeneratedValue
    private Long id;
	private int signUp;
	
	
	@Size(min=3)
	private String name; 
	@Size(min=3)
	private String instructor; 
	private int  courseLimit;
   
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "users_courses",
		joinColumns = @JoinColumn(name = "course_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id"))
	
    private List<User> users;
    
    @Column(updatable=false)
    private Date createdAt;
   
    
    
    //-------------------------------------------------------
    
    
    
    public Date getCreatedAt() {
		return createdAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getSignUp() {
		return signUp;
	}
	public void setSignUp(int signUp) {
		this.signUp = signUp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public int getCourseLimit() {
		return courseLimit;
	}
	public void setCourseLimit(int courseLimit) {
		this.courseLimit = courseLimit;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
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
	private Date updatedAt;
    
    public Course() {
    }
    //---------------------------------------------------------------
    

    
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    public Course(String name, String instructor){
		this.name = name;
		this.instructor = instructor;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
}
