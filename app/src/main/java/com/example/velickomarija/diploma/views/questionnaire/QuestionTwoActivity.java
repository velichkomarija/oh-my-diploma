package com.example.velickomarija.diploma.views.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.Algorithms;
import com.example.velickomarija.diploma.models.TextUtils;

public class QuestionTwoActivity extends AppCompatActivity {

    TextView textView;
    Button buttonPlus, buttonMinus;
    ImageView image;
    Algorithms algorithm = new Algorithms();
    int[] arrayResult = new int[40];
    float size;
    Animation animation;
    int countQuestions = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_two);
        animation = AnimationUtils.loadAnimation(this, R.anim.question_anim);
        size = TextUtils.textSize(getBaseContext());
        textView = (TextView) findViewById(R.id.questionText);
        image = (ImageView) findViewById(R.id.image);
        buttonMinus = (Button) findViewById(R.id.button_minus);
        buttonPlus = (Button) findViewById(R.id.button_plus);
        textView.setTextSize(size * 1.5f);
        buttonMinus.setTextSize(size * 1.3f);
        buttonPlus.setTextSize(size * 1.3f);
    }

    public void onBackPressed() {
        // do nothing
    }

    public void onClickNextQuestionPlus(View view) {
        arrayResult[countQuestions - 1] = 1;
        countQuestions++;
        view.startAnimation(animation);
        goToNextQuestion(countQuestions);
    }

    public void onClickNextQuestionMinus(View view) {
        arrayResult[countQuestions - 1] = 0;
        countQuestions++;
        view.startAnimation(animation);
        goToNextQuestion(countQuestions);
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
            String result = algorithm.algorithmQuestion2(arrayResult);
            Intent intent = new Intent(this, ResultTwoQuestionActivity.class);
            intent.putExtra("result", result);
            startActivity(intent);
        }
    }
}
