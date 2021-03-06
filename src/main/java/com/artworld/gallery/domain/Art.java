package com.artworld.gallery.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Art {
	
	//The primary key field. Each art object will include an unique, 
	//automatically generated, permanent number
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	
	//The name field cannot have a null value and none of the 
	//generated objects can have a same name
	@Column(nullable=false, unique=true)
	private String name;
	
	//The year field, on the other hand, isn't mandatory
	private int year;
	
	
	//
	@ManyToOne
	@JoinColumn(name = "mediumid")
	private Medium medium;
	
	@ManyToOne
	@JoinColumn(name = "artistid")
	private Artist artist;

	
	//A constructor with all the user-managed fields for object creation
	public Art(String name, Artist artist, int year, Medium medium) {
		super();
		//These sentences below permit the use of DI
		this.name = name;
		this.artist = artist;
		this.year = year;
		this.medium = medium;
	}

	// A constructor without any of the fields, so the object can be
	//created without anything written
	public Art() {}


	//The getters for each field to fetch any  written data, 
	//including id, from an object
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}
	
	public Medium getMedium() {
		return medium;
	}

	public Artist getArtist() {
		return artist;
	}

	
	//The setters for rewriting data fields of an object 
	//We may not need to edit ID, but this one is none the less
	//important when it comes to modifying an existing object without 
	//creating duplication
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public void setMedium(Medium medium) {
		this.medium = medium;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
}
