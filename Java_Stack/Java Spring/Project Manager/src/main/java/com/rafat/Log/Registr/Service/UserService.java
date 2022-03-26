package com.rafat.Log.Registr.Service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.rafat.Log.Registr.Repository.UserRepository;
import com.rafat.Log.Registr.models.LoginUser;
import com.rafat.Log.Registr.models.User;
@Service
	public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {
        
    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
    	if (potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "Email already exists");
    	}
    	
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
    	
    	String toCheckPattern = newUser.getFirstName();
    	if (!toCheckPattern.matches("[a-zA-Z]+")) {
    		 result.rejectValue("firstName", "Matches", "Must contain letters only");
		}
    	String toCheck = newUser.getLastName();
    	if (!toCheck.matches("[a-zA-Z]+")) {
    		 result.rejectValue("lastName", "Matches", "Must contain letters only");
		}
    	
    	if (result.hasErrors()) {
    		return null;
    	}
    	else {
        	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        	newUser.setPassword(hashed);
        	userRepo.save(newUser);
            return newUser;
    	} 
    }
	public User login(LoginUser newLoginObject, BindingResult result) {

		Optional<User> u = userRepo.findByEmail(newLoginObject.getEmail());

		if (!u.isPresent()) {

			result.rejectValue("email", "Matches", "Invalid Email or Password!");
		} else if (!BCrypt.checkpw(newLoginObject.getPassword(), u.get().getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Email or Password!");
		}

		if (result.hasErrors()) {
			return null;
		}

		return u.get();

	}

	public User findUserByEmail(String email) {
		Optional<User> u = userRepo.findByEmail(email);
		if (u.isPresent()) {
			User user = u.get();
			return user;
		} else {
			return null;
		}

	}
	public User findUserById(Long id) {
		Optional<User> u = userRepo.findById(id);
		if (u.isPresent()) {
			User user = u.get();
			return user;
		} else {
			return null;
		}

	}

	public void deleteUser(Long id) {
		User user = this.findUserById(id);
		userRepo.delete(user);

	}
}
