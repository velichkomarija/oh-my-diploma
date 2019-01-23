package com.velickomarija.diploma.views.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.velickomarija.diploma.INavigation;
import com.velickomarija.diploma.R;

/**
 * Класс, отвечающий за отрисовку фрагмента инструкиции перед тестированием.
 */
public class EnterFragment extends Fragment implements INavigation {
    private static final String TAG = "ENTER_TESTING";

    /**
     * Метод, необходимый для связывания компонентов внутри фрагмента.
     *
     * @param inflater           объект класса LayoutInflater.
     * @param container          объект класса ViewGroup.
     * @param savedInstanceState объект класса Bundle.
     * @return объект класса View.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.enter_test_fragment, container, false);

        ((Button) view.findViewById(R.id.next_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment("PROFILE", new ProfileFragment());
            }
        });

        return view;
    }

    /**
     * Конструктор класса.
     */
    public EnterFragment() {
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
