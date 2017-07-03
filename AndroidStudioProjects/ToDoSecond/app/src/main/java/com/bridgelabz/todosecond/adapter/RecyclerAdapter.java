package com.bridgelabz.todosecond.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bridgelabz.todosecond.R;
import com.bridgelabz.todosecond.fragment.Fragments;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    Context context;
    List<String> data;
    public RecyclerAdapter(Context context,List<String> data){
        this.context=context;
        this.data=data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_welcome,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        AppCompatTextView textView;
        public MyViewHolder(final View itemView)
        {
            super(itemView);
            textView=(AppCompatTextView)itemView.findViewById(R.id.mytextView);
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                   // Intent intent=new Intent(itemView.getContext(), Result.class);
                    //Bundle bundle=new Bundle();
                    //bundle.putString("text",textView.getText().toString());
                    //intent.putExtra("name",bundle);
                    //itemView.getContext().startActivity(intent);
                    //Toast.makeText(itemView.getContext(),""+textView.getText().toString(), Toast.LENGTH_SHORT).show();
                    //AppCompatActivity activity= (AppCompatActivity) itemView.getContext();
                    //Fragment myFragment=new MyFragment();
                    // .getSupportFragmentManager().beginTransaction().replace(R.id.fragment, myFragment).addToBackStack(null).commit();

                    Fragments fra=new Fragments();
                    Bundle bundle=new Bundle();
                    bundle.putString("keys",textView.getText().toString());
                    fra.setArguments(bundle);
                    ((Activity)context).getFragmentManager().beginTransaction().replace(R.id.myframe_layout,fra).addToBackStack(null).commit();
                }


            });
        }
    }
}
