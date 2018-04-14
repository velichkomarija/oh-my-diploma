package com.example.velickomarija.diploma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.velickomarija.diploma.models.PreferencesLocal;
import com.example.velickomarija.diploma.views.questionnaire.QuestionEnterActivity;

public class PauseOneActivity extends AppCompatActivity {

    PreferencesLocal preferencesLocal = new PreferencesLocal();
    TextView textData, textResultSound, textResultC1, textResultC2,
            textResultImage, textResultImageZ1, textResultImageZ2, textResultSoundLast1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause_one);
        preferencesLocal.addProperty("PREF_IMAGE1", "none", PauseOneActivity.this);

        //tableR1 = (TableRow) tableLayout.findViewById(R.id.pauseOneTableRow1);
        textData = (TextView) findViewById(R.id.textViewData);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(preferencesLocal.getProperty("PREF_NAME") + "/");
        stringBuffer.append(preferencesLocal.getProperty("PREF_AGE") + "/");
        stringBuffer.append(preferencesLocal.getProperty("PREF_EDUCATION"));
        textData.setText(stringBuffer.toString());
        stringBuffer.replace(0, stringBuffer.length(), "");

        //tableR2 = (TableRow) tableLayout.findViewById(R.id.pauseOneTableRow2);
        textResultSound = (TextView) findViewById(R.id.textViewResultSound);
        stringBuffer.append(preferencesLocal.getProperty("PREF_SOUNDRESULT1") + "/");
        stringBuffer.append(preferencesLocal.getProperty("PREF_SOUNDRESULT2") + "/");
        stringBuffer.append(preferencesLocal.getProperty("PREF_SOUNDRESULT3"));
        textResultSound.setText(stringBuffer.toString());
        stringBuffer.replace(0, stringBuffer.length(), "");

        //tableR3 = (TableRow) tableLayout.findViewById(R.id.pauseOneTableRow3);
        textResultC1 = (TextView) findViewById(R.id.textViewResultSoundC1);
        textResultC1.setText(String.valueOf(preferencesLocal.getProperty("PREF_C1")));

        //tableR4 = (TableRow) tableLayout.findViewById(R.id.pauseOneTableRow4);
        textResultC2 = (TextView) findViewById(R.id.textViewResultSoundC2);
        textResultC2.setText(preferencesLocal.getProperty("PREF_C2"));

        //tableR5 = (TableRow) tableLayout.findViewById(R.id.pauseOneTableRow5);
        textResultImage = (TextView) findViewById(R.id.textViewResultImage123);
        stringBuffer.append(preferencesLocal.getProperty("PREF_RESULTIMAGE1") + "/");
        stringBuffer.append(preferencesLocal.getProperty("PREF_RESULTIMAGE2") + "/");
        stringBuffer.append(preferencesLocal.getProperty("PREF_RESULTIMAGE3"));
        textResultImage.setText(stringBuffer.toString());
        stringBuffer.replace(0, stringBuffer.length(), "");

        //tableR6 = (TableRow) tableLayout.findViewById(R.id.pauseOneTableRow6);
        textResultImageZ1 = (TextView) findViewById(R.id.textViewResultImageZ1);
        textResultImageZ1.setText(preferencesLocal.getProperty("PREF_Z1"));

        textResultImageZ2 = (TextView) findViewById(R.id.textViewResultImageZ2);
        textResultImageZ2.setText(preferencesLocal.getProperty("PREF_Z2"));

        textResultSoundLast1 = (TextView) findViewById(R.id.textViewSoundLastResult);
        textResultSoundLast1.setText(preferencesLocal.getProperty("PREF_SOUNDLASTRESULT1"));
    }

    @Override
    public void onBackPressed() {
        // do nothing
    }

    public void onClickToGoTestingSoundNewWords(View view) {
        view.setClickable(false);
        Intent intent = new Intent(this,
                QuestionEnterActivity.class);
        view.setClickable(true);
        startActivity(intent);
    }
}
