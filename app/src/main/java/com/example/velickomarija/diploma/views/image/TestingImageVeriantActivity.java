package com.example.velickomarija.diploma.views.image;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.velickomarija.diploma.PauseTwoActivity;
import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.Algorithms;
import com.example.velickomarija.diploma.models.Functions;
import com.example.velickomarija.diploma.models.PreferencesLocal;
import com.example.velickomarija.diploma.views.sound.TestingSoundActivity;

import java.util.HashMap;
import java.util.Map;

public class TestingImageVeriantActivity extends AppCompatActivity {

    Algorithms algorithms = new Algorithms();
    TextView textViewTitle1;
    int parsedColor = Color.parseColor("#37bc51");
    PreferencesLocal preferencesLocal = new PreferencesLocal();

    boolean btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14,
            btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25, btn26,
            btn27, btn28, btn29, btn30, btn31, btn32, btn33, btn34, btn35, btn36;
    boolean[] btnArray = new boolean[36];

    @Override
    public void onBackPressed() {
        // do nothing
    }

    private void reverseElement2() {
        //general image
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton1.setImageResource(R.drawable.symbol8);
        ImageButton imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButton7.setImageResource(R.drawable.symbol9);
        ImageButton imageButton10 = (ImageButton) findViewById(R.id.imageButton10);
        imageButton10.setImageResource(R.drawable.symbol2);
        ImageButton imageButton12 = (ImageButton) findViewById(R.id.imageButton12);
        imageButton12.setImageResource(R.drawable.symbol3);
        ImageButton imageButton14 = (ImageButton) findViewById(R.id.imageButton14);
        imageButton14.setImageResource(R.drawable.symbol6);
        ImageButton imageButton18 = (ImageButton) findViewById(R.id.imageButton18);
        imageButton18.setImageResource(R.drawable.symbol10);
        ImageButton imageButton22 = (ImageButton) findViewById(R.id.imageButton22);
        imageButton22.setImageResource(R.drawable.symbol11);
        ImageButton imageButton24 = (ImageButton) findViewById(R.id.imageButton24);
        imageButton24.setImageResource(R.drawable.symbol1);
        ImageButton imageButton27 = (ImageButton) findViewById(R.id.imageButton27);
        imageButton27.setImageResource(R.drawable.symbol4);
        ImageButton imageButton30 = (ImageButton) findViewById(R.id.imageButton30);
        imageButton30.setImageResource(R.drawable.symbol7);
        ImageButton imageButton32 = (ImageButton) findViewById(R.id.imageButton32);
        imageButton32.setImageResource(R.drawable.symbol12);
        ImageButton imageButton34 = (ImageButton) findViewById(R.id.imageButton34);
        imageButton34.setImageResource(R.drawable.symbol5);

        //else image
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setImageResource(R.drawable.symbol6i);
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton3.setImageResource(R.drawable.symbol5r);
        ImageButton imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton4.setImageResource(R.drawable.symbol3i);
        ImageButton imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton5.setImageResource(R.drawable.symbol2i);
        ImageButton imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton6.setImageResource(R.drawable.symbol12r);
        ImageButton imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
        imageButton8.setImageResource(R.drawable.symbol12i);
        ImageButton imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
        imageButton9.setImageResource(R.drawable.symbol10i);
        ImageButton imageButton11 = (ImageButton) findViewById(R.id.imageButton11);
        imageButton11.setImageResource(R.drawable.symbol10r);
        ImageButton imageButton13 = (ImageButton) findViewById(R.id.imageButton13);
        imageButton13.setImageResource(R.drawable.symbol2r);
        ImageButton imageButton15 = (ImageButton) findViewById(R.id.imageButton15);
        imageButton15.setImageResource(R.drawable.symbol11r);
        ImageButton imageButton16 = (ImageButton) findViewById(R.id.imageButton16);
        imageButton16.setImageResource(R.drawable.symbol5i);
        ImageButton imageButton17 = (ImageButton) findViewById(R.id.imageButton17);
        imageButton17.setImageResource(R.drawable.symbol4r);
        ImageButton imageButton19 = (ImageButton) findViewById(R.id.imageButton19);
        imageButton19.setImageResource(R.drawable.symbol1r);
        ImageButton imageButton20 = (ImageButton) findViewById(R.id.imageButton20);
        imageButton20.setImageResource(R.drawable.symbol7r);
        ImageButton imageButton21 = (ImageButton) findViewById(R.id.imageButton21);
        imageButton21.setImageResource(R.drawable.symbol9i);
        ImageButton imageButton23 = (ImageButton) findViewById(R.id.imageButton23);
        imageButton23.setImageResource(R.drawable.symbol9r);
        ImageButton imageButton25 = (ImageButton) findViewById(R.id.imageButton25);
        imageButton25.setImageResource(R.drawable.symbol4i);
        ImageButton imageButton26 = (ImageButton) findViewById(R.id.imageButton26);
        imageButton26.setImageResource(R.drawable.symbol11i);
        ImageButton imageButton28 = (ImageButton) findViewById(R.id.imageButton28);
        imageButton28.setImageResource(R.drawable.symbol6r);
        ImageButton imageButton29 = (ImageButton) findViewById(R.id.imageButton29);
        imageButton29.setImageResource(R.drawable.symbol3r);
        ImageButton imageButton31 = (ImageButton) findViewById(R.id.imageButton31);
        imageButton31.setImageResource(R.drawable.symbol8r);
        ImageButton imageButton33 = (ImageButton) findViewById(R.id.imageButton36);
        imageButton33.setImageResource(R.drawable.symbol7i);
        ImageButton imageButton35 = (ImageButton) findViewById(R.id.imageButton35);
        imageButton35.setImageResource(R.drawable.symbol8i);
        ImageButton imageButton36 = (ImageButton) findViewById(R.id.imageButton36);
        imageButton36.setImageResource(R.drawable.symbol1i);
    }

    private void reverseElement1() {
        //general image
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton1.setImageResource(R.drawable.symbol11);
        ImageButton imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButton7.setImageResource(R.drawable.symbol5);
        ImageButton imageButton10 = (ImageButton) findViewById(R.id.imageButton10);
        imageButton10.setImageResource(R.drawable.symbol2);
        ImageButton imageButton12 = (ImageButton) findViewById(R.id.imageButton12);
        imageButton12.setImageResource(R.drawable.symbol9);
        ImageButton imageButton14 = (ImageButton) findViewById(R.id.imageButton14);
        imageButton14.setImageResource(R.drawable.symbol10);
        ImageButton imageButton18 = (ImageButton) findViewById(R.id.imageButton18);
        imageButton18.setImageResource(R.drawable.symbol1);
        ImageButton imageButton22 = (ImageButton) findViewById(R.id.imageButton22);
        imageButton22.setImageResource(R.drawable.symbol12);
        ImageButton imageButton24 = (ImageButton) findViewById(R.id.imageButton24);
        imageButton24.setImageResource(R.drawable.symbol6);
        ImageButton imageButton27 = (ImageButton) findViewById(R.id.imageButton27);
        imageButton27.setImageResource(R.drawable.symbol4);
        ImageButton imageButton30 = (ImageButton) findViewById(R.id.imageButton30);
        imageButton30.setImageResource(R.drawable.symbol7);
        ImageButton imageButton32 = (ImageButton) findViewById(R.id.imageButton32);
        imageButton32.setImageResource(R.drawable.symbol8);
        ImageButton imageButton34 = (ImageButton) findViewById(R.id.imageButton34);
        imageButton34.setImageResource(R.drawable.symbol3);

        //else image
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setImageResource(R.drawable.symbol11r);
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton3.setImageResource(R.drawable.symbol9r);
        ImageButton imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton4.setImageResource(R.drawable.symbol3r);
        ImageButton imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton5.setImageResource(R.drawable.symbol6i);
        ImageButton imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton6.setImageResource(R.drawable.symbol3i);
        ImageButton imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
        imageButton8.setImageResource(R.drawable.symbol4i);
        ImageButton imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
        imageButton9.setImageResource(R.drawable.symbol10i);
        ImageButton imageButton11 = (ImageButton) findViewById(R.id.imageButton11);
        imageButton11.setImageResource(R.drawable.symbol12r);
        ImageButton imageButton13 = (ImageButton) findViewById(R.id.imageButton13);
        imageButton13.setImageResource(R.drawable.symbol12i);
        ImageButton imageButton15 = (ImageButton) findViewById(R.id.imageButton15);
        imageButton15.setImageResource(R.drawable.symbol9i);
        ImageButton imageButton16 = (ImageButton) findViewById(R.id.imageButton16);
        imageButton16.setImageResource(R.drawable.symbol10r);
        ImageButton imageButton17 = (ImageButton) findViewById(R.id.imageButton17);
        imageButton17.setImageResource(R.drawable.symbol11i);
        ImageButton imageButton19 = (ImageButton) findViewById(R.id.imageButton19);
        imageButton19.setImageResource(R.drawable.symbol7r);
        ImageButton imageButton20 = (ImageButton) findViewById(R.id.imageButton20);
        imageButton20.setImageResource(R.drawable.symbol1r);
        ImageButton imageButton21 = (ImageButton) findViewById(R.id.imageButton21);
        imageButton21.setImageResource(R.drawable.symbol8r);
        ImageButton imageButton23 = (ImageButton) findViewById(R.id.imageButton23);
        imageButton23.setImageResource(R.drawable.symbol2r);
        ImageButton imageButton25 = (ImageButton) findViewById(R.id.imageButton25);
        imageButton25.setImageResource(R.drawable.symbol5r);
        ImageButton imageButton26 = (ImageButton) findViewById(R.id.imageButton26);
        imageButton26.setImageResource(R.drawable.symbol6r);
        ImageButton imageButton28 = (ImageButton) findViewById(R.id.imageButton28);
        imageButton28.setImageResource(R.drawable.symbol8i);
        ImageButton imageButton29 = (ImageButton) findViewById(R.id.imageButton29);
        imageButton29.setImageResource(R.drawable.symbol4r);
        ImageButton imageButton31 = (ImageButton) findViewById(R.id.imageButton31);
        imageButton31.setImageResource(R.drawable.symbol7i);
        ImageButton imageButton33 = (ImageButton) findViewById(R.id.imageButton36);
        imageButton33.setImageResource(R.drawable.symbol5i);
        ImageButton imageButton35 = (ImageButton) findViewById(R.id.imageButton35);
        imageButton35.setImageResource(R.drawable.symbol2i);
        ImageButton imageButton36 = (ImageButton) findViewById(R.id.imageButton36);
        imageButton36.setImageResource(R.drawable.symbol1i);
    }

    private void reverseElement3() {
        //general image
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton1.setImageResource(R.drawable.symbol10);
        ImageButton imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButton7.setImageResource(R.drawable.symbol12);
        ImageButton imageButton10 = (ImageButton) findViewById(R.id.imageButton10);
        imageButton10.setImageResource(R.drawable.symbol3);
        ImageButton imageButton12 = (ImageButton) findViewById(R.id.imageButton12);
        imageButton12.setImageResource(R.drawable.symbol8);
        ImageButton imageButton14 = (ImageButton) findViewById(R.id.imageButton14);
        imageButton14.setImageResource(R.drawable.symbol7);
        ImageButton imageButton18 = (ImageButton) findViewById(R.id.imageButton18);
        imageButton18.setImageResource(R.drawable.symbol5);
        ImageButton imageButton22 = (ImageButton) findViewById(R.id.imageButton22);
        imageButton22.setImageResource(R.drawable.symbol9);
        ImageButton imageButton24 = (ImageButton) findViewById(R.id.imageButton24);
        imageButton24.setImageResource(R.drawable.symbol4);
        ImageButton imageButton27 = (ImageButton) findViewById(R.id.imageButton27);
        imageButton27.setImageResource(R.drawable.symbol2);
        ImageButton imageButton30 = (ImageButton) findViewById(R.id.imageButton30);
        imageButton30.setImageResource(R.drawable.symbol6);
        ImageButton imageButton32 = (ImageButton) findViewById(R.id.imageButton32);
        imageButton32.setImageResource(R.drawable.symbol11);
        ImageButton imageButton34 = (ImageButton) findViewById(R.id.imageButton34);
        imageButton34.setImageResource(R.drawable.symbol1);

        //else image
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setImageResource(R.drawable.symbol11i);
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton3.setImageResource(R.drawable.symbol3r);
        ImageButton imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton4.setImageResource(R.drawable.symbol12i);
        ImageButton imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton5.setImageResource(R.drawable.symbol2i);
        ImageButton imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton6.setImageResource(R.drawable.symbol4i);
        ImageButton imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
        imageButton8.setImageResource(R.drawable.symbol9i);
        ImageButton imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
        imageButton9.setImageResource(R.drawable.symbol11r);
        ImageButton imageButton11 = (ImageButton) findViewById(R.id.imageButton11);
        imageButton11.setImageResource(R.drawable.symbol12r);
        ImageButton imageButton13 = (ImageButton) findViewById(R.id.imageButton13);
        imageButton13.setImageResource(R.drawable.symbol6r);
        ImageButton imageButton15 = (ImageButton) findViewById(R.id.imageButton15);
        imageButton15.setImageResource(R.drawable.symbol9r);
        ImageButton imageButton16 = (ImageButton) findViewById(R.id.imageButton16);
        imageButton16.setImageResource(R.drawable.symbol8r);
        ImageButton imageButton17 = (ImageButton) findViewById(R.id.imageButton17);
        imageButton17.setImageResource(R.drawable.symbol3i);
        ImageButton imageButton19 = (ImageButton) findViewById(R.id.imageButton19);
        imageButton19.setImageResource(R.drawable.symbol2r);
        ImageButton imageButton20 = (ImageButton) findViewById(R.id.imageButton20);
        imageButton20.setImageResource(R.drawable.symbol7r);
        ImageButton imageButton21 = (ImageButton) findViewById(R.id.imageButton21);
        imageButton21.setImageResource(R.drawable.symbol1i);
        ImageButton imageButton23 = (ImageButton) findViewById(R.id.imageButton23);
        imageButton23.setImageResource(R.drawable.symbol10i);
        ImageButton imageButton25 = (ImageButton) findViewById(R.id.imageButton25);
        imageButton25.setImageResource(R.drawable.symbol5r);
        ImageButton imageButton26 = (ImageButton) findViewById(R.id.imageButton26);
        imageButton26.setImageResource(R.drawable.symbol10r);
        ImageButton imageButton28 = (ImageButton) findViewById(R.id.imageButton28);
        imageButton28.setImageResource(R.drawable.symbol7i);
        ImageButton imageButton29 = (ImageButton) findViewById(R.id.imageButton29);
        imageButton29.setImageResource(R.drawable.symbol8i);
        ImageButton imageButton31 = (ImageButton) findViewById(R.id.imageButton31);
        imageButton31.setImageResource(R.drawable.symbol6i);
        ImageButton imageButton33 = (ImageButton) findViewById(R.id.imageButton36);
        imageButton33.setImageResource(R.drawable.symbol4r);
        ImageButton imageButton35 = (ImageButton) findViewById(R.id.imageButton35);
        imageButton35.setImageResource(R.drawable.symbol1r);
        ImageButton imageButton36 = (ImageButton) findViewById(R.id.imageButton36);
        imageButton36.setImageResource(R.drawable.symbol5i);
    }

