package com.example.android.solarsystemquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

public class DiscoveryAndExploration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discovery_and_exploration);
    }

    // "X" Button, which is the back button, that bring us to the previous activity
    public void startMainActivity(View view) {
        startActivityWithParams(MainActivity.class);
    }

    //Check button, which we click after submitting the answer of a question, that brings us to the next activity
    public void startPlanetsSize(View view) {
        startActivityWithParams(PlanetsSize.class);
    }

    private void startActivityWithParams(Class<?> cls) {
        RadioGroup question = (RadioGroup) findViewById(R.id.firstQuestion);
        int checkedBtnId = question.getCheckedRadioButtonId();
        Intent i = getIntent();
        String username = i.getStringExtra("com.example.android.solarsystemquiz.username");
        int answers[] = i.getIntArrayExtra("com.example.android.solarsystemquiz.answers");
        if (answers == null)
            // reserve space for a maximum of 10 questions
            answers = new int[10];
        // question1 answer goes to index 0
        answers[0] = checkedBtnId;
        Intent activity = new Intent(this, cls);
        activity.putExtra("com.example.android.solarsystemquiz.username", username);
        activity.putExtra("com.example.android.solarsystemquiz.answers", answers);
        startActivity(activity);
    }
}
