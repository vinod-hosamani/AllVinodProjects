package com.bridgelabz.practice3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateListView();
        registerClickClaaBack();
    }
    /*private void populateListView() {
        //create list view items
        String[] myItems={"blue","green","purple","red"};

        //buildAdapter
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,               //context for the activity
                R.layout.da_item,   // layout to use(create)
                myItems);           // items to displayed

        //configure the listview

        ListView list=(ListView)findViewById(R.id.listViewMain);
        list.setAdapter(adapter);
    }
public void registerClickClaaBack(){
    ListView list=(ListView)findViewById(R.id.listViewMain);
    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            TextView textView=(TextView)view;
            Toast.makeText(MainActivity.this,textView.getText().toString(),Toast.LENGTH_LONG).show();
        }
    });
}*/
    public void populateListView(){
        String[] s={"one","two","Three","foru"};
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,R.layout.da_item,s);
        ListView listView=(ListView)findViewById(R.id.listVie   wMain);
        listView.setAdapter(adapter);
    }
    public void registerClickClaaBack(){
        ListView listView=(ListView)findViewById(R.id.listViewMain);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView=(TextView)view;
                Toast.makeText(MainActivity.this,textView.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
