package com.example.finalprojectcs125;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/** Discussion page! This is where we will communicate so we know what we want & any issues we have - be as descriptive as possible
/** IF a task needs to be done, use the TODO text to do so
 *
 * Feedback Page ---------------
 * I would prefer if we did not have our email in clear text. The app should do work behind to scenes to take their info and send/store it
 *
 *
 * Settings Page ---------------
 * TODO add settings ofc - reset points button
 * Todo !!!!(ANGEL)!!!! Can you sort out the UI here? and check if everything looks neat and cool?
 * Be careful when sorting the UI ^^^^^ The points screen needs ample size to display the score ex: points of 100 or 100000000
 * What settings are going to be stored?
 *
 * Secret Thank You Page -------------
 * todo fix the clunkiness of thank you
 *
 *
 *
 * Main Clicker App Page --------------
 * todo make the page & theme & upgrade page
 * todo upgrades being x points per click, points per sec
 * todo special abilities IF time
 *
 *
 * General Critiques ---------
 * todo delete reset button on main page and all of it's usages
 *
 *
 */

public class MainActivity extends AppCompatActivity {

    /** points
     * Does what it says! Holds and stores the points that we have accumulated
     */
    public static int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sets the welcome screen text to something nice and welcoming :)
        String[] welcomeArray = new String[6];
        double random = (Math.random() * (welcomeArray.length - 1));
        int replacer = (int) Math.ceil(random);
        welcomeArray[0] = "Welcome!";
        welcomeArray[1] = "Hey guys!";
        welcomeArray[2] = "How about that extra credit?";
        welcomeArray[3] = "Welcome to my CS125 app!";
        welcomeArray[4] = "Hello there :D";
        welcomeArray[5] = "Hey guys, welcome to my CS125 Project walkthrough :)";
        TextView welcomeText = findViewById(R.id.welcomeText);
        welcomeText.setText(welcomeArray[replacer]); //sets the welcome text
        // End of welcome text setting stuff!


        // Takes us to the feedback menu
        Button feedbackMenuButton = findViewById(R.id.feedbackButton);
        feedbackMenuButton.setOnClickListener(e -> {
            setContentView(R.layout.feedback_layout);
            feedbackTransition();
        });

        // Takes us to the secret/staff menu
        Button secretButton = findViewById(R.id.secretButton);
        secretButton.setOnClickListener(o -> {
            secretNameMethodTransition();
        });

        // Takes us to the clicker game
        Button clickerGameButton = findViewById(R.id.clickergameButton);
        clickerGameButton.setOnClickListener(iw -> {
            setContentView(R.layout.clickergame_gaming);
        });

        // Takes us to the settingsButton
        Button settingsMenuButton = findViewById(R.id.settingsButton);
        settingsMenuButton.setOnClickListener(heyooo -> {
            settingsMenuTransition();
        });
    }

    /** feedbackTransition
     * transitions us to the feedbackMenu and initializes all the buttons
     */
    public void feedbackTransition() {
        setContentView(R.layout.feedback_layout);
        TextView feedtext = findViewById(R.id.feedtext);
        feedtext.setVisibility(View.VISIBLE);

        Button returnMain = findViewById(R.id.returnMain);
        returnMain.setOnClickListener(f -> { //Returns to mainMenu from feedback screen
            setContentView(R.layout.activity_main);
            mainMenuButtonReinitializer();
        });
    }



    public void settingsMenuTransition() {
        setContentView(R.layout.setting_menu);

        TextView settingsMenuTextView = findViewById(R.id.settingsMenuPointsDisplay);
        settingsMenuTextView.setText("Your points are: " + points);

        Button muteMusicButton = findViewById(R.id.muteMusicButton);
        muteMusicButton.setOnClickListener(ef -> {
            // TODO: 2019-12-05 add code that will mute the music
        });

        Button muteSoundEffectsButton = findViewById(R.id.muteSoundEffectsButton);
        muteSoundEffectsButton.setOnClickListener(egg -> {
            // TODO: 2019-12-05 add code that will mute the sound effects
        });

        Button resetPointsButton = findViewById(R.id.resetPointsButton);
        resetPointsButton.setOnClickListener(eg -> {
            points = 0;
            settingsMenuTextView.setText("Your points are: " + points);
        });

        Button returnToMainMenu = findViewById(R.id.returnToMainMenuFromSettings);
        returnToMainMenu.setOnClickListener(eggwugu -> {
            mainMenuButtonReinitializer();
        });

        Switch darkModeSwitch = findViewById(R.id.darkModeSwitch);
        darkModeSwitch.setOnClickListener(gnijs -> {
            Log.i("Test","The darkmode switch has been toggled!");
            // TODO: 2019-12-05 add code here that will make the game go in darkmode! Do we need to store a boolean?
        });
    }



    /** mainMenuButtonReinitializer
     * Reinitializes all the buttons and stuff on the main menu!
     */
    public void mainMenuButtonReinitializer() {

        setContentView(R.layout.activity_main);
        // TODO: 2019-12-04 Make it so the greeting is randomly changed when going back to main 
        
        // Reinitializes the secretButton
        Button secretButton = findViewById(R.id.secretButton);
        secretButton.setOnClickListener(v -> { // Go to secret thankyou screen
            secretNameMethodTransition();
        });


        // Reinitializes the settingsButton
        Button settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(v -> {
            settingsMenuTransition();
        });

        // Reinitializes the feedbackButton
        Button feedbackButton = findViewById(R.id.feedbackButton);
        feedbackButton.setOnClickListener(v -> {
            feedbackTransition();
        });

        Button clickerGameButton = findViewById(R.id.clickergameButton);
        clickerGameButton.setOnClickListener(iw -> {
            clickerGameTransition();
        });
    }




    /** Below this block is work that has to do with the clickerGame & its transitions
     * Below this block is work that has to do with the clickerGame & its transitions
     * Below this block is work that has to do with the clickerGame & its transitions
     * Below this block is work that has to do with the clickerGame & its transitions
     * Below this block is work that has to do with the clickerGame & its transitions
     * Below this block is work that has to do with the clickerGame & its transitions
     * Below this block is work that has to do with the clickerGame & its transitions
     */

    public void clickerGameTransition() {
        setContentView(R.layout.clickergame_gaming);

        Button returnToMainMenuButton = findViewById(R.id.gotoMainMenuFromClickerAppButton);
        returnToMainMenuButton.setOnClickListener(egg -> {
            mainMenuButtonReinitializer();
        });

        Button gotoSettingsButton = findViewById(R.id.gotoSettingsFromClickerAppButton);
        gotoSettingsButton.setOnClickListener(eggwugu -> {
            settingsMenuTransition();
        });

        Button clickForPointsButton = findViewById(R.id.clickerAppClickingButton);
        clickForPointsButton.setOnClickListener(egggg -> {
            // TODO: 2019-12-05 Do something when they click the button to get points!
        });

        Button upgradePointsButton = findViewById(R.id.gotoUpgradesFromClickerAppButton);
        upgradePointsButton.setOnClickListener(transitionTime -> {
            // TODO: 2019-12-05 Add transition to upgrade menu!
        });
    }



    /** Below this block is work that has to do with the secretNameMethod & its transitions
     * Below this block is work that has to do with the secretNameMethod & its transitions
     * Below this block is work that has to do with the secretNameMethod & its transitions
     * Below this block is work that has to do with the secretNameMethod & its transitions
     * Below this block is work that has to do with the secretNameMethod & its transitions
     * Below this block is work that has to do with the secretNameMethod & its transitions
     * Below this block is work that has to do with the secretNameMethod & its transitions
     * Below this block is work that has to do with the secretNameMethod & its transitions
     * Below this block is work that has to do with the secretNameMethod & its transitions
     * Below this block is work that has to do with the secretNameMethod & its transitions
     */

    /** secretNameMethodTransition
     * Transitions us from main menu to the secretNameMethod
     */
    public void secretNameMethodTransition() {
        // Sets the screen and ensures that the
        setContentView(R.layout.secret_thankyou);

        Button submitNameButton = findViewById(R.id.submitNameButton);
        EditText thankYouNameInput = findViewById(R.id.thankyouNameInput);

        // When we click submit - call the secretPoints method & clear the text box
        submitNameButton.setOnClickListener(l -> {
            String x = thankYouNameInput.getText().toString();
            secretNameMethod(x);
            thankYouNameInput.setText("");

            // Hides the keyboard after we input something
            View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager managerABC = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                managerABC.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });

        // TODO: 2019-12-05 Find a way to hide the Enter name here when we initially click
        thankYouNameInput.setOnClickListener(ef -> {
            thankYouNameInput.setText("");
        });

        //Reinitializes the button to take us back to the main menu
        Button returnToMain = findViewById(R.id.returnToMainMenuFromSecret);
        returnToMain.setOnClickListener(f -> { //Returns to mainMenu from secret thankyou screen
            //setContentView(R.layout.activity_main);
            System.out.println("!!!!points are: " + points);
            mainMenuButtonReinitializer();
        });
    }


    /** secretNameMethod
     * Takes the parameter and compares it to see if the user is a CA/TA/Staff/Creator of the game
     * @param compareName Passed through textbox that is provided and is used as a comparison.
     */
    public void secretNameMethod(String compareName) {
        boolean CS125Staff = false;

        TextView thankYouMessage = findViewById(R.id.thankyouMessage);
        thankYouMessage.setText(""); // clears the text box each time the screen is accessed & button is pressed

        // TODO: 2019-12-05 Make it so the setText is more smooth (not long & clunky, too many lines etc.)


        if (compareName.equals("Nathaniel Zukowski")) {
            points = 1000000000; //bil
            thankYouMessage.setText("Hey! I made this game!");
            CS125Staff = true;
        }

        if (compareName.equals("Angel Canty")) {
            points = 1000000000;
            thankYouMessage.setText("Your thankyou here");
            CS125Staff = true;
        }

        if (compareName.equals("Geoff Challen")) {
            points = 378456738;
            Log.i("SecretNameMethod","---------------");
            Log.i("SecretNameMethod","JDHSBKLMDSFNSD our points are: " + points);
            CS125Staff = true;
            thankYouMessage.setText("Thanks for the great semester!");
        }
        if (compareName.equals("Ben Nordick")) {
            points = 3928407;
            CS125Staff = true;
            thankYouMessage.setText("Thanks for making the MP and helping others in office hours, on the forum and irl!");
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
                thankYouMessage.setText("Thanks for TAing for CS 125! Your work helped us succeed this semester!");
            }
        }
        for (int i = 0; i < caArray.length; i++) { // CA thankyou array
            if (caArray[i].equals(compareName)) {
                CS125Staff = true;
                points = 500000; //half a million points
                thankYouMessage.setText("Thanks for CAing this semester! Your work in office hours" +
                        " and on the form helped us with the MPs, final project, homework and so much more. Thanks for everything!");
            }
        }
        if (CS125Staff == false) {
            System.out.println("Not CS125 staff!");
            //thankYouMessage.setText("");
        }
    }
}

