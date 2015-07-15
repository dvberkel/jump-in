package nl.dvberkel.demo;

import nl.dvberkel.demo.annotation.DeepThought;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AnnotationApplicationContextTest {
    @Test
    public void shouldBeAbleToConfigureAnApplicationContextFromAnnotations() {
        ApplicationContext context = new ClassPathXmlApplicationContext("test.annotation.application-context.xml");

        DeepThought computer = context.getBean(DeepThought.class);

        assertThat(computer.provideAnswer(), is(42));

    }
}
