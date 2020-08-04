package com.techleads.app.runner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.techleads.app.model.Review;
import com.techleads.app.repository.CourseRepository;
import com.techleads.app.repository.ReviewRepository;

@Component
@Transactional
public class ReviewRunner implements CommandLineRunner {
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private ReviewRepository reviewRepository;
	private Logger logger = LoggerFactory.getLogger(ReviewRunner.class);

	@Autowired
	private EntityManager em;
	@Override
	public void run(String... args) throws Exception {
		logger.info("Find All Reviews are below");
		reviewRepository.findAllReviews().forEach(System.out::println);
		logger.info("Find All Reviews are above");
		
		logger.info("Find Reviews By ID are below");
		Review findReviewById = reviewRepository.findReviewById(200);
		System.out.println(findReviewById);
		logger.info("Find Reviews By ID are above");
		
		logger.info("Delete Review by Id");
		reviewRepository.deleteReviewById(200);
		logger.info("Delete Review by Id end ");
		
	}

}
