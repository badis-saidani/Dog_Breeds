package com.badis.dogbreeds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 Created By Badis Saidani 5/13/2019
 */
public class MainActivity extends AppCompatActivity {

    Button viewAll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewAll = (Button) findViewById(R.id.viewAll);

        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,ViewAllDogBreeds.class);
                startActivity(i);
            }
        });
    }


}
