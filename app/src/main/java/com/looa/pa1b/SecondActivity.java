package com.looa.pa1b;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        int p = getIntent().getExtras().getInt("rng", 1);
        ImageView prizeView = findViewById(R.id.prize);
        switch (p) {
            case 1:
                prizeView.setImageResource(R.drawable.sword_r);
                break;
            case 2:
                prizeView.setImageResource(R.drawable.sword_sr);
                break;
            case 3:
                prizeView.setImageResource(R.drawable.sword_ssr);
                break;
            case 4:
                prizeView.setImageResource(R.drawable.sword_uhh);
        }

        Button btnFinish = findViewById(R.id.finish_button);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
