package com.example.finalprojectcs125;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


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
 * todo fix transition crash
 *
 *
 * General Critiques ---------
 * Effectivity of a randomized array of only 6 or so greetings
 * is questionable. It's PSYCH 101 when understanding that the Diversification of greetings adds excitement and encourages
 * repeated visits to the main menu. I've coined it
 * the "fortune cookie effect", wherein user will visit menu (or any screen with randomized
 * strings) multiple times in an attempt to see a new greeting or message. May increase users time on our app. Note.
 *
 *
 */

public class MainActivity extends AppCompatActivity {
    public TextView timerio;
    public  TextView clicksio;
    public  Button empezario;
    public ImageButton clickerio;
    boolean BackgroundColorChanger = true;
    /**
     * music
     */
    MediaPlayer song;
    MediaPlayer song2;
    /**
     * checks if X upgrade has been purchased.
     */
    boolean upgrade1Purchased = false;
    boolean upgrade2Purchased = false;
    boolean upgrade3Purchased = false;
    boolean upgrade4Purchased = false;
    boolean upgrade5Purchased = false;
    boolean upgrade6Purchased = false;
    boolean upgrade7Purchased = false;
    boolean upgrade8Purchased = false;

    CountDownTimer time;

    int tiempo = 30;
    int clix = 0;

    boolean leftClickerGame = false;

    /** points
     * Does what it says! Holds and stores the points that we have accumulated
     */
    public static int points;

    /** pointsPerClick
     * Sets the pointsPerClick! Initially is 1 point per click
     */
    public static int pointsPerClick;

    /** loadTime
     * The amount of time in seconds the user will need to wait until the page loads
     */
    public static int loadTime = 10;

    /**
     *
     */
    boolean firstimeforeverything = true;

    /** darkMode
     * boolean that checks if we are in darkmode ( toggle in settings )
     */
    boolean darkMode = false;

    /** musicEnabled
     * tells us if the user wants to hear music
     */
    boolean musicEnabled = true;

    /** soundEffectsEnabled
     * tells us if the user wants to hear sound effects
     */
    boolean soundEffectsEnabled = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: 2019-12-07 brief transition when starting app
        setContentView(R.layout.activity_main);

