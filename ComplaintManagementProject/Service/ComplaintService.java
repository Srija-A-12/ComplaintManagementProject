package com.example.ComplaintManagementProject.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ComplaintManagementProject.Model.Authentication;
import com.example.ComplaintManagementProject.Model.Complaint;
import com.example.ComplaintManagementProject.Model.ComplaintUpdates;
import com.example.ComplaintManagementProject.Repo.AuthenRepo;
import com.example.ComplaintManagementProject.Repo.ComplaintRepo;
import com.example.ComplaintManagementProject.Repo.Complaint_update_repo;

@Service
public class ComplaintService {
	
	@Autowired
	private ComplaintRepo complaintRepo; //why this is helpfull for
	@Autowired
	private Complaint_update_repo complaint_update_repo;
	
	
	public Complaint addComplaint(String title,String Description,String category ) {
	     Complaint complaint = new Complaint(title, Description, category); //why object ??
		return complaintRepo.save(complaint);
	}
	
	public List<Complaint> getAllComplaint(){
		return complaintRepo.findAll();
		
	}
	
	
	
	 public Complaint updateStatus(int complaintId, String newStatus, String updateText) {
	        // 1️⃣ Update the main complaint
	        Complaint complaint = complaintRepo.findById(complaintId)
	                .orElseThrow(() -> new RuntimeException("Complaint not found"));
	        complaint.setStatus(newStatus);
	        complaintRepo.save(complaint);


	        ComplaintUpdates update = new ComplaintUpdates();
	        update.setComplaintId(complaintId);
	        update.setComplaintText(updateText);
	        update.setUpdatedTime(LocalDateTime.now());
	        complaint_update_repo.save(update);

	        return complaint;
	    }

	 


}



