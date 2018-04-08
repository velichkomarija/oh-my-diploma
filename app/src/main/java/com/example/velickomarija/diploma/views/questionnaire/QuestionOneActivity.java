package com.example.velickomarija.diploma.views.questionnaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.Functions;
import com.example.velickomarija.diploma.models.TextUtils;

public class QuestionOneActivity extends AppCompatActivity {

    TextView textView;
    RadioGroup radioGroup;
    Button button;
    int[] arrayResult = new int[20];
    int res = -1;
    int countQuestions = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_one);

        float size = TextUtils.textSize(getBaseContext());
        textView = (TextView) findViewById(R.id.questionText);
        button = (Button) findViewById(R.id.button_end_test);
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

        if (number < 20) {
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
        }
        else {
            textView.setText(R.string.q20);
            arrayResult[19] = res;

            Toast.makeText(QuestionOneActivity.this,
                    "Test all",
                    Toast.LENGTH_LONG).show();

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
    }
}
