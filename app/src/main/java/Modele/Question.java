package Modele;

import java.util.List;

public class Question {
    private String mQuestion;
    private List<String> mChoices;
    private int mIndexAnswer;

    public Question (String Question, List<String> Answer1, int indexAnswer ){
        this.setQuestion(Question);
        this.setChoices(Answer1);
        this.setIndexAnswer(indexAnswer);
    }

    public String getQuestion() {
        return mQuestion;
    }

    public List<String> getChoices() {
        return mChoices;
    }

    public int getIndexAnswer() {
        return mIndexAnswer;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public void setChoices(List<String> choices) {
        mChoices = choices;
    }

    public void setIndexAnswer(int indexAnswer) {
        mIndexAnswer = indexAnswer;
    }

    @Override
    public String toString() {
        return "Question {" +
                "mQuestion='" + mQuestion + '\'' +
                ", mChoiceList=" + mChoices+
                ", mAnswerIndex="+ mIndexAnswer+
                '}';
    }
}
