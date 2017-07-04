package com.example.codetribe.coffeeorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView menu;
    TextView total;
    MainActivity x = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        menu = (TextView)findViewById(R.id.lblMenu);
        total = (TextView)findViewById(R.id.lblTotal);

        //Intent in  = getIntent();
        //String total = in.getStringExtra("total");
        menu.setText(x.val + "\n\n- " + x.topping.getSelectedItem().toString() + " Topping");
        total.setText("Total: " + x.txtTotal.getText().toString());
    }

}
