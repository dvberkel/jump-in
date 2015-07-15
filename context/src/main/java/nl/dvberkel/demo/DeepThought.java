package nl.dvberkel.demo;

public class DeepThought {
    private AnswerProvider answerProvider;

    public void setAnswerProvider(AnswerProvider answerProvider) {
        this.answerProvider = answerProvider;
    }

    public AnswerProvider getAnswerProvider() {
        return answerProvider;
    }


    public int provideAnswer() {
        return answerProvider.getAnswer();
    }
}
