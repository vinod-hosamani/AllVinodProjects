package com.bridgelabz.listview1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//array of options-->ArrayAdapter-->ListView

//List view:(view:da_itemx.xml)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateListView();
        RegisterClickCallBack();
    }

    private void populateListView() {
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

    private void RegisterClickCallBack() {
        ListView list=(ListView)findViewById(R.id.listViewMain);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> paret, View viewclicked, int position, long id) {

                TextView textview=(TextView)viewclicked;

                String message=" you clicked "+position+"  "+" , which is string "+textview.getText().toString();
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();

            }
        });
    }
}
