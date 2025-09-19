package com.example.ComplaintManagementProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ComplaintManagementProject.Model.Complaint;

public interface ComplaintRepo extends JpaRepository<Complaint, Integer>{

}
