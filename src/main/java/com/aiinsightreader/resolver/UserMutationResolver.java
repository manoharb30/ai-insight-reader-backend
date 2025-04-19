package com.aiinsightreader.resolver;

import com.aiinsightreader.model.Role;
import com.aiinsightreader.model.User;
import com.aiinsightreader.repository.UserRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(String email, String password, String name, String role) {
        System.out.println("🚀 createUser triggered with email: " + email);
    
        if (userRepository.findByEmail(email).isPresent()) {
            System.out.println("⚠️ Email already exists: " + email);
            throw new RuntimeException("Email already in use.");
        }
    
        Role userRole;
        try {
            userRole = Role.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Invalid role passed: " + role);
            throw new RuntimeException("Invalid role: " + role);
        }
    
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setName(name);
        user.setRole(userRole);
        user.setCredits(0);
        user.setSubscriptionActive(false);
        user.setEmailVerified(false);
        user.setActive(true);
    
        User saved = userRepository.save(user);
        System.out.println("✅ User saved with ID: " + saved.getId());
        return saved;
    }
    
}
