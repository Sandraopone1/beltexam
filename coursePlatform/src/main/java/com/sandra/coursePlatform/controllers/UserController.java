package com.sandra.coursePlatform.controllers;

import java.security.Principal;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sandra.coursePlatform.models.Course;
import com.sandra.coursePlatform.models.User;
import com.sandra.coursePlatform.services.CourseService;

import com.sandra.coursePlatform.services.UserService;
import com.sandra.coursePlatform.validator.UserValidator;

@Controller
public class UserController {
	private UserService userService;
	private UserValidator userValidator;
	private CourseService courseService;

	    
	    public UserController(UserService userService, UserValidator userValidator, CourseService courseService) {
	        this.userService = userService;
	        this.userValidator = userValidator;
	        this.courseService = courseService;

	    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
    	 userValidator.validate(user, result);    
    	 if (result.hasErrors()) {
             return "loginPage.jsp";
         }
     	
     	if(userService.findByEmail(user.getEmail() ) !=null	) {
     		model.addAttribute("emailError", "Email already exists!");
     		return "loginPage.jsp";
     	}
     	if(userService.findByUsername(user.getUsername() ) !=null ) {
     		model.addAttribute("usernameError", "Username already taken!");
     		return "loginPage.jsp";
     	}
     	 
     	
     	if(userService.all().size() == 0) {
     		userService.saveWithAdmirRole(user);
//     		
     	} else {
     		userService.saveWithUserRole(user);
     	}
     	
         return "redirect:/login";
    }
    
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model, User user) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "loginPage.jsp";
    }
    
    @RequestMapping(value = {"/", "/courses"})
    public String courseHome(Principal principal, Model model) {
    	String email = principal.getName();
        User user = userService.findByEmail(email);
        ArrayList<Course> courses = courseService.all();
		model.addAttribute("courses", courses);
		model.addAttribute("currentUser", user);
        
        return "courses.jsp";
    }
    
    
    
   
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "adminPage.jsp";
    }
   
}
