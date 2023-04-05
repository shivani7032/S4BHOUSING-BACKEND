package com.real.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.real.models.Property;
import com.real.models.PropertyInerests;
import com.real.models.PropertyReviews;
import com.real.payload.response.MessageResponse;
import com.real.repository.PropertyImagesRepository;
import com.real.repository.PropertyInterestsRepository;
import com.real.repository.PropertyRepository;
import com.real.repository.PropertyReviewsRepository;
import com.real.repository.UserRepository;

@RestController
@RequestMapping("/api/property")
public class PropertyController {
	
	@Autowired
	PropertyRepository propertyRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PropertyImagesRepository propertyImagesRepository;
	
	@Autowired
	PropertyInterestsRepository propertyInterestsRepository;
	
	@Autowired
	PropertyReviewsRepository propertyReviewsRepository;
	
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	
	@PostMapping("/create")
	public ResponseEntity<?> registerUser(@Valid @RequestBody Property property) {

		propertyRepository.save(property);

		return ResponseEntity.ok(new MessageResponse("Property created successfully!"));
	}
	
	@PostMapping("/updateinterest")
	public ResponseEntity<?> interestUpdate(@Valid @RequestBody PropertyInerests interests) {

		propertyInterestsRepository.save(interests);

		return ResponseEntity.ok(new MessageResponse("Property Interest sent successfully!"));
	}
	
	@PostMapping("/updatereview")
	public ResponseEntity<?> reviewUpdate(@Valid @RequestBody PropertyReviews reviews) {

		propertyReviewsRepository.save(reviews);

		return ResponseEntity.ok(new MessageResponse("Property review sent successfully!"));
	}
	
	@GetMapping("get/getproperties")
	public List<Property> getProperties() {		
		return propertyRepository.findAll();		
	}
	
	@GetMapping("get/getproperty/{id}")
	public Optional<Property> getEmployeeById(@PathVariable(value = "id") Long p_id) {
	    return propertyRepository.findById(p_id);
	}
	
	@GetMapping("get/getproperties/{lat}/{lng}/{rad}")
	public List<Property> getPropertiesbyLatLongRadius(@PathVariable(value = "lat") String p_lat, @PathVariable(value = "lng") String p_long, @PathVariable(value = "rad") int radius) {		
		return propertyRepository.findByLatLongRadius(p_lat, p_long, radius);		
	}
	
	@GetMapping("get/getpropertiesbybounds/{east}/{west}/{south}/{north}")
	public List<Property> getPropertiesbyBounds(@PathVariable(value = "east") String east, @PathVariable(value = "west") String west, @PathVariable(value = "south") String south, @PathVariable(value = "north") String north) {
		double e = Double.parseDouble(east);
		double w = Double.parseDouble(west);
		double s = Double.parseDouble(south);
		double n = Double.parseDouble(north);
		double a,b,c,d = 0;
		
		if(e > w) {
			a = w;
			b = e;
		}else {
			a = e;
			b = w;
		}
		if(s > n) {
			c = n;
			d = s;
		}else {
			c = s;
			d = n;
		}
		return propertyRepository.findByBounds(a, b, c, d);		
	}
	
	@GetMapping("getproperties/{user_id}")
	public List<Property> getPropertiesbyUserid(@PathVariable(value = "user_id") long user_id) {		
		return propertyRepository.findByUserid(user_id);		
	}
	
}
