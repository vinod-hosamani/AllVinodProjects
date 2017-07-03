package com.bridgelabz.todosecond.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bridgelabz.todosecond.R;
import com.bridgelabz.todosecond.baseclass.BaseActivity;

public class Result extends BaseActivity implements View.OnClickListener {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        AppCompatTextView textView=(AppCompatTextView)findViewById(R.id.resulttextView);
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("name");

        if(bundle!=null)
        {

            String data =(String) bundle.get("text");
            textView.setText(data);
        }
    }

    @Override
    public void initView() {
        editText =(EditText)findViewById(R.id.resulttextView);
        setListener();
    }

    @Override
    public void setListener() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.notes_item_details_action,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_pushpin:

                Toast.makeText(this, "deleted..", Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);

            case R.id.action_edit:

                Toast.makeText(this, "Edited..", Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
            case R.id.action_save:

                Toast.makeText(this, "Saved..", Toast.LENGTH_SHORT).show();

                return super.onOptionsItemSelected(item);


            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onClick(View view) {
       // switch (v.getId()){

        //}
    }
}
