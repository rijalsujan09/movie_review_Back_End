package com.projectsujan.moviereview.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@NamedQueries({
	@NamedQuery(name = "User.findByUsernameAndOTP", 
			query = "SELECT u FROM User u WHERE u.userName = ?1 and u.otp= ?2"),
		@NamedQuery(name = "User.findByUsernameAndPassword", 
		query = "SELECT u FROM User u WHERE u.userName = ?1 and u.password= ?2"),
		@NamedQuery(name = "User.findByUsername", 
		query = "SELECT u FROM User u WHERE u.userName = ?1")
})
public class User implements Serializable{

	private static final long serialVersionUID = 525508524584090047L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String userName;
	private String email;
	private String password;
	private Boolean otpVerified;
	private String  role;
	private String otp;
	
	@ColumnDefault("true")
	private Boolean active;
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Movie> movies =new ArrayList<>();
	
	@OneToMany(targetEntity=MovieReview.class, mappedBy="reviewer", cascade=CascadeType.ALL, fetch = FetchType.LAZY) 
    private Set<MovieReview> reviews  = new HashSet<>();
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getOtpVerified() {
		return otpVerified;
	}

	public void setOtpVerified(Boolean otpVerified) {
		this.otpVerified = otpVerified;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<MovieReview> getReviews() {
		return reviews;
	}

	public void setReviews(Set<MovieReview> reviews) {
		this.reviews = reviews;
	}
	
	
}