    private void reverseElement4() {
        //general image
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton1.setImageResource(R.drawable.symbol11);
        ImageButton imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButton7.setImageResource(R.drawable.symbol4);
        ImageButton imageButton10 = (ImageButton) findViewById(R.id.imageButton10);
        imageButton10.setImageResource(R.drawable.symbol2);
        ImageButton imageButton12 = (ImageButton) findViewById(R.id.imageButton12);
        imageButton12.setImageResource(R.drawable.symbol12);
        ImageButton imageButton14 = (ImageButton) findViewById(R.id.imageButton14);
        imageButton14.setImageResource(R.drawable.symbol8);
        ImageButton imageButton18 = (ImageButton) findViewById(R.id.imageButton18);
        imageButton18.setImageResource(R.drawable.symbol1);
        ImageButton imageButton22 = (ImageButton) findViewById(R.id.imageButton22);
        imageButton22.setImageResource(R.drawable.symbol6);
        ImageButton imageButton24 = (ImageButton) findViewById(R.id.imageButton24);
        imageButton24.setImageResource(R.drawable.symbol7);
        ImageButton imageButton27 = (ImageButton) findViewById(R.id.imageButton27);
        imageButton27.setImageResource(R.drawable.symbol10);
        ImageButton imageButton30 = (ImageButton) findViewById(R.id.imageButton30);
        imageButton30.setImageResource(R.drawable.symbol5);
        ImageButton imageButton32 = (ImageButton) findViewById(R.id.imageButton32);
        imageButton32.setImageResource(R.drawable.symbol3);
        ImageButton imageButton34 = (ImageButton) findViewById(R.id.imageButton34);
        imageButton34.setImageResource(R.drawable.symbol9);

        //else image
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setImageResource(R.drawable.symbol12i);
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton3.setImageResource(R.drawable.symbol1i);
        ImageButton imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton4.setImageResource(R.drawable.symbol11r);
        ImageButton imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton5.setImageResource(R.drawable.symbol6i);
        ImageButton imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton6.setImageResource(R.drawable.symbol12r);
        ImageButton imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
        imageButton8.setImageResource(R.drawable.symbol7i);
        ImageButton imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
        imageButton9.setImageResource(R.drawable.symbol10i);
        ImageButton imageButton11 = (ImageButton) findViewById(R.id.imageButton11);
        imageButton11.setImageResource(R.drawable.symbol4r);
        ImageButton imageButton13 = (ImageButton) findViewById(R.id.imageButton13);
        imageButton13.setImageResource(R.drawable.symbol9r);
        ImageButton imageButton15 = (ImageButton) findViewById(R.id.imageButton15);
        imageButton15.setImageResource(R.drawable.symbol4i);
        ImageButton imageButton16 = (ImageButton) findViewById(R.id.imageButton16);
        imageButton16.setImageResource(R.drawable.symbol9i);
        ImageButton imageButton17 = (ImageButton) findViewById(R.id.imageButton17);
        imageButton17.setImageResource(R.drawable.symbol2r);
        ImageButton imageButton19 = (ImageButton) findViewById(R.id.imageButton19);
        imageButton19.setImageResource(R.drawable.symbol3r);
        ImageButton imageButton20 = (ImageButton) findViewById(R.id.imageButton20);
        imageButton20.setImageResource(R.drawable.symbol8r);
        ImageButton imageButton21 = (ImageButton) findViewById(R.id.imageButton21);
        imageButton21.setImageResource(R.drawable.symbol10r);
        ImageButton imageButton23 = (ImageButton) findViewById(R.id.imageButton23);
        imageButton23.setImageResource(R.drawable.symbol5r);
        ImageButton imageButton25 = (ImageButton) findViewById(R.id.imageButton25);
        imageButton25.setImageResource(R.drawable.symbol6r);
        ImageButton imageButton26 = (ImageButton) findViewById(R.id.imageButton26);
        imageButton26.setImageResource(R.drawable.symbol3i);
        ImageButton imageButton28 = (ImageButton) findViewById(R.id.imageButton28);
        imageButton28.setImageResource(R.drawable.symbol8i);
        ImageButton imageButton29 = (ImageButton) findViewById(R.id.imageButton29);
        imageButton29.setImageResource(R.drawable.symbol11i);
        ImageButton imageButton31 = (ImageButton) findViewById(R.id.imageButton31);
        imageButton31.setImageResource(R.drawable.symbol7r);
        ImageButton imageButton33 = (ImageButton) findViewById(R.id.imageButton36);
        imageButton33.setImageResource(R.drawable.symbol1r);
        ImageButton imageButton35 = (ImageButton) findViewById(R.id.imageButton35);
        imageButton35.setImageResource(R.drawable.symbol2i);
        ImageButton imageButton36 = (ImageButton) findViewById(R.id.imageButton36);
        imageButton36.setImageResource(R.drawable.symbol5i);
    }

