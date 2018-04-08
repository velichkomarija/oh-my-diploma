package com.example.velickomarija.diploma.views.sound;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.Functions;
import com.example.velickomarija.diploma.models.TextUtils;

public class TestingEnterSoundNWordsActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_enter_sound_new_words);

        textView = (TextView) findViewById(R.id.startTextSoundNewWordsView);
        button = (Button) findViewById(R.id.soundNewWordsSoundButton);

        float size = TextUtils.textSize(getBaseContext());
        textView.setTextSize(size*1.3f);
        button.setTextSize(size*1.3f);
    }

    public void onClickToGoTestingSoundNewWords(View view) {
        Functions.showDialog(TestingSoundNWordsActivity.class,
                "Будте внимательны, через 5 секунд будет воспроизведена запись для " +
                "узнования слов, если готовы нажмите Продолжить",
                view);
    }

    @Override
    public void onBackPressed() {
        // do nothing
    }
}

