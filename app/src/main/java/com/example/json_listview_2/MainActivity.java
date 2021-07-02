package com.example.json_listview_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//Widgets
    ListView listy;

    // JSON STRING
    //This is the format of Json
    //CHEK the DESCRIPTION Below for SOURCE CODE

    String json_string = "{\n" +
            "\"title\":\"JSONParserTutorial\", \n" +
            " \"array\" :[\n" +
            " {\n" +
            " \"company\": \"Google\"\n" +
            " }, \n" +
            " {\n" +
            " \"company\": \"Nokia\"\n" +
            " }, \n" +
            " {\n" +
            " \"company\": \"Tesla\"\n" +
            " }, \n" +
            " {\n" +
            " \"company\": \"Microsoft\"\n" +
            " }, \n" +
            " {\n" +
            " \"company\": \"Apple\"\n" +
            " }, \n" +
            " {\n" +
            " \"company\": \"Samsung\"\n" +
            " }, \n" +
            " {\n" +
            " \"company\": \"Hello\"\n" +
            " }, \n" +
            " {\n" +
            " \"company\": \"World\"\n" +
            " } \n" +
            " ], \n" +
            " \"nested\": {\n" +
            " \"flag\" : true,\n" +
            " \"random_number\":1\n" +
            " }\n" +
            " }";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Getting Json Objects
        try {
            listy = findViewById(R.id.list_view);

            // 1 - Storing Items in a lest
            List<String> items = new ArrayList<>();

            // 2 - Creating a JSON Object
            JSONObject root = new JSONObject(json_string);

            //3 Getting data from array
            JSONArray array = root.getJSONArray("array");

            //4- Setting the title
            this.setTitle(root.getString("title"));

            // 5 - Loop to get al company details/ objects
            for (int i = 0; i < array.length(); i++){
                JSONObject object = array.getJSONObject(i);
                items.add(object.getString("company"));
            }

            //6- Creating adapter for the listView items
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items);

            if (listy != null){
                listy.setAdapter(adapter);
            }

            JSONObject nested = root.getJSONObject("nested");
            Log.d("TAG", "flag value" + nested.getBoolean("flag"));


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}