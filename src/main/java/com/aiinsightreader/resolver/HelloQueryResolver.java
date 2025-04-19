package com.aiinsightreader.resolver;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloQueryResolver {

    public HelloQueryResolver() {
        System.out.println("✅ HelloQueryResolver initialized");
    }

    @QueryMapping
    public String hello() {
        System.out.println("📡 hello() resolver hit!");
        return "Hello from Spring Boot GraphQL!";
    }
}
