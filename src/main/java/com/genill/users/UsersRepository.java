package com.genill.users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.genill.user.profile.ProfilePicture;

public interface UsersRepository extends CrudRepository<Users, String> {
	

	public Users findByUsername(String username);
	
}
