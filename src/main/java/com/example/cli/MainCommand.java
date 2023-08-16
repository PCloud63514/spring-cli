package com.example.cli;

import com.example.demo.example.DigimonApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

@CommandLine.Command(name = "main", description = "main commands", subcommands = {DigimonApp.class})
@Component
public class MainCommand {
    @Autowired
    private DigimonApp digimonApp;
}
