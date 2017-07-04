package com.example.codetribe.coffeeorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

//public class MainActivity extends AppCompatActivity {
    public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //Finding elements in the xml
    CheckBox chkCof;
    CheckBox chkHot;
    CheckBox chkCup;

    TextView lblCof;
    TextView lblHot;
    TextView lblCup;

    TextView lblR1;
    TextView lblR2;
    TextView lblR3;

    public static EditText txtTotal, txtCofQ, txtHotQ, txtCup;
    TextView lblTotal;
    public static Spinner topping;

    Button btnOrder;
    Double total = 0.0;
    Button btnCheckout;
    public static String val = "";
   // public static Double quantity = 0.0;
    public static TextView lblQues;

    EditText Q1;
    public static EditText Q2;
    public static EditText Q3;
    public static TextView Q;

    public static Double amount;
    public static Double t;
    public static int q1;
    public static int q2;
    public static int q3;

    public static String myX;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Casting variables;
        txtTotal = (EditText) findViewById(R.id.txtTotal);
        chkCof = (CheckBox) findViewById(R.id.chkCoffee1);
        chkHot = (CheckBox) findViewById(R.id.chkCoffee2);
        chkCup = (CheckBox) findViewById(R.id.chkCoffee3);
        lblCof = (TextView) findViewById(R.id.txtPrice1);
        lblCup = (TextView) findViewById(R.id.txtPrice3);
        lblHot = (TextView) findViewById(R.id.txtPrice2);
        lblR1 = (TextView) findViewById(R.id.lblR1);
        lblR2 = (TextView) findViewById(R.id.lblR2);
        lblR3 = (TextView) findViewById(R.id.lblR3);
        btnOrder = (Button) findViewById(R.id.btnOrder);
        lblTotal = (TextView) findViewById(R.id.lblTotal);
        btnCheckout = (Button) findViewById(R.id.btnProceed);
        lblQues = (TextView) findViewById(R.id.lblQues);

        topping = (Spinner)findViewById(R.id.spinner);


        Q1 = (EditText) findViewById(R.id.txtC);
        Q2 = (EditText) findViewById(R.id.txtH);
        Q3 = (EditText) findViewById(R.id.txtCa);
        Q = (TextView) findViewById(R.id.lblQues);

        btnOrder.setOnClickListener(this);

