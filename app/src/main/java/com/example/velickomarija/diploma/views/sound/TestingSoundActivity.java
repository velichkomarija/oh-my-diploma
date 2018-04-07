package com.example.velickomarija.diploma.views.sound;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.velickomarija.diploma.PauseOneActivity;
import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.Algorithms;
import com.example.velickomarija.diploma.models.PreferencesLocal;
import com.example.velickomarija.diploma.models.TextUtils;
import com.example.velickomarija.diploma.views.image.TestingEnterImageActivity;
import com.example.velickomarija.diploma.views.image.TestingImageVeriantActivity;

public class TestingSoundActivity extends AppCompatActivity {

    PreferencesLocal preferencesLocal = new PreferencesLocal();
    Algorithms algorithms = new Algorithms();

    TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_sound);
        float size = TextUtils.textSize(getBaseContext());

        textView = (TextView) findViewById(R.id.textSoundRepeat);
        editText = (EditText) findViewById(R.id.editTextResultTest1);
        button = (Button) findViewById(R.id.button_next);
        textView.setTextSize(size*1.4f);
        editText.setTextSize(size*1.4f);
        button.setTextSize(size*1.4f);

        if(preferencesLocal.getProperty("PREF_NUM_SOUND").equals("5")){
            textView.setText(R.string.textNewWords);
        }
        if(preferencesLocal.getProperty("PREF_NUM_SOUND").equals("4")){
            textView.setText(R.string.textSoundLast);
        }
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
        builder.setMessage(Html.fromHtml("<font color='#000000'>" + text + "</font>"));
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void onClickToGoTesting23(View view) {

        int numParam = 1;

        if (!(preferencesLocal.getProperty("PREF_NUM_SOUND").equals("none"))) {
            try {
                numParam = Integer.parseInt(preferencesLocal.getProperty("PREF_NUM_SOUND"));
            } catch (Exception e) {
                Toast toast = Toast.makeText(getApplicationContext(), preferencesLocal.getProperty("PREF_NUM_SOUND"), Toast.LENGTH_LONG);
                toast.show();
            }
        }

        EditText textBox = (EditText) findViewById(R.id.editTextResultTest1);
        String text = textBox.getText().toString();
        int res = algorithms.algorithmSoundMemoryC1(text);//верно
        String resString = String.valueOf(res);

        if(numParam == 5){
            resString = algorithms.algorithmSoundNewWords(text);
            if (resString.equals("11") || resString.equals("12")) {
                resString = "10";
            }
            preferencesLocal.addProperty("PREF_C4", resString, TestingSoundActivity.this);
            preferencesLocal.addProperty("PREF_NUM_SOUND", "6", TestingSoundActivity.this);

            showDialog(TestingImageVeriantActivity.class, "Вы уверены в ответе?");
        }

        if(numParam == 4){
            preferencesLocal.addProperty("PREF_SOUNDLASTRESULT1", resString, TestingSoundActivity.this);
            preferencesLocal.addProperty("PREF_NUM_SOUND", "5", TestingSoundActivity.this);

            showDialog(PauseOneActivity.class, "Вы уверены в ответе?");
        }

        if (numParam == 3) {
            preferencesLocal.addProperty("PREF_SOUNDRESULT3", resString, TestingSoundActivity.this);

            String par1 = preferencesLocal.getProperty("PREF_SOUNDRESULT1");
            String par2 = preferencesLocal.getProperty("PREF_SOUNDRESULT2");
            String par3 = preferencesLocal.getProperty("PREF_SOUNDRESULT3");

            String result = algorithms.algorithmSoundMemoryC2(par1, par2, par3);
            preferencesLocal.addProperty("PREF_C2", result, TestingSoundActivity.this);
            preferencesLocal.addProperty("PREF_NUM_SOUND", "4", TestingSoundActivity.this);
            preferencesLocal.addProperty("PREF_NUM_IMAGE", "2", TestingSoundActivity.this);
            showDialog(TestingEnterImageActivity.class, "Вы уверены в ответе?");
        }

        if (numParam == 2) {
            preferencesLocal.addProperty("PREF_SOUNDRESULT2", resString, TestingSoundActivity.this);
            preferencesLocal.addProperty("PREF_NUM_SOUND", "3", TestingSoundActivity.this);

            showDialog(TestingEnterSoundActivity.class, "Вы уверены в ответе?");
        }

        if (numParam == 1) {
            if (resString.equals(11)) {
                preferencesLocal.addProperty("PREF_C1", "10", TestingSoundActivity.this);
            } else {
                preferencesLocal.addProperty("PREF_C1", resString, TestingSoundActivity.this);
            }
            preferencesLocal.addProperty("PREF_SOUNDRESULT1", resString, TestingSoundActivity.this);
            preferencesLocal.addProperty("PREF_NUM_SOUND", "2", TestingSoundActivity.this);

            showDialog(TestingEnterSoundActivity.class, "Вы уверены в ответе?");
        }
    }
}
