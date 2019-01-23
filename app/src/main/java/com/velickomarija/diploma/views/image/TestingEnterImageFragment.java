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
import com.velickomarija.diploma.models.Constants;
import com.velickomarija.diploma.models.PreferencesLocal;

/**
 * Класс, отвечающий за отрисовку фрагмента инструкции к тестированию зрительной памяти.
 */
public class TestingEnterImageFragment extends Fragment implements INavigation {
    private static final String TAG = "TESTING_ENTER_IMAGE";
    private PreferencesLocal preferencesLocal = new PreferencesLocal();

    /**
     * Метод, необходимый для связывания компонентов внутри фрагмента.
     *
     * @param inflater           объект класса LayoutInflater.
     * @param container          объект класса ViewGroup.
     * @param savedInstanceState объект класса Bundle.
     * @return объект класса View.
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.testing_enter_fragment, container, false);

        TextView textView = (TextView) view.findViewById(R.id.start_text);
        if (preferencesLocal.getProperty(Constants.PREF_NUM_IMAGE).equals("2")) {
            textView.setText(getString(R.string.enter_testing_image_manifest));
        } else {
            textView.setText(getString(R.string.enter_testing_image));
        }


        Button button = (Button) view.findViewById(R.id.button_next);
        button.setText(getString(R.string.image));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment("TESTING_IMAGE", new TestingImageFragment());
            }
        });
        return view;
    }

    /**
     * Конструктор класса.
     */
    public TestingEnterImageFragment() {

    }

    /**
     * Метод-обработчик нажатия на физическую кнопку "Назад".
     */
    public void onBackPressed() {
        // do nothing
    }

    /**
     * Метод для обеспечения перехода между фрагментами.
     *
     * @param tag      тег фрагмента.
     * @param fragment объект класса Fragment.
     */
    @Override
    public void replaceFragment(String tag, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
