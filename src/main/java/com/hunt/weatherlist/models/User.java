package com.hunt.weatherlist.models;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection="users") 
public class User implements UserDetails {
	private static final long serialVersionUID = 1L;

	private String firstName, lastName, email;
	
	@Indexed(unique=true)
	private String username;
	private String password;
	
	private Photo profilePicture;
		
	@Id
	private String id;
	
	@JsonIgnore
	private boolean enabled;
	
	public User() {
	}
	
	private User(Builder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.email = builder.email;
		this.username = builder.username;
		this.password = builder.password;
		this.profilePicture = builder.profilePicture;
		this.enabled = builder.enabled;
	}
	
//	@Override
//	public String toString() {
//		return "[ name: " + getFirstName() + " " + getLastName() + 
//				", username: " + getUsername() +
//				", password: " + getPassword() +
//				", enabled: " + isEnabled() + 
//				" ]";
//	}
	
	
	
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", profilePicture=" + profilePicture + ", id=" + id + ", enabled="
				+ enabled + "]";
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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



	public Photo getProfilePicture() {
		return profilePicture;
	}



	public void setProfilePicture(Photo profilePicture) {
		this.profilePicture = profilePicture;
	}


	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}




	
	public static class Builder {
		private String firstName, lastName, email, username, password;
		Photo profilePicture;
        private Boolean enabled;
		
		@Id
		private String id;
		
		public Builder id( String id) {
			this.id = id;
			return this;
		}
		
		public Builder firstName( String firstName ) {
			this.firstName = firstName;
			return this;
		}
		
		public Builder lastName( String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public Builder email( String email ) {
			this.email = email;
			return this;
		}
		
		public Builder username( String username ) {
			this.username = username;
			return this;
		}
		
		public Builder password( String password ) {
			this.password = password;
			return this;
		}
		
		public Builder enabled(Boolean enabled) {
        	this.enabled = enabled;
        	return this;
        }
		
		public User build() {
			return new User(this);
		}
	}

	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		return this.enabled;
	}
}
