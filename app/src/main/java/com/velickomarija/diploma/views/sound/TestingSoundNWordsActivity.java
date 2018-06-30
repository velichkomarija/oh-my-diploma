package com.velickomarija.diploma.views.sound;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.Algorithms;
import com.velickomarija.diploma.models.PreferencesLocal;

/**
 * Класс-активность для тестирования слухоречевой памяти.
 */
public class TestingSoundNWordsActivity extends AppCompatActivity {

    private TextView mTimer;
    private Intent intent;
    private MediaPlayer mPlayer;
    private Animation animation;
    private boolean clk = false;
    private Algorithms algorithms = new Algorithms();
    private PreferencesLocal preferencesLocal = new PreferencesLocal();

    /**
     * Метод, вызываемый перед началом работы активности.
     *
     * @param savedInstanceState объект тпа Bundle, который может хранить состояние приложения
     *                           при перерисовке активности.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_sound_nwords);
        animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        intent = new Intent(this, TestingSoundActivity.class);
        timing();
    }

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    @Override
    public void onBackPressed() {
        // do nothing
    }

    /**
     * Метод обратного отсчета перед воспроизведением аудиозаписи.
     */
    private void timing() {
        mTimer = (TextView) findViewById(R.id.text_view_time);
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

    /**
     * Метод для воспроизведения аудиозаписи.
     */
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
                String res = algorithms.algorithmFindOldWordsInNew(str);
                preferencesLocal.addProperty("PREF_RESULTOLDWORDS",
                        res,
                        TestingSoundNWordsActivity.this);
                startActivity(intent);
            }
        }.start();
    }

    /**
     * Метод обработчик нажатия на кнопку "+"
     *
     * @param view объект класса View.
     */
    public void onClickToPlusAction(View view) {
        clk = true;
        view.startAnimation(animation);
    }
}
