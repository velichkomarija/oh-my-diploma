package com.example.velickomarija.diploma;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TestingNewWordsActivity extends AppCompatActivity {

    Algoritms algoritms = new Algoritms();
    PreferencesLocal preferencesLocal = new PreferencesLocal();

    @Override
    public void onBackPressed() {
        // do nothing
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_new_words);
    }

    private void activityTOGo(Class cl) {
        Intent intent = new Intent(this, cl);
        startActivity(intent);
    }

    private void showDialog(final Class cl, String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(TestingNewWordsActivity.this);
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

    public void onClickToGoNext(View view) {
        view.setClickable(false);
        EditText textBox = (EditText) findViewById(R.id.editTextResultTestNew);
        String text = textBox.getText().toString();
        String res = algoritms.AlgorihmSoundNewWords(text);
        if (res.equals("11") || res.equals("12")) {
            res = "10";
        }
        preferencesLocal.addProperty("PREF_C4", res, TestingNewWordsActivity.this);
        view.setClickable(true);
        showDialog(TestingLastImageActivity.class, "Вы уверены в ответе?");
    }
}
