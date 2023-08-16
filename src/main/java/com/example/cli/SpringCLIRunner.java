package com.example.cli;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import picocli.CommandLine;
import picocli.shell.jline3.PicocliJLineCompleter;

@Component
public class SpringCLIRunner implements CommandLineRunner {
    @Autowired
    private MainCommand mainCommand;
    @Autowired
    private SpringFactory springFactory;

    @Override
    public void run(final String... args) throws Exception {
        final CommandLine cmd = new CommandLine(mainCommand, springFactory);
        final Terminal terminal = TerminalBuilder.builder().build();
        final LineReader lineReader = LineReaderBuilder.builder()
                .terminal(terminal)
                .completer(new PicocliJLineCompleter(cmd.getCommandSpec()))
                .build();

        final String prompt = "prompt> ";
        while (true) {
            String line;
            try {
                line = lineReader.readLine(prompt);
                if ("exit".equalsIgnoreCase(line)) {
                    break;
                }
                cmd.execute(line.split(" "));
            } catch (UserInterruptException e) {
                // 사용자가 Ctrl+C를 누를 경우
                break;
            } catch (EndOfFileException e) {
                // 사용자가 Ctrl+D를 누를 경우
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
