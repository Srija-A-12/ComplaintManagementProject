//package com.example.ComplaintManagementProject.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.example.ComplaintManagementProject.Model.Authentication;
//import com.example.ComplaintManagementProject.Repo.AuthenRepo;
//
//@Service
//public class UserService {
//	@Autowired
//	private AuthenRepo authenRepo;
//	
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//	
//	public Authentication registerUser(String email,String password,String role) {
//		// SERVER-SIDE VALIDATION: Ensure only @srmist.edu.in emails can register.
//        if (email == null || !email.toLowerCase().endsWith("@srmist.edu.in")) {
//            throw new IllegalArgumentException("Registration is restricted to @srmist.edu.in email addresses only.");
//        }
//        
//        // Prevent duplicate user registration
//        if (authenRepo.findByEmail(email).isPresent()) {
//            throw new IllegalArgumentException("An account with this email address already exists.");
//        }
//
//		Authentication auth=new Authentication();
//		auth.setEmail(email);
//		auth.setPassword(password);
//		auth.setRole(role);
//		return authenRepo.save(auth);
//	}
//	
//
//}

package com.example.ComplaintManagementProject.Service;

import com.example.ComplaintManagementProject.Model.Authentication; // Using your Authentication model
import com.example.ComplaintManagementProject.Repo.AuthenRepo;   // Using your AuthenRepo repository
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

        // Create an instance of the Model, not the Repository
        Authentication user = new Authentication();
        user.setEmail(email);

        // This correctly encrypts the password before saving.
        user.setPassword(passwordEncoder.encode(password));

        user.setRole(role.toUpperCase()); // Store roles in uppercase for consistency
        
        // Save the new user object using the repository
        return authenRepo.save(user);
    }
}

