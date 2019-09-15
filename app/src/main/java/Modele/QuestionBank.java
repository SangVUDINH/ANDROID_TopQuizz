package Modele;


import java.util.Collections;
import java.util.List;

public class QuestionBank {
    private List<Question> mQuestionList;

    // index of list ( we make a random later)
    private  int mNextQuestionIndex;


    public QuestionBank(List<Question>QuestionList){
        this.mQuestionList = QuestionList;

        // Shuffle the question list (random list)
        Collections.shuffle(mQuestionList);

        this.mNextQuestionIndex = 0;
    }

    public Question getQuestion() {
        if (mNextQuestionIndex == mQuestionList.size()){
            mNextQuestionIndex=0;
        }

        // simple get an element of the list with index
        return mQuestionList.get(mNextQuestionIndex++);
    }




}
