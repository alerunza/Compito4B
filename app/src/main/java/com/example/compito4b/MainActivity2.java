package com.example.compito4b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent home = getIntent();

        String conv = home.getStringExtra("valconv");
        String sym = home.getStringExtra("symbol");

        TextView val = (TextView) findViewById(R.id.txt_val);

        val.setText(conv + " " + sym);
    }

    public void backhome(View v){
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }

}