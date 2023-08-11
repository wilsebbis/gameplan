package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Timer;
import java.util.TimerTask;

public class DisplayMessageActivity extends AppCompatActivity {

    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the intent that started this activity and extract the string
        Intent intent=getIntent();
        String message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView=(TextView)findViewById(R.id.textView2);
        textView.setText(message);

        Button calander = (Button) findViewById(R.id.button2);
        calander.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DisplayMessageActivity.this, Calander.class);
                                startActivity(intent);
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DisplayMessageActivity.this, Timer_Page.class);
                startActivity(intent);
            }
        });

        Button voting = (Button) findViewById(R.id.button6);
        voting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DisplayMessageActivity.this, Voting.class);
                startActivity(intent);
            }
        });

        Button voting2 = (Button) findViewById(R.id.button9);
        voting2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DisplayMessageActivity.this, Voting.class);
                startActivity(intent);
            }
        });

        Button voting3 = (Button) findViewById(R.id.button10);
        voting3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DisplayMessageActivity.this, Voting.class);
                startActivity(intent);
            }
        });

        Button friend = (Button) findViewById(R.id.button8);
        friend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DisplayMessageActivity.this, FriendList.class);
                startActivity(intent);
            }
        });
    }

}