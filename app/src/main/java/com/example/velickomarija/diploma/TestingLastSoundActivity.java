package com.example.velickomarija.diploma;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TestingLastSoundActivity extends AppCompatActivity {

    PreferencesLocal preferencesLocal = new PreferencesLocal();
    Algoritms algoritms = new Algoritms();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_last_sound);
    }

    @Override
    public void onBackPressed() {
        // do nothing
    }

    private void activityTOGo(Class cl) {
        Intent intent = new Intent(this, cl);
        startActivity(intent);
    }

    private void showDialog(final Class cl, String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(TestingLastSoundActivity.this);
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

    public void onClickToGoLastSound(View view) {
        view.setClickable(false);
        EditText textBox = (EditText) findViewById(R.id.editTextResultTest1);
        String text = textBox.getText().toString();
        int res = algoritms.AlgorithmSoundMemoryC1(text);
        String resString = String.valueOf(res);
        preferencesLocal.addProperty("PREF_SOUNDLASTRESULT1", resString, TestingLastSoundActivity.this);
        view.setClickable(true);
        showDialog(PauseOneActivity.class,"Вы уверены в ответе?");
    }
}
