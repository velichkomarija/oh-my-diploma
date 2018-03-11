package com.example.velickomarija.diploma;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestingImageVeriantActivity extends AppCompatActivity {

    Algoritms algoritms = new Algoritms();
    int parsedColor = Color.parseColor("#37bc51");
    PreferencesLocal preferencesLocal = new PreferencesLocal();
    boolean btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15,
            btn16, btn17, btn18, btn19, btn20, btn21;
    boolean[] btnArray = new boolean[21];

    @Override
    public void onBackPressed() {
        // do nothing
    }

    private void reverseElement2(){
        //general image
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton1.setImageResource(R.drawable.symbol5n);
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton3.setImageResource(R.drawable.symbol12n);
        ImageButton imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
        imageButton8.setImageResource(R.drawable.symbol7n);
        ImageButton imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButton7.setImageResource(R.drawable.symbol8n);
        ImageButton imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton5.setImageResource(R.drawable.symbol1n);
        ImageButton imageButton10 = (ImageButton) findViewById(R.id.imageButton10);
        imageButton10.setImageResource(R.drawable.symbol20n);
        ImageButton imageButton12 = (ImageButton) findViewById(R.id.imageButton12);
        imageButton12.setImageResource(R.drawable.symbol3n);
        ImageButton imageButton16 = (ImageButton) findViewById(R.id.imageButton16);
        imageButton16.setImageResource(R.drawable.symbol19n);
        ImageButton imageButton18 = (ImageButton) findViewById(R.id.imageButton18);
        imageButton18.setImageResource(R.drawable.symbol14n);
        ImageButton imageButton14 = (ImageButton) findViewById(R.id.imageButton14);
        imageButton14.setImageResource(R.drawable.symbol18n);
        ImageButton imageButton20 = (ImageButton) findViewById(R.id.imageButton20);
        imageButton20.setImageResource(R.drawable.symbol10n);
        ImageButton imageButton19 = (ImageButton) findViewById(R.id.imageButton19);
        imageButton19.setImageResource(R.drawable.symbol16n);

        //else image
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setImageResource(R.drawable.symbol21n);
        ImageButton imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton4.setImageResource(R.drawable.symbol17n);
        ImageButton imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton6.setImageResource(R.drawable.symbol15n);
        ImageButton imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
        ImageButton imageButton11 = (ImageButton) findViewById(R.id.imageButton11);
        imageButton11.setImageResource(R.drawable.symbol13n);
        ImageButton imageButton13 = (ImageButton) findViewById(R.id.imageButton13);
        imageButton13.setImageResource(R.drawable.symbol11n);
        ImageButton imageButton15 = (ImageButton) findViewById(R.id.imageButton15);
        imageButton15.setImageResource(R.drawable.symbol6n);
        ImageButton imageButton17 = (ImageButton) findViewById(R.id.imageButton17);
        imageButton17.setImageResource(R.drawable.symbol4n);
        ImageButton imageButton21 = (ImageButton) findViewById(R.id.imageButton21);
        imageButton2.setImageResource(R.drawable.symbol2n);
    }

    private void reverseElement1(){
        //general image
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton1.setImageResource(R.drawable.symbol16n);
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton3.setImageResource(R.drawable.symbol12n);
        ImageButton imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
        imageButton8.setImageResource(R.drawable.symbol19n);
        ImageButton imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButton7.setImageResource(R.drawable.symbol14n);
        ImageButton imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton5.setImageResource(R.drawable.symbol10n);
        ImageButton imageButton10 = (ImageButton) findViewById(R.id.imageButton10);
        imageButton10.setImageResource(R.drawable.symbol5n);
        ImageButton imageButton12 = (ImageButton) findViewById(R.id.imageButton12);
        imageButton12.setImageResource(R.drawable.symbol3n);
        ImageButton imageButton16 = (ImageButton) findViewById(R.id.imageButton16);
        imageButton16.setImageResource(R.drawable.symbol1n);
        ImageButton imageButton18 = (ImageButton) findViewById(R.id.imageButton18);
        imageButton18.setImageResource(R.drawable.symbol20n);
        ImageButton imageButton14 = (ImageButton) findViewById(R.id.imageButton14);
        imageButton14.setImageResource(R.drawable.symbol7n);
        ImageButton imageButton20 = (ImageButton) findViewById(R.id.imageButton20);
        imageButton20.setImageResource(R.drawable.symbol18n);
        ImageButton imageButton19 = (ImageButton) findViewById(R.id.imageButton19);
        imageButton19.setImageResource(R.drawable.symbol8n);

        //else image
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setImageResource(R.drawable.symbol13n);
        ImageButton imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton4.setImageResource(R.drawable.symbol15n);
        ImageButton imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton6.setImageResource(R.drawable.symbol17n);
        ImageButton imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
        imageButton9.setImageResource(R.drawable.symbol11n);
        ImageButton imageButton11 = (ImageButton) findViewById(R.id.imageButton11);
        imageButton11.setImageResource(R.drawable.symbol9n);
        ImageButton imageButton13 = (ImageButton) findViewById(R.id.imageButton13);
        imageButton13.setImageResource(R.drawable.symbol2n);
        ImageButton imageButton15 = (ImageButton) findViewById(R.id.imageButton15);
        imageButton15.setImageResource(R.drawable.symbol4n);
        ImageButton imageButton17 = (ImageButton) findViewById(R.id.imageButton17);
        imageButton17.setImageResource(R.drawable.symbol6n);
        ImageButton imageButton21 = (ImageButton) findViewById(R.id.imageButton21);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_image_veriant);
        if (preferencesLocal.getProperty("PREF_NUM_IMAGE").equals("3")){
            reverseElement1();
        }
        if (preferencesLocal.getProperty("PREF_NUM_IMAGE").equals("1")){
            reverseElement2();
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
    }

    private void activityTOGo(Class cl) {
        Intent intent = new Intent(this, cl);
        startActivity(intent);
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

    private void showDialog(final Class cl, String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(TestingImageVeriantActivity.this);
        builder.setTitle("Важное сообщение!")
                .setMessage(text)
                .setIcon(R.drawable.ic_error_black_24dp)
                .setCancelable(false).setPositiveButton("Да, продолжить",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        activityTOGo(cl);
                    }
                })
                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        }
                );
        builder.setMessage(Html.fromHtml("<font color='#000000'>"+text+"</font>"));
        AlertDialog alert = builder.create();
        alert.show();
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

    public void onClickToGoTestingImage2(View view) {
        view.setClickable(false);
        Map<Integer, Boolean> map = new HashMap<>();
        btnArray = getArrayButtons();
        for (int i = 0; i < 21; i++) {
            map.put(i + 1, btnArray[i]);
        }

        int res = algoritms.AlgorithmImageMemoryZ1(map);
        String resString = String.valueOf(res);


        if (preferencesLocal.getProperty("PREF_NUM_IMAGE").equals("2")) {
            if (resString.equals("12") || resString.equals("11")) {
                preferencesLocal.addProperty("PREF_Z1", "10", TestingImageVeriantActivity.this);
            } else {
                preferencesLocal.addProperty("PREF_Z1", resString, TestingImageVeriantActivity.this);
            }
            preferencesLocal.addProperty("PREF_RESULTIMAGE1", resString, TestingImageVeriantActivity.this);
            showDialog(TestingEnterImageActivity.class, "Вы уверены в ответе?");
        }

        if (preferencesLocal.getProperty("PREF_NUM_IMAGE").equals("3")) {
            preferencesLocal.addProperty("PREF_RESULTIMAGE2", resString, TestingImageVeriantActivity.this);
            showDialog(TestingEnterImageActivity.class, "Вы уверены в ответе?");
        }

        if (preferencesLocal.getProperty("PREF_NUM_IMAGE").equals("1")) {
            preferencesLocal.addProperty("PREF_RESULTIMAGE3", resString, TestingImageVeriantActivity.this);
            String par1 = preferencesLocal.getProperty("PREF_RESULTIMAGE1");
            String par2 = preferencesLocal.getProperty("PREF_RESULTIMAGE2");
            String par3 = preferencesLocal.getProperty("PREF_RESULTIMAGE3");
            String result = algoritms.AlgorithmSoundMemoryC2(par1, par2, par3);
            preferencesLocal.addProperty("PREF_Z2", result, TestingImageVeriantActivity.this);
            showDialog(TestingLastSoundActivity.class, "Вы уверены в ответе?");
            preferencesLocal.addProperty("PREF_NUM_IMAGE","none",TestingImageVeriantActivity.this);
        }
        view.setClickable(true);
    }
}
