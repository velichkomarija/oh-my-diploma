package com.example.velickomarija.diploma;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) this.findViewById(R.id.startTextView);
        button = (Button) this.findViewById(R.id.nextButton);
        float size = TextUtils.textSize(getBaseContext());
        text.setTextSize(size);
        button.setTextSize(size);
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    public void onClickToRegistrationUser(View view) {
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }

    public void onBackPressed() {
        // do nothing
    }
}