    private void getFalseButton() {
        btn1 = false;
        btn2 = false;
        btn3 = false;
        btn4 = false;
        btn5 = false;
        btn6 = false;
        btn7 = false;
        btn8 = false;
        btn9 = false;
        btn10 = false;
        btn11 = false;
        btn12 = false;
        btn13 = false;
        btn14 = false;
        btn15 = false;
        btn16 = false;
        btn17 = false;
        btn18 = false;
        btn19 = false;
        btn20 = false;
        btn21 = false;
        btn22 = false;
        btn23 = false;
        btn24 = false;
        btn25 = false;
        btn26 = false;
        btn27 = false;
        btn28 = false;
        btn29 = false;
        btn30 = false;
        btn31 = false;
        btn32 = false;
        btn33 = false;
        btn34 = false;
        btn35 = false;
        btn36 = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_image_veriant);

        textViewTitle1 = (TextView) findViewById(R.id.textViewTit);
        textViewTitle1.setText("Отметье фигуры, которые Вы запомнили");

        if (preferencesLocal.getProperty("PREF_NUM_IMAGE").equals("3")) {
            reverseElement1();
        }
        if (preferencesLocal.getProperty("PREF_NUM_IMAGE").equals("1")) {
            reverseElement2();
        }
        if (preferencesLocal.getProperty("PREF_NUM_IMAGE").equals("4")) {
            textViewTitle1.setText("Давайте вспомним фигуры, которые\n мы запомниали и отметим их");
            reverseElement3();
        }

