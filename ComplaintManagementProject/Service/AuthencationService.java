package com.example.ComplaintManagementProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ComplaintManagementProject.Model.Authentication;
import com.example.ComplaintManagementProject.Repo.AuthenRepo;

@Service
public class AuthencationService implements UserDetailsService{
	
	@Autowired
	private AuthenRepo authenRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		Authentication auth=authenRepo.findByEmail(email)
				.orElseThrow(()-> new UsernameNotFoundException("User not found"));
		
				return User.builder()
					.username(auth.getEmail())
					.password(auth.getPassword())
					.roles(auth.getRole())
					.build();
	}
	

}
