package com.example.velickomarija.diploma.views.image;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.PreferencesLocal;

public class TestingImageActivity extends AppCompatActivity {
    public Intent intent;
    PreferencesLocal preferencesLocal = new PreferencesLocal();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_image);
        intent = new Intent(this, TestingImageVariantActivity.class);
        timingTest();
    }

    @Override
    public void onBackPressed() {
        // do nothing
    }

    private void timingTest() {
        int numParam = 1;

        if (!(preferencesLocal.getProperty("PREF_NUM_IMAGE") == null)) {
            numParam = Integer.parseInt(preferencesLocal.getProperty("PREF_NUM_IMAGE"));
        }

        if (numParam == 3) {
            preferencesLocal.addProperty("PREF_NUM_IMAGE",
                    "1",
                    TestingImageActivity.this);
            time(30000);
        }

        if (numParam == 2) {
            preferencesLocal.addProperty("PREF_NUM_IMAGE",
                    "3",
                    TestingImageActivity.this);
            time(45000);
        }

        if (numParam == 1) {
            preferencesLocal.addProperty("PREF_NUM_IMAGE",
                    "2",
                    TestingImageActivity.this);
            time(60000);
        }

    }

    private void time(int startTime) {
        CountDownTimer start = new CountDownTimer(startTime, 15000) {

            public void onTick(long milliesUntilFinished) {
                Toast toast = Toast.makeText(TestingImageActivity.this,
                        "Программа работает, она не зависла!",
                        Toast.LENGTH_LONG);
                View view = toast.getView();
                toast.getView().setPadding(10, 10, 10, 10);
                view.setBackgroundResource(R.color.colorAccent);
                toast.show();
            }

            public void onFinish() {
                startActivity(intent);
            }
        }.start();
    }
}
