package com.genill.user.profile;

import org.springframework.web.multipart.MultipartFile;

public class ProfilePicture {

	private MultipartFile profileImage;
	private String profileImageName;

	
	public MultipartFile getProfileImage() {
	return profileImage;
	}
	public void setProfileImage(MultipartFile profileImage) {
	this.profileImage = profileImage;
	}

	public String getProfileImageName() {
		return profileImageName;
	}
	public void setProfileImageName(String profileImageName) {
		this.profileImageName = profileImageName;
	}
	
	
}
