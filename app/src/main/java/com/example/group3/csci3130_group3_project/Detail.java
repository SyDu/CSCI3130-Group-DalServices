package com.example.group3.csci3130_group3_project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    private TextView idtext, lotext, phone, webtext;
    private String name, location, phonenumber, web, ima;
    private ImageView imageView, callima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        idtext = (TextView)findViewById(R.id.textViewdatail);
        lotext = (TextView)findViewById(R.id.detailLocationtextView2);
        phone = (TextView)findViewById(R.id.detailnumber_text);
        webtext = (TextView)findViewById(R.id.detailwebtextView);
        imageView = (ImageView)findViewById(R.id.detailimageView2);
        callima = (ImageView)findViewById(R.id.callimaView);


        Intent i = getIntent();
        name = i.getStringExtra("name");
        location = i.getStringExtra("lo");
        phonenumber = i.getStringExtra("ph");
        ima = i.getStringExtra("ima");
        web = i.getStringExtra("web");
        idtext.setText(name);
        webtext.setText(web);
        lotext.setText(location);
        phone.setText(phonenumber);
        callima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makecall();
            }
        });
    }

    private void makecall() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(phonenumber));
        startActivity(intent);
    }


}
