package nl.dvberkel.demo;

import nl.dvberkel.demo.xml.AnswerProvider;
import nl.dvberkel.demo.xml.DeepThought;
import nl.dvberkel.demo.xml.FortuneTeller;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class XmlApplicationContextTest {
    @Test
    public void shouldBeAbleToConfigureAnApplicationContextFromXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("test.xml.application-context.xml");

        DeepThought computer = context.getBean("deep-thought", DeepThought.class);

        assertThat(computer.provideAnswer(), is(42));
    }

    @Test
    public void shouldBeAbleToConfigureAnApplicationContextFromMultipleXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{
                "test.xml.application-context.xml",
                "test.xml.application-context.2.xml"
        });

        assertThat(context.getBean(DeepThought.class).provideAnswer(), is(42));
        assertThat(context.getBean(FortuneTeller.class).fortune(), is("you will win the lottery"));
    }

    @Test
    public void shouldBeAbleToConfigureAnApplicationContextFromXmlThatImportsOthers() {
        ApplicationContext context = new ClassPathXmlApplicationContext("test.xml.imported.application-context.xml");

        assertThat(context.getBean(DeepThought.class).provideAnswer(), is(42));
        assertThat(context.getBean(FortuneTeller.class).fortune(), is("you will win the lottery"));
    }

    @Test
    public void shouldCreateAnswerProviderAnewEachTime() {
        ApplicationContext context = new ClassPathXmlApplicationContext("test.xml.application-context.xml");

        assertThat(context.getBean(AnswerProvider.class), is(not(context.getBean(AnswerProvider.class))));
    }
}
