package nl.dvberkel.demo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeepThought {
    @Autowired
    private AnswerProvider answerProvider;

    public int provideAnswer() {
        return answerProvider.getAnswer();
    }
}
