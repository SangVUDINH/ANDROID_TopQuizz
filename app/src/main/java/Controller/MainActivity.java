package Controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.topquiz.R;

import Modele.User;

import static java.lang.System.out;

public class MainActivity extends AppCompatActivity {

    private TextView mMessageToUser;
    private EditText mTextSaisi;
    private Button mButtonLetPlay;
    private Button mButtonRanking;
    private User mUser;

    public static final int  GAME_ACTIVITY_REQUEST_CODE = 42;
    public static final String PREF__KEY_SCORE = "PREF__KEY_SCORE";
    public static final String PREF__KEY_FIRSTNAME = "PREF__KEY_FIRSTNAME";

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

    private static final String TAG = MainActivity.class.getSimpleName();


    private SharedPreferences mPreferences;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // on verifie le resquest code que c'est bien les data du bon activity
        if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            // lecture du data
            int score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);
            mPreferences.edit().putInt(PREF__KEY_SCORE,score).apply();


            int scoreA []= new int[5];
            String nameA[]= new String[5];

            scoreA[0]  = mPreferences.getInt(PREF__KEY_SCORE1,0);
            nameA[0]   = mPreferences.getString(PREF__KEY_FIRSTNAME1,null);

            scoreA[1]  = mPreferences.getInt(PREF__KEY_SCORE2,0);
            nameA[1]   = mPreferences.getString(PREF__KEY_FIRSTNAME2,null);

            scoreA[2]  = mPreferences.getInt(PREF__KEY_SCORE3,0);
            nameA[2]   = mPreferences.getString(PREF__KEY_FIRSTNAME3,null);

            scoreA[3]  = mPreferences.getInt(PREF__KEY_SCORE4,0);
            nameA[3]   = mPreferences.getString(PREF__KEY_FIRSTNAME4,null);

            scoreA[4]  = mPreferences.getInt(PREF__KEY_SCORE5,0);
            nameA[4]   = mPreferences.getString(PREF__KEY_FIRSTNAME5,null);

            if (score >= scoreA[0]){
                mPreferences.edit().putInt(PREF__KEY_SCORE1,score).apply();
                mPreferences.edit().putString(PREF__KEY_FIRSTNAME1,mUser.getFirstName()).apply();
                //UNRANK OLD PLAYER
                mPreferences.edit().putInt(PREF__KEY_SCORE2,scoreA[0]).apply();
                mPreferences.edit().putString(PREF__KEY_FIRSTNAME2,nameA[0]).apply();

                mPreferences.edit().putInt(PREF__KEY_SCORE3,scoreA[1]).apply();
                mPreferences.edit().putString(PREF__KEY_FIRSTNAME3,nameA[1]).apply();

                mPreferences.edit().putInt(PREF__KEY_SCORE4,scoreA[2]).apply();
                mPreferences.edit().putString(PREF__KEY_FIRSTNAME4,nameA[2]).apply();

                mPreferences.edit().putInt(PREF__KEY_SCORE5,scoreA[3]).apply();
                mPreferences.edit().putString(PREF__KEY_FIRSTNAME5,nameA[3]).apply();

            }else if(score >= scoreA[1]){
                mPreferences.edit().putInt(PREF__KEY_SCORE2,score).apply();
                mPreferences.edit().putString(PREF__KEY_FIRSTNAME2,mUser.getFirstName()).apply();
                //UNRANK OLD PLAYER
                mPreferences.edit().putInt(PREF__KEY_SCORE3,scoreA[1]).apply();
                mPreferences.edit().putString(PREF__KEY_FIRSTNAME3,nameA[1]).apply();

                mPreferences.edit().putInt(PREF__KEY_SCORE4,scoreA[2]).apply();
                mPreferences.edit().putString(PREF__KEY_FIRSTNAME4,nameA[2]).apply();

                mPreferences.edit().putInt(PREF__KEY_SCORE5,scoreA[3]).apply();
                mPreferences.edit().putString(PREF__KEY_FIRSTNAME5,nameA[3]).apply();

            }else if(score >= scoreA[2]){
                mPreferences.edit().putInt(PREF__KEY_SCORE3,score).apply();
                mPreferences.edit().putString(PREF__KEY_FIRSTNAME3,mUser.getFirstName()).apply();
                //UNRANK OLD PLAYER
                mPreferences.edit().putInt(PREF__KEY_SCORE4,scoreA[2]).apply();
                mPreferences.edit().putString(PREF__KEY_FIRSTNAME4,nameA[2]).apply();

                mPreferences.edit().putInt(PREF__KEY_SCORE5,scoreA[3]).apply();
                mPreferences.edit().putString(PREF__KEY_FIRSTNAME5,nameA[3]).apply();

            }else if(score >= scoreA[3]){
                mPreferences.edit().putInt(PREF__KEY_SCORE4,score).apply();
                mPreferences.edit().putString(PREF__KEY_FIRSTNAME4,mUser.getFirstName()).apply();
                //UNRANK OLD PLAYER
                mPreferences.edit().putInt(PREF__KEY_SCORE5,scoreA[3]).apply();
                mPreferences.edit().putString(PREF__KEY_FIRSTNAME5,nameA[3]).apply();

            }else if(score >= scoreA[4]){
                mPreferences.edit().putInt(PREF__KEY_SCORE5,score).apply();
                mPreferences.edit().putString(PREF__KEY_FIRSTNAME5,mUser.getFirstName()).apply();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUser= new User();
        mPreferences=getSharedPreferences("A",MODE_PRIVATE);

        mMessageToUser  =   findViewById(R.id.activity_main_txt1);
        mTextSaisi      =   findViewById(R.id.activity_main_saisirtxt1);
        mButtonLetPlay  =   findViewById(R.id.activity_main_btn1);
        mButtonRanking  =   findViewById(R.id.activity_main_btnRank);

        mButtonLetPlay.setEnabled(false);
        checkUser();

        mTextSaisi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mButtonLetPlay.setEnabled(charSequence.toString().length() !=0);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        mButtonLetPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String firstname = mTextSaisi.getText().toString();
                mUser.setFirstName(firstname);

                mPreferences.edit().putString(PREF__KEY_FIRSTNAME,mUser.getFirstName()).apply();



                // User clicked the button
                Intent GameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
                startActivityForResult(GameActivityIntent, GAME_ACTIVITY_REQUEST_CODE);


            }
        });

        mButtonRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // User clicked the button
                Intent RankingActivityIntent = new Intent(MainActivity.this, RankingActivity.class);
                startActivity(RankingActivityIntent);

            }
        });

    }

    private void checkUser() {
        String name =getPreferences(MODE_PRIVATE).getString(PREF__KEY_FIRSTNAME, null);
        if (name != null){
            mTextSaisi.setText(name);
            String fullText = "hey "+name;
            mMessageToUser.setText(fullText);
            mButtonLetPlay.setEnabled(true);
            mTextSaisi.setSelection(name.length());
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        out.println("MainActivity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        out.println("MainActivity::onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        out.println("MainActivity::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        out.println("MainActivity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        out.println("MainActivity::onDestroy()");
    }
}
