package com.velickomarija.diploma.views.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.velickomarija.diploma.INavigation;
import com.velickomarija.diploma.R;

/**
 * Класс-активность, загружающая интерфейс приветственного окна приложения.
 */
public class UserActivity extends AppCompatActivity implements INavigation {
    private static final String TAG = "USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment("ENTER_TESTING", new EnterFragment());
        ScrollView scroll = (ScrollView) findViewById(R.id.scroll_main);
        scroll.setFocusableInTouchMode(true);
        scroll.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
    }

    public void replaceFragment(String tag, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }

    /**
     * Метод обработчик нажатия аппаратной кнопки "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }
}
