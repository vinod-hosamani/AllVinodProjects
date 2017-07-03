package com.bridgelabz.navdrawerexample1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




public class BlankFragment extends Fragment
{
    private static final String ARG_PARAM1 = "param1";
    private int mParam1;


    private OnFragmentInteractionListener mListener;

    public BlankFragment()
    {
    }


    public static BlankFragment newInstance(int param1)
    {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Integer total=mParam1*5;
        onButtonPressed(total.toString());
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    public void onButtonPressed(String data)
    {
        if (mListener != null)
        {
            mListener.onFragmentInteraction(data);
        }
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener)
        {
            mListener = (OnFragmentInteractionListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString()+" must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener
    {
        void onFragmentInteraction(String data);
    }
}
