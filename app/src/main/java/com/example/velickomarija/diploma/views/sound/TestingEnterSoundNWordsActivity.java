package com.example.velickomarija.diploma.views.sound;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.Functions;
import com.example.velickomarija.diploma.models.TextUtils;

/**
 * Класс-активность для отображения инструкции к тесту слухоречевой памяти.
 * Узнавание "старых" слов из "новых".
 */
public class TestingEnterSoundNWordsActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;

    /**
     * Метод, вызываемый перед началом работы активности.
     *
     * @param savedInstanceState объект тпа Bundle, который может хранить состояние приложения
     *                           при перерисовке активности.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_enter_sound_new_words);

        textView = (TextView) findViewById(R.id.start_text_sound_new_words_view);
        button = (Button) findViewById(R.id.soundNewWordsSoundButton);

        float size = TextUtils.setNewTextSize(getBaseContext());
        textView.setTextSize(size * 1.2f);
        button.setTextSize(size * 1.4f);
    }

    /**
     * Метод-обработчик нажатия на кнопку "Продолжить".
     *
     * @param view объект класса View.
     */
    public void onClickToGoTestingSoundNewWords(View view) {
        Functions.showDialog(TestingSoundNWordsActivity.class,
                "Будте внимательны, через 5 секунд будет воспроизведена запись для " +
                        "узнования слов, если готовы нажмите Продолжить",
                view);
    }

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    @Override
    public void onBackPressed() {
        // do nothing
    }
}