//        btnOrder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                    //if(Q1.equals(0))
//                calcOrder();
//            }
//        });

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);
            }
        });

        chkCof.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!chkCof.isChecked()){
                    lblTotal.setVisibility(View.INVISIBLE);
                    txtTotal.setVisibility(View.INVISIBLE);
                    btnCheckout.setVisibility(View.INVISIBLE);
                    btnOrder.setVisibility(View.INVISIBLE);
                    Q.setVisibility(View.INVISIBLE);
                    Q1.setVisibility(View.INVISIBLE);
                    lblCof.setVisibility(View.VISIBLE);
                    lblR1.setVisibility(View.VISIBLE);
                }
                else{
                    chkCof.setFocusable(true);
                    btnOrder.setVisibility(View.VISIBLE);
                    Q.setVisibility(View.VISIBLE);
                    Q1.setText("");
                    Q1.setVisibility(View.VISIBLE);
                    lblCof.setVisibility(View.INVISIBLE);
                    lblR1.setVisibility(View.INVISIBLE);
                }
            }
        });

        chkHot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!chkHot.isChecked()){
                    lblTotal.setVisibility(View.INVISIBLE);
                    txtTotal.setVisibility(View.INVISIBLE);
                    btnCheckout.setVisibility(View.INVISIBLE);
                    btnOrder.setVisibility(View.INVISIBLE);
                    Q.setVisibility(View.INVISIBLE);
                    Q2.setVisibility(View.INVISIBLE);
                    lblHot.setVisibility(View.VISIBLE);
                    lblR2.setVisibility(View.VISIBLE);
                }
                else {
                    chkHot.setFocusable(true);
                    lblTotal.setVisibility(View.INVISIBLE);
                    txtTotal.setVisibility(View.INVISIBLE);
                    btnOrder.setVisibility(View.VISIBLE);
                    Q.setVisibility(View.VISIBLE);
                    Q2.setText("");
                    Q2.setVisibility(View.VISIBLE);
                    lblHot.setVisibility(View.INVISIBLE);
                    lblR2.setVisibility(View.INVISIBLE);
                }
            }
        });

        chkCup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!chkCup.isChecked()){
                    lblTotal.setVisibility(View.INVISIBLE);
                    txtTotal.setVisibility(View.INVISIBLE);
                    btnCheckout.setVisibility(View.INVISIBLE);
                    btnOrder.setVisibility(View.INVISIBLE);
                    Q.setVisibility(View.INVISIBLE);
                    Q3.setVisibility(View.INVISIBLE);
                    lblCup.setVisibility(View.VISIBLE);
                    lblR3.setVisibility(View.VISIBLE);
                }
                else{
                    chkCup.setFocusable(true);
                    btnOrder.setVisibility(View.VISIBLE);
                    Q.setVisibility(View.VISIBLE);
                    Q3.setText("");
                    Q3.setVisibility(View.VISIBLE);
                    lblCup.setVisibility(View.INVISIBLE);
                    lblR3.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    void calcOrder() {

        if (chkCof.isChecked()) {
            txtTotal.setVisibility(View.VISIBLE);
            lblTotal.setVisibility(View.VISIBLE);

            Double x = Double.valueOf(lblCof.getText().toString());
            Double q = Double.valueOf(Q1.getText().toString());
            total = q * x;

            txtTotal.setText(Double.toString(Double.valueOf(new DecimalFormat("#.##").format(total))));
            val = "Coffee with " + Q1.getText() + Double.toString(total + x);
            btnCheckout.setVisibility(View.VISIBLE);
        }else{
            Q1.setError("Please Fill In How Many Cups!");
        }
        if (chkHot.isChecked()) {
            txtTotal.setVisibility(View.VISIBLE);
            lblTotal.setVisibility(View.VISIBLE);

            Double x = Double.valueOf(lblHot.getText().toString());
            Double q = Double.valueOf(Q2.getText().toString());
            total = x * q;
            txtTotal.setText(Double.toString(Double.valueOf(new DecimalFormat("#.##").format(total))));
            val = "Hot Coco " +Q2.getText()+ " @ R" + x.toString();
            btnCheckout.setVisibility(View.VISIBLE);
        }
        if (chkCup.isChecked()) {
            txtTotal.setVisibility(View.VISIBLE);
            lblTotal.setVisibility(View.VISIBLE);

            Double x = Double.valueOf(lblCup.getText().toString());
            Double q = Double.valueOf(Q3.getText().toString());

            total = x * q;
            txtTotal.setText(Double.toString(Double.valueOf(new DecimalFormat("#.##").format(total))));
            val = "Cappuccino "+Q3.getText()+ " @ R" + lblCup.getText();
            btnCheckout.setVisibility(View.VISIBLE);
        }
        if (chkCof.isChecked() && chkHot.isChecked()) {
            txtTotal.setVisibility(View.VISIBLE);
            lblTotal.setVisibility(View.VISIBLE);

            Double x = Double.valueOf(lblCof.getText().toString());
            Double y = Double.valueOf(lblHot.getText().toString());
            Double q1 = Double.valueOf(Q1.getText().toString());
            Double q2 = Double.valueOf(Q2.getText().toString());

            total = (x * q1) + (y * q2);
            //Double.valueOf(new DecimalFormat("#.##").format(total));
            txtTotal.setText("R" + Double.toString(Double.valueOf(new DecimalFormat("#.##").format(total))));

            val = "Coffee "+Q1.getText()+" @ R" + x + "\nHot Coco "+Q2.getText()+ " @ R" + y;
            btnCheckout.setVisibility(View.VISIBLE);
        }
        if (chkCof.isChecked() && chkCup.isChecked()) {
            txtTotal.setVisibility(View.VISIBLE);
            lblTotal.setVisibility(View.VISIBLE);

            Double x = Double.valueOf(lblCof.getText().toString());
            Double z = Double.valueOf(lblCup.getText().toString());
            Double q1 = Double.valueOf(Q1.getText().toString());
            Double q3 = Double.valueOf(Q3.getText().toString());

            total = (x * q1) + (z * q3);

            txtTotal.setText("R" + Double.toString(Double.valueOf(new DecimalFormat("#.##").format(total))));
            val = "Coffee "+Q1.getText()+" @ R" + x + "\nCappuccino "+Q3.getText()+ " @ R" +  z;
            btnCheckout.setVisibility(View.VISIBLE);
        }
        if (chkHot.isChecked() && chkCup.isChecked()) {
            txtTotal.setVisibility(View.VISIBLE);
            lblTotal.setVisibility(View.VISIBLE);
            btnOrder.setText("Order");
            

            Double y = Double.valueOf(lblHot.getText().toString());
            Double z = Double.valueOf(lblCup.getText().toString());
            Double q2 = Double.valueOf(Q2.getText().toString());
            Double q3 = Double.valueOf(Q3.getText().toString());

            total = (y * q2) + (z * q3);

            txtTotal.setText("R" + Double.toString(Double.valueOf(new DecimalFormat("#.##").format(total))));
            val = "Hot Coco "+Q2.getText()+" @ R" + y + "\nCappuccino "+Q3.getText()+" @ R" + z;
            btnCheckout.setVisibility(View.VISIBLE);
        }
        if (chkCof.isChecked() && chkHot.isChecked() && chkCup.isChecked()) {
            txtTotal.setVisibility(View.VISIBLE);
            lblTotal.setVisibility(View.VISIBLE);

            Double x = Double.valueOf(lblCof.getText().toString());
            Double y = Double.valueOf(lblHot.getText().toString());
            Double z = Double.valueOf(lblCup.getText().toString());
            Double q1 = Double.valueOf(Q1.getText().toString());
            Double q2 = Double.valueOf(Q2.getText().toString());
            Double q3 = Double.valueOf(Q3.getText().toString());

            total = (x * q1) + (y * q2) + (z * q3);

            txtTotal.setText("R" + Double.toString(Double.valueOf(new DecimalFormat("#.##").format(total))));
            val = "Coffee "+Q1.getText()+" @ R" + x + "\nHot Coco "+Q2.getText()+" @ R" + y +
                    "\nCappuccino "+Q3.getText()+" @ R" + z;
            btnCheckout.setVisibility(View.VISIBLE);
        }
        if (!chkCof.isChecked() && !chkHot.isChecked() && !chkCup.isChecked()) {
            txtTotal.setVisibility(View.INVISIBLE);
            lblTotal.setVisibility(View.INVISIBLE);

            txtTotal.setText("R");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOrder:
                validation();
                break;

        }
    }

    void validation(){

        if(Q1.getText().toString().isEmpty()){
            Q1.setError("Please enter a Number value");
        }
        if(Q2.getText().toString().isEmpty()){
            Q2.setError("Please enter a Number value");
        }
        if(Q3.getText().toString().isEmpty()){
            Q3.setError("Please enter a Number value");
        }
        if(!Q1.getText().toString().isEmpty() || !Q3.getText().toString().isEmpty() || !Q2.getText().toString().isEmpty()){
            calcOrder();

        }
    }

    Object topping(Object y) {
        if (myX.equalsIgnoreCase("Chocolate")) {
            y = "Topping: Chocolate";
        }
        if (myX.equalsIgnoreCase("Vanilla")) {
            y = "Topping: Vanilla";
        }
        if (myX.equalsIgnoreCase("White Cream")) {
            y = "Topping: White Cream";
        }
        if (myX.equalsIgnoreCase("White Coco")) {
            y = "Topping: White Coco";
        }
        if (myX.equalsIgnoreCase("Select Topping")) {
            y = "";
        }
        return y;
    }


}
