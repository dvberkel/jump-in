package nl.dvberkel.demo.configuration;

public class AnswerProvider {
    private final int answer;

    public AnswerProvider(int answer) {

        this.answer = answer;
    }

    public int getAnswer() {
        return answer;
    }
}
