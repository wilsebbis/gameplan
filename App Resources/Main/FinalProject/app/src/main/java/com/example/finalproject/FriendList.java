package com.example.finalproject;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.text.InputType;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class FriendList extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                addFriendDialog();
                break;
            case R.id.button2:
                addToGroup();
                break;
        }
    }
    private void addFriendDialog() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("Add a Friend");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setHint("Name");
        dialog.setView(input);

        dialog.setPositiveButton("Add",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                    }
                });
        dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }

    private void addToGroup() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        String[] friendOptions = {"Select a Friend", "Justin", "Harry"};
        String[] groupOptions = {"Select a Group", "The Homies"};
        dialog.setTitle("Add to group");

        final ArrayAdapter<String> friendAdp = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, friendOptions);
        final ArrayAdapter<String> groupAdp = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, groupOptions);


        final Spinner friend = new Spinner(this);
        final Spinner group = new Spinner(this);

        friend.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        group.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        friend.setAdapter(friendAdp);
        group.setAdapter(groupAdp);

        LinearLayout ll = new LinearLayout(this);
        ll.addView(friend);
        ll.addView(group);
        dialog.setView(ll);

        dialog.setPositiveButton("Add",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                    }
                });
        dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }
}

