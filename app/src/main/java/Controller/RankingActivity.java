package Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.topquiz.R;

import java.util.Arrays;

public class RankingActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mPlayer1;
    private TextView mPlayer2;
    private TextView mPlayer3;
    private TextView mPlayer4;
    private TextView mPlayer5;
    private Button mButtonRank;
    private Button mButtonRankAlpha;

    private String[] ranking= new String[5];
    private String[] rankingAlpha= new String[5];
    private int[] rankingScore= new int[5];

    SharedPreferences mPreferences;
    public static final String PREF__KEY_FIRSTNAME1 = "PREF__KEY_FIRSTNAME1";
    public static final String PREF__KEY_FIRSTNAME2 = "PREF__KEY_FIRSTNAME2";
    public static final String PREF__KEY_FIRSTNAME3 = "PREF__KEY_FIRSTNAME3";
    public static final String PREF__KEY_FIRSTNAME4 = "PREF__KEY_FIRSTNAME4";
    public static final String PREF__KEY_FIRSTNAME5 = "PREF__KEY_FIRSTNAME5";

    public static final String PREF__KEY_SCORE1 = "PREF__KEY_SCORE1";
    public static final String PREF__KEY_SCORE2 = "PREF__KEY_SCORE2";
    public static final String PREF__KEY_SCORE3 = "PREF__KEY_SCORE3";
    public static final String PREF__KEY_SCORE4 = "PREF__KEY_SCORE4";
    public static final String PREF__KEY_SCORE5 = "PREF__KEY_SCORE5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        mPreferences=getSharedPreferences("A",MODE_PRIVATE);

        ranking[0] = mPreferences.getString(PREF__KEY_FIRSTNAME1,null);
        ranking[1] = mPreferences.getString(PREF__KEY_FIRSTNAME2,null);
        ranking[2] = mPreferences.getString(PREF__KEY_FIRSTNAME3,null);
        ranking[3] = mPreferences.getString(PREF__KEY_FIRSTNAME4,null);
        ranking[4] = mPreferences.getString(PREF__KEY_FIRSTNAME5,null);

        rankingScore[0] = mPreferences.getInt(PREF__KEY_SCORE1,0);
        rankingScore[1] = mPreferences.getInt(PREF__KEY_SCORE2,0);
        rankingScore[2] = mPreferences.getInt(PREF__KEY_SCORE3,0);
        rankingScore[3] = mPreferences.getInt(PREF__KEY_SCORE4,0);
        rankingScore[4] = mPreferences.getInt(PREF__KEY_SCORE5,0);

        rankingAlpha[0] = ranking[0]+ " Score :"+rankingScore[0];
        rankingAlpha[1] = ranking[1]+ " Score :"+rankingScore[1];
        rankingAlpha[2] = ranking[2]+ " Score :"+ rankingScore[2];
        rankingAlpha[3] = ranking[3]+ " Score :"+rankingScore[3];
        rankingAlpha[4] = ranking[4]+ " Score :"+rankingScore[4];
        Arrays.sort(rankingAlpha);



        // BRANCHEMENT DES VAR PLAYERS
        mPlayer1 = findViewById(R.id.activity_ranking_player1);
        mPlayer2 = findViewById(R.id.activity_ranking_player2);
        mPlayer3 = findViewById(R.id.activity_ranking_player3);
        mPlayer4 = findViewById(R.id.activity_ranking_player4);
        mPlayer5 = findViewById(R.id.activity_ranking_player5);

        mButtonRank= findViewById(R.id.activity_ranking_btnRank);
        mButtonRankAlpha= findViewById(R.id.activity_ranking_btnAlpha);


        // affectation value
        mPlayer1.setText(ranking[0]+" Score: "+rankingScore[0]);
        mPlayer2.setText(ranking[1]+" Score: "+rankingScore[1]);
        mPlayer3.setText(ranking[2]+" Score: "+rankingScore[2]);
        mPlayer4.setText(ranking[3]+" Score: "+rankingScore[3]);
        mPlayer5.setText(ranking[4]+" Score: "+rankingScore[4]);

        mButtonRank.setTag(1);
        mButtonRankAlpha.setTag(2);
        mButtonRank.setOnClickListener(this);
        mButtonRankAlpha.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        int clickButtonTag = (int) view.getTag();

        if (clickButtonTag == 2){
            mPlayer1.setText(rankingAlpha[0]);
            mPlayer2.setText(rankingAlpha[1]);
            mPlayer3.setText(rankingAlpha[2]);
            mPlayer4.setText(rankingAlpha[3]);
            mPlayer5.setText(rankingAlpha[4]);
        }else {
            mPlayer1.setText(ranking[0]+" Score: "+rankingScore[0]);
            mPlayer2.setText(ranking[1]+" Score: "+rankingScore[1]);
            mPlayer3.setText(ranking[2]+" Score: "+rankingScore[2]);
            mPlayer4.setText(ranking[3]+" Score: "+rankingScore[3]);
            mPlayer5.setText(ranking[4]+" Score: "+rankingScore[4]);
        }
    }
}
