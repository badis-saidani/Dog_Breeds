package com.badis.dogbreeds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 Created By Badis Saidani 5/13/2019
 */
public class ViewAllDogBreeds extends AppCompatActivity {
    String urlshow="https://api.thedogapi.com/v1/breeds?limit=10&page=0";
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_dog_breeds);

        listView = (ListView) findViewById(R.id.listDogs);
        new Downloader(ViewAllDogBreeds.this,urlshow,listView).execute();
    }
}
