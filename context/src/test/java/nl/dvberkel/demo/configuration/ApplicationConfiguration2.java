package nl.dvberkel.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ApplicationConfiguration2 {

    @Bean
    public FortuneTeller createFortuneTeller(){
        return new CannedResponseFortuneTeller(Arrays.asList(new String[]{ "you will win the lottery" }));
    }
}
