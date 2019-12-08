package com.example.finalprojectcs125;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class enter_the_matrix extends View {
    private static final Random rand = new Random();
    private int width;     //default initial width
    private int height;        //default initial height
    private Canvas canvas;    //default canvas
    private Bitmap bitmap;     //Bitmap used to create the canvas
    private int fontSize = 15;       //font size of the text which will fall
    private int columnSize;      //column size ; no of digit required to fill the screen
    private char[] code = "=+-*&^%$#@!~*&%$#@%^&CS125#@!$%&*9&&^%GEOFF%$#@$#%=+-=_%#+_$".toCharArray();
    private int[] textSize;
    private Paint paint;



    public enter_the_matrix(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}

