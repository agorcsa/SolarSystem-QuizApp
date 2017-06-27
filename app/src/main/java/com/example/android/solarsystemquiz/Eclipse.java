package com.example.android.solarsystemquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class Eclipse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eclipse);
    }

    public void startBrightestPlanet(View view) {
        startActivityWithParams(BrightestPlanet.class);
    }

    public void startPlanetRings(View view) {
        startActivityWithParams(PlantetRings.class);
    }

    private void startActivityWithParams(Class<?> cls) {
        RadioGroup question = (RadioGroup) findViewById(R.id.fourthQuestion);
        int checkedBtnId = question.getCheckedRadioButtonId();
        Intent i = getIntent();
        String username = i.getStringExtra("com.example.android.solarsystemquiz.username");
        int answers[] = i.getIntArrayExtra("com.example.android.solarsystemquiz.answers");
        answers[3] = checkedBtnId;
        Intent activity = new Intent(this, cls);
        activity.putExtra("com.example.android.solarsystemquiz.username", username);
        activity.putExtra("com.example.android.solarsystemquiz.answers", answers);
        startActivity(activity);
    }
}
