package com.example.velickomarija.diploma.views.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.Algorithms;
import com.example.velickomarija.diploma.models.TextUtils;

public class QuestionTwoActivity extends AppCompatActivity {

    TextView textView;
    ProgressBar progressBar;
    Button buttonPlus, buttonMinus;
    ImageView image;
    Algorithms algorithm = new Algorithms();
    int[] arrayResult = new int[40];
    float size;
    int countQuestions = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_two);
        size = TextUtils.setNewTextSize(getBaseContext());
        textView = (TextView) findViewById(R.id.questionText);
        image = (ImageView) findViewById(R.id.image);
        buttonMinus = (Button) findViewById(R.id.button_minus);
        buttonPlus = (Button) findViewById(R.id.button_plus);
        progressBar = findViewById(R.id.progress);

        progressBar.setVisibility(View.INVISIBLE);
        textView.setTextSize(size * 1.5f);
        buttonMinus.setTextSize(size * 1.3f);
        buttonPlus.setTextSize(size * 1.3f);
    }

    public void onBackPressed() {
        // do nothing
    }

    public void onClickNextQuestionPlus(View view) {
        arrayResult[countQuestions - 1] = 1;
        clk(view);
    }

    public void onClickNextQuestionMinus(View view) {
        arrayResult[countQuestions - 1] = 0;
        clk(view);
    }

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

    private void clk(View view) {
        time();
        countQuestions++;
        goToNextQuestion(countQuestions);
    }

    private void time() {
        textView.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        buttonMinus.setClickable(false);
        buttonPlus.setClickable(false);
        CountDownTimer start = new CountDownTimer(1000, 250) {

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
