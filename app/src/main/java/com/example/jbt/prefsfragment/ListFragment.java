package com.example.jbt.prefsfragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<Celeb> allCelebs= new ArrayList<>();

        allCelebs.add(new Celeb("Miri Regev", R.drawable.miri, true));
        allCelebs.add(new Celeb("Miri Mesika", R.drawable.mesika, true));
        allCelebs.add(new Celeb("Miri Aloni",R.drawable.aloni , true));
        allCelebs.add(new Celeb("Zohar Argov",R.drawable.zohar , false));

        RecyclerView recyclerView= (RecyclerView) v.findViewById(R.id.celebsRV);

        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getActivity());

        //get value from SharedPrefs
        String showInList = sharedPreferences.getString("list_preference", "list");

        if(showInList.equals("List")) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        }
        else
        {
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        }

        MyAdapter myAdapter= new MyAdapter(allCelebs, getActivity());

        recyclerView.setAdapter(myAdapter);


        //get message from sharedPrefes and show in dialog

        String message= sharedPreferences.getString("message" ,"");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("This is a message")
                .setMessage(message)
                .setPositiveButton("OK!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();



        return v;
    }

}
