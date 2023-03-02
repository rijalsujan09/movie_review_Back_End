package com.projectsujan.moviereview.web.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.ColumnDefault;

public class ReviewDTO implements Serializable {

	private static final long serialVersionUID = 5365174850483326598L;

	private Long id;

	private String review;

	@ColumnDefault("true")
	private Boolean active;

	private Date createDate;

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}


	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ReviewDTO() {
		super();
		
	}
	
	

}
