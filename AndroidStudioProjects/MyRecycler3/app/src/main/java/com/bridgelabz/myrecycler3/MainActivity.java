package com.bridgelabz.myrecycler3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.myrecyclerview);
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add("WelCome ");
            data.add("vinod");
            data.add("bridgeit");
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this,data);
        recyclerView.setAdapter(recyclerAdapter);
    }

}