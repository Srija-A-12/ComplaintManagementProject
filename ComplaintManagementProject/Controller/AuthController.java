//package com.example.ComplaintManagementProject.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.ComplaintManagementProject.Service.UserService;
//
//@RestController
//public class AuthController {
//	
//	@Autowired
//	private UserService userService;
//	
//	 @PostMapping("/register")
//	    public String register(@RequestParam String email,
//	                           @RequestParam String password,
//	                           @RequestParam String role) {
//	        userService.registerUser(email, password, role);
//	        return "User registered successfully!";
//	    }
//
//	    @GetMapping("/login")
//	    public String login() {
//	        return "Please login using form-based authentication.";
//	    }
//
//	    @GetMapping("/dashboard")
//	    public String dashboard() {
//	        return "Welcome to the dashboard!";
//	    }
//	}

package com.example.ComplaintManagementProject.Controller;

import com.example.ComplaintManagementProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String role) {
        // Simple validation to ensure role is either STUDENT or TEACHER
        if (!"STUDENT".equalsIgnoreCase(role) && !"TEACHER".equalsIgnoreCase(role)) {
            return "Invalid role specified. Must be 'STUDENT' or 'TEACHER'.";
        }
        userService.registerUser(email, password, role.toUpperCase());
        return "User registered successfully! You can now <a href='/login.html'>login</a>.";
    }

    @GetMapping("/login")
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.status(401).body("User not authenticated");
        }
        Map<String, Object> userDetailsMap = new HashMap<>();
        userDetailsMap.put("username", userDetails.getUsername());
        String role = userDetails.getAuthorities().stream()
                .findFirst()
                .map(grantedAuthority -> grantedAuthority.getAuthority().replace("ROLE_", ""))
                .orElse("UNKNOWN");
        userDetailsMap.put("role", role);

        return ResponseEntity.ok(userDetailsMap);
    }
}

