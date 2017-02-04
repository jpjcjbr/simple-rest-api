package br.com.geoambiente.collect.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Collect {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "creationDate")
	private LocalDateTime date;

	private String description;

	private String location;
	
	public Collect(LocalDateTime date, String description, String location) {
		this.date = date;
		this.description = description;
		this.location = location;
	}
	
	public Collect() {
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
