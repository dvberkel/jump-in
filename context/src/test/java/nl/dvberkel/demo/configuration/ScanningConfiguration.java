package nl.dvberkel.demo.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("nl.dvberkel.demo.annotation")
public class ScanningConfiguration {
}
