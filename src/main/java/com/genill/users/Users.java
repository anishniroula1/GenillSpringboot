package com.genill.users;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@Entity
@Table(name="users")
public class Users {
	
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "firstname")
    private String firstName;
    
	@Column(name = "lastname")
	private String lastName;
	
	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "password")
    private String password;
	
	@Column(name = "salt")
	private String salt;
    
    private String confirmPassword;
    
    @Column(name = "account_created_date_time")
	private LocalDateTime accountCreatedDateTime;
	
	private boolean passwordMatching;
	
	/*----Optional when Signing Up ---*/
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "phonenumber")
	private String phoneNumber;
	
	@Column(name = "date_of_birth")
	private String dateOfBirth;
	
	@Column(name = "field_of_study")
	private String fieldOfStudy;
	
	@Column(name = "edu_email")
	private String eduEmail;
	
	@Column(name = "profile_picture")
	private String profilePicture;
	
	public boolean isPasswordMatching() {
        if (password != null) {
            return password.equals(confirmPassword);
        }
        return true;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public LocalDateTime getAccountCreatedDateTime() {
		return accountCreatedDateTime;
	}

	public void setAccountCreatedDateTime(LocalDateTime accountCreatedDateTime) {
		this.accountCreatedDateTime = accountCreatedDateTime;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFieldOfStudy() {
		return fieldOfStudy;
	}

	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}

	public String getEduEmail() {
		return eduEmail;
	}

	public void setEduEmail(String eduEmail) {
		this.eduEmail = eduEmail;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public void setPasswordMatching(boolean passwordMatching) {
		this.passwordMatching = passwordMatching;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	
}
