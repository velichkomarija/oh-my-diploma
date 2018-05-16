package com.example.velickomarija.diploma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.velickomarija.diploma.models.PreferencesLocal;
import com.example.velickomarija.diploma.views.questionnaire.QuestionEnter2Activity;

public class PauseTwoActivity extends AppCompatActivity {

    PreferencesLocal preferencesLocal = new PreferencesLocal();
    TextView textData, resultNewWordsInOld, textViewResultSound, textViewResultImage1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause_two);

        textData = (TextView) findViewById(R.id.text_view_data);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(preferencesLocal.getProperty("PREF_NAME") + "/");
        stringBuffer.append(preferencesLocal.getProperty("PREF_AGE") + "/");
        stringBuffer.append(preferencesLocal.getProperty("PREF_EDUCATION"));
        textData.setText(stringBuffer.toString());
        stringBuffer.replace(0, stringBuffer.length(), "");

        resultNewWordsInOld = (TextView) findViewById(R.id.text_view_result_sound_new_words);
        resultNewWordsInOld.setText(preferencesLocal.getProperty("PREF_RESULTOLDWORDS"));

        textViewResultSound = (TextView) findViewById(R.id.text_view_result_sound_C4);
        textViewResultSound.setText(preferencesLocal.getProperty("PREF_C4"));

        textViewResultImage1 = (TextView) findViewById(R.id.text_view_result_last_image1);
        textViewResultImage1.setText(preferencesLocal.getProperty("PREF_Z5"));

    }

    public void onClickToGoTestingImageNew(View view) {
        view.setClickable(false);
        preferencesLocal.addProperty("PREF_IMAGE1", "1", PauseTwoActivity.this);
        Intent intent = new Intent(this,QuestionEnter2Activity.class);
        view.setClickable(true);
        startActivity(intent);
    }
}