        getFalseButton();
    }

    private boolean[] getArrayButtons() {
        btnArray[0] = btn1;
        btnArray[1] = btn2;
        btnArray[2] = btn3;
        btnArray[3] = btn4;
        btnArray[4] = btn5;
        btnArray[5] = btn6;
        btnArray[6] = btn7;
        btnArray[7] = btn8;
        btnArray[8] = btn9;
        btnArray[9] = btn10;
        btnArray[10] = btn11;
        btnArray[11] = btn12;
        btnArray[12] = btn13;
        btnArray[13] = btn14;
        btnArray[14] = btn15;
        btnArray[15] = btn16;
        btnArray[16] = btn17;
        btnArray[17] = btn18;
        btnArray[18] = btn19;
        btnArray[19] = btn20;
        btnArray[20] = btn21;
        btnArray[21] = btn22;
        btnArray[22] = btn23;
        btnArray[23] = btn24;
        btnArray[24] = btn25;
        btnArray[25] = btn26;
        btnArray[26] = btn27;
        btnArray[27] = btn28;
        btnArray[28] = btn29;
        btnArray[29] = btn30;
        btnArray[30] = btn31;
        btnArray[31] = btn32;
        btnArray[32] = btn33;
        btnArray[33] = btn34;
        btnArray[34] = btn35;
        btnArray[35] = btn36;
        return btnArray;
    }

    private boolean clcSymbol(ImageButton imageButton, boolean btn) {
        if (btn == true) {
            imageButton.setBackgroundColor(Color.WHITE);
            btn = false;
        } else {
            imageButton.setBackgroundColor(parsedColor);
            btn = true;
        }
        return btn;
    }

    public void clickSymbol1(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton1);
        btn1 = clcSymbol(imageButton, btn1);
    }

    public void clickSymbol2(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton2);
        btn2 = clcSymbol(imageButton, btn2);
    }

    public void clickSymbol3(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton3);
        btn3 = clcSymbol(imageButton, btn3);
    }

    public void clickSymbol4(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton4);
        btn4 = clcSymbol(imageButton, btn4);
    }

    public void clickSymbol5(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton5);
        btn5 = clcSymbol(imageButton, btn5);
    }

    public void clickSymbol6(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton6);
        btn6 = clcSymbol(imageButton, btn6);
    }

    public void clickSymbol7(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton7);
        btn7 = clcSymbol(imageButton, btn7);
    }

    public void clickSymbol21(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton21);
        btn21 = clcSymbol(imageButton, btn21);
    }

    public void clickSymbol20(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton20);
        btn20 = clcSymbol(imageButton, btn20);
    }

    public void clickSymbol19(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton19);
        btn19 = clcSymbol(imageButton, btn19);
    }

    public void clickSymbol18(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton18);
        btn18 = clcSymbol(imageButton, btn18);
    }

    public void clickSymbol17(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton17);
        btn17 = clcSymbol(imageButton, btn17);
    }

    public void clickSymbol16(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton16);
        btn16 = clcSymbol(imageButton, btn16);
    }

    public void clickSymbol15(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton15);
        btn15 = clcSymbol(imageButton, btn15);
    }

    public void clickSymbol14(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton14);
        btn14 = clcSymbol(imageButton, btn14);
    }

    public void clickSymbol13(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton13);
        btn13 = clcSymbol(imageButton, btn13);
    }

    public void clickSymbol12(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton12);
        btn12 = clcSymbol(imageButton, btn12);
    }

    public void clickSymbol11(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton11);
        btn11 = clcSymbol(imageButton, btn11);
    }

    public void clickSymbol10(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton10);
        btn10 = clcSymbol(imageButton, btn10);
    }

    public void clickSymbol9(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton9);
        btn9 = clcSymbol(imageButton, btn9);
    }

    public void clickSymbol8(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton8);
        btn8 = clcSymbol(imageButton, btn8);
    }

    public void clickSymbol22(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton22);
        btn22 = clcSymbol(imageButton, btn22);
    }

    public void clickSymbol23(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton23);
        btn23 = clcSymbol(imageButton, btn23);
    }

    public void clickSymbol24(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton24);
        btn24 = clcSymbol(imageButton, btn24);
    }

    public void clickSymbol25(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton25);
        btn25 = clcSymbol(imageButton, btn25);
    }

    public void clickSymbol26(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton26);
        btn26 = clcSymbol(imageButton, btn26);
    }

    public void clickSymbol27(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton27);
        btn27 = clcSymbol(imageButton, btn27);
    }

    public void clickSymbol28(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton28);
        btn28 = clcSymbol(imageButton, btn28);
    }

    public void clickSymbol29(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton29);
        btn29 = clcSymbol(imageButton, btn29);
    }

    public void clickSymbol30(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton30);
        btn30 = clcSymbol(imageButton, btn30);
    }

    public void clickSymbol31(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton31);
        btn31 = clcSymbol(imageButton, btn31);
    }

    public void clickSymbol32(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton32);
        btn32 = clcSymbol(imageButton, btn32);
    }

    public void clickSymbol33(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton33);
        btn33 = clcSymbol(imageButton, btn33);
    }

    public void clickSymbol34(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton34);
        btn34 = clcSymbol(imageButton, btn34);
    }

    public void clickSymbol35(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton35);
        btn35 = clcSymbol(imageButton, btn35);
    }

    public void clickSymbol36(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton36);
        btn36 = clcSymbol(imageButton, btn36);
    }

    public void onClickToGoTestingImage2(View view) {
        Map<Integer, Boolean> map = new HashMap<>();
        btnArray = getArrayButtons();
        for (int i = 0; i < 36; i++) {
            map.put(i + 1, btnArray[i]);
        }

        int res = algorithms.algorithmImageMemoryZ1(map);
        String resString = String.valueOf(res);

        if (preferencesLocal.getProperty("PREF_NUM_IMAGE").equals("2")) {

            if (resString.equals("12") || resString.equals("11")) {
                preferencesLocal.addProperty("PREF_Z1",
                        "10",
                        TestingImageVeriantActivity.this);
            } else {
                preferencesLocal.addProperty("PREF_Z1",
                        resString,
                        TestingImageVeriantActivity.this);
            }

            preferencesLocal.addProperty("PREF_RESULTIMAGE1",
                    resString,
                    TestingImageVeriantActivity.this);
            preferencesLocal.addProperty("PREF_NUM_IMAGE",
                    "3",
                    TestingImageVeriantActivity.this);
            Functions.showDialog(TestingEnterImageActivity.class, "Вы уверены в ответе?", view);

        } else if (preferencesLocal.getProperty("PREF_NUM_IMAGE").equals("3")) {

            preferencesLocal.addProperty("PREF_RESULTIMAGE2",
                    resString,
                    TestingImageVeriantActivity.this);
            preferencesLocal.addProperty("PREF_NUM_IMAGE",
                    "1",
                    TestingImageVeriantActivity.this);
            Functions.showDialog(TestingEnterImageActivity.class, "Вы уверены в ответе?", view);

        } else if (preferencesLocal.getProperty("PREF_NUM_IMAGE").equals("1")) {

            preferencesLocal.addProperty("PREF_RESULTIMAGE3",
                    resString,
                    TestingImageVeriantActivity.this);

            String par1 = preferencesLocal.getProperty("PREF_RESULTIMAGE1");
            String par2 = preferencesLocal.getProperty("PREF_RESULTIMAGE2");
            String par3 = preferencesLocal.getProperty("PREF_RESULTIMAGE3");
            String result = algorithms.algorithmSoundMemoryC2(par1, par2, par3);

            preferencesLocal.addProperty("PREF_Z2",
                    result,
                    TestingImageVeriantActivity.this);
            Functions.showDialog(TestingSoundActivity.class, "Вы уверены в ответе?", view);
            preferencesLocal.addProperty("PREF_NUM_IMAGE",
                    "4",
                    TestingImageVeriantActivity.this);

        } else {

            preferencesLocal.addProperty("PREF_LASTIMAGERESULT1",
                    resString,
                    TestingImageVeriantActivity.this);
            preferencesLocal.addProperty("PREF_NUM_IMAGE",
                    "5",
                    TestingImageVeriantActivity.this);

            Functions.showDialog(PauseTwoActivity.class, "Вы уверены в ответе?", view);
            //todo второе отсроченное
        }
    }
}
