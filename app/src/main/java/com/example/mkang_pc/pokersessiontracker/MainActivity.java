package com.example.mkang_pc.pokersessiontracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void calculateDifference(View view) {
        EditText bi = (EditText) findViewById(R.id.buyin);
        EditText co = (EditText) findViewById(R.id.cashout);
        double buyin = Double.parseDouble(bi.getText().toString());
        double cashout = Double.parseDouble(co.getText().toString());
        double net = cashout - buyin;
        final TextView netValue = (TextView) findViewById(R.id.netValue);
        netValue.setText(String.valueOf(net));
    }
}
