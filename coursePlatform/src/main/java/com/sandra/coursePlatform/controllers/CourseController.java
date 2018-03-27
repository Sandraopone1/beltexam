package com.sandra.coursePlatform.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sandra.coursePlatform.models.Course;
import com.sandra.coursePlatform.models.User;
import com.sandra.coursePlatform.services.CourseService;
import com.sandra.coursePlatform.services.UserService;





@Controller
public class CourseController {
	private CourseService courseService;
	private UserService userService;
	
	public CourseController(CourseService courseService, UserService userService) {
		this.userService = userService;
		this.courseService = courseService;
	}
	
	@RequestMapping("/courses/new")
	public String addCoursePage(@Valid @ModelAttribute("course") Course course) {
		return "newCourse.jsp";
	}

	@PostMapping("/courses/new")
	public String addCourse(@Valid @ModelAttribute("course") Course course, BindingResult result) {
		if (result.hasErrors()) {
			return "newCourse.jsp";
		}
		courseService.create(course);
		return "redirect:/courses";
	}
	
	@RequestMapping("/courses/{id}")
	public String showEvent(@PathVariable("id") long id, Model model) {
		
		model.addAttribute("course", (Course)courseService.findById(id));
		
		return "showCourse.jsp";
	}

	
	@PostMapping("/{id}/edit")
	public String editCourse(@Valid @ModelAttribute("course") Course course, @PathVariable("id") Long course_id, BindingResult result) {
		if (result.hasErrors()) {
			return "editCourse.jsp";
		}
		courseService.create(course);
		return "redirect:/courses";
	}


	@RequestMapping("/{id}/join")
	public String join(Principal principal, @PathVariable("id") Long id, Model model) {
		Course cou = courseService.findById(id);
		
		return "redirect:/courses";
	}
	
	
	@RequestMapping("/{id}/destroy")
	public String deleteCourse(@PathVariable("id") Long course_id) {
		courseService.destroy(course_id);
		return "redirect:/courses";
	}
	
	
	
}
