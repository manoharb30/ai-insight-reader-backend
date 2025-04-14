package com.aiinsightreader.resolver;

import com.aiinsightreader.model.Role;
import com.aiinsightreader.model.User;
import com.aiinsightreader.repository.UserRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMutationResolver implements GraphQLMutationResolver {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserMutationResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String email, String password, String name, String role) {
        User user = User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .name(name)
                .role(Role.valueOf(role.toUpperCase()))
                .isActive(true)
                .isEmailVerified(false)
                .subscriptionActive(false)
                .credits(10)
                .build();
        return userRepository.save(user);
    }
}
