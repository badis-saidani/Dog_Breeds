package com.badis.dogbreeds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
Created By Badis Saidani 5/13/2019
 */
public class BreedDetails extends AppCompatActivity {

    int id;
    String name, bred_for, breed_group, life_span, temperament, origin;
    TextView nameTxtDetail, bred_forTxtDetail, breed_groupTxtDetail, life_spanTxtDetail, temperamentTxtDetail, originTxtDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_details);

        nameTxtDetail = (TextView) findViewById(R.id.nameTxtDetail);
        bred_forTxtDetail = (TextView) findViewById(R.id.bredForTxtDetail);
        breed_groupTxtDetail = (TextView) findViewById(R.id.breedGroupTxtDetail);
        life_spanTxtDetail = (TextView) findViewById(R.id.lifeSpanTxtDetail);
        temperamentTxtDetail = (TextView) findViewById(R.id.temperamentTxtDetail);
        originTxtDetail = (TextView) findViewById(R.id.originTxtDetail);

        //RECEIVE DATA
        Intent i = this.getIntent();
        id = i.getExtras().getInt("ID_KEY");
        name = i.getExtras().getString("NAME_KEY");
        bred_for = i.getExtras().getString("BRED_FOR_KEY");
        breed_group = i.getExtras().getString("BREED_GROUP_KEY");
        life_span = i.getExtras().getString("LIFE_SPAN_KEY");
        temperament = i.getExtras().getString("TEMPERAMENT_KEY");
        origin = i.getExtras().getString("ORIGIN_KEY");


        //BIND

        nameTxtDetail.setText(name);
        bred_forTxtDetail.setText(bred_for);
        breed_groupTxtDetail.setText(breed_group);
        life_spanTxtDetail.setText(life_span);
        temperamentTxtDetail.setText(temperament);
        originTxtDetail.setText(origin);
    }
}
