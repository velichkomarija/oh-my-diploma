package com.velickomarija.diploma.views.image;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.velickomarija.diploma.INavigation;
import com.velickomarija.diploma.R;

public class TestingEnterImageFragment extends Fragment implements INavigation {
    private static final String TAG = "TESTING_ENTER_IMAGE";
    private TextView textView;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.testing_enter_fragment, container, false);

        textView = (TextView) view.findViewById(R.id.start_text);
        textView.setText(getString(R.string.enter_testing_image_manifest));

        button = (Button) view.findViewById(R.id.button_next);
        button.setText(getString(R.string.image));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment("TESTING_IMAGE", new TestingImageFragment());
            }
        });
        return view;
    }

    public TestingEnterImageFragment() {

    }

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }

    @Override
    public void replaceFragment(String tag, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }
}