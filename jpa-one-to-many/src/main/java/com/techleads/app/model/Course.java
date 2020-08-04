package com.techleads.app.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@NamedQueries(value = { @NamedQuery(name = "FIND_ALL_COURSES", query = "SELECT C FROM COURSE C"),
//		@NamedQuery(name = "FIND_ALL_COURSES_CONTAINS_Kuber", query = "SELECT C FROM COURSE C WHERE C.name like '%Kuber%'") })

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "course_seq", initialValue = 2001, allocationSize = 1)
@ToString(exclude="reviews")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	private Integer id;
	private String name;

	public Course(String name) {
		super();
		this.name = name;
	}
//By default fetch strategy is lazy
	//@OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
	private List<Review> reviews = new ArrayList<>();
	@UpdateTimestamp
	@Column(name = "LAST_UPDATED")
	private LocalDateTime lastUpdatedDate;
	@CreationTimestamp
	@Column(name = "CREATED_DATE")
	private LocalDateTime createdDate;

}
