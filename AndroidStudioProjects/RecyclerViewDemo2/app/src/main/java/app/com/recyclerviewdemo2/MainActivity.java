package app.com.recyclerviewdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<String> stringList=new ArrayList<>();
        for(int i=0;i<20;i++){
            stringList.add("vinod"+i);
        }
        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(this,stringList);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
