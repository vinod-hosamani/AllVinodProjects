package com.bridgelabz.todosecond.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.bridgelabz.todosecond.R;
import com.bridgelabz.todosecond.adapter.RecyclerAdapter;
import com.bridgelabz.todosecond.baseclass.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bridgeit on 25/3/17.
 */

public abstract class WelcomeActivity extends BaseActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    boolean isView=false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_recycler);
        initView();

        List<String> data = new ArrayList<>();
            data.add("vinod hosamani ");
            data.add(" i am working with bridgelabz");
            data.add("As an Android domain");
            data.add("hi how are you ");
        Log.i("ggff", "onCreate: ");
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this,data);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setOnClickListener(this);

    }
    @Override
    public void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.myrecyvinodclerView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.changeview:
                if(!isView){
                    recyclerView.setLayoutManager(new GridLayoutManager(this,1));

                    isView = true;
                }
                else{
                    recyclerView.setLayoutManager(new GridLayoutManager(this,2));

                    isView = false;
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onClick(View v) {
       /* switch (v.getId()){


        }*/
    }
}
