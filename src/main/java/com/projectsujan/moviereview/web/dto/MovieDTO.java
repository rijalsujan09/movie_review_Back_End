package com.projectsujan.moviereview.web.dto;

import java.math.BigDecimal;

import com.projectsujan.moviereview.entity.Category;
import com.projectsujan.moviereview.entity.User;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class MovieDTO {

	private Long id;

	@NotNull(message = "Name field can't be empty")
	@NotBlank(message = "Name can't be blank")
	private String name;

	private Float aggregatedRating;

	private BigDecimal budget;

	private String synopsis;

	private Boolean active;
	
	private Category category;

	private User user;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getAggregatedRating() {
		return aggregatedRating;
	}

	public void setAggregatedRating(Float aggregatedRating) {
		this.aggregatedRating = aggregatedRating;
	}

	public BigDecimal getBudget() {
		return budget;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	

	public MovieDTO() {
		
	}

	public MovieDTO(String name,Float aggregatedRating, BigDecimal budget, String synopsis, Boolean active) {
		this.name = name;
		this.aggregatedRating = aggregatedRating;
		this.budget = budget;
		this.synopsis = synopsis;
		this.active = active;
	}

	public Category getCategory(Category category2) {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser(User user2) {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	
}
