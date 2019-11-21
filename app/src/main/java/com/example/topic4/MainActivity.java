package com.example.topic4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String countries[] = {
            "Nepal" ,
            "India" ,
            "Chine",
            "UK",
            "USA",
            "Canada"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView Countries = findViewById(R.id.LvCountries);

        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );

        Countries.setAdapter(adapter);

    }
}
