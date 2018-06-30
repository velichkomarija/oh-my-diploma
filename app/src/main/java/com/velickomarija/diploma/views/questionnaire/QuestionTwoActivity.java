package com.velickomarija.diploma.views.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.Algorithms;
import com.velickomarija.diploma.models.TextUtils;

/**
 * Класс-активность для проведения опроса №2.
 */
public class QuestionTwoActivity extends AppCompatActivity {

    private TextView textView;
    private ProgressBar progressBar;
    private Button buttonPlus, buttonMinus;
    private Algorithms algorithm = new Algorithms();
    private int[] arrayResult = new int[40];
    private float size;
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
        setContentView(R.layout.activity_questionnaire_two);
        size = TextUtils.setNewTextSize(getBaseContext());
        textView = (TextView) findViewById(R.id.question_text);
        buttonMinus = (Button) findViewById(R.id.button_minus);
        buttonPlus = (Button) findViewById(R.id.button_plus);
        progressBar = findViewById(R.id.progress);

        progressBar.setVisibility(View.INVISIBLE);
        textView.setTextSize(size * 1.5f);
        buttonMinus.setTextSize(size * 1.3f);
        buttonPlus.setTextSize(size * 1.3f);
    }

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }

    /**
     * Метод-обработчик нажатия на кнопку "Согласен".
     *
     * @param view объект класса View.
     */
    public void onClickNextQuestionPlus(View view) {
        arrayResult[countQuestions - 1] = 1;
        clk(view);
    }

    /**
     * Метод-обработчик нажатия на кнопку "Не согласен".
     *
     * @param view объект класса View.
     */
    public void onClickNextQuestionMinus(View view) {
        arrayResult[countQuestions - 1] = 0;
        clk(view);
    }

    /**
     * Метод загрузки следующего высказывания.
     *
     * @param number номер высказывания.
     */
    private void goToNextQuestion(int number) {

        if (number <= 40) {
            String resource = "qq" + number;

            try {
                textView.setText((Integer) R.string
                        .class
                        .getField(resource)
                        .get(getResources()));
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            buttonMinus.setVisibility(View.INVISIBLE);
            buttonPlus.setVisibility(View.INVISIBLE);
            String result = algorithm.algorithmQuestionTwo(arrayResult);
            Intent intent = new Intent(this, ResultTwoQuestionActivity.class);
            intent.putExtra("result", result);
            startActivity(intent);
        }
    }

    /**
     * Метод для загрузки нового высказывания.
     *
     * @param view номер высказывания.
     */
    private void clk(View view) {
        time();
        countQuestions++;
        goToNextQuestion(countQuestions);
    }

    /**
     * Метод для обработки шкалы загрузки вопроса.
     */
    private void time() {
        textView.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        buttonMinus.setClickable(false);
        buttonPlus.setClickable(false);
        CountDownTimer start = new CountDownTimer(600, 150) {

            int progress = 25;

            public void onTick(long milliesUntilFinished) {
                progress = progress + 25;
                progressBar.setSecondaryProgress(progress);
            }

            public void onFinish() {
                progressBar.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.VISIBLE);
                buttonMinus.setClickable(true);
                buttonPlus.setClickable(true);
            }
        }.start();
    }
}
