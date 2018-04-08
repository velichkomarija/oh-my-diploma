package com.example.velickomarija.diploma.views.questionnaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.Algorithms;
import com.example.velickomarija.diploma.models.Functions;
import com.example.velickomarija.diploma.models.TextUtils;
import com.example.velickomarija.diploma.views.common.SplashActivity;
import com.example.velickomarija.diploma.views.sound.TestingEnterSoundNWordsActivity;

public class QuestionOneActivity extends AppCompatActivity {

    TextView textView;
    RadioGroup radioGroup;
    Button button;
    ImageView image;
    Algorithms algorithm = new Algorithms();
    int[] arrayResult = new int[20];
    int res = -1;
    boolean toGo = false;
    int countQuestions = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_one);

        float size = TextUtils.textSize(getBaseContext());
        textView = (TextView) findViewById(R.id.questionText);
        button = (Button) findViewById(R.id.button_end_test);
        image = (ImageView) findViewById(R.id.image);
        textView.setTextSize(size * 1.3f);
        button.setTextSize(size * 1.3f);

        radioGroup = (RadioGroup) findViewById(R.id.radioQuestion);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case -1:

                        break;

                    case R.id.radioV1:
                        res = 1;
                        break;

                    case R.id.radioV2:
                        res = 2;
                        break;

                    case R.id.radioV3:
                        res = 3;
                        break;

                    case R.id.radioV4:
                        res = 4;
                        break;

                    case R.id.radioV5:
                        res = 5;
                        break;

                    default:
                        break;
                }
            }
        });
    }

    public void onBackPressed() {
        // do nothing
    }

    // щелчок кнопки
    public void onClick(View view) {
        // очистить все переключатели
        radioGroup.clearCheck();
    }

    private void goToNextQuestion(int number) {

        if (number <= 20) {
            String resource = "q" + number;

            try {
                textView.setText((Integer) R.string
                        .class
                        .getField(resource)
                        .get(getResources()));
            } catch (Exception e) {
                e.printStackTrace();
            }

            arrayResult[number - 2] = res;
            res = -1;
        } else {
            button.setClickable(false);
            button.setText(R.string.next_test);
            image.setImageResource(R.mipmap.result);
            String result = algorithm.algorithmQuestion1(arrayResult);
            radioGroup.setVisibility(View.INVISIBLE);
            textView.setText(result);
            toGo = true;
            button.setClickable(true);
        }
    }

    public void onClickNextQuestion(View view) {

        if (res == -1) {
            Functions.showErrorDialog(view, "Ничего не выбрано!");
        } else {
            countQuestions++;
            radioGroup.clearCheck();
            goToNextQuestion(countQuestions);
        }

        if (countQuestions == 22) {
            startActivity(new Intent(QuestionOneActivity.this,
                    TestingEnterSoundNWordsActivity.class));
        }
    }
}
