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

import com.example.velickomarija.diploma.PauseOneActivity;
import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.Algorithms;
import com.example.velickomarija.diploma.models.PreferencesLocal;
import com.example.velickomarija.diploma.models.TextUtils;

public class TestingLastSoundActivity extends AppCompatActivity {

    PreferencesLocal preferencesLocal = new PreferencesLocal();
    Algorithms algorithms = new Algorithms();
    TextView textView;
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_last_sound);

        editText = (EditText) findViewById(R.id.editTextResultTest1);
        textView = (TextView) findViewById(R.id.textSoundRepeat);
        button = (Button) findViewById(R.id.button_next);
        float size = TextUtils.textSize(getBaseContext());
        textView.setTextSize(size*1.4f);
        editText.setTextSize(size*1.4f);
        button.setTextSize(size*1.4f);
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
        builder.setMessage(Html.fromHtml("<font color='#000000'>"+text+"</font>"));
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void onClickToGoLastSound(View view) {
        EditText textBox = (EditText) findViewById(R.id.editTextResultTest1);
        String text = textBox.getText().toString();
        int res = algorithms.algorithmSoundMemoryC1(text);
        String resString = String.valueOf(res);
        preferencesLocal.addProperty("PREF_SOUNDLASTRESULT1", resString, TestingLastSoundActivity.this);
        showDialog(PauseOneActivity.class,"Вы уверены в ответе?");
    }
}
