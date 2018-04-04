package com.example.velickomarija.diploma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.velickomarija.diploma.models.PreferencesLocal;

public class PauseThreeActivity extends AppCompatActivity {

    PreferencesLocal preferencesLocal = new PreferencesLocal();
    TextView textData, resultOldImage, resultNewImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause_three);

        textData = (TextView) findViewById(R.id.textViewData);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(preferencesLocal.getProperty("PREF_NAME") + "/");
        stringBuffer.append(preferencesLocal.getProperty("PREF_AGE") + "/");
        stringBuffer.append(preferencesLocal.getProperty("PREF_EDUCATION"));
        textData.setText(stringBuffer.toString());
        stringBuffer.replace(0, stringBuffer.length(), "");

        resultOldImage = (TextView) findViewById(R.id.textViewResultOldImage);
        resultOldImage.setText(preferencesLocal.getProperty("PREF_LASTIMAGERESULT2"));

        resultNewImage = (TextView) findViewById(R.id.textViewResultNewImage);
        resultNewImage.setText(preferencesLocal.getProperty("PREF_Z4"));
    }

    public void onClickToGoTestingImageNew(View view) {
        view.setClickable(false);
//        Intent intent = new Intent(this, TestingLastImageActivity.class);
        view.setClickable(true);
        //startActivity(intent);
    }
}
