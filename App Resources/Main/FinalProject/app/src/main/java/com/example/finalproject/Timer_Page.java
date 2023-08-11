package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

public class Timer_Page extends AppCompatActivity {

    private NumberPicker picker1;
    private NumberPicker picker2;
    private NumberPicker picker3;
    public boolean timer_running;
    private Button start_button;
    private Button pause_button;
    private Button clear_button;

    private Timer clock = null;

    private TimerTask clockTask;
    private int timeInSeconds = 0; // In seconds

    private Handler uiHandler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_second);
        Intent intent = getIntent();
        timeInSeconds = intent.getIntExtra("time", 0);
        timer_running = intent.getBooleanExtra("running", false);
        picker1 = (NumberPicker) findViewById(R.id.picker1);
        picker2 = (NumberPicker) findViewById(R.id.picker2);
        picker3 = (NumberPicker) findViewById(R.id.picker3);
        start_button = (Button) findViewById(R.id.button_start);
        pause_button = (Button) findViewById(R.id.button_pause);
        clear_button = (Button) findViewById(R.id.button_clear);
        picker1.setMaxValue(59);
        picker1.setMinValue(0);
        picker2.setMaxValue(59);
        picker2.setMinValue(0);
        picker3.setMaxValue(12);
        picker3.setMinValue(0);
        start_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                timeInSeconds = picker1.getValue() + 60*picker2.getValue() + 60*60*picker3.getValue();
                timer_running = true;
                if(clock != null) {
                    clock.cancel();
                }
                clock = new Timer("gameTimer", true);
                clockTask = new TimerTask() {
                    @Override
                    public void run() {
                        if(timer_running == true) {
                            countdown();
                            timeInSeconds--;
                            if (timeInSeconds <= 0) {
                                timeInSeconds = 0;
                                clock.cancel();
                            }
                        }
                    }
                };
                clock.scheduleAtFixedRate(clockTask, 0, 1000);
            }
        });

        pause_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                timer_running = !timer_running;
            }
        });

        clear_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                clock.cancel();
                timer_running = false;
                timeInSeconds = 0;
                picker1.setValue(0);
                picker2.setValue(0);
                picker3.setValue(0);
            }
        });
    }

    public void countdown(){
        uiHandler.post(new Runnable() {
            @Override
            public void run() {
                picker3.setValue((int)(timeInSeconds / 3600));
                picker2.setValue((int)(timeInSeconds / 60) % 60);
                picker1.setValue((int)(timeInSeconds % 60));
            }
        });
    }
}
