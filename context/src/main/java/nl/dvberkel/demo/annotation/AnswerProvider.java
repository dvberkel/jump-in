package nl.dvberkel.demo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AnswerProvider {
    @Autowired
    @Value("42")
    private int answer;

    public int getAnswer() {
        return answer;
    }
}
