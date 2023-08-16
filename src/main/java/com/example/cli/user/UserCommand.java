package com.example.cli.user;

import org.springframework.stereotype.Component;
import picocli.CommandLine;

@CommandLine.Command(name = "user", description = {"Manage User"}, subcommands = {UserCreateCommand.class})
@Component
public class UserCommand {
}
