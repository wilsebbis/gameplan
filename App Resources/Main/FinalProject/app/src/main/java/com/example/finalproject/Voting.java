package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.util.Objects;


public class Voting extends AppCompatActivity {
    boolean reset = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voting);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Voting");

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button okaybutton = (Button) findViewById(R.id.okaybutton);

        button1.setText("Roblox");
        button2.setText("Minecraft");
        button3.setText("Halo");

        NumberPicker numberpicker = (NumberPicker) findViewById(R.id.numberpicker);

        numberpicker.setMinValue(0);
        numberpicker.setMaxValue(3);
        numberpicker.setDisplayedValues( new String[] { "Select one of the following:", "Call of Duty", "Among Us", "Fortnite" } );
        numberpicker.setWrapSelectorWheel(false);

        button6.setVisibility(View.INVISIBLE);


        numberpicker.setVisibility(View.INVISIBLE);
        okaybutton.setVisibility(View.INVISIBLE);

        button4.setText("Pick new game");

        button1.setBackgroundColor(Color.RED);
        button2.setBackgroundColor(Color.RED);
        button3.setBackgroundColor(Color.RED);
        button4.setBackgroundColor(Color.RED);

        button1.setOnClickListener(view -> {
            if (reset == false) {
                button4.setEnabled(false);
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button1.setBackgroundColor(Color.GREEN);
                button6.setVisibility(View.VISIBLE);
            } else if (reset){
                if (numberpicker.getVisibility() != View.INVISIBLE){
                    button1.setText("Pick new game");
                    numberpicker.setVisibility(View.INVISIBLE);
                    okaybutton.setVisibility(View.INVISIBLE);
                } else {
                    button1.setText("Cancel");
                    numberpicker.setVisibility(View.VISIBLE);
                }
            }
        });

        button2.setOnClickListener(view -> {
            button4.setEnabled(false);
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button2.setBackgroundColor(Color.GREEN);
            button6.setVisibility(View.VISIBLE);
        });

        button3.setOnClickListener(view -> {
            button4.setEnabled(false);
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button3.setBackgroundColor(Color.GREEN);
            button6.setVisibility(View.VISIBLE);
        });

        button4.setOnClickListener(view -> {
            if (numberpicker.getVisibility() != View.INVISIBLE){
                button4.setText("Pick new game");
                numberpicker.setVisibility(View.INVISIBLE);
                okaybutton.setVisibility(View.INVISIBLE);
            } else {
                button4.setText("Cancel");
                numberpicker.setVisibility(View.VISIBLE);
            }
        });

        numberpicker.setOnValueChangedListener((numberPicker, i, i2) -> {
            String display = numberpicker.getDisplayedValues()[i2];
            okaybutton.setVisibility(View.VISIBLE);

            okaybutton.setOnClickListener(view -> {
                if(!reset){
                    if(i2 != 0) {
                        button4.setText(display);
                        okaybutton.setVisibility(View.INVISIBLE);
                        numberpicker.setVisibility(View.INVISIBLE);
                        button4.setEnabled(false);
                        button1.setEnabled(false);
                        button2.setEnabled(false);
                        button3.setEnabled(false);
                        button4.setBackgroundColor(Color.GREEN);
                        button6.setVisibility(View.VISIBLE);
                    }
                    if(i2 == 0) {
                        Context context = getApplicationContext();
                        CharSequence text = "Choose a game!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }
                if(reset){
                    if(i2 != 0) {
                        button1.setText(display);
                        okaybutton.setVisibility(View.INVISIBLE);
                        numberpicker.setVisibility(View.INVISIBLE);
                        button1.setEnabled(false);
                        button1.setEnabled(false);
                        button2.setEnabled(false);
                        button3.setEnabled(false);
                        button1.setBackgroundColor(Color.GREEN);
                        button6.setVisibility(View.VISIBLE);
                        button2.setVisibility(View.VISIBLE);
                    }
                    if(i2 == 0) {
                        Context context = getApplicationContext();
                        CharSequence text = "Choose a game!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }
            });
        });

        button5.setOnClickListener(view -> {
            button1.setText("Pick new game");
            button2.setText("Pick new game");
            button3.setText("Pick new game");
            button4.setText("Pick new game");
            button1.setEnabled(true);
            button2.setVisibility(View.INVISIBLE);
            button3.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.INVISIBLE);
            button5.setEnabled(false);
            reset = true;
        });

        button6.setOnClickListener(view -> {
            if(!reset){
                button6.setVisibility(View.INVISIBLE);
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(true);
                button4.setEnabled(true);
                button1.setBackgroundColor(Color.RED);
                button2.setBackgroundColor(Color.RED);
                button3.setBackgroundColor(Color.RED);
                button4.setBackgroundColor(Color.RED);
            } else if (reset){
                button6.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                button1.setEnabled(true);
                button1.setBackgroundColor(Color.RED);
                button1.setText("Pick new game");
            }
        });

        button4.setOnClickListener(view -> {
            if (numberpicker.getVisibility() != View.INVISIBLE){
                button4.setText("Pick new game");
                numberpicker.setVisibility(View.INVISIBLE);
                okaybutton.setVisibility(View.INVISIBLE);
            } else {
                button4.setText("Cancel");
                numberpicker.setVisibility(View.VISIBLE);
            }
        });
    }

}
