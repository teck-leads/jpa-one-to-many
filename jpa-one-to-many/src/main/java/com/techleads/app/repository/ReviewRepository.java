package com.techleads.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techleads.app.model.Review;
@Transactional
@Repository
public class ReviewRepository {
	private static Logger logger =LoggerFactory.getLogger(CourseRepository.class);
	@Autowired
	private EntityManager entityManager;
	
	public Review findReviewById(Integer reviewId) {
		Review review = entityManager.find(Review.class, reviewId);
		return review;
	}
	public void deleteReviewById(Integer reviewId) {
		Review findReviewById = findReviewById(reviewId);
		entityManager.remove(findReviewById);
	}
	
	public List<Review> findAllReviews() {
		TypedQuery<Review> createNamedQuery = entityManager.createNamedQuery("FIND_ALL_REVIEWS", Review.class);
		List<Review> resultList = createNamedQuery.getResultList();
		return resultList;
	}

}
