package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer firstOperand, secondOperand;
    private Boolean isOperationClick;
    private Boolean isOperationPlus = false;
    private Boolean isOperationMinus = false;
    private Boolean isOperationMultiply = false;
    private Boolean isOperationDivide = false;

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
        firstOperand = Integer.valueOf(data);

        if (view.getId() == R.id.btn_plus) {
            isOperationPlus = true;
        }

        if (view.getId() == R.id.btn_minus) {
            isOperationMinus = true;
        }

        if (view.getId() == R.id.btn_multiply) {
            isOperationMultiply = true;
        }

        if (view.getId() == R.id.btn_divide) {
            isOperationDivide = true;
        }
        isOperationClick = true;
    }

    public void onEqualClick(View view) {
        String data = textView.getText().toString();
        secondOperand = Integer.valueOf(data);
        if (isOperationPlus) {
            Integer result = firstOperand + secondOperand;
            textView.setText(result.toString());
            isOperationPlus = false;
        } else if (isOperationMinus) {
            Integer result = firstOperand - secondOperand;
            textView.setText(result.toString());
            isOperationMinus = false;
        } else if (isOperationMultiply) {
            Integer result = firstOperand * secondOperand;
            textView.setText(result.toString());
            isOperationMultiply = false;
        } else if (isOperationDivide) {
            Integer result = firstOperand / secondOperand;
            textView.setText(result.toString());
            isOperationDivide = false;
        }
        isOperationClick = true;
    }
}