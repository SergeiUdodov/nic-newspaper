package com.nic.newspaper.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.nic.newspaper.validation.FieldMatch;
import com.nic.newspaper.validation.ValidEmail;

@FieldMatch.List({
    @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
public class CrmUser {

	@NotNull(message = "Необходимо ввести имя")
	@Size(min = 1, message = "Необходимо ввести имя")
	private String userName;

	@NotNull(message = "Необходимо ввести пароль")
	@Size(min = 1, message = "Необходимо ввести пароль")
	private String password;
	
	@NotNull(message = "Необходимо подтвердить пароль")
	@Size(min = 1, message = "Необходимо подтвердить пароль")
	private String matchingPassword;

	@NotNull(message = "Необходимо ввести имя")
	@Size(min = 1, message = "Необходимо ввести имя")
	private String firstName;

	@NotNull(message = "Необходимо ввести фамилию")
	@Size(min = 1, message = "Необходимо ввести фамилию")
	private String lastName;

	@ValidEmail
	@NotNull(message = "Необходимо ввести email")
	@Size(min = 1, message = "Необходимо ввести email")
	private String email;

	public CrmUser() {

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
