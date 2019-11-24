package com.example.topic4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        TextView tvOutput = findViewById(R.id.tvOutput);
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            String message = bundle.getString("myMessage");
            tvOutput.setText(message);
        }
        else
        {
            Toast.makeText(this, "No Message", Toast.LENGTH_SHORT).show();
        }

    }
}
