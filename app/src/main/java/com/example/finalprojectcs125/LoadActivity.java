package com.example.finalprojectcs125;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoadActivity extends AppCompatActivity {
    int a = 1000000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);


       // ProgressBar works;
       // works = new ProgressDialog(LoadActivity.this);
        //works.setMessage("Loading..");
        //w.setTitle("Get Data");
       // nDialog.setIndeterminate(false);
       // nDialog.setCancelable(true);
       // nDialog.show();
        final ProgressBar pbar = findViewById(R.id.pbar);
        pbar.setProgress(a);
        //pbar.setVisibility(View.VISIBLE);
        ProgressBar v =  findViewById(R.id.pbar);
        v.getIndeterminateDrawable().setColorFilter(Color.RED,
                android.graphics.PorterDuff.Mode.MULTIPLY);


        // TODO: 2019-12-08 Add some unique startup greetings!
        String[] loadArray = new String[8];
        double random = (Math.random() * (loadArray.length - 1));
        int replacer = (int) Math.ceil(random);
        loadArray[0] = "Welcome, Coder aspirant.";
        loadArray[1] = "Please wait, coder Aspirant.";
        loadArray[2] = "Hello there, coder aspirant.";
        loadArray[3] = "Ready to click, coder aspirant?";
        loadArray[4] = "greetings, coder aspirant.";
        loadArray[5] = "We've been expecting you, coder aspirant.";
        loadArray[6] = "Hola. Bienvenido, aspirante.";
        loadArray[7] = "Ready, aspirant ?";

        TextView loadingText = findViewById(R.id.loadingScreenTextView);
        loadingText.setText(loadArray[replacer]);
        loadingText.setTextColor(Color.WHITE);

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
