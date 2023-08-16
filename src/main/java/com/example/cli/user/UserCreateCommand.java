package com.example.cli.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "create", description = "Create a new user")
@Component
public class UserCreateCommand implements Runnable {
    @Autowired
    private GoodWordComponent goodWordComponent;

    @Option(names = "-name", description = "Name of the user")
    String name;

    @Option(names = "-description", description = "Description of the user")
    String description;

    @Override
    public void run() {
        // 생성 로직
        System.out.println("Creating user with name: " + name + ", description: " + description + goodWordComponent.message());
    }
}
