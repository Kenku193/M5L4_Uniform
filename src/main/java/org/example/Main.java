package org.example;

import org.example.config.AppConfig;
import org.example.service.ActorService;
import org.example.service.ResourceService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ActorService serviceA = context.getBean("serviceA", ActorService.class);
        ActorService serviceB = context.getBean("serviceB", ActorService.class);

        System.out.println(serviceA);
        System.out.println(serviceB);

        serviceA.textMeSomething();
        serviceB.textMeSomething();

        ResourceService resourceService = context.getBean(ResourceService.class);
        Resource resource = resourceService.getResource();
        File file = resource.getFile();
        String s = new String(Files.readAllBytes(file.toPath()));
        System.out.println(s);

        System.out.println(resourceService.getTernary());
        System.out.println(resourceService.isNot());

        context.close();

    }
}