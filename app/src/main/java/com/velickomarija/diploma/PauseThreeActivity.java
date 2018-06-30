package com.velickomarija.diploma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.velickomarija.diploma.models.PreferencesLocal;
import com.velickomarija.diploma.views.common.ResultActivity;

public class PauseThreeActivity extends AppCompatActivity {

    PreferencesLocal preferencesLocal = new PreferencesLocal();
    TextView textData, resultOldImage, resultNewImage;

    public void onBackPressed() {
        // do nothing
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause_three);

        textData = (TextView) findViewById(R.id.text_view_data);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(preferencesLocal.getProperty("PREF_NAME") + "/");
        stringBuffer.append(preferencesLocal.getProperty("PREF_AGE") + "/");
        stringBuffer.append(preferencesLocal.getProperty("PREF_EDUCATION"));
        textData.setText(stringBuffer.toString());
        stringBuffer.replace(0, stringBuffer.length(), "");

        resultOldImage = (TextView) findViewById(R.id.text_view_result_old_image);
        resultOldImage.setText(preferencesLocal.getProperty("PREF_LASTIMAGERESULT2"));

        resultNewImage = (TextView) findViewById(R.id.text_view_result_new_image);
        resultNewImage.setText(preferencesLocal.getProperty("PREF_Z5 "));
    }

    public void onClickToGoTestingImageNew(View view) {
        view.setClickable(false);
        Intent intent = new Intent(this, ResultActivity.class);
        view.setClickable(true);
        startActivity(intent);
    }
}
