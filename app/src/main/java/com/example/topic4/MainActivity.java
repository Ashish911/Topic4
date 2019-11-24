package com.example.topic4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button btnIntent;

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
        final ListView Countries = findViewById(R.id.LvCountries);
        btnIntent = findViewById(R.id.btnB);

        dictionary = new HashMap<>();
        for (int i = 0; i < countries.length; i+=2) {
            dictionary.put(countries[i],countries[i+1]);
        }

        /**
         * A class of android which sets the values uniformly.
         */
        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet())
        );

        Countries.setAdapter(adapter);

        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MessageActivity.class);
                intent.putExtra("myMessage", "Hello there");
                startActivity(intent);
            }
        });

        Countries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country = parent.getItemAtPosition(position).toString();
                String capital = dictionary.get(country);
                Toast.makeText(getApplicationContext(), capital.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        );

    }
}
