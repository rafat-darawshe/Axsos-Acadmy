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
		if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Unique", "This email is already in use!");
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
		if(result.hasErrors()) {
			return null;
		} else {
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashed);
			return userRepo.save(newUser);
		}
	}
	public User login(LoginUser newLogin, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "Unique", "Unknown email!");
			return null;
		}
		User user = potentialUser.get();
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}
		if(result.hasErrors()) {
			return null;
		} else {
			return user;
		}
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
