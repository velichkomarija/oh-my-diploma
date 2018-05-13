package com.example.velickomarija.diploma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.velickomarija.diploma.models.Algorithms;
import com.example.velickomarija.diploma.models.PreferencesLocal;
import com.example.velickomarija.diploma.models.ResultCreator;

public class ResultActivity extends AppCompatActivity {

    TextView sound, image, total;
    PreferencesLocal preferencesLocal = new PreferencesLocal();
    Algorithms algorithms = new Algorithms();

    public void onBackPressed() {
        // do nothing
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //todo доделать
        sound = findViewById(R.id.textViewResultSound);
        image = findViewById(R.id.resultImage);
        total = findViewById(R.id.resultTotal);

        preferencesLocal.addProperty("PREF_C6",
                algorithms.getCorrectionC6(preferencesLocal.getProperty("PREF_C6")),
                getBaseContext());

        preferencesLocal.addProperty("PREF_Z6",
                algorithms.getCorrectionC6(preferencesLocal.getProperty("PREF_Z6")),
                getBaseContext());

        String[] results = countResult();

        sound.setText(results[0]);
        image.setText(results[1]);
        total.setText(results[2]);

        ResultCreator.sendFile(ResultActivity.this);
    }

    private String[] countResult() {
        String[] result = new String[3];
        int resSound = 0;

        for (int i = 0; i < 6; i++) {
            String nameProperty = "PREF_C" + (i + 1);
            try {
                resSound = resSound + Integer.parseInt(preferencesLocal.getProperty(nameProperty));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String resString = String.valueOf(resSound);
        preferencesLocal.addProperty("PREF_TOTAL_SOUND",
                resString,
                ResultActivity.this);
        result[0] = resString;

        int resImage = 0;
        for (int i = 0; i < 6; i++) {
            String nameProperty = "PREF_Z" + (i + 1);
            try {
                resImage = resImage + Integer.parseInt(preferencesLocal.getProperty(nameProperty));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        resString = String.valueOf(resImage);
        preferencesLocal.addProperty("PREF_TOTAL_IMAGE",
                resString,
                ResultActivity.this);
        result[1] = resString;

        resString = String.valueOf(resImage + resSound);
        preferencesLocal.addProperty("PREF_TOTAL",
                resString,
                ResultActivity.this);
        result[2] = resString;

        return result;
    }

}
