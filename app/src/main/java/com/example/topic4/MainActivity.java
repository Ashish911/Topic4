package com.example.topic4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String countries[] = {
            "Nepal", "Kathmandu",
            "India", "New Delhi" ,
            "Chine", "Beijing",
            "UK", "London",
            "USA", "Washington D.C",
            "Canada", "Ottawa"
    };
    private Map<String,String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView Countries = findViewById(R.id.LvCountries);

        dictionary = new HashMap<>();
        for (int i = 0; i < countries.length; i+=2) {
            dictionary.put(countries[i],countries[i+1]);
        }

        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet())
        );

        Countries.setAdapter(adapter);

    }
}
