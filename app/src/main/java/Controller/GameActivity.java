package Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.topquiz.R;

import java.util.Arrays;

import Modele.Question;
import Modele.QuestionBank;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestionTextView;
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;
    private Button mAnswerButton4;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;

    private int mScore;
    private int mNumberOfQuestions;

    public static final String BUNDLE_EXTRA_SCORE ="BUNDLE_EXTRA_SCORE";
    public static final String BUNDLE_STATE_SCORE ="currentQuestion";
    public static final String BUNDLE_STATE_QUESTION ="currentQuestion";

    private boolean mEnableTouchEvents;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        System.out.println("GameActivity::onCreate()");


        if (savedInstanceState != null) {
            mScore = savedInstanceState.getInt(BUNDLE_STATE_SCORE);
            mNumberOfQuestions = savedInstanceState.getInt(BUNDLE_STATE_QUESTION);
        } else {
            mScore = 0;
            mNumberOfQuestions = 4;
        }

        mEnableTouchEvents = true;

        // Wire widgets
        mQuestionTextView = (TextView) findViewById(R.id.activity_game_question_text);
        mAnswerButton1 = (Button) findViewById(R.id.activity_game_buttonAnswer1);
        mAnswerButton2 = (Button) findViewById(R.id.activity_game_buttonAnswer2);
        mAnswerButton3 = (Button) findViewById(R.id.activity_game_buttonAnswer3);
        mAnswerButton4 = (Button) findViewById(R.id.activity_game_buttonAnswer4);

        // Use the tag property to 'name the buttons
        mAnswerButton1.setTag(1);
        mAnswerButton2.setTag(2);
        mAnswerButton3.setTag(3);
        mAnswerButton4.setTag(4);

        mAnswerButton1.setOnClickListener(this);
        mAnswerButton2.setOnClickListener(this);
        mAnswerButton3.setOnClickListener(this);
        mAnswerButton4.setOnClickListener(this);


        mQuestionBank = this.generateQuestions();
        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion((mCurrentQuestion));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(BUNDLE_STATE_SCORE, mScore);
        outState.putInt(BUNDLE_STATE_QUESTION, mNumberOfQuestions);

        super.onSaveInstanceState(outState);
    }

    private QuestionBank generateQuestions() {
        Question question1= new Question("What is the name of the current french president ?",
                Arrays.asList("Francois Hollande", "Emmanuel Macron", "Jacques Chirac", "Francois Mitterand"),2);
        Question question2 = new Question("How many countries are there in the European Union?",
                Arrays.asList("15", "24", "28", "32"),
                2);

        Question question3 = new Question("Who is the creator of the Android operating system?",
                Arrays.asList("Andy Rubin", "Steve Wozniak", "Jake Wharton", "Paul Smith"),
                0);

        Question question4 = new Question("When did the first man land on the moon?",
                Arrays.asList("1958", "1962", "1967", "1969"),
                3);

        Question question5 = new Question("What is the capital of Romania?",
                Arrays.asList("Bucarest", "Warsaw", "Budapest", "Berlin"),
                0);

        Question question6 = new Question("Who did the Mona Lisa paint?",
                Arrays.asList("Michelangelo", "Leonardo Da Vinci", "Raphael", "Carravagio"),
                1);

        Question question7 = new Question("In which city is the composer Frédéric Chopin buried?",
                Arrays.asList("Strasbourg", "Warsaw", "Paris", "Moscow"),
                2);

        Question question8 = new Question("What is the country top-level domain of Belgium?",
                Arrays.asList(".bg", ".bm", ".bl", ".be"),
                3);

        Question question9 = new Question("What is the house number of The Simpsons?",
                Arrays.asList("42", "101", "666", "742"),
                3);

        return new QuestionBank( Arrays.asList(question1,
                question2,
                question3,
                question4,
                question5,
                question6,
                question7,
                question8,
                question9));
    }

    private void displayQuestion(final Question question){
        mQuestionTextView.setText(question.getQuestion());
        mAnswerButton1.setText(question.getChoices().get(0));
        mAnswerButton2.setText(question.getChoices().get(1));
        mAnswerButton3.setText(question.getChoices().get(2));
        mAnswerButton4.setText(question.getChoices().get(3));
    }

    @Override
    public void onClick(View view) {
        int responseIndex = (int) view.getTag();

        if(responseIndex == mCurrentQuestion.getIndexAnswer()){
            Toast.makeText(this,"Correct",Toast.LENGTH_SHORT).show();
            mScore++;
        }else {
            Toast.makeText(this,"Wrong Answer",Toast.LENGTH_SHORT).show();
        }

        mEnableTouchEvents = false;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mEnableTouchEvents = true;

                // il decremente a chaque check de if
                if (--mNumberOfQuestions ==0){
                    // End Game
                    endGame();
                }else {
                    // model affiche une nouvelle question
                    mCurrentQuestion = mQuestionBank.getQuestion();
                    displayQuestion(mCurrentQuestion);
                }
            }
        } ,2000);

    }

    // on active l event touch que si la var est TRUE
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return mEnableTouchEvents && super.dispatchTouchEvent(ev);
    }

    private void endGame () {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Well done!");
        builder.setMessage("Your Score is " + mScore);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // End the activity
                Intent intent = new Intent();
                intent.putExtra(BUNDLE_EXTRA_SCORE,mScore); // fnc (id, data)
                setResult(RESULT_OK, intent); // enregistre l'intent dans ANDROID
                finish();
            }
        });
        // il cree le builder
        builder.create();
        // puis il le montre
        builder.show();

    }

    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("GameActivity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("GameActivity::onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("GameActivity::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("GameActivity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("GameActivity::onDestroy()");
    }
}
