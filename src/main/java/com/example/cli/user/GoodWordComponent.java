package com.example.cli.user;

import org.springframework.stereotype.Component;

@Component
public class GoodWordComponent {
    public String message() {
        return "Good!";
    }
}
