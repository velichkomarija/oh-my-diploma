package com.example.velickomarija.diploma.views.common;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.models.TextUtils;

public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        float size = TextUtils.setNewTextSize(getBaseContext());
        TextView textView = findViewById(R.id.start_text_finish);
        Button button = findViewById(R.id.exit);
        textView.setTextSize(size * 2.0f);
        button.setTextSize(size * 1.4f);
    }

    public void onClickExit(View view) {
        finishAffinity();
    }
}
