package com.example.ComplaintManagementProject.Service;

import com.example.ComplaintManagementProject.Model.Authentication;
import com.example.ComplaintManagementProject.Repo.AuthenRepo;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AuthenRepo authenRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Authentication registerUser(String email, String password, String role) {
        // SERVER-SIDE VALIDATION: Ensure only @srmist.edu.in emails can register.
        if (email == null || !email.toLowerCase().endsWith("@srmist.edu.in")) {
            throw new IllegalArgumentException("Registration is restricted to @srmist.edu.in email addresses only.");
        }

        // Prevent duplicate user registration
        if (authenRepo.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("An account with this email address already exists.");
        }
        Authentication user = new Authentication();
        user.setEmail(email);

        // This correctly encrypts the password before saving.
        user.setPassword(passwordEncoder.encode(password));

        user.setRole(role.toUpperCase()); // Store roles in uppercase for consistency
        
        return authenRepo.save(user);
    }
}


