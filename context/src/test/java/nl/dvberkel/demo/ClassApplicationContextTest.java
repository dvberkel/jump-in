package nl.dvberkel.demo;

import nl.dvberkel.demo.configuration.ApplicationConfiguration;
import nl.dvberkel.demo.configuration.DeepThought;
import nl.dvberkel.demo.configuration.FortuneTeller;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ClassApplicationContextTest {
    @Test
    public void shouldBeAbleToConfigureAnApplicationContextFromConfigurationClass() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        DeepThought computer = context.getBean(DeepThought.class);

        assertThat(computer.provideAnswer(), is(42));
    }

    @Test
    public void shouldBeAbleToConfigureAnApplicationContextFromConfigurationClassFoundByScanning() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("nl.dvberkel.demo.configuration");
        context.refresh();

        assertThat(context.getBean(DeepThought.class).provideAnswer(), is(42));
        assertThat(context.getBean(FortuneTeller.class).fortune(), is("you will win the lottery"));
    }
}
