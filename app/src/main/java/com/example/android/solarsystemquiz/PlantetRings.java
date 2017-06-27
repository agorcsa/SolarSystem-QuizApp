package com.example.android.solarsystemquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class PlantetRings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantet_rings);
    }

    public void startEclipse(View view) {
        startActivityWithParams(Eclipse.class);
    }

    public void startPhenomena(View view) {
        startActivityWithParams(Phenomena.class);
    }

    private void startActivityWithParams(Class<?> cls) {
        RadioGroup question = (RadioGroup) findViewById(R.id.fifthQuestion);
        int checkedBtnId = question.getCheckedRadioButtonId();
        Intent i = getIntent();
        String username = i.getStringExtra("com.example.android.solarsystemquiz.username");
        int answers[] = i.getIntArrayExtra("com.example.android.solarsystemquiz.answers");
        answers[4] = checkedBtnId;
        Intent activity = new Intent(this, cls);
        activity.putExtra("com.example.android.solarsystemquiz.username", username);
        activity.putExtra("com.example.android.solarsystemquiz.answers", answers);
        startActivity(activity);
    }
}
