package com.example.velickomarija.diploma;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class TestingLastImageActivity extends AppCompatActivity {

    //todo проверить
    Algoritms algoritms = new Algoritms();
    int parsedColor = Color.parseColor("#37bc51");
    PreferencesLocal preferencesLocal = new PreferencesLocal();
    boolean btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15,
            btn16, btn17, btn18, btn19, btn20, btn21;
    boolean[] btnArray = new boolean[21];
    TextView textViewTitle1;

    @Override
    public void onBackPressed() {
        // do nothing
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_last_image);
        if (preferencesLocal.getProperty("PREF_IMAGE1").equals("2")) {
            textViewTitle1 = (TextView) findViewById(R.id.textViewTitle);
            textViewTitle1.setText("Давайте вспомним фигуры, которые\n мы НЕ запомниали и отметим их");
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

    private void showDialog(final Class cl, String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(TestingLastImageActivity.this);
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
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void onClickToGoTestingImage2(View view) {
        view.setClickable(false);
        Map<Integer, Boolean> map = new HashMap<>();
        btnArray = getArrayButtons();
        for (int i = 0; i < 21; i++) {
            map.put(i + 1, btnArray[i]);
        }
        //todo организовать отдельную функцию
        int res = algoritms.AlgorithmImageMemoryZ1(map);
        String resString = String.valueOf(res);
        if (resString.equals("12") || resString.equals("11")) {
            resString = "10";
        }

        if (preferencesLocal.getProperty("PREF_IMAGE1").equals("1")) {
            preferencesLocal.addProperty("PREF_LASTIMAGERESULT2", resString, TestingLastImageActivity.this);
            showDialog(TestingLastImageActivity.class, "Вы уверены в ответе?");
            preferencesLocal.addProperty("PREF_IMAGE1", "2", TestingLastImageActivity.this);
        } else if (preferencesLocal.getProperty("PREF_IMAGE1").equals("2")) {
            resString = algoritms.AlgotihmImageNew(map);
            preferencesLocal.addProperty("PREF_Z4", resString, TestingLastImageActivity.this);
            showDialog(PauseThreeActivity.class, "Вы уверены в ответе?");
        } else {
            preferencesLocal.addProperty("PREF_LASTIMAGERESULT1", resString, TestingLastImageActivity.this);
            showDialog(PauseTwoActivity.class, "Вы уверены в ответе?");
        }
        view.setClickable(true);
    }
}
