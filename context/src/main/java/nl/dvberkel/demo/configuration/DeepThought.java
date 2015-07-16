package nl.dvberkel.demo.configuration;

public class DeepThought {
    private final AnswerProvider answerProvider;

    public DeepThought(AnswerProvider answerProvider) {
        this.answerProvider = answerProvider;
    }

    public int provideAnswer() {
        return answerProvider.getAnswer();
    }
}
