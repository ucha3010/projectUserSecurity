package com.udemy.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="user_security")
public class User {

	@Id
	@Column(name = "username", unique = true)
	@NotNull
	@Length(max = 45)
	private String username;
	
	@NotNull
	@Length(max = 60)
	private String password;
	
	@NotNull
	private boolean enabled;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<UserRole>();
	
	private boolean accountNonExpired;
	private boolean credentialsNonExpired;
	private boolean accountNonLocked;
	private String name;
	private String lastname;
	private Date bithday;
	
	public User() {
	}

	public User(@NotNull @Length(max = 45) String username, @NotNull @Length(max = 60) String password,
			@NotNull boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(@NotNull @Length(max = 45) String username, @NotNull @Length(max = 60) String password,
			@NotNull boolean enabled, Set<UserRole> userRole) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}

	public User(@NotNull @Length(max = 45) String username, @NotNull @Length(max = 60) String password,
			@NotNull boolean enabled, Set<UserRole> userRole, boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
		this.accountNonExpired = accountNonExpired;
		this.credentialsNonExpired = credentialsNonExpired;
		this.accountNonLocked = accountNonLocked;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBithday() {
		return bithday;
	}

	public void setBithday(Date bithday) {
		this.bithday = bithday;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", enabled=" + enabled + ", userRole="
				+ userRole + ", accountNonExpired=" + accountNonExpired + ", credentialsNonExpired="
				+ credentialsNonExpired + ", accountNonLocked=" + accountNonLocked + ", name=" + name + ", lastname="
				+ lastname + ", bithday=" + bithday + "]";
	}

}
