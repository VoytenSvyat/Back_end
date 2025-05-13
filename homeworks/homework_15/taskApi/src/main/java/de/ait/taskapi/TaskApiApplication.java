package de.ait.taskapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TaskApiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TaskApiApplication.class, args);
        System.out.println("qwerty");
    }

}
