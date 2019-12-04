package com.example.finalprojectcs125;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sets the welcome screen text to something nice and welcoming :)
        String[] welcomeArray = new String[21];
        double random = (Math.random() * (welcomeArray.length - 1));
        int replacer = (int) Math.ceil(random);
        System.out.println("The random number is: " + replacer);

        welcomeArray[0] = "Welcome!";;
        welcomeArray[1] = "Hey guys!";
        welcomeArray[2] = "How about that extra credit?";
        welcomeArray[3] = "Welcome to my CS125 app!";
        welcomeArray[4] = "Hello there :D";
        welcomeArray[5] = "Hey guys, welcome to my CS125 Project walkthrough :)";
        welcomeArray[6] = "Did you do today's CS 125 HW?";
        welcomeArray[7] = "CS 125 was great. I hear the sequel, CS 225, is even 'greater'....";
        welcomeArray[8] = "So a student and a CA walk into office hours... " +
                "Just kidding! there's no such thing as CAs in office hours!";
        welcomeArray[9] = "Hey you!, Python is better than java. " +
                "Don't tell Geoff I said that, though.";
        welcomeArray[10] = "Welcome! What keeps you up at night? " +
                "For me, it's my CS 125 quiz average";
        welcomeArray[11] = "Ready to get Arthritis? Good. Start Clicking!";
        welcomeArray[12] = "Welcome to my app. Take a look around :)";
        welcomeArray[13] = "howdy!";
        welcomeArray[14] =  "bienvenidos ustedes!";
        welcomeArray[15] = "Nothing special here. Just the welcome screen :). Have we met?";
        welcomeArray[16] = "Hey you! Are you a 10xer? Please help me improve my app :)";
        welcomeArray[17] = "Greetings. Ready or not, this app will be fun, " +
                "I promise. If it isn't, " +
                "you can yell at us using that feedback button on your left :)";
        welcomeArray[18] = "Gooooooooodmorningggg Siebel!";
        welcomeArray[19] = "Hello there, ready for some fun?";
        welcomeArray[20] = "Enter at your own risk. " +
                "App may crash your phone. Just kidding. Have fun!";











        // add more greetings?
        TextView welcomeText = findViewById(R.id.welcomeText);
        welcomeText.setText(welcomeArray[replacer]); //Welcome text
        // End of random greeting

        Button resetPoints = findViewById(R.id.resetPointsButton);
        resetPoints.setOnClickListener(f -> {
            points = 0;
            System.out.println("The points are now: " + points);
        });

        Button secretButton = findViewById(R.id.secretButton);
        secretButton.setOnClickListener(v -> { // Go to secret thankyou screen
            setContentView(R.layout.secret_thankyou);
            secretNameMethod();
            System.out.println("atteJHNBFINDSOFDSIFSDOFDFMK");
            EditText nameInputBar = findViewById(R.id.thankyouNameInput);
            nameInputBar.setVisibility(View.VISIBLE);
            ////

        });




    }

    public void secretNameMethod() {
        boolean CS125Staff = false;

        EditText userNameInput = findViewById(R.id.thankyouNameInput);
        String compareName = userNameInput.toString(); //??

        // TODO: 2019-12-02 find way to make clean transition instead of choppy blackscreen
        // Test cases to deal with if empty string, nan, null, etc.

        Button returnToMain = findViewById(R.id.returnToMainMenuFromSecret);
        returnToMain.setOnClickListener(f -> { // Returns to mainMenu from secret thankyou screen
            setContentView(R.layout.activity_main);
            Intent intent = getIntent();
            recreate();
            points++;
            System.out.println("!!!!points are: " + points);
            startActivity(intent);
        });

        if (compareName.equals("Geoff Challen")) {
            points = 378456738;
            CS125Staff = true;
            // Thank you message
        }
        if (compareName.equals("Ben Nordick")) {
            points = 3928407;
            CS125Staff = true;
            // Thank you message
        }
        String[] taArray = new String[8];
        taArray[0] = "Aabhas Chauhan";
        taArray[1] = "Heather Huynh";
        taArray[2] = "Jishnu Dey";
        taArray[3] = "Mingkun Gao";
        taArray[4] = "Mohammed Hassan";
        taArray[5] = "Nerla Jean-Louis";
        taArray[6] = "Silas Hsu";
        taArray[7] = "Vinith Krishnan";

        String[] caArray = new String[86];
        caArray[0] = "Alan Andrade";
        caArray[1] = "Alex Nickl";
        caArray[2] = "Andre Castaneda";
        caArray[3] = "Ang Li";
        caArray[4] = "Archisha Majee";
        caArray[5] = "Arden Wen";
        caArray[6] = "Ashay Mehta";
        caArray[7] = "Ben Sutter";
        caArray[8] = "Benedict Austriaco";
        caArray[9] = "Blair Wang";
        caArray[10] = "Calen Resh";
        caArray[11] = "Charudutt Kher";
        caArray[12] = "Chris Kull";
        caArray[13] = "Colleen McConnell";
        caArray[14] = "David Ruvinskiy";
        caArray[15] = "Dylan Ott";
        caArray[16] = "Emilia Kedainis";
        caArray[17] = "Eric Liu";
        caArray[18] = "Filip Matasic";
        caArray[19] = "Gabriella Xue";
        caArray[20] = "Geon Kim";
        caArray[21] = "Husnain Raza";
        caArray[22] = "Hyosang Ahn";
        caArray[23] = "Isabel Ruiz";
        caArray[24] = "Isaiah Delgado";
        caArray[25] = "Jack Gentile";
        caArray[26] = "Jack Shao";
        caArray[27] = "Jeffrey Aguirre";
        caArray[28] = "Jessie Yang";
        caArray[29] = "Jiacheng Guo";
        caArray[30] = "Jiahe Su";
        caArray[31] = "Jiaqi Cao";
        caArray[32] = "Jiaqi Cheng";
        caArray[33] = "John Weng";
        caArray[34] = "Jonathan Kim";
        caArray[35] = "Jordan Parker";
        caArray[36] = "Joseph Wang";
        caArray[37] = "Long Phan";
        caArray[38] = "Matt Angel";
        caArray[39] = "Matt Forrest";
        caArray[40] = "Matthew Augustyn";
        caArray[41] = "Matthew Lezak";
        caArray[42] = "Matthew Pham";
        caArray[43] = "Megan Wang";
        caArray[44] = "Mona Liao";
        caArray[45] = "Moritz Kraemer";
        caArray[46] = "Nanyi Yang";
        caArray[47] = "Nima Shafikhani";
        caArray[48] = "Ning Wan";
        caArray[49] = "Pranav Raman";
        caArray[50] = "Quentin Wetzel";
        caArray[51] = "Quinn Collins";
        caArray[52] = "Ridha Alkhabaz";
        caArray[53] = "Rochelle Tham";
        caArray[54] = "Ruisong Li";
        caArray[55] = "Ryan O'Neall";
        caArray[56] = "Sarod Nori";
        caArray[57] = "Shirley Wang";
        caArray[58] = "Shruthi Kondin";
        caArray[59] = "Snehal Somalraju";
        caArray[60] = "Wajid Siddiqui";
        caArray[61] = "Waleed Khan";
        caArray[62] = "Wall Sun";
        caArray[63] = "Wangqi Xiang";
        caArray[64] = "Wei Shen";
        caArray[65] = "Xavier Higgins";
        caArray[66] = "Xiaohan Wang";
        caArray[67] = "Xiaoying Zhu";
        caArray[68] = "Yan Yan";
        caArray[69] = "Yixuan Jia";
        caArray[70] = "Youcheng Cai";
        caArray[71] = "Yu Du";
        caArray[72] = "Yunwen Zhu";
        caArray[73] = "Yuxin Wang";
        caArray[74] = "Zach Hamilton";
        caArray[75] = "Zaitian Wang";
        caArray[76] = "Zepei Li";
        caArray[77] = "Zihan Shan";
        caArray[78] = "Zihan Xu"; // Last CA ----
        caArray[79] = "Ahmad Dinkins"; // Office hours captains vvv
        caArray[80] = "Ajay Tatachar";
        caArray[81] = "Amirthavarshini Sureshbabu";
        caArray[82] = "Catherine Yuan";
        caArray[83] = "Daniel Gleason";
        caArray[84] = "Nikhil Garg";
        caArray[85] = "Rima Bouhal";
        for (int i = 0; i < taArray.length; i ++) { // TA thankyou array
            if (taArray[i].equals(compareName)) {
                points = 1000000; // million points
                CS125Staff = true;
                // Thank you message here
            }
        }
        for (int i = 0; i < caArray.length; i++) { // CA thankyou array
            if (caArray[i].equals(compareName)) {
                CS125Staff = true;
                points = 500000; //half a million points


                // Thank you message here
            }
        }
        if (CS125Staff == false) {
            System.out.println("Not CS125 staff!");
            // Do something?
        }
    }
}

