package com.example.alertapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button alertDialog;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alertDialog = (Button) findViewById(R.id.exitButton);
        text = (TextView) findViewById(R.id.text);
        ListenerButton();
    }

    private void ListenerButton(){
        alertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog();
            }
        });

    }

    private void createDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("EXIT ALERT");
        builder.setMessage("Are you sure you want to exit?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override //autocompletado
            public void onClick(DialogInterface dialog, int which) {
                text.setText("You are out");
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override //autocompletado
            public void onClick(DialogInterface dialog, int which) {
                text.setText("You are not out");
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}