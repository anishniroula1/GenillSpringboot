package com.genill.users;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserMap {

	public Object mapToUser(Users user) {
		Map<String, Object> userMap = new HashMap<>();
		userMap.put("firstName", user.getFirstName());
		userMap.put("lastName", user.getLastName());
		userMap.put("username", user.getUsername());
		userMap.put("accountCreatedDateTime", user.getAccountCreatedDateTime());
		userMap.put("email", user.getEmail());
		userMap.put("eduEmail", user.getEduEmail());
		userMap.put("gender", user.getGender());
		userMap.put("profilePicture", user.getProfilePicture());
		userMap.put("phoneNumber", user.getPhoneNumber());
		userMap.put("fieldOfStudy", user.getFieldOfStudy());
		return userMap;
	}
}
