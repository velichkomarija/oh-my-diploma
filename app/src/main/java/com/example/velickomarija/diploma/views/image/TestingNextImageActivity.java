package com.example.velickomarija.diploma.views.image;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.velickomarija.diploma.PauseThreeActivity;
import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.Algorithms;
import com.example.velickomarija.diploma.models.Functions;
import com.example.velickomarija.diploma.models.PreferencesLocal;

import java.util.HashMap;
import java.util.Map;

public class TestingNextImageActivity extends AppCompatActivity {

    //todo проверить
    Algorithms algorithms = new Algorithms();
    int parsedColor = Color.parseColor("#37bc51");
    PreferencesLocal preferencesLocal = new PreferencesLocal();
    TextView textViewTitle1;

    boolean btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15,
            btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24;
    boolean[] btnArray = new boolean[24];

    @Override
    public void onBackPressed() {
        // do nothing
    }

    private void reverseElement() {
        //general image
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setImageResource(R.drawable.symbol21n);
        ImageButton imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton4.setImageResource(R.drawable.symbol17n);
        ImageButton imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton6.setImageResource(R.drawable.symbol6n);
        ImageButton imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
        imageButton9.setImageResource(R.drawable.symbol11n);
        ImageButton imageButton11 = (ImageButton) findViewById(R.id.imageButton11);
        imageButton11.setImageResource(R.drawable.symbol9n);
        ImageButton imageButton13 = (ImageButton) findViewById(R.id.imageButton13);
        imageButton13.setImageResource(R.drawable.symbol13n);
        ImageButton imageButton15 = (ImageButton) findViewById(R.id.imageButton15);
        imageButton15.setImageResource(R.drawable.symbol4n);
        ImageButton imageButton17 = (ImageButton) findViewById(R.id.imageButton17);
        imageButton17.setImageResource(R.drawable.symbol15n);
        ImageButton imageButton21 = (ImageButton) findViewById(R.id.imageButton21);
        imageButton21.setImageResource(R.drawable.symbol2n);
        ImageButton imageButton23 = (ImageButton) findViewById(R.id.imageButton23);
        imageButton23.setImageResource(R.drawable.symbol3extra);

        //else image
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton1.setImageResource(R.drawable.symbol1nn);
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton3.setImageResource(R.drawable.symbol2nn);
        ImageButton imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton5.setImageResource(R.drawable.symbol3nn);
        ImageButton imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButton7.setImageResource(R.drawable.symbol4nn);
        ImageButton imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
        imageButton8.setImageResource(R.drawable.symbol5nn);
        ImageButton imageButton10 = (ImageButton) findViewById(R.id.imageButton10);
        imageButton10.setImageResource(R.drawable.symbol6nn);
        ImageButton imageButton12 = (ImageButton) findViewById(R.id.imageButton12);
        imageButton12.setImageResource(R.drawable.symbol7nn);
        ImageButton imageButton14 = (ImageButton) findViewById(R.id.imageButton14);
        imageButton14.setImageResource(R.drawable.symbol8nn);
        ImageButton imageButton16 = (ImageButton) findViewById(R.id.imageButton16);
        imageButton16.setImageResource(R.drawable.symbol9nn);
        ImageButton imageButton18 = (ImageButton) findViewById(R.id.imageButton18);
        imageButton18.setImageResource(R.drawable.symbol10nn);
        ImageButton imageButton19 = (ImageButton) findViewById(R.id.imageButton19);
        imageButton19.setImageResource(R.drawable.symbol11nn);

        ImageButton imageButton20 = (ImageButton) findViewById(R.id.imageButton20);
        imageButton20.setImageResource(R.drawable.symbol1extra);
        ImageButton imageButton24 = (ImageButton) findViewById(R.id.imageButton24);
        imageButton24.setImageResource(R.drawable.symbol5i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_last_image);

        if (preferencesLocal.getProperty("PREF_NUM_IMAGE").equals("6")) {

            textViewTitle1 = (TextView) findViewById(R.id.textViewTitle);
            textViewTitle1.setText("Сейчас необходимо отметить те " +
                    "\nфигуры, которые были новыми в предыдущей таблице");
            reverseElement();
        }

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
        return btnArray;
    }

