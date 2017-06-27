package com.example.android.solarsystemquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class CalculateScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_score);
        displayScore();
    }

    public void endGame(View view) {
    }

    private void startActivityWithParams(Class<?> cls) {
        Intent i = getIntent();
        String username = i.getStringExtra("com.example.android.solarsystemquiz.username");
        int answers[] = i.getIntArrayExtra("com.example.android.solarsystemquiz.answers");
        Intent activity = new Intent(this, cls);
        activity.putExtra("com.example.android.solarsystemquiz.username", username);
        activity.putExtra("com.example.android.solarsystemquiz.answers", answers);
        startActivity(activity);
    }

    private void displayScore() {
        int goodAnswers[] = new int[10];
        goodAnswers[0] = R.id.oneC;
        goodAnswers[1] = R.id.twoC;
        goodAnswers[2] = R.id.treeC;
        goodAnswers[3] = R.id.fourA;
        goodAnswers[4] = R.id.fiveA;
        goodAnswers[5] = R.id.sixA;
        goodAnswers[6] = R.id.sevenC;
        goodAnswers[7] = R.id.eightB;
        goodAnswers[8] = R.id.nineA;
        Intent i = getIntent();
        String username = i.getStringExtra("com.example.android.solarsystemquiz.username");
        int answers[] = i.getIntArrayExtra("com.example.android.solarsystemquiz.answers");
        TextView txtAnswers[] = new TextView[10];
        txtAnswers[0] = (TextView) findViewById(R.id.txtAnswer1);
        txtAnswers[1] = (TextView) findViewById(R.id.txtAnswer2);
        txtAnswers[2] = (TextView) findViewById(R.id.txtAnswer3);
        txtAnswers[3] = (TextView) findViewById(R.id.txtAnswer4);
        txtAnswers[4] = (TextView) findViewById(R.id.txtAnswer5);
        txtAnswers[5] = (TextView) findViewById(R.id.txtAnswer6);
        txtAnswers[6] = (TextView) findViewById(R.id.txtAnswer7);
        txtAnswers[7] = (TextView) findViewById(R.id.txtAnswer8);
        txtAnswers[8] = (TextView) findViewById(R.id.txtAnswer9);
        txtAnswers[9] = (TextView) findViewById(R.id.txtAnswer10);
        TextView txtAnswerTotal = (TextView) findViewById(R.id.txtAnswerTotal);
        int countOfGood = 0;
        for (int idx = 0; idx < 10; idx++) {
            String value = " incorrect";
            if (answers[idx] == goodAnswers[idx]) {
                value = " correct";
                countOfGood++;
            }
            txtAnswers[idx].setText(txtAnswers[idx].getText() + value);
        }
        txtAnswerTotal.setText("Good Answers: " + Integer.toString(countOfGood));
    }
}
