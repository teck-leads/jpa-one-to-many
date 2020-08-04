package com.techleads.app.runner;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.techleads.app.model.Course;
import com.techleads.app.model.Review;
import com.techleads.app.repository.CourseRepository;
import com.techleads.app.repository.ReviewRepository;

//@Component
@Transactional
public class CourseRunner implements CommandLineRunner {
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private ReviewRepository reviewRepository;
	private Logger logger = LoggerFactory.getLogger(CourseRepository.class);

	@Autowired
	private EntityManager em;
	@Override
	public void run(String... args) throws Exception {
		/*
		 * System.out.println("==========findById(-) From JPA Repository==============="
		 * ); Course course = courseRepository.findById(101);
		 * System.out.println(course);
		 * System.out.println("==========findById(-) From JPA Repository==============="
		 * ); //courseRepository.deleteById(101); System.out.
		 * println("=====Again=====findById(-) From JPA Repository===============");
		 * course = courseRepository.findById(101); System.out.println(course);
		 * 
		 * System.out.
		 * println("==========Save or update entity(-) From JPA Repository==============="
		 * ); Course inserUpdate = courseRepository.inserUpdate(new
		 * Course("Apache Kafka")); System.out.println(inserUpdate);
		 * 
		 * System.out.
		 * println("=========playWithEntityManger() From JPA Repository==============="
		 * ); courseRepository.playWithEntityManger();
		 * 
		 * System.out.println("==========findAll() From JPA Repository===============");
		 * List<Course> findAll = courseRepository.findAll();
		 * findAll.forEach(System.out::println);
		 */
		
		logger.info("=>{} Adding a Review for a course");
		Review review =new Review("Very nice course", "5");
		Course course = courseRepository.addReview(101, review);
		logger.info("Course details=>{} ",course);
		
		 logger.info("=>{} END Adding a Review for a course");
		 
		 logger.info("=>{} Get Review by Id");
		 Review findReviewById = reviewRepository.findReviewById(500);
			
		 logger.info("Review details "+findReviewById.toString());
			logger.info("Course details=>{} ",course);
			
			 logger.info("=>{} END Adding a Review for a course");
			
		
	}

}
