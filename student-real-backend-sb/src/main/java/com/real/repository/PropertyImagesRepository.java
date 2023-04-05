package com.real.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.real.models.PropertyImages;

@Repository
public interface PropertyImagesRepository extends JpaRepository<PropertyImages, Long> {

}
