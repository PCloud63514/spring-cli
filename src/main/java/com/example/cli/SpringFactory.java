package com.example.cli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import picocli.CommandLine;
@Component
public class SpringFactory implements CommandLine.IFactory {
    @Autowired
    private ApplicationContext context;

    @Override
    public <K> K create(Class<K> cls) {
        return context.getBean(cls);
    }
}
