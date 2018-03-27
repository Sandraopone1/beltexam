package com.sandra.coursePlatform.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sandra.coursePlatform.models.Role;
import com.sandra.coursePlatform.models.User;
import com.sandra.coursePlatform.repositories.RoleRepository;
import com.sandra.coursePlatform.repositories.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        init();
    }
    		
    			
    public void init() {
    	if(roleRepository.findAll().size() < 1) {
    		Role user = new Role();
    		user.setName("ROLE_USER");
    		
    		Role admin = new Role();
    		admin.setName("ROLE_ADMIN");
    		
    		roleRepository.save(user);
    		roleRepository.save(admin);
    		
    	}
}
    
  public void saveWithUserRole(User user) {
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
     
    
   public void  saveWithAdmirRole( User user) {
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
       userRepository.save(user);
   }        
    
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public User findByEmail(String email) {
        return userRepository.findByUsername(email);
    }
    
   public User getById(Long id) {
    		return userRepository.findById(id).orElse(null);
    		}
   
   public ArrayList<User> all() {
		return (ArrayList<User>) userRepository.findAll();
   }
    
    public void update(User user){userRepository.save(user);}
	public void destroy(long id){userRepository.deleteById(id);}

    

//public void create(String[] roles,User user){
//	List<Role> userRoles = new ArrayList<>();
//	
//	for(String role:roles){
//		Role getRole = (Role) roleRepository.findByName(role);
//		if(getRole != null){userRoles.add(getRole);}
//	}
//			
//	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//	user.setRoles(userRoles);
//	userRepository.save(user);
//}
}