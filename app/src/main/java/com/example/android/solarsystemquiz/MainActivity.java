package com.example.android.solarsystemquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startScrollView(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        if (name.length() == 0) {
            // The name can not be empty to continue
            Toast.makeText(getApplicationContext(), "Fill user name!", Toast.LENGTH_SHORT).show();
            return;
        }

        //Starts the next activity, which is a scroll text
        Intent activity = new Intent(this, ScrollView.class);
        activity.putExtra("com.example.android.solarsystemquiz.username", name);
        startActivity(activity);
    }
}
