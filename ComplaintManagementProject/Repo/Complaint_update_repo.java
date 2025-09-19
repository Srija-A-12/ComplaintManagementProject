package com.example.ComplaintManagementProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ComplaintManagementProject.Model.ComplaintUpdates;

public interface Complaint_update_repo extends JpaRepository<ComplaintUpdates, Integer>{

}