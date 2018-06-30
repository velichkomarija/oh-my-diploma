package com.velickomarija.diploma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.velickomarija.diploma.models.PreferencesLocal;
import com.velickomarija.diploma.views.questionnaire.QuestionEnterActivity;

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
        textData = (TextView) findViewById(R.id.text_view_data);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(preferencesLocal.getProperty("PREF_NAME") + "/");
        stringBuffer.append(preferencesLocal.getProperty("PREF_AGE") + "/");
        stringBuffer.append(preferencesLocal.getProperty("PREF_EDUCATION"));
        textData.setText(stringBuffer.toString());
        stringBuffer.replace(0, stringBuffer.length(), "");

        //tableR2 = (TableRow) tableLayout.findViewById(R.id.pauseOneTableRow2);
        textResultSound = (TextView) findViewById(R.id.text_view_result_sound);
        stringBuffer.append(preferencesLocal.getProperty("PREF_SOUNDRESULT1") + "/");
        stringBuffer.append(preferencesLocal.getProperty("PREF_SOUNDRESULT2") + "/");
        stringBuffer.append(preferencesLocal.getProperty("PREF_SOUNDRESULT3"));
        textResultSound.setText(stringBuffer.toString());
        stringBuffer.replace(0, stringBuffer.length(), "");

        //tableR3 = (TableRow) tableLayout.findViewById(R.id.pauseOneTableRow3);
        textResultC1 = (TextView) findViewById(R.id.text_view_result_sound_C1);
        textResultC1.setText(String.valueOf(preferencesLocal.getProperty("PREF_C1")));

        //tableR4 = (TableRow) tableLayout.findViewById(R.id.pauseOneTableRow4);
        textResultC2 = (TextView) findViewById(R.id.text_view_result_sound_C2);
        textResultC2.setText(preferencesLocal.getProperty("PREF_C2"));

        //tableR5 = (TableRow) tableLayout.findViewById(R.id.pauseOneTableRow5);
        textResultImage = (TextView) findViewById(R.id.text_view_result_image_123);
        stringBuffer.append(preferencesLocal.getProperty("PREF_RESULTIMAGE1") + "/");
        stringBuffer.append(preferencesLocal.getProperty("PREF_RESULTIMAGE2") + "/");
        stringBuffer.append(preferencesLocal.getProperty("PREF_RESULTIMAGE3"));
        textResultImage.setText(stringBuffer.toString());
        stringBuffer.replace(0, stringBuffer.length(), "");

        //tableR6 = (TableRow) tableLayout.findViewById(R.id.pauseOneTableRow6);
        textResultImageZ1 = (TextView) findViewById(R.id.text_view_result_image_Z1);
        textResultImageZ1.setText(preferencesLocal.getProperty("PREF_Z1"));

        textResultImageZ2 = (TextView) findViewById(R.id.text_view_result_image_Z2);
        textResultImageZ2.setText(preferencesLocal.getProperty("PREF_Z2"));

        textResultSoundLast1 = (TextView) findViewById(R.id.text_view_sound_last_result);
        textResultSoundLast1.setText(preferencesLocal.getProperty("PREF_C5"));
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
