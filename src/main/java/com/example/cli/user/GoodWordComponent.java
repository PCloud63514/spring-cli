package com.example.cli.user;

import org.springframework.stereotype.Component;

@Component
class GoodWordComponent {
    public String message() {
        return "Good!";
    }
}
