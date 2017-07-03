package app.com.recyclerviewdemo2;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.security.PublicKey;
import java.util.List;

/**
 * Created by bridgeit on 29/3/17.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    List<String> data;

    public RecyclerAdapter(Context context,List<String> data){
        this.context=context;
        this.data=data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.row_items,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
      AppCompatActivity textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView=(AppCompatActivity)textView.findViewById(R.id.text);

        }
    }
}
