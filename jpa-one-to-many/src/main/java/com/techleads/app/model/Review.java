package com.techleads.app.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NamedQueries(value = { 
		@NamedQuery(name = "FIND_ALL_REVIEWS", query = "SELECT r FROM REVIEW r")
		})

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "REVIEW")
@SequenceGenerator(name = "review_seq", initialValue = 500, allocationSize = 1)
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_seq")
	private Integer id;
	private String description;
	private String rating ;

	@ManyToOne
	private Course course;
	

	public Review(String description, String rating) {
		this.description = description;
		this.rating = rating;
	}
	@UpdateTimestamp
	@Column(name = "LAST_UPDATED")
	private LocalDateTime lastUpdatedDate;
	@CreationTimestamp
	@Column(name = "CREATED_DATE")
	private LocalDateTime createdDate;

}
