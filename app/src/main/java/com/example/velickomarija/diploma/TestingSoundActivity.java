package com.example.velickomarija.diploma;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TestingSoundActivity extends AppCompatActivity {

    PreferencesLocal preferencesLocal = new PreferencesLocal();
    Algoritms algoritms = new Algoritms();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_sound);
        // settings = getSharedPreferences(PREFS_FILE, MODE_PRIVATE);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(TestingSoundActivity.this);
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

    public void onClickToGoTesting23(View view) {

        view.setClickable(false);
        int numParam = 1;

        if (!(preferencesLocal.getProperty("PREF_NUM_SOUND").equals("none"))) {
            try {
                numParam = Integer.parseInt(preferencesLocal.getProperty("PREF_NUM_SOUND"));
            }
            catch (Exception e){
                Toast toast = Toast.makeText(getApplicationContext(),preferencesLocal.getProperty("PREF_NUM_SOUND"),Toast.LENGTH_LONG);
                toast.show();
            }
        }

        EditText textBox = (EditText) findViewById(R.id.editTextResultTest1);
        String text = textBox.getText().toString();
        int res = algoritms.AlgorithmSoundMemoryC1(text);//верно
        String resString = String.valueOf(res);

        if (numParam == 3) {
            preferencesLocal.addProperty("PREF_SOUNDRESULT3", resString, TestingSoundActivity.this);
            preferencesLocal.addProperty("PREF_NUM_SOUND", "1", TestingSoundActivity.this);

            String par1 = preferencesLocal.getProperty("PREF_SOUNDRESULT1");
            String par2 = preferencesLocal.getProperty("PREF_SOUNDRESULT2");
            String par3 = preferencesLocal.getProperty("PREF_SOUNDRESULT3");

            String result = algoritms.AlgorithmSoundMemoryC2(par1, par2, par3);
            preferencesLocal.addProperty("PREF_C2", result, TestingSoundActivity.this);
            preferencesLocal.addProperty("PREF_NUM_IMAGE","1",TestingSoundActivity.this);

            showDialog(TestingEnterImageActivity.class,"Вы уверены в ответе?");
        }

        if (numParam == 2) {
            preferencesLocal.addProperty("PREF_SOUNDRESULT2", resString, TestingSoundActivity.this);
            preferencesLocal.addProperty("PREF_NUM_SOUND", "3", TestingSoundActivity.this);

            showDialog(TestingEnterSoundActivity.class,"Вы уверены в ответе?");
        }

        if (numParam == 1) {
            if(resString.equals(11)){
                preferencesLocal.addProperty("PREF_C1", "10", TestingSoundActivity.this);
            }else{
                preferencesLocal.addProperty("PREF_C1", resString, TestingSoundActivity.this);
            }
            preferencesLocal.addProperty("PREF_SOUNDRESULT1", resString, TestingSoundActivity.this);
            preferencesLocal.addProperty("PREF_NUM_SOUND", "2", TestingSoundActivity.this);

            showDialog(TestingEnterSoundActivity.class,"Вы уверены в ответе?");
        }
        view.setClickable(true);
    }
}
