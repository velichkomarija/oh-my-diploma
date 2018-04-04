package com.example.velickomarija.diploma.views.sound;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.Algorithms;
import com.example.velickomarija.diploma.models.PreferencesLocal;
import com.example.velickomarija.diploma.models.TextUtils;
import com.example.velickomarija.diploma.views.image.TestingImageVeriantActivity;

public class TestingNewWordsActivity extends AppCompatActivity {

    Algorithms algorithms = new Algorithms();
    PreferencesLocal preferencesLocal = new PreferencesLocal();
    TextView textView;
    Button button;
    EditText editText;

    @Override
    public void onBackPressed() {
        // do nothing
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_new_words);

        editText = (EditText) findViewById(R.id.editTextResultTestNew);
        textView = (TextView) findViewById(R.id.textSoundRepeat);
        button = (Button) findViewById(R.id.button_next);
        float size = TextUtils.textSize(getBaseContext());
        textView.setTextSize(size*1.2f);
        editText.setTextSize(size*1.2f);
        button.setTextSize(size*1.4f);
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
        builder.setMessage(Html.fromHtml("<font color='#000000'>"+text+"</font>"));
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void onClickToGoNext(View view) {
        view.setClickable(false);
        EditText textBox = (EditText) findViewById(R.id.editTextResultTestNew);
        String text = textBox.getText().toString();
        String res = algorithms.algorithmSoundNewWords(text);
        if (res.equals("11") || res.equals("12")) {
            res = "10";
        }
        preferencesLocal.addProperty("PREF_C4", res, TestingNewWordsActivity.this);
        view.setClickable(true);
      //  preferencesLocal.addProperty("PREF_NUM_IMAGE", "4", TestingNewWordsActivity.this);
        showDialog(TestingImageVeriantActivity.class, "Вы уверены в ответе?");
    }
}
