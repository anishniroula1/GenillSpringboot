package com.genill.restApi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.genill.authentication.JwtTokenHandler;
import com.genill.authentication.RequestAuthProvider;
import com.genill.authentication.UnauthorizedException;
import com.genill.authentication.UserCreationException;
import com.genill.emailService.EmailServiceImpl;
import com.genill.users.UserMap;
import com.genill.users.UserService;
import com.genill.users.Users;

@CrossOrigin()
@RestController
@RequestMapping("genill/api")
public class UsersAuthApi {
	@Autowired
	private RequestAuthProvider auth;

	@Autowired
	private JwtTokenHandler tokenHandler;
	
	@Autowired
	private UserService userService;
	
	@Autowired(required = true)
	private EmailServiceImpl emailService;
	
	@Autowired
	private UserMap userMap;
	
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@RequestBody Users user) throws UnauthorizedException {

		if (auth.signIn(user.getUsername(), user.getPassword())) {
			Users currentUser = auth.getCurrentUser();
			tokenHandler.createToken(user.getUsername(), currentUser.getRole());

			return user.getUsername();

		} else {
			throw new UnauthorizedException();
		}
	}
	
	@PostMapping(path = "/register")
	@ResponseStatus(HttpStatus.CREATED)
	public String register(@Valid @RequestBody Users user, BindingResult result) throws UserCreationException {
		if (result.hasErrors()) {
			String errorMessages = "";
			for (ObjectError error : result.getAllErrors()) {
				errorMessages += error.getDefaultMessage() + "\n";
			}
			throw new UserCreationException(errorMessages);
		}
		user.setRole("user");
		emailService.sendSimpleMessage(user.getEmail(), user.getEmail());
		auth.register(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(), user.getRole(),
				user.getEmail());
		return user.getUsername();
	}
	
	@GetMapping("/logout") 
	public String logOut() {
		auth.logOff();
		return "logout Success";
	}
	
	@GetMapping("/username/{username}")
	public Object getUserByUsername(@PathVariable String username) {
		Users user = userService.getUserByUsername(username);
		return userMap.mapToUser(user);
	}
	

	@GetMapping("/users")
	public List<Users> getAllUsers() {
		return userService.getAllUsers();
	}
}
