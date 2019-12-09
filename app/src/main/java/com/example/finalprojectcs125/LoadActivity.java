package com.example.finalprojectcs125;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class LoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);


        // TODO: 2019-12-08 Add some unique startup greetings!
        String[] loadArray = new String[10];
        double random = (Math.random() * (loadArray.length - 1));
        int replacer = (int) Math.ceil(random);
        loadArray[0] = "load1";
        loadArray[1] = "load2";
        loadArray[2] = "load3";
        loadArray[3] = "load4";
        loadArray[4] = "load5";
        loadArray[5] = "load6";
        loadArray[6] = "load7";
        loadArray[7] = "load8";
        loadArray[8] = "load9";
        loadArray[9] = "load10";

        TextView loadingText = findViewById(R.id.loadingScreenTextView);
        loadingText.setText(loadArray[replacer]);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main = new Intent(LoadActivity.this, MainActivity.class);
                startActivity(main);
                finish();
            }
        }, 4500); //4.5 sec delay before start
    }
}
