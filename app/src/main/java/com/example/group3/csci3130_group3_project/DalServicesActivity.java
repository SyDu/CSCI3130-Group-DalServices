package com.example.group3.csci3130_group3_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class DalServicesActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapters;
    private ArrayList<String> list,namelist,idlist;
    private DatabaseReference databaseReference;
    private String select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dal_services);
        final Intent i = getIntent();
        select=i.getStringExtra("select");
        listView=(ListView) findViewById(R.id.listview1);
        list=new ArrayList<String>();
        namelist=new ArrayList<String>();
        idlist=new ArrayList<String>();
        adapters=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        listView.setAdapter(adapters);
        databaseReference= FirebaseDatabase.getInstance().getReference(select);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String value=dataSnapshot.getKey();
                list.add(value);
                adapters.notifyDataSetChanged();
                String n=dataSnapshot.child("name").getValue(String.class);
                namelist.add(n);
                String id=dataSnapshot.child("id").getValue(String.class);
                idlist.add(id);


            }


            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getKey();
                list.remove(value);
                adapters.notifyDataSetChanged();

                String n=dataSnapshot.child("name").getValue(String.class);
                namelist.remove(n);
                String id=dataSnapshot.child("id").getValue(String.class);
                idlist.remove(id);


            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(view.getContext(),Detail.class);
                intent.putExtra("name",namelist.get(position));
                intent.putExtra("id",idlist.get(position));
                view.getContext().startActivity(intent);
            }
        });


    }
}