    private boolean clicSymbolN(ImageButton imageButton, boolean btn) {
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
        btn1 = clicSymbolN(imageButton, btn1);
    }

    public void clickSymbol2(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton2);
        btn2 = clicSymbolN(imageButton, btn2);
    }

    public void clickSymbol3(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton3);
        btn3 = clicSymbolN(imageButton, btn3);
    }

    public void clickSymbol4(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton4);
        btn4 = clicSymbolN(imageButton, btn4);
    }

    public void clickSymbol5(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton5);
        btn5 = clicSymbolN(imageButton, btn5);
    }

    public void clickSymbol6(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton6);
        btn6 = clicSymbolN(imageButton, btn6);
    }

    public void clickSymbol7(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton7);
        btn7 = clicSymbolN(imageButton, btn7);
    }

    public void clickSymbol21(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton21);
        btn21 = clicSymbolN(imageButton, btn21);
    }

    public void clickSymbol20(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton20);
        btn20 = clicSymbolN(imageButton, btn20);
    }

    public void clickSymbol19(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton19);
        btn19 = clicSymbolN(imageButton, btn19);
    }

    public void clickSymbol18(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton18);
        btn18 = clicSymbolN(imageButton, btn18);
    }

    public void clickSymbol17(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton17);
        btn17 = clicSymbolN(imageButton, btn17);
    }

    public void clickSymbol16(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton16);
        btn16 = clicSymbolN(imageButton, btn16);
    }

    public void clickSymbol15(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton15);
        btn15 = clicSymbolN(imageButton, btn15);
    }

    public void clickSymbol14(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton14);
        btn14 = clicSymbolN(imageButton, btn14);
    }

    public void clickSymbol13(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton13);
        btn13 = clicSymbolN(imageButton, btn13);
    }

    public void clickSymbol12(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton12);
        btn12 = clicSymbolN(imageButton, btn12);
    }

    public void clickSymbol11(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton11);
        btn11 = clicSymbolN(imageButton, btn11);
    }

    public void clickSymbol10(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton10);
        btn10 = clicSymbolN(imageButton, btn10);
    }

    public void clickSymbol9(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton9);
        btn9 = clicSymbolN(imageButton, btn9);
    }

    public void clickSymbol8(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton8);
        btn8 = clicSymbolN(imageButton, btn8);
    }

    public void clickSymbol22(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton22);
        btn22 = clicSymbolN(imageButton, btn22);
    }

    public void clickSymbol23(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton23);
        btn23 = clicSymbolN(imageButton, btn23);
    }

    public void clickSymbol24(View view) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton24);
        btn24 = clicSymbolN(imageButton, btn24);
    }

    public void onClickToGoNextTestingImage(View view) {

        String resString = "";
        Map<Integer, Boolean> map = new HashMap<>();
        btnArray = getArrayButtons();

        for (int i = 0; i < 24; i++) {
            map.put(i + 1, btnArray[i]);
        }
        resString = algorithms.algotithmImageNew(map);

        if (preferencesLocal.getProperty("PREF_NUM_IMAGE").equals("5")) {

            preferencesLocal.addProperty("PREF_LASTIMAGERESULT2",
                    resString,
                    TestingNextImageActivity.this);

            Functions.showDialogImage(TestingNextImageActivity.class,
                    "Вы уверены в ответе?",
                    view,
                    "6");

        } else if (preferencesLocal.getProperty("PREF_NUM_IMAGE").equals("6")) {

            preferencesLocal.addProperty("PREF_Z4",
                    resString,
                    TestingNextImageActivity.this);

            Functions.showDialog(PauseThreeActivity.class, "Вы уверены в ответе?", view);
        }
    }
}
