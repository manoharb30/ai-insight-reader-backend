package com.aiinsightreader.resolver;

import com.aiinsightreader.model.User;
import com.aiinsightreader.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserResolver {

    @Autowired
    private UserRepository userRepository;

    @QueryMapping
    public User getUserByEmail(@Argument String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @QueryMapping
    public List<User> users() {
        return userRepository.findAll();
    }
}
