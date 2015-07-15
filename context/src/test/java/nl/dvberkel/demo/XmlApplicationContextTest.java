package nl.dvberkel.demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class XmlApplicationContextTest {
    @Test
    public void shouldBeAbleToConfigureAnApplicationContextFromXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("test.xml.application-context.xml");

        DeepThought computer = context.getBean("deep-thought", DeepThought.class);

        assertThat(computer.provideAnswer(), is(42));
    }
}
