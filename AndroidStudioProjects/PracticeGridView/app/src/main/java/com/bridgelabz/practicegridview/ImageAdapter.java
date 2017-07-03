package com.bridgelabz.practicegridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by bridgeit on 10/4/17.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbsId.lenth();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View converview, ViewGroup parent) {
        ImageView imageView

         if(converview==null)
         {
             imageView=new ImageView(mContext);
             imageView.setLayoutParams(new GridView.LayoutParams(85,85));
         }
        else{
             imageView=(ImageView) converview;
         }
        imageView.setImageResource(mThumbsId[position]);
        return imageView;
    }
    public Integer mThumbsId={ };
    }
}