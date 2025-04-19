package com.aiinsightreader.resolver;

import com.aiinsightreader.model.Role;
import com.aiinsightreader.model.User;
import com.aiinsightreader.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
public class UserMutationResolver {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @MutationMapping
    public User createUser(
        @Argument String email,
        @Argument String password,
        @Argument String name,
        @Argument Role role
    ) {
        System.out.println("🚀 createUser called with email: " + email + ", role: " + role);

        if (userRepository.findByEmail(email).isPresent()) {
            System.out.println("❌ Email already exists: " + email);
            throw new RuntimeException("Email already in use.");
        }

        // Role userRole;
        // try {
        //     userRole = Role.valueOf(role.toUpperCase());
        // } catch (IllegalArgumentException ex) {
        //     System.out.println("❌ Invalid role passed: " + role);
        //     throw new RuntimeException("Invalid role: " + role + ". Allowed values: " + String.join(", ", Role.names()));
        // }

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setName(name);
        user.setRole(role);
        user.setCredits(0);
        user.setSubscriptionActive(false);
        user.setEmailVerified(false);
        user.setActive(true);

        User saved = userRepository.save(user);
        System.out.println("✅ User created with ID: " + saved.getId());
        return saved;
    }
}
