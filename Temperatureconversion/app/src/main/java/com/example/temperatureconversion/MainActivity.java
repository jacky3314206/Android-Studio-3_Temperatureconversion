package com.example.temperatureconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener, TextWatcher {


    RadioGroup unit;
    EditText value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unit = (RadioGroup) findViewById(R.id.unit);
        unit.setOnCheckedChangeListener(this);

        value = (EditText) findViewById(R.id.value);
        value.addTextChangedListener((TextWatcher) this);
    }

    @Override
    public void beforeTextChanged(CharSequence arg0, int start, int arg1, int arg2) {

    }

    @Override
    public void onTextChanged(CharSequence arg0, int start, int arg1, int arg2) {

    }

    @Override
    public void afterTextChanged(Editable arg0) {
        calc();
    }

    @Override
    public void onCheckedChanged(RadioGroup arg0, int arg1) {
        calc();
    }


    protected void calc() {
        TextView degF = (TextView) findViewById(R.id.degF);
        TextView degC = (TextView) findViewById(R.id.degC);

        double f=0,c = 0;  //儲存溫度換算結果

        if (unit.getCheckedRadioButtonId() == R.id.unitF) {

            if(!value.getText().toString().equals("")){           //如果輸入值有輸入時進行以下換算
                f = Double.parseDouble(value.getText().toString());
                c = (f - 32) * 5 / 9; //華式轉攝氏
            }

        } else {
            if(!value.getText().toString().equals("")) {     //如果輸入值有輸入時進行以下換算
                c = Double.parseDouble(value.getText().toString());
                f = c * 9 / 5 + 32; //攝氏轉華式
            }
        }




        degC.setText(String.format("%.1f", c) + getResources().getString(R.string.charC));


        degF.setText(String.format("%.1f", f) + getResources().getString(R.string.charF));
    }

}
