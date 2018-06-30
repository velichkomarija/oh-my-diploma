package com.velickomarija.diploma.views.sound;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.PreferencesLocal;
import com.velickomarija.diploma.models.TextUtils;

/**
 * Класс-активность отображения инструкции к слухоречевым тестам
 * и воспроизведения аудиозаписей со словами.
 */
public class TestingEnterSoundActivity extends AppCompatActivity {

    private MediaPlayer mPlayer;
    private Button startButton;
    private Intent intent;
    private PreferencesLocal preferencesLocal = new PreferencesLocal();
    private TextView textView;

    /**
     * Метод, вызываемый перед началом работы активности.
     *
     * @param savedInstanceState объект тпа Bundle, который может хранить состояние приложения
     *                           при перерисовке активности.
     */
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
            textView.setText(R.string.enter_testing_manifest_sound);
        } else {
            textView.setText(R.string.enter_testing_manifest);
        }

        intent = new Intent(this, TestingSoundActivity.class);
    }

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    @Override
    public void onBackPressed() {
        // do nothing
    }

    /**
     * Метод для воспроизведения аудиозаписи со словами для запоминания.
     *
     * @param sound аудиозапись со словами.
     * @param time  время воспроизведения аудиозаписи.
     */
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

    /**
     * Метод-обработчик нажатия на кнопку "Продолжить".
     *
     * @param view объект класса View.
     */
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
