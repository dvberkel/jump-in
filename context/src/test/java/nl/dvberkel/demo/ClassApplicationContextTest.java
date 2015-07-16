package nl.dvberkel.demo;

import nl.dvberkel.demo.annotation.*;
import nl.dvberkel.demo.configuration.*;
import nl.dvberkel.demo.configuration.DeepThought;
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

    @Test
    public void shouldBeAbleToConfigureAnApplicationContextFromConfigurationClassFoundByImportingOtherApplicationContexts() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportedConfiguration.class);

        assertThat(context.getBean(DeepThought.class).provideAnswer(), is(42));
        assertThat(context.getBean(FortuneTeller.class).fortune(), is("you will win the lottery"));
    }

    @Test
    public void shouldBeAbleToConfigureAnApplicationContextFromConfigurationClassFoundByScanningForComponents() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanningConfiguration.class);

        nl.dvberkel.demo.annotation.DeepThought computer = context.getBean(nl.dvberkel.demo.annotation.DeepThought.class);

        assertThat(computer.provideAnswer(), is(42));
    }
}
