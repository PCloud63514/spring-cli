package com.example.cli;

import com.example.cli.user.UserCommand;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

@CommandLine.Command(name = "main", description = "main commands", subcommands = {UserCommand.class})
@Component
class MainCommand {
}
