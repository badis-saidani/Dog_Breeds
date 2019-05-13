package com.badis.dogbreeds;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 Created By Badis Saidani 5/13/2019
 */
public class DogAdapter  extends BaseAdapter {

    Context c;
    ArrayList<Breed> breeds;

    LayoutInflater inflater;


    public DogAdapter(Context c, ArrayList<Breed> breeds) {
        this.c = c;
        this.breeds = breeds;

        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return breeds.size();
    }

    @Override
    public Object getItem(int i) {
        return breeds.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        if(inflater==null)
        {
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        //PERFORM INFLATION
        if (view==null)
        {
            view=inflater.inflate(R.layout.row,viewGroup,false);
        }

        //BIND DATA TO VIEWS
        TextView nameTxt= (TextView) view.findViewById(R.id.name);

        //BIND DATA
        Breed breed=breeds.get(i);
        final int id=breed.getId();
        final String name=breed.getName();
        final String bred_for=breed.getBred_for();
        final String breed_group=breed.getBreed_group();
        final String life_span=breed.getLife_span();
        final String temperament=breed.getTemperament();
        final String origin=breed.getOrigin();


        nameTxt.setText(name);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity(id, name, bred_for, breed_group, life_span, temperament, origin);

            }
        });

        return view;
    }


    private  void  openDetailActivity (int id, String name, String bred_for, String breed_group, String life_span, String temperament, String origin)
    {
        Intent i = new Intent(c, BreedDetails.class);

        i.putExtra("ID_KEY",id);
        i.putExtra("NAME_KEY",name);
        i.putExtra("BRED_FOR_KEY",bred_for);
        i.putExtra("BREED_GROUP_KEY",breed_group);
        i.putExtra("LIFE_SPAN_KEY",life_span);
        i.putExtra("TEMPERAMENT_KEY",temperament);
        i.putExtra("ORIGIN_KEY",origin);




        c.startActivity(i);

    }



}
