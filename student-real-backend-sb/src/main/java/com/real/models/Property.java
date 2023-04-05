package com.real.models;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "properties")
public class Property {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long p_id;

  private String p_name;
  
  private String p_description;
  
  private String p_type;
  
  private String p_rent_buy;
  
  private String p_address;
  
  private String p_city;
  
  private String p_locality;
  
  private String p_zipcode;
  
  private String p_lat;
  
  private String p_long;
  
  private int p_no_of_bedroom;
  
  private double p_no_of_bathroom;
  
  private Date p_creation_date;
  
  private String p_status;
  
  private int p_price;
  
  private int p_built_area;
  
  private int p_cover_area;
  
  private long userid;
  
	/*
	 * @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 * 
	 * @JoinColumn(name = "id", nullable = false)
	 * 
	 * @OnDelete(action = OnDeleteAction.CASCADE) private User user;
	 */

	
	  @OneToMany(targetEntity = PropertyImages.class,cascade = CascadeType.ALL)	  
	  @JoinColumn(name = "p_id_fk", referencedColumnName = "p_id")	  
	  @OnDelete(action = OnDeleteAction.CASCADE) 
	  private List<PropertyImages> propertyImages;
	  
	  @OneToMany(targetEntity = PropertyReviews.class,cascade = CascadeType.ALL)	  
	  @JoinColumn(name = "p_id", referencedColumnName = "p_id")	  
	  @OnDelete(action = OnDeleteAction.CASCADE) 
	  private List<PropertyReviews> propertyReviews;
	  
	  @OneToMany(targetEntity = PropertyInerests.class,cascade = CascadeType.ALL)	  
	  @JoinColumn(name = "p_id", referencedColumnName = "p_id")	  
	  @OnDelete(action = OnDeleteAction.CASCADE) 
	  private List<PropertyInerests> propertyInterests;
	 
  
}
