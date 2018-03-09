package com.example.velickomarija.diploma;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TestingEnterSoundNWordsActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_enter_sound_new_words);
        intent = new Intent(this, TestingSoundNWordsActivity.class);

    }

    public void onClickToGoTestingSoundNewWords(View view) {
        showDialog(view, "Будте внимательны, через 5 секунд будет воспроизведена запись для " +
                "узнования слов, если готовы нажмите Продолжить");
    }

    @Override
    public void onBackPressed() {
        // do nothing
    }

    private void showDialog(View v, String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(TestingEnterSoundNWordsActivity.this);
        builder.setTitle("Важное сообщение!")
                .setMessage(text)
                .setIcon(R.drawable.ic_error_black_24dp)
                .setCancelable(false).setPositiveButton("Продолжить",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        startActivity(intent);
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
}

