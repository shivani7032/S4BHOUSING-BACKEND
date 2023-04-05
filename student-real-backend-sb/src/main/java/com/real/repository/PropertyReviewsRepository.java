package com.real.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.real.models.PropertyReviews;

@Repository
public interface PropertyReviewsRepository extends JpaRepository<PropertyReviews, Long> {

}
