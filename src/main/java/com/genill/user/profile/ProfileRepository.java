package com.genill.user.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.genill.users.Users;

public interface ProfileRepository extends JpaRepository<Users, String> {

	public Users findByUsername(String username);
	
	public Users findByEmail(String email);
	
}
