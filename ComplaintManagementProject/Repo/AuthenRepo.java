package com.example.ComplaintManagementProject.Repo;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ComplaintManagementProject.Model.Authentication;

@Repository
public interface AuthenRepo extends JpaRepository<Authentication, Integer>{

	Optional<Authentication> findByEmail(String email);
	

}
