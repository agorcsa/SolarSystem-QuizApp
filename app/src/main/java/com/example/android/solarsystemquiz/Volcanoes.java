package com.example.android.solarsystemquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class Volcanoes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volcanoes);
    }

    public void startSun(View view) {
        startActivityWithParams(CalculateScore.class);
    }

    public void startSolarSystemDeath(View view) {
        startActivityWithParams(SolarSystemDeath.class);
    }

    private void startActivityWithParams(Class<?> cls) {
        RadioGroup question = (RadioGroup) findViewById(R.id.ninethQuestion);
        int checkedBtnId = question.getCheckedRadioButtonId();
        Intent i = getIntent();
        String username = i.getStringExtra("com.example.android.solarsystemquiz.username");
        int answers[] = i.getIntArrayExtra("com.example.android.solarsystemquiz.answers");
        answers[8] = checkedBtnId;
        Intent activity = new Intent(this, cls);
        activity.putExtra("com.example.android.solarsystemquiz.username", username);
        activity.putExtra("com.example.android.solarsystemquiz.answers", answers);
        startActivity(activity);
    }
}
