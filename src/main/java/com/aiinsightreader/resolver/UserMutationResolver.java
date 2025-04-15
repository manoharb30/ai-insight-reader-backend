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
        // Prevent duplicate email
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email already in use.");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setName(name);
        user.setRole(Role.valueOf(role.toUpperCase()));
        user.setCredits(0);
        user.setSubscriptionActive(false);
        user.setEmailVerified(false);
        user.setActive(true);

        return userRepository.save(user);
    }
}
