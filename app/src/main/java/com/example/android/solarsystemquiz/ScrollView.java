package com.example.android.solarsystemquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ScrollView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
    }

    //Starts the next activity which is the 1st question of the quizz
    public void startDiscoveryAndExploration(View view) {
        Intent i = getIntent();
        String username = i.getStringExtra("com.example.android.solarsystemquiz.username");
        Intent activity = new Intent(this, DiscoveryAndExploration.class);
        activity.putExtra("com.example.android.solarsystemquiz.username", username);
        startActivity(activity);
    }
}
