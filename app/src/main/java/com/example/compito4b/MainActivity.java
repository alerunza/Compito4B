package com.example.compito4b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String scelta = "";

    public void convert(View v){
        EditText input = (EditText) findViewById(R.id.edt_input);
        double fahr = 0, kel = 0, conv = 0;
        String symbol = "";

        if(input.getText().toString().matches("") || scelta.matches("")){
            Toast.makeText(this, "Scegli la conversione o immetti un dato", Toast.LENGTH_SHORT).show();
            return;
        }

        if(input.getText().toString().matches("-237.15")){
            Toast.makeText(this, "Errore", Toast.LENGTH_SHORT).show();
            return;
        }

        if(scelta.contains("Fahrenheit")){
            fahr = Double.parseDouble(input.getText().toString());
            conv = ((fahr * 1.8) + 32);
            symbol = "F";
        }
        if(scelta.contains("Kelvin")){
            kel = Double.parseDouble(input.getText().toString());
            conv = kel + 273.15;
            symbol = "K";
        }

        Intent valoreconvertito = new Intent(this, MainActivity2.class);
        valoreconvertito.putExtra("valconv", String.valueOf(conv));
        valoreconvertito.putExtra("symbol", symbol);
        startActivity(valoreconvertito);

        //output.setText(String.valueOf(conv) + " " + symbol);
    }

    public void choose(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.rb_far:
                if (checked){
                    scelta = "Fahrenheit";
                }
                    break;
            case R.id.rb_kel:
                if (checked){
                    scelta = "Kelvin";
                }
                    break;
        }
    }
}