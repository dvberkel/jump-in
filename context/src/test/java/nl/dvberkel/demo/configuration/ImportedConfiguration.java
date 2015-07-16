package nl.dvberkel.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ApplicationConfiguration.class, ApplicationConfiguration2.class})
public class ImportedConfiguration {
}
