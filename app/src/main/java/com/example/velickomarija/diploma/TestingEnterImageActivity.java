package com.example.velickomarija.diploma;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TestingEnterImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_enter_image);
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
