package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer firstOperand, secondOperand;
    private Boolean isOperationClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        if (view.getId() == R.id.btn_clear) {
            textView.setText("0");
            firstOperand = 0;
            secondOperand = 0;
        } else {
            String text = ((MaterialButton) view).getText().toString();
            if (textView.getText().toString().equals("0") || isOperationClick) {
                textView.setText(text);
            } else {
                textView.append(text);
            }
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        String data = textView.getText().toString();
        if (view.getId() == R.id.btn_plus) {
            firstOperand = Integer.valueOf(data);
        } else if (view.getId() == R.id.btn_equal) {
            secondOperand = Integer.valueOf(data);
            Integer result = firstOperand + secondOperand;
            textView.setText(result.toString());
        }
        isOperationClick = true;
    }
}