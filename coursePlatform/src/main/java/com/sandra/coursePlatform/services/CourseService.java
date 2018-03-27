package com.sandra.coursePlatform.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.sandra.coursePlatform.models.Course;
import com.sandra.coursePlatform.repositories.CourseRepository;

@Service
public class CourseService {
private CourseRepository courseRepository;

	
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	
	}
	
	public void create(Course course) {
		courseRepository.save(course);
	}
	
	public Course findById(Long id) {
		return courseRepository.findById(id).orElse(null);
	}
	
	
	public void update(Course course) {
		courseRepository.save(course);
	}
	
	public void destroy(Long id) {
		courseRepository.deleteById(id);
	}
	
	public ArrayList<Course> all(){
		return (ArrayList<Course>) courseRepository.findAll();
	}
	

}
