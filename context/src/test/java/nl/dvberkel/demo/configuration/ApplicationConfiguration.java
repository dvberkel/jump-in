package nl.dvberkel.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public AnswerProvider createAnswerProvider(){
        return new AnswerProvider(42);
    }

    @Bean
    public DeepThought createDeepThought(){
        return new DeepThought(createAnswerProvider());
    }
}

