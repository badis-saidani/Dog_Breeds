package com.badis.dogbreeds;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
Created By Badis Saidani 5/13/2019
*/
public class DataParser extends AsyncTask<Void,Void,Integer> {

    Context c;
    String jsonData;
    ListView lv;

    ProgressDialog pd;

    ArrayList<Breed> breeds = new ArrayList<>();

    public DataParser(Context c, String jsonData, ListView lv) {
        this.c = c;
        this.jsonData = jsonData;
        this.lv = lv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd = new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...Please wait");
        pd.show();
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

        pd.dismiss();

        if (result == 0) {
            Toast.makeText(c, "Unable To Parse 1 ", Toast.LENGTH_SHORT).show();
        } else {
            //BIND DATA TO LISTVIEW
            DogAdapter adapter = new DogAdapter(c, breeds);
            lv.setAdapter(adapter);
        }
    }

    private int parseData() {
        try {
            JSONArray ja = new JSONArray(jsonData);
            JSONObject jo = null;

            breeds.clear();


            for (int i = 0; i < ja.length(); i++) {
                Breed breed = new Breed();
                jo = ja.getJSONObject(i);

                int id = jo.getInt("id");
                String name = jo.getString("name");
                String bred_for = "N/A";
                String breed_group = "N/A";
                String life_span = "N/A";
                String temperament = "N/A";
                String origin= "N/A";

                    id = jo.getInt("id");
                    name = jo.getString("name");

                    try {
                    bred_for = jo.getString("bred_for");
                } catch (JSONException e) {
                };
                try {
                    breed_group = jo.getString("breed_group");
                } catch (JSONException e) {
                };
                try {
                    life_span = jo.getString("life_span");
                } catch (JSONException e) {
                };
                try {
                    temperament = jo.getString("temperament");
                } catch (JSONException e) {
                };
                try {
                    origin= jo.getString("origin");
                } catch (JSONException e) {
                };






                breed.setId(id);
                breed.setName(name);
                breed.setBred_for(bred_for);
                breed.setBreed_group(breed_group);
                breed.setLife_span(life_span);
                breed.setTemperament(temperament);
                breed.setOrigin(origin);

                breeds.add(breed);


            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
