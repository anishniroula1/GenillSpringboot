package com.genill.user.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genill.exception.ResourceNotFoundException;
import com.genill.users.Users;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepo;
	
	public Users checkUsernameExist(String username) {
		Users user = profileRepo.findByUsername(username);
		user.getFirstName();
		user.getLastName();
		user.getUsername();
		
		return user;
		
	}
	public Users checkUserByEmail(String email) {
		Users user = profileRepo.findByEmail(email);
		user.getFirstName();
		user.getLastName();
		user.getEmail();
		return user;
		
	}
	
	public Users saveProfileImage(ProfilePicture saveImage, String username) {
		String imageName = saveImage.getProfileImageName();
		return profileRepo.findById(username).map( user -> {
			user.setProfilePicture(imageName);
			return profileRepo.save(user);
		}).orElseThrow(() -> new ResourceNotFoundException("Somthing went wrong "));
		
	}
}
