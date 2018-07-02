package com.example.group3.csci3130_group3_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    private TextView idtext,numbertext;
    private String name,id,number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        idtext=(TextView) findViewById(R.id.textViewdatail);
        numbertext=(TextView) findViewById(R.id.number_text);
        Intent i = getIntent();
        name=i.getStringExtra("name");
        id=i.getStringExtra("id");
        idtext.setText(name);
        numbertext.setText(id);
    }
}
