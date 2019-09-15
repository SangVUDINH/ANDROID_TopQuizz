package Modele;

import java.util.List;

public class User {
    private String mFirstName;
    private List<String> mChoiceList;
    private int mAnswerIndex;



    public String getFirstName() {
        return mFirstName;
    }

    public List<String> getChoiceList() {
        return mChoiceList;
    }

    public int getAnswerIndex() {
        return mAnswerIndex;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public void setChoiceList(List<String> choiceList) {
        mChoiceList = choiceList;
    }

    public void setAnswerIndex(int answerIndex) {
        mAnswerIndex = answerIndex;
    }

    @Override
    public String toString() {

        return "User {" + "mFirstName='" + mFirstName+ '\''+'}';
    }
}
