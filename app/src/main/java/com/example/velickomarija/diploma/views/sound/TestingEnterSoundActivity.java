package com.example.velickomarija.diploma.views.sound;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.PreferencesLocal;
import com.example.velickomarija.diploma.models.TextUtils;

public class TestingEnterSoundActivity extends AppCompatActivity {

    MediaPlayer mPlayer;
    Button startButton;
    Intent intent;
    PreferencesLocal preferencesLocal = new PreferencesLocal();
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_enter);

        textView = (TextView) findViewById(R.id.start_text);
        startButton = (Button) findViewById(R.id.button_next);

        float size = TextUtils.setNewTextSize(getBaseContext());
        textView.setTextSize(size * 1.35f);
        startButton.setTextSize(size * 1.4f);

        if (preferencesLocal.getProperty("PREF_NUM_SOUND").equals("2") ||
                preferencesLocal.getProperty("PREF_NUM_SOUND").equals("3")) {
            textView.setText(R.string.enter_testing_manifest23);
        } else {
            textView.setText(R.string.enter_testing_manifest);
        }

        intent = new Intent(this, TestingSoundActivity.class);
    }

    @Override
    public void onBackPressed() {
        // do nothing
    }

    public void sound(int sound, long time) {
        mPlayer = MediaPlayer.create(this, sound);
        mPlayer.start();
        textView.setText("Воспроизведение аудиозаписи");
        textView.setTextSize(TextUtils.setNewTextSize(getBaseContext()) * 3);

        CountDownTimer start = new CountDownTimer(time, 500) {

            public void onTick(long milliesUntilFinished) {
                //do nothing
            }

            public void onFinish() {
                startActivity(intent);
            }

        }.start();
    }

    public void onClickToGoTesting(View view) {
        startButton.setEnabled(false);
        startButton.setVisibility(View.INVISIBLE);

        if (preferencesLocal.getProperty("PREF_NUM_SOUND").equals("2") ||
                preferencesLocal.getProperty("PREF_NUM_SOUND").equals("3")) {
            sound(R.raw.test_15sec, 15500);
        } else {
            sound(R.raw.test_20sec, 20500);
        }
    }
}