        VideoView video = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.vid);
        video.setVideoURI(uri);
        video.start();
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });


        /**
         * adds music
         */
        song = MediaPlayer.create(this, R.raw.song);
        song.setLooping(true);
        song.setVolume(1000,1000);
        song.start();
        //MediaPlayer ring= MediaPlayer.create(MainActivity.this,R.raw.song);
        // ring.start();


        View currentView = this.findViewById(android.R.id.content);
        ConstraintLayout clickup = findViewById(R.id.clickup);
        if (currentView.equals(clickup) && musicEnabled) { //credits menu music
            song2 = MediaPlayer.create(this, R.raw.upgrades_song);
            song2.setLooping(true);
            song2.setVolume(1000,1000);
            song2.start();
        } else {
            if (musicEnabled) {
                song.start();
            }
        }




        /**
         * will save data if we choose to enable
         */
        SharedPreferences.Editor save = getSharedPreferences("myInt", MODE_PRIVATE).edit();
        save.putInt("points", points);
        save.apply();

        TextView title = findViewById(R.id.title);
        title.setTextColor(Color.RED);

        SharedPreferences pref = getSharedPreferences("PreferencesName", MODE_PRIVATE);
        int myInt = pref.getInt("points",0);

        pointsPerClick = 1;

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
        Button feedbackMenuButton = findViewById(R.id.creditsButton);
        feedbackMenuButton.setBackgroundColor(Color.RED);
        feedbackMenuButton.setOnClickListener(e -> {
            setContentView(R.layout.feedback_layout);
            feedbackTransition();
        });

        // Takes us to the secret/staff menu
        Button secretButton = findViewById(R.id.secretButton);
        secretButton.setBackgroundColor(Color.RED);
        secretButton.setOnClickListener(o -> {
            secretNameMethodTransition();
        });

        // Takes us to the clicker game
        Button clickerGameButton = findViewById(R.id.clickergameButton);
        clickerGameButton.setBackgroundColor(Color.RED);
        clickerGameButton.setOnClickListener(iw -> {
            attemptatttempt();
            /*
            setContentView(R.layout.clickergame_gaming);
            clickerGameTransition();

             */
        });

        // Takes us to the settingsButton
        Button settingsMenuButton = findViewById(R.id.settingsButton);
        settingsMenuButton.setBackgroundColor(Color.RED);
        settingsMenuButton.setOnClickListener(heyooo -> {
            settingsMenuTransition();
        });

        TextView menuTextPoints = findViewById(R.id.menuPointsTextView);
        menuTextPoints.setTextColor(Color.WHITE);
        menuTextPoints.setText("You have: " + points + " points");

    }

    /** feedbackTransition
     * transitions us to the feedbackMenu and initializes all the buttons
     */
    public void feedbackTransition() {
        // TODO: 2019-12-07 add transition func here 
        setContentView(R.layout.feedback_layout);
        TextView feedtext = findViewById(R.id.feedtext);
        feedtext.setVisibility(View.VISIBLE);
        /**
         * credits?
         */
        Animation animation;
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.feedback_layout);
        feedtext.setText("CREDITS\n" + "Aaaaaaaaaaaaaaaaaaaaaaa - wwwwwwwwwwww\n");
        feedtext.startAnimation(animation);
        song.stop();
        song2 = MediaPlayer.create(this, R.raw.still_feel);
        song2.setLooping(true);
        song2.setVolume(1000,1000);
        song2.start();

        Button returnMain = findViewById(R.id.returnMain);
        returnMain.setOnClickListener(f -> { //Returns to mainMenu from feedback screen
            setContentView(R.layout.activity_main);
            song2.stop();
            song = MediaPlayer.create(this, R.raw.song);
            song.setLooping(true);
            song.setVolume(1000,1000);
            song.start();
            mainMenuButtonReinitializer();
        });

    }

    /** clickerGame
     * code that allows the clicker to work properly.
     */
    public void clickerGame() {

        firstimeforeverything = false;

        //startClickerGame
        // if startClickerGame == true then start everything and set boolean to FALSE
        // if timer == 0 then stop the timer and do the do
        // IF the layout is NOT clickergame then stop
        // or, if user calls upgrade menu or settings or mainmenu, set the boolean to false


        /**
         * this textView is the timer.
         */
        timerio = findViewById(R.id.timer);
        //timerio.setTextColor(Color.WHITE);
        //timerio.setBackgroundColor(Color.RED);
        /**
         * this textView shows the # of clicks the user has
         */
        clicksio = findViewById(R.id.clicks);
        clicksio.setBackgroundColor(Color.RED);
        clicksio.setTextColor(Color.BLACK);
        /**
         * this button allows the user to start a clicking session.
         * If not clicked, the clicker wil not work. empezar = start, in spanish.
         */
        empezario = findViewById(R.id.empezar);
        /**
         * this is the clicker button itself.
         */

        currentEraButton.setEnabled(false);
        // TODO: 2019-12-07  declare all image buttons here 

        empezario.setEnabled(true);

        /**
         * this textview encourages the user to keep playing once the timer has run out.
         */
        TextView finished = findViewById(R.id.finished);
       // finished.setTextColor(Color.WHITE);
        //finished.setBackgroundColor(Color.BLACK);


        time = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tiempo--;
                timerio.setText("Time: " + tiempo);
                //finished.setText("");
                if (tiempo == 0 ) {
                    finished.setText("Out Of Time!");
                }
            }

            @Override
            public void onFinish() {
                TextView clickerapppTs = findViewById(R.id.clickerAppPointsTextView);
                clickerapppTs.setTextColor(Color.BLACK);
                clickerapppTs.setBackgroundColor(Color.RED);
                empezario.setEnabled(true);
                currentEraButton.setEnabled(false); // TODO: 2019-12-07 if ??EracurrentlyEquipped then set enabled false
                String[] coercionArray = new String[9];
                double random = (Math.random() * (coercionArray.length - 1));
                int cs225 = (int) Math.ceil(random);
                coercionArray[0] = "Wanna play again?";
                coercionArray[1] = "What? You thought that was it? PLAY AGAIN!";
                coercionArray[2] = "Play again. I dare you";
                coercionArray[3] = "give in to your anger....click that button some more!";
                coercionArray[4] = "clickclickclickclick---don't stop! let's play again!";
                coercionArray[5] = "let us play again. shall we?";
                coercionArray[6] = "my i5 four-core can run faster than you can click. click faster!";
                coercionArray[7] = "Good work, but like my CS125 grade, it could be better. Try again?";
                coercionArray[8] = "Have you gotten Arthritis yet? No? Then click some more!";
                finished.setText(coercionArray[cs225]);
                if (leftClickerGame == false) {
                    TextView clickerappPts = findViewById(R.id.clickerAppPointsTextView);
                    clickerappPts.setText("Total points: " + points);
                    // TODO: 2019-12-07 Ensure this bug is gone
                }
            }
        };
        currentEraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View x) {
                clix++;
                points += pointsPerClick;
                Log.i("Points","Points per click is: " + pointsPerClick);
                clicksio.setText("Clicks: " + clix);
                //timerio.setText("Time: 0");

            }
        });
                time.start();
                empezario.setEnabled(false);
                currentEraButton.setEnabled(true);
                clix = 0;
                tiempo = 30;
                timerio.setText("Time: " + tiempo);
                clicksio.setText("Clicks: " + clix);
                if (tiempo <= 30 && tiempo > 0) {
                    finished.setText("click away!");
                }
                if (tiempo <= 0) {
                    time.cancel();
                }





    }


    public void attemptatttempt() {
        setContentView(R.layout.activity_load);
        if (loadTime != 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent main = new Intent(MainActivity.this, MainActivity.class);
                    clickerGameTransition();
                    Log.i("Runner", "Ok charles we're doing it");
                }
            }, loadTime * 1000);//4.5 sec delay before start
            Log.i("Runner", "Charles you left me :(");
        } else {
            clickerGameTransition();
        }
    }


    public void settingsMenuTransition() {
        // TODO: 2019-12-07 add transition loading here
        setContentView(R.layout.setting_menu);
        leftClickerGame = true;

        TextView settingsMenuTextView = findViewById(R.id.settingsMenuPointsDisplay);
        settingsMenuTextView.setText("Your points are: " + points);

        Button muteMusicButton = findViewById(R.id.muteMusicButton);
        muteMusicButton.setOnClickListener(ef -> {
            if (musicEnabled) {
                musicEnabled = false;
                song.stop();
                Log.i("Music","Music is currently: " + musicEnabled);
            } else {
                musicEnabled = true;
                song = MediaPlayer.create(this, R.raw.song);
                song.start();
                Log.i("Music","Music is currently: " + musicEnabled);
            }
        });

        Button muteSoundEffectsButton = findViewById(R.id.muteSoundEffectsButton);
        muteSoundEffectsButton.setOnClickListener(egg -> {
            if (soundEffectsEnabled) {
                soundEffectsEnabled = false;
            } else {
                soundEffectsEnabled = true;
            }
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
            if (darkMode) {
                darkMode = false;
            } else {
                darkMode = true;
            }
            // TODO: 2019-12-05 add code here that will make the game go in darkmode! Do we need to store a boolean?
        });
    }



    /** mainMenuButtonReinitializer
     * Reinitializes all the buttons and stuff on the main menu!
     */
    public void mainMenuButtonReinitializer() {
        // TODO: 2019-12-07 add transition loading here 
        setContentView(R.layout.activity_main);
        leftClickerGame = true;
        TextView title = findViewById(R.id.title);
        title.setTextColor(Color.RED);

        VideoView video= (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.vid);
        video.setVideoURI(uri);
        video.start();


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
        welcomeText.setText(welcomeArray[replacer]);

        // Reinitializes the secretButton
        Button secretButton = findViewById(R.id.secretButton);
        secretButton.setBackgroundColor(Color.RED);
        secretButton.setOnClickListener(v -> { // Go to secret thankyou screen
            secretNameMethodTransition();
        });


        // Reinitializes the settingsButton
        Button settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setBackgroundColor(Color.RED);
        settingsButton.setOnClickListener(v -> {
            settingsMenuTransition();
        });

        // Reinitializes the feedbackButton
        Button feedbackButton = findViewById(R.id.creditsButton);
        feedbackButton.setBackgroundColor(Color.RED);
        feedbackButton.setOnClickListener(v -> {
            feedbackTransition();
        });

        Button clickerGameButton = findViewById(R.id.clickergameButton);
        clickerGameButton.setBackgroundColor(Color.RED);
        clickerGameButton.setOnClickListener(iw -> {
            attemptatttempt();
        });

        TextView menuTextPoints = findViewById(R.id.menuPointsTextView);
        menuTextPoints.setTextColor(Color.WHITE);
        menuTextPoints.setText("You have: " + points + " points");

        //VideoView video = (VideoView) findViewById(R.id.videoView);
        //Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.vid);
        video.setVideoURI(uri);
        video.start();
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        //MediaPlayer ring= MediaPlayer.create(MainActivity.this,R.raw.song);
        // ring.start();
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
        // TODO: 2019-12-07 add transition loading here
        setContentView(R.layout.clickergame_gaming);
        leftClickerGame = false;
        currentEraButton = findViewById(R.id.clicker);
        ConstraintLayout clickerGamebackGround = findViewById(R.id.j);
        if (darkMode) {
            clickerGamebackGround.setBackgroundColor(Color.BLACK);
        } else {
            clickerGamebackGround.setBackgroundColor(Color.WHITE);
        }

        if (era0UpgradeEquipped) {
            currentEraButton.setImageResource(R.drawable.background0);
        } else if (era1UpgradeEquipped) {
            currentEraButton.setImageResource(R.drawable.background1);
        } else if (era2UpgradeEquipped) {
            currentEraButton.setImageResource(R.drawable.background2);
        } else if (era3UpgradeEquipped) {
            currentEraButton.setImageResource(R.drawable.background3);
        } else if (era4UpgradeEquipped) {
            currentEraButton.setImageResource(R.drawable.background4);
        } else if (era5UpgradeEquipped) {
            currentEraButton.setImageResource(R.drawable.background5);
        }
        TextView timey = findViewById(R.id.timer);
        timey.setBackgroundColor(Color.RED);
        timey.setTextColor(Color.BLACK);

        TextView finisher = findViewById(R.id.finished);
        finisher.setTextColor(Color.BLACK);
        finisher.setBackgroundColor(Color.RED);



        Button returnToMainMenuButton = findViewById(R.id.gotoMainMenuFromClickerAppButton);
        returnToMainMenuButton.setBackgroundColor(Color.RED);
        returnToMainMenuButton.setOnClickListener(egg -> {
            if (!firstimeforeverything) {
                time.cancel();
            }
            leftClickerGame = true;
            mainMenuButtonReinitializer();
        });

        Button gotoSettingsButton = findViewById(R.id.gotoSettingsFromClickerAppButton);
        gotoSettingsButton.setBackgroundColor(Color.RED);
        gotoSettingsButton.setOnClickListener(eggwukjnsgu -> {
            if (!firstimeforeverything) {
                time.cancel();
            }
            leftClickerGame = true;
            settingsMenuTransition();
        });

        TextView yourPoints = findViewById(R.id.clickerAppPointsTextView);
        yourPoints.setText(" TOTAL POINTS: " + points);
        yourPoints.setTextColor(Color.BLACK);
        yourPoints.setBackgroundColor(Color.RED);

        TextView pointsPerClicks = findViewById((R.id.ppc));
        pointsPerClicks.setTextColor(Color.BLACK);
        pointsPerClicks.setBackgroundColor(Color.RED);
        pointsPerClicks.setText("CLICK VALUE: " + pointsPerClick);

        Button upgradePointsButton = findViewById(R.id.gotoUpgradesFromClickerAppButton);
        upgradePointsButton.setBackgroundColor(Color.RED);
        upgradePointsButton.setOnClickListener(transitionTime -> {
            if (!firstimeforeverything) {
                time.cancel();
            }
            leftClickerGame = true;
            clickerUpgradePageOneTransition();
        });

        TextView click = findViewById(R.id.clicks);
        click.setText("CLICKS: 0");
        click.setTextColor(Color.BLACK);
        click.setBackgroundColor(Color.RED);

        currentEraButton.setEnabled(false);
        Button attackButton = findViewById(R.id.empezar);
        attackButton.setBackgroundColor(Color.RED);
        attackButton.setTextColor(Color.BLACK);
        attackButton.setOnClickListener(yoyo -> {
            attackButton.setEnabled(false);
            clickerGame();
        });
        
    }

    public void clickerUpgradePageOneTransition() {
        setContentView(R.layout.clickerupgrades_menu);

        Button gotoUpgradePageTwo = findViewById(R.id.upgradePageOneToTwo);
        gotoUpgradePageTwo.setOnClickListener(letsGo -> {
            clickerUpgradePageTwoTransition();
        });

        // X upgrade - costs 100
        Button upgrade1 = findViewById(R.id.upgrade1);
        if (points < 100 || upgrade1Purchased) {
            upgrade1.setEnabled(false);
        } else if (points >= 100 && !upgrade1Purchased){
            upgrade1.setEnabled(true);
        }

        upgrade1.setOnClickListener(e -> {
            pointsPerClick += 2;
            points = points - 100;
            upgrade1.setEnabled(false);
            upgrade1.setText("PURCHASED");
            upgrade1Purchased = true;
        });

        // X upgrade - costs 500
        Button upgrade2 = findViewById(R.id.upgrade2);
        if (points < 500 || upgrade2Purchased) {
            upgrade2.setEnabled(false);
        } else if (points >= 500 && !upgrade2Purchased){
            upgrade2.setEnabled(true);
        }
        upgrade2.setOnClickListener(e -> {
            pointsPerClick += 4;
            points = points - 500;
            upgrade2.setEnabled(false);
            upgrade2.setText("PURCHASED");
            upgrade2Purchased = true;
        });

        // X upgrade - costs 1000
        Button upgrade3 = findViewById(R.id.upgrade3);
        if (points < 1000 || upgrade3Purchased) {
            upgrade3.setEnabled(false);
        } else if (points >= 1000 && !upgrade3Purchased){
            upgrade3.setEnabled(true);
        }

            upgrade3.setOnClickListener(e -> {
                pointsPerClick += 6;
                points = points - 1000;
                upgrade3.setEnabled(false);
                upgrade3.setText("PURCHASED");
                upgrade3Purchased = true;
            });

        // X upgrade - costs 2000
        Button upgrade4 = findViewById(R.id.upgrade4);
        if (points < 2000 || upgrade4Purchased) {
            upgrade4.setEnabled(false);
        } else if (points >= 2000 && !upgrade4Purchased){
            upgrade4.setEnabled(true);
        }
        upgrade4.setOnClickListener(e -> {
            pointsPerClick += 8;
            points = points - 2000;
            upgrade4.setEnabled(false);
            upgrade4.setText("PURCHASED");
            upgrade4Purchased = true;
        });

        //i5 upgrade - cost 4k
        Button upgrade5 = findViewById(R.id.upgrade5);
        if (points < 4000 || upgrade5Purchased) {
            upgrade5.setEnabled(false);
        } else if (points >= 4000 && !upgrade5Purchased) {
            upgrade5.setEnabled(true);
        }
        upgrade5.setOnClickListener(e -> {
            if (loadTime > 7) {
                loadTime = 7;
            }
            Log.i("Loadtime","The loadtime is: " + loadTime);
            points = points - 4000;
            upgrade5.setEnabled(false);
            upgrade5.setText("PURCHASED");
            upgrade5Purchased = true;
        });

        //i7 upgrade - cost 6k
        Button upgrade6 = findViewById(R.id.upgrade6);
        if (points < 6000 || upgrade6Purchased) {
            upgrade6.setEnabled(false);
        } else if (points >= 6000 && !upgrade6Purchased) {
            upgrade6.setEnabled(true);
        }
        upgrade6.setOnClickListener(e -> {
            if (loadTime > 5) {
                loadTime = 5;
            }
            Log.i("Loadtime","The loadtime is: " + loadTime);
            points = points - 6000;
            upgrade6.setEnabled(false);
            upgrade6.setText("PURCHASED");
            upgrade6Purchased = true;
        });

        //i9 upgrade - cost 8k
        Button upgrade7 = findViewById(R.id.upgrade7);
        if (points < 8000 || upgrade7Purchased) {
            upgrade7.setEnabled(false);
        } else if (points >= 8000 && !upgrade7Purchased) {
            upgrade7.setEnabled(true);
        }
        upgrade7.setOnClickListener(e -> {
            if (loadTime > 3) {
                loadTime = 3;
            }
            Log.i("Loadtime","The loadtime is: " + loadTime);
            points = points - 8000;
            upgrade7.setEnabled(false);
            upgrade7.setText("PURCHASED");
            upgrade7Purchased = true;
        });

        //threadripper upgrade - cost 10k
        Button upgrade8 = findViewById(R.id.upgrade8);
        if (points < 10000 || upgrade8Purchased) {
            upgrade8.setEnabled(false);
        } else if (points >= 10000 && !upgrade8Purchased) {
            upgrade8.setEnabled(true);
        }
        upgrade8.setOnClickListener(e -> {
            loadTime = 0;
            Log.i("Loadtime","The loadtime is: " + loadTime);
            points = points - 10000;
            upgrade8.setEnabled(false);
            upgrade8.setText("PURCHASED");
            upgrade8Purchased = true;
        });

        Button returnToClickerApp = findViewById(R.id.returnToClickerApp);
        returnToClickerApp.setOnClickListener(egggg -> {
            clickerGameTransition();
        });

        TextView upgradeText1 = findViewById(R.id.upgradeText1);
        upgradeText1.setText("student powerup");

        TextView upgradeText2 = findViewById(R.id.upgradeText2);
        upgradeText2.setText("10xer student powerup");

        TextView upgradeText3 = findViewById(R.id.upgradeText3);
        upgradeText3.setText("CA powerup");

        TextView upgradeText4 = findViewById(R.id.upgradeText4);
        upgradeText4.setText("TA powerup");

        TextView upgradeText5 = findViewById(R.id.upgradeText5);
        upgradeText5.setText("Upgrade5Text");

        TextView upgradeText6 = findViewById(R.id.upgradeText6);
        upgradeText6.setText("Upgrade6Text");

        TextView upgradeText7 = findViewById(R.id.upgradeText7);
        upgradeText7.setText("Upgrade7Text");

        TextView upgradeText8 = findViewById(R.id.upgradeText8);
        upgradeText8.setText("Upgrade8Text");
        // vvv These set the text for if the upgrade has been purchased (global boolean) vvv


        if (upgrade1Purchased) { // Points per click upgrade 1
            upgrade1.setText("PURCHASED");
        } else {
            upgrade1.setText("Up1"); // TODO: 2019-12-07 Change text here for powerup button name & same for below
        }
        // -------------------------------
        if (upgrade2Purchased) { // Points per click upgrade 2
            upgrade2.setText("PURCHASED");
        } else {
            upgrade2.setText("Up2");
        }
        // -------------------------------
        if(upgrade3Purchased) { // Points per click upgrade 3
            upgrade3.setText("PURCHASED");
        } else {
            upgrade3.setText("Up3");
        }
        // -------------------------------
        if(upgrade4Purchased) { // Points per click upgrade 4
            upgrade4.setText("PURCHASED");
        } else {
            upgrade4.setText("Up4");
        }
        // -------------------------------
        if(upgrade5Purchased) { //i5
            upgrade5.setText("PURCHASED");
        } else {
            upgrade5.setText("i5");
        }
        // -------------------------------
        if(upgrade6Purchased) { //i7
            upgrade6.setText("PURCHASED");
        } else {
            upgrade6.setText("i7");
        }
        // -------------------------------
        if(upgrade7Purchased) { //i9
            upgrade7.setText("PURCHASED");
        } else {
            upgrade7.setText("i9");
        }
        // -------------------------------
        if(upgrade8Purchased) { //threadripper
            upgrade8.setText("PURCHASED");
        } else {
            upgrade8.setText("Threadripper");
        }
    }


    public boolean era1UpgradeBought = false;
    public boolean era2UpgradeBought = false;
    public boolean era3UpgradeBought = false;
    public boolean era4UpgradeBought = false;
    public boolean era5UpgradeBought = false;

    public boolean era0UpgradeEquipped = true;
    public boolean era1UpgradeEquipped = false;
    public boolean era2UpgradeEquipped = false;
    public boolean era3UpgradeEquipped = false;
    public boolean era4UpgradeEquipped = false;
    public boolean era5UpgradeEquipped = false;

    public ImageButton currentEraButton;

    public void clickerUpgradePageTwoTransition() {
        setContentView(R.layout.clickerupgrades2_menu);
        Button backtoUpgradePageOne = findViewById(R.id.returnToUpgradePg1);
        backtoUpgradePageOne.setOnClickListener(eee -> {
            clickerUpgradePageOneTransition();
        });



        Button era0Upgrade = findViewById(R.id.clickerButtonChange0);
        era0Upgrade.setEnabled(false);

        if (!era0UpgradeEquipped) {
            era0Upgrade.setText("Equip?");
            era0Upgrade.setEnabled(true);
        }
        era0Upgrade.setOnClickListener(neutral -> {
            era0Upgrade.setText("Equipped");
            era0Upgrade.setEnabled(false);
            era0UpgradeEquipped = true; // THIS UPGRADE equipped
            era1UpgradeEquipped = false;
            era2UpgradeEquipped = false;
            era3UpgradeEquipped = false;
            era4UpgradeEquipped = false;
            era5UpgradeEquipped = false;
            clickerUpgradePageTwoTransition();
        });






        // 5k
        Button era1Upgrade = findViewById(R.id.clickerButtonChange1);
        era1Upgrade.setEnabled(false);

        // If the upgrade is not equipped AND the upgrade has been purchased
        if (!era1UpgradeEquipped && era1UpgradeBought) {
            era1Upgrade.setText("Equip?");
            era1Upgrade.setEnabled(true);
        }
        // If the upgrade has not been equipped
        if (!era1UpgradeBought && points >= 5000) {
            era1Upgrade.setEnabled(true);
            era1Upgrade.setText("BUY?");
        }

        era1Upgrade.setOnClickListener(e -> {
            if (!era1UpgradeBought) {
                points = points - 5000;
                era1UpgradeBought = true;
                era1UpgradeEquipped = true;
            }
            // equip shenanigans
            era0UpgradeEquipped = false;
            era1UpgradeEquipped = true; // THIS UPGRADE equipped
            era2UpgradeEquipped = false;
            era3UpgradeEquipped = false;
            era4UpgradeEquipped = false;
            era5UpgradeEquipped = false;
            clickerUpgradePageTwoTransition();
        });






        // 10k
        Button era2Upgrade = findViewById(R.id.clickerButtonChange2);
        era2Upgrade.setEnabled(false);

        // If the upgrade is not equipped AND the upgrade has been purchased
        if (!era2UpgradeEquipped && era2UpgradeBought) {
            era2Upgrade.setText("Equip?");
            era2Upgrade.setEnabled(true);
        }

        // If the upgrade has not been equipped
        if (!era2UpgradeBought && points >= 10000) {
            era2Upgrade.setEnabled(true);
            era2Upgrade.setText("BUY?");
        }

        era2Upgrade.setOnClickListener(ee -> {
            if (!era2UpgradeBought) {
                points = points - 10000;
                era2UpgradeBought = true;
                era2UpgradeEquipped = true;
            }
            // equip shenanigans
            era0UpgradeEquipped = false;
            era1UpgradeEquipped = false;
            era2UpgradeEquipped = true; // THIS UPGRADE equipped
            era3UpgradeEquipped = false;
            era4UpgradeEquipped = false;
            era5UpgradeEquipped = false;
            clickerUpgradePageTwoTransition();
        });






        // 15k
        Button era3Upgrade = findViewById(R.id.clickerButtonChange3);
        era3Upgrade.setEnabled(false);

        // If the upgrade is not equipped AND the upgrade has been purchased

        if (!era3UpgradeEquipped && era3UpgradeBought) {
            era3Upgrade.setText("Equip?");
            era3Upgrade.setEnabled(true);
        }

        // If the upgrade has not been equipped
        if (!era3UpgradeBought && points >= 15000) {
            era3Upgrade.setEnabled(true);
            era3Upgrade.setText("BUY?");
        }


        era3Upgrade.setOnClickListener(eee -> {
            if (!era3UpgradeBought) {
                points = points - 15000;
                era3UpgradeBought = true;
                era3UpgradeEquipped = true;
            }
            // equip shenanigans
            era0UpgradeEquipped = false;
            era1UpgradeEquipped = false;
            era2UpgradeEquipped = false;
            era3UpgradeEquipped = true; // THIS UPGRADE equipped
            era4UpgradeEquipped = false;
            era5UpgradeEquipped = false;
            clickerUpgradePageTwoTransition();
        });






        // 20k
        Button era4Upgrade = findViewById(R.id.clickerButtonChange4);
        era4Upgrade.setEnabled(false);

        // If the upgrade is not equipped AND the upgrade has been purchased
        if (!era4UpgradeEquipped && era4UpgradeBought) {
            era4Upgrade.setText("Equip?");
            era4Upgrade.setEnabled(true);
        }

        // If the upgrade has not been equipped
        if (!era4UpgradeBought && points >= 20000) {
            era4Upgrade.setEnabled(true);
            era4Upgrade.setText("BUY?");
        }

        era4Upgrade.setOnClickListener(eeee -> {
            if (!era4UpgradeBought) {
                points = points - 20000;
                era4UpgradeBought = true;
                era4UpgradeEquipped = true; // THIS UPGRADE equipped
            }
            era0UpgradeEquipped = false;
            era1UpgradeEquipped = false;
            era2UpgradeEquipped = false;
            era3UpgradeEquipped = false;
            era4UpgradeEquipped = true; // THIS UPGRADE equipped
            era5UpgradeEquipped = false;
            clickerUpgradePageTwoTransition();
        });






        // 25k
        Button era5Upgrade = findViewById(R.id.clickerButtonChange5);
        era5Upgrade.setEnabled(false);

        // If the upgrade is not equipped AND the upgrade has been purchased
        if (!era5UpgradeEquipped && era5UpgradeBought) {
            era5Upgrade.setText("Equip?");
            era5Upgrade.setEnabled(true);
        }

        // If the upgrade has not been equipped
        if (!era5UpgradeBought && points >= 25000) {
            era5Upgrade.setEnabled(true);
            era5Upgrade.setText("BUY?");
        }

        era5Upgrade.setOnClickListener(eeee -> {
            if (!era5UpgradeBought) {
                points = points - 25000;
                era5UpgradeBought = true;
                era5UpgradeEquipped = true;
            }
            // equip shenanigans
            era0UpgradeEquipped = false;
            era1UpgradeEquipped = false;
            era2UpgradeEquipped = false;
            era3UpgradeEquipped = false;
            era4UpgradeEquipped = false;
            era5UpgradeEquipped = true; // THIS UPGRADE equipped
            clickerUpgradePageTwoTransition();
        });

        if (era0UpgradeEquipped) {
            era0Upgrade.setText("Equipped");
        }
        if (era1UpgradeEquipped) {
            era1Upgrade.setText("Equipped");
        }
        if (era2UpgradeEquipped) {
            era2Upgrade.setText("Equipped");
        }
        if (era3UpgradeEquipped) {
            era3Upgrade.setText("Equipped");
        }
        if (era4UpgradeEquipped) {
            era4Upgrade.setText("Equipped");
        }
        if (era5UpgradeEquipped) {
            era5Upgrade.setText("Equipped");
        }

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
            thankYouMessage.setText("Hey! I also made this game!");
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
                thankYouMessage.setText("CS125 TAs get it done, and in doing so help students get " +
                        "what they've got to get done done as well. In other words, thank you! " + "AWARDED: 1000000pts");
            }
        }
        for (int i = 0; i < caArray.length; i++) { // CA thankyou array
            if (caArray[i].equals(compareName)) {
                CS125Staff = true;
                points = 500000; //half a million points
                thankYouMessage.setText(" CS125 CAs are the life jackets keeping students " +
                        "afloat while they learn" +
                        " to swim their way through this ocean of a course. Thank you! AWARDED: 1000000pts");
            }
        }
        if (CS125Staff == false) {
            System.out.println("Not CS125 staff!");
            //thankYouMessage.setText("");
        }
    }
}
