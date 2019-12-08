package com.example.finalprojectcs125;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * credit to Youtube channel: Sylvain Saurel for tutorial and source of most code
 */
public class enter_the_matrix extends View {
    private static final Random rand = new Random();
    private int width;     //default initial width
    private int height;        //default initial height
    private Canvas canvas;    //default canvas
    private Bitmap bitmap;     //Bitmap used to create the canvas
    private int fontSize = 30;       //font size of the text which will fall
    private int columnSize;      //column size ; no of digit required to fill the screen
    private char[] code = "=+-*&^%$#@!~*&%$#@%^&CS125#@!$%&*9&&^%GEOFF%$#@$#%=+-=_%#+_$".toCharArray();
    private int[] textSize;
    private Paint paint, paint2, paint3, paint4;



    public enter_the_matrix(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        paint.setTextSize(30);

        paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(Color.BLACK);
        paint2.setAlpha(5);

        paint3 = new Paint();
        paint3.setColor(Color.BLACK);

        paint4 = new Paint();
        paint4.setColor(Color.BLACK);
        paint4.setAlpha(255);
        paint4.setStyle(Paint.Style.FILL);
    }

    protected void onSizeChanged(int w, int h, int ow, int oh) {
        super.onSizeChanged(w, h, ow, oh);
        width = w;
        height = h;

        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        canvas.drawRect(0, 0, width, height, paint4);
        columnSize = width / fontSize;

        textSize = new int[columnSize + 1];

        for (int i = 0; i < columnSize; i++) {
            textSize[i] = rand.nextInt(height / 2) + 1;
        }
    }
    private void maul() {
        for (int i = 0; i < textSize.length; i++) {
            canvas.drawText("" + code[rand.nextInt(code.length)], i * fontSize, textSize[i] * fontSize, paint);
            if (textSize[i] * fontSize > height && Math.random() > 0.975) {
                textSize[i] = 0;
            }
            textSize[i]++;
        }
    }
    private void darth() {
        canvas.drawRect(0,0, width, height, paint2);
        maul();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 0,0, paint3);
        darth();
        invalidate();
    }
}

