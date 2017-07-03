package com.bridgelabz.timeanddate;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    RecyclerView recyclerView;
    AppCompatTextView textViewDate;
    AppCompatTextView textViewTime;
    AppCompatButton buttonDate;
    AppCompatButton buttonTime;
    TimePickerDialog timePicker;
    DatePickerDialog datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        recyclerView=(RecyclerView)findViewById(R.id.recyclerViewId);
        List<String> data=new ArrayList<>();
       // data.add((String) textViewDate.getText());
      //  data.add((String) textViewTime.getText());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(this,data);
        recyclerView.setAdapter(recyclerAdapter);
    }

    public void initView()
    {
        textViewDate=(AppCompatTextView)findViewById(R.id.textViewDate);
        textViewTime=(AppCompatTextView)findViewById(R.id.textViewTime);
        buttonDate=(AppCompatButton)findViewById(R.id.buttondate);
        buttonTime=(AppCompatButton)findViewById(R.id.buttontime);

       // buttonDate.setOnClickListener(this);
      //  buttonTime.setOnClickListener(this);

    }

    java.util.Calendar myCalender=java.util.Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date= new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth)
        {
            myCalender.set(Calendar.YEAR,year);
            myCalender.set(Calendar.MONTH,monthOfYear);
            myCalender.set(Calendar.DAY_OF_MONTH,dayOfMonth);

            timePicker=new TimePickerDialog(getApplicationContext(),time,myCalender.get(Calendar.HOUR_OF_DAY),myCalender.get(Calendar.MINUTE),true);
            timePicker.show();
        }
    };

    TimePickerDialog.OnTimeSetListener time= new TimePickerDialog.OnTimeSetListener()
    {
        @Override
        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute)
        {
            myCalender.set(Calendar.HOUR_OF_DAY,hourOfDay);
            myCalender.set(Calendar.MINUTE,minute);
            myCalender.set(Calendar.SECOND,00);

            updateLabel();
        }
    };

    private void updateLabel()
    {
        String format="MMMM dd,yyyy";
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        textViewDate.setText(sdf.format(myCalender.getTime()));

        String format1="hh:mm";
        SimpleDateFormat sdf1=new SimpleDateFormat(format1);
        textViewTime.setText(sdf1.format(myCalender.getTime()));

    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.buttondate:
                datePicker=new DatePickerDialog(this,date,
                        myCalender.get(Calendar.YEAR),
                        myCalender.get(Calendar.MONTH),
                        myCalender.get(Calendar.DAY_OF_MONTH));
                break;
        }
    }
}
