package com.real.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.real.models.PropertyInerests;

@Repository
public interface PropertyInterestsRepository extends JpaRepository<PropertyInerests, Long> {

}
