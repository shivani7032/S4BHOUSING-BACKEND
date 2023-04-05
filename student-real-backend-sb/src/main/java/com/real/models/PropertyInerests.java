package com.real.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "property_interests")
public class PropertyInerests {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  
	  private long p_id;
	  
	  
	  private long user_id;
	  
	 
	  private String message;
	  
	  @OneToOne(targetEntity = User.class,cascade = CascadeType.ALL)	  
	  @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)	
	  private User user;
	 	 
}
