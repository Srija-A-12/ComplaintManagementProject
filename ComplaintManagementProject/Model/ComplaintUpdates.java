package com.example.ComplaintManagementProject.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ComplaintUpdates {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(name="complaint_id")
	    private int complaintId;

	    @Column(name="complaint_text")
	    private String complaintText;

	    @Column(name="updated_time")
	    private LocalDateTime updatedTime;

	
	public ComplaintUpdates() {
		
	}
	
	public ComplaintUpdates(int complaintId, String complaintText, LocalDateTime updatedTime) {
		this.complaintId = complaintId;
		this.complaintText = complaintText;
		this.updatedTime = updatedTime;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}
	public String getComplaintText() {
		return complaintText;
	}
	public void setComplaintText(String complaintText) {
		this.complaintText = complaintText;
	}
	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	
	
	
}

