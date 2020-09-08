package com.looa.pa1b;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private int money = 300;
    private TextView showMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showMoney = findViewById(R.id.money_textview);
        showMoney.setText(String.format("%s", money));

        Button btnAdd = findViewById(R.id.add_button);
        Button btnRoll = findViewById(R.id.roll_button);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMoney();
            }
        });

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll();
            }
        });
    }

    public void addMoney() {
        money = money + 10;
        showMoney.setText(String.format("%s", money));
    }

    public void roll(){
        if(money < 30) {
            Toast.makeText(getApplicationContext(), "You've wasted all your money!",
                    Toast.LENGTH_LONG).show();
        } else {
            money = money - 30;
            showMoney.setText(String.format("%s", money));

            Random rng = new Random();
            int pull = rng.nextInt(4) + 1;

            Intent i = new Intent(getApplicationContext(), SecondActivity.class);
            i.putExtra("rng", pull);
            startActivity(i);
        }
    }

}
