package br.com.example.collect.controller.dto;

import java.time.LocalDateTime;

public class CollectFilter {

	private LocalDateTime start;
	
	private LocalDateTime end;
	
	private String description;
	
	private String location;

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
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

	public boolean hasValidDates() {
		return getStart() != null && getEnd() != null;
	}
}
