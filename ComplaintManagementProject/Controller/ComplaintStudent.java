package com.example.ComplaintManagementProject.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ComplaintManagementProject.Model.Complaint;
import com.example.ComplaintManagementProject.Model.ComplaintUpdates;
import com.example.ComplaintManagementProject.Service.ComplaintService;

@RestController
public class ComplaintStudent {
	@Autowired
	private ComplaintService complaintService;
	
	
	@PostMapping("/Student/Complaint")
	public Complaint raiseComplaint(@RequestParam String title,
									@RequestParam(name = "description") String Description,
									@RequestParam String category) {
			return complaintService.addComplaint(title, Description, category);
		
	}


	
	@GetMapping("/Student/SeeComplaint")
	public List<Complaint> viewComplaints() {
		return complaintService.getAllComplaint();
	}
	
	@PutMapping("/Head/UpdateComplaint")
	public Complaint updateComplaintStatus(@RequestParam int id,
											@RequestParam String status) {
		return complaintService.updateStatus(id, status, status);
	}

	
	

}
