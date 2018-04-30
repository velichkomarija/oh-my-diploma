package com.example.velickomarija.diploma.views.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.TextUtils;

public class QuestionEnter2Activity extends AppCompatActivity {
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_enter);

        float size = TextUtils.setNewTextSize(getBaseContext());
        textView = (TextView) findViewById(R.id.start_text);
        button = (Button) findViewById(R.id.go_testing);
        button.setTextSize(size * 1.4f);
        textView.setText(R.string.enterTwoQuestionnarie);
        textView.setTextSize(size * 1.4f);
    }

    public void onBackPressed() {
        // do nothing
    }

    public void onClickToGoAnswerQuestion(View view) {
        Intent intent = new Intent(this, QuestionTwoActivity.class);
        startActivity(intent);
    }
}
