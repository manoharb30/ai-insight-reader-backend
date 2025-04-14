package com.aiinsightreader.resolver;

import com.aiinsightreader.model.User;
import com.aiinsightreader.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class UserResolver {

    private final UserService userService;

    public UserResolver(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    public User getUserByEmail(@Argument String email) {
        Optional<User> user = userService.getUserByEmail(email);
        return user.orElse(null);
    }
}
