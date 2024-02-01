package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String data = getIntent().getStringExtra("key1");
        TextView textView = findViewById(R.id.text_view);
        textView.setText(data);
    }

    public void onNextClick(View view) {
        this.finishAffinity();
    }
}