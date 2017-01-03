package com.example.mkang_pc.pokersessiontracker;

import android.content.SharedPreferences;
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
        final TextView netValue = (TextView) findViewById(R.id.netValue);
        float net = 0;
        if (!isEmpty(bi) && !isEmpty(co)) { // if fields are not empty
            float buyin = Float.parseFloat(bi.getText().toString());
            float cashout = Float.parseFloat(co.getText().toString());
            net = cashout - buyin;
            netValue.setText(String.valueOf(net));
        }
        else {
            netValue.setText("please fill in some values");
        }

        SharedPreferences sharedPref = getSharedPreferences("progress", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putFloat("total", net);
        editor.commit();
    }

    public void commitValue(View view) {
        SharedPreferences sharedPref = getSharedPreferences("progress", 0);
        float value = sharedPref.getFloat("total",0);
        final TextView netValue = (TextView) findViewById(R.id.netValue);
        netValue.setText(String.valueOf(value));
    }

    private boolean isEmpty(EditText eText) { // true = field is empty, false = not empty
        return eText.getText().toString().trim().length() == 0;
    }
}
