package com.example.velickomarija.diploma;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TestingEnterImageActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_enter_image);

        float size = TextUtils.textSize(getBaseContext());
        textView =  (TextView) findViewById(R.id.start_text);
        button = (Button) findViewById(R.id.button_next);
        button.setTextSize(size);
        textView.setTextSize(size);
    }

    public void onBackPressed() {
        // do nothing
    }

    public void onClickToGoTestingImage(View view) {
        view.setClickable(false);
        Intent intent = new Intent(this,TestingImageActivity.class);
        view.setClickable(true);
        startActivity(intent);
    }
}
