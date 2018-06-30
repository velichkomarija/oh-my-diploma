package com.velickomarija.diploma.views.questionnaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.Algorithms;
import com.velickomarija.diploma.models.Functions;
import com.velickomarija.diploma.models.TextUtils;
import com.velickomarija.diploma.views.sound.TestingEnterSoundNWordsActivity;

/**
 * Класс-активность для проведения опроса №1.
 */
public class QuestionOneActivity extends AppCompatActivity {

    private TextView textView;
    private RadioGroup radioGroup;
    private Button button;
    private ImageView image;
    private Algorithms algorithm = new Algorithms();
    private int[] arrayResult = new int[20];
    private int res = -1;
    private boolean toGo = false;
    private int countQuestions = 1;

    /**
     * Метод, вызываемый перед началом работы активности.
     *
     * @param savedInstanceState объект тпа Bundle, который может хранить состояние приложения
     *                           при перерисовке активности.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_one);

        float size = TextUtils.setNewTextSize(getBaseContext());
        textView = (TextView) findViewById(R.id.question_text);
        button = (Button) findViewById(R.id.button_end_test);
        image = (ImageView) findViewById(R.id.image);
        textView.setTextSize(size * 1.3f);
        button.setTextSize(size * 1.3f);

        radioGroup = (RadioGroup) findViewById(R.id.radio_question);
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

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }

    /**
     * Метод-обработчик нажатия на радио-кнопки.
     *
     * @param view объект класса View.
     */
    public void onClick(View view) {
        // очистить все переключатели
        radioGroup.clearCheck();
    }

    /**
     * Метод для загрузки следующего вопроса.
     *
     * @param number номер текущего вопроса.
     */
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
            String result = algorithm.algorithmQuestionOne(arrayResult);
            radioGroup.setVisibility(View.INVISIBLE);
            textView.setText(result);
            toGo = true;
            button.setClickable(true);
        }
    }

    /**
     * Метод-обработчик нажатия на кнопку "Следующий вопрос".
     *
     * @param view объект класса View.
     */
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
