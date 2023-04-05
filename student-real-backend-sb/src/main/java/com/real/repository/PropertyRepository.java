package com.real.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.real.models.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

	@Query(value = "SELECT *, ( 3959 * acos( cos( radians(?1) ) * cos( radians( p_lat ) ) "
			+ "    * cos( radians( p_long ) - radians(?2) ) + sin( radians(?1) ) * sin(radians(p_lat)) ) ) AS distance  "
			+ "FROM properties "
			+ "HAVING distance < ?3 "
			+ "ORDER BY distance; ", nativeQuery = true)
	List<Property> findByLatLongRadius(String p_lat, String p_long, int radius);
	
	List<Property> findByUserid(long userid);
	
	
	
	   @Query(value = "SELECT * "
	   		+ "	FROM properties "
	   		+ "	 WHERE p_long  BETWEEN ?1 AND ?2 "
	   		+ "	 AND p_lat BETWEEN ?3 AND ?4", nativeQuery = true)
		List<Property> findByBounds(double a, double b, double c, double d);
}
