package com.example.velickomarija.diploma.views.questionnaire;

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
    int res = -1;
    boolean toGo = false;
    Animation animation;
    int countQuestions = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_two);
        animation = AnimationUtils.loadAnimation(this, R.anim.question_anim);
        float size = TextUtils.textSize(getBaseContext());
        textView = (TextView) findViewById(R.id.questionText);
        image = (ImageView) findViewById(R.id.image);
        buttonMinus = (Button) findViewById(R.id.button_minus);
        buttonPlus = (Button) findViewById(R.id.button_plus);
        textView.setTextSize(size * 1.5f);
        buttonMinus.setTextSize(size*1.3f);
        buttonPlus.setTextSize(size*1.3f);
    }

    public void onBackPressed() {
        // do nothing
    }

    public void onClickNextQuestionPlus(View view) {
        countQuestions++;
        view.startAnimation(animation);
        goToNextQuestion(countQuestions);
    }

    public void onClickNextQuestionMinus(View view) {
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

            arrayResult[number - 2] = res;
            res = -1;
        } else {
            /*
            button.setClickable(false);
            button.setText(R.string.next_test);
            image.setImageResource(R.mipmap.result);
            String result = algorithm.algorithmQuestion1(arrayResult);
            radioGroup.setVisibility(View.INVISIBLE);
            textView.setText(result);
            toGo = true;
            button.setClickable(true);
            */
        }
    }
}
