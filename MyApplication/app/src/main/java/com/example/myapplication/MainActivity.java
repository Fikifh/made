package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtWidth, edtHeigh, edtLength;
    Button btnCalculate;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtWidth = findViewById(R.id.edt_width);
        edtLength = findViewById(R.id.edt_length);
        edtHeigh = findViewById(R.id.edt_heigh);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_calculate){
            String inputLength = edtLength.getText().toString().trim();
            String inputWidth = edtWidth.getText().toString().trim();
            String inputHeigh = edtHeigh.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if(TextUtils.isEmpty(inputLength)){
                isEmptyFields = true;
                edtLength.setError("Field Ini TIdak Boleh Kosong !");
            }
            if(TextUtils.isEmpty(inputWidth)){
                isEmptyFields = true;
                edtLength.setError("Field Ini Tidak Boleh Kosong !");
            }
            if(TextUtils.isEmpty(inputHeigh)){
                isEmptyFields = true;
                edtHeigh.setError("Field Ini Tidak Boleh Kosong !");
            }

            Double length = toDouble(inputLength);
            Double width = toDouble(inputWidth);
            Double heigh = toDouble(inputHeigh);

            if(heigh == null){
                isInvalidDouble = true;
                edtHeigh.setError("Field Ini Harus Berupa Nomor yang Valid !");
            }
            if(!isEmptyFields && !isInvalidDouble){
                double volume = length * width * heigh;
                tvResult.setText(String.valueOf(volume));
            }


        }
    }
    Double toDouble(String str){
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e){
            return null;
        }
    }
}

