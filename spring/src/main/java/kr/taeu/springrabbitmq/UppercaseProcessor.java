package kr.taeu.springrabbitmq;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class UppercaseProcessor {
    @Bean
    public Consumer<String> uppercase() {
        return message -> System.out.println("Received message: " + message);
    }
}
