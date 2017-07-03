package com.bridgelabz.timeanddate;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by bridgeit on 27/6/17.
 */
public class    RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
{
    Context context;
    List<String> data;

   public  RecyclerAdapter(Context context,List<String> data)
   {
       this.context=context;
       this.data=data;
   }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(context).inflate(R.layout.card_view,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position)
    {
        holder.textViewDate.setText(data.get(position));
        holder.textViewTime.setText(data.get(position));
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        AppCompatTextView textViewDate;
        AppCompatTextView textViewTime;
        public ViewHolder(View itemView)
        {
            super(itemView);
            textViewDate=(AppCompatTextView)itemView.findViewById(R.id.textViewDate);
            textViewTime=(AppCompatTextView)itemView.findViewById(R.id.textViewTime);

        }
    }
}
