package com.bridgelabz.todosecond.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bridgelabz.todosecond.R;


/**
 * Created by bridgeit on 31/3/17.
 */

public class Fragments extends Fragment
{
    AppCompatEditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.activity_todoitemsdetails,container,false);
        editText=(AppCompatEditText)view.findViewById(R.id.resultEdittext);
        Bundle bundle=getArguments();

        if(bundle !=null)
        {
            String data=(bundle.getString("keys"));
            editText.setText(data);
        }
        return view;
    }
}