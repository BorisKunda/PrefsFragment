package com.example.jbt.prefsfragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jbt on 22/12/2017.
 */
//1. extend RecyclerView.Adapter
    //3 put the viewHolder inside the  < >
    //4. override methods

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myVH> {

    //5. create ctor
    ArrayList<Celeb> allCelebs;
    Context context;

    public MyAdapter(ArrayList<Celeb> allCelebs, Context context) {
        this.allCelebs = allCelebs;
        this.context = context;
    }

    @Override
    public myVH onCreateViewHolder(ViewGroup parent, int viewType) {
        //6. generate view and viewHolder
        View v= LayoutInflater.from(context).inflate(R.layout.single_item, null);
        myVH MyVH= new myVH(v);
        return MyVH;
    }

    @Override
    public void onBindViewHolder(myVH holder, int position) {

        //7. bind data to view holder
        Celeb current= allCelebs.get(position);
        holder.bindCelebToControls(current);

    }

    @Override
    public int getItemCount() {
        return allCelebs.size();
    }

    //2. create class that extend ViewHolder
    public class myVH extends RecyclerView.ViewHolder
    {
        View itemView;

        public myVH(View itemView) {
            super(itemView);
            this.itemView=itemView;
        }
        //8. create public  method that binds the data

        public void bindCelebToControls(Celeb current)
        {
            TextView textView= itemView.findViewById(R.id.celebTV);
            textView.setText(current.name);
            ImageView imageView= (ImageView) itemView.findViewById(R.id.celebIV);
            imageView.setImageResource(current.pic);
            CheckBox checkBox= (CheckBox) itemView.findViewById(R.id.aliveCB);

            SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(context);
            boolean showCB= preferences.getBoolean("showAlive", true);

            checkBox.setChecked(current.isAlive);

            if(showCB)
            {
                checkBox.setVisibility(View.VISIBLE);
            }
            else
            {
                checkBox.setVisibility(View.INVISIBLE);
            }

        }



    }

}
