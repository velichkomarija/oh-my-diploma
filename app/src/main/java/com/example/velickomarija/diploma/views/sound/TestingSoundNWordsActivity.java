package com.example.velickomarija.diploma.views.sound;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.Algorithms;
import com.example.velickomarija.diploma.models.PreferencesLocal;

public class TestingSoundNWordsActivity extends AppCompatActivity {

    TextView mTimer;
    public Intent intent;
    MediaPlayer mPlayer;
    Animation animation;
    boolean clk = false;
    Algorithms algorithms = new Algorithms();
    PreferencesLocal preferencesLocal = new PreferencesLocal();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_sound_nwords);
        animation = AnimationUtils.loadAnimation(this,R.anim.anim);
        intent = new Intent(this, TestingNewWordsActivity.class);
        timing();
    }

    @Override
    public void onBackPressed() {
        // do nothing
    }

    private void timing() {
        mTimer = (TextView) findViewById(R.id.textViewTime);
        CountDownTimer start = new CountDownTimer(6000, 1000) {
            public void onTick(long milliesUntilFinished) {
                mTimer.setText(String.valueOf(milliesUntilFinished / 1000));
            }

            public void onFinish() {
                mTimer.setText("Запись");
                soundTiming();
            }
        }.start();
    }

    private void soundTiming() {
        final StringBuffer stringBuffer = new StringBuffer();
        mPlayer = MediaPlayer.create(this, R.raw.test_40sec);
        mPlayer.start();
        final CountDownTimer start = new CountDownTimer(42000, 100) {
            public void onTick(long milliesUntilFinished) {
                if (clk) {
                    clk = false;
                    stringBuffer.append(milliesUntilFinished / 10 + " ");
                }
            }

            public void onFinish() {
                String str = stringBuffer.toString();
                String res = algorithms.algorithmFindOldWorldsInNew(str);
                preferencesLocal.addProperty("PREF_RESULTOLDWORDS", res, TestingSoundNWordsActivity.this);
                startActivity(intent);
            }
        }.start();
    }

    public void onClickToPluseAction(View view) {
        clk = true;
        view.startAnimation(animation);
    }
}
