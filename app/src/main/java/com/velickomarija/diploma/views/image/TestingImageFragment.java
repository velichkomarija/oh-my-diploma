package com.velickomarija.diploma.views.image;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.velickomarija.diploma.INavigation;
import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.Constants;
import com.velickomarija.diploma.models.PreferencesLocal;

public class TestingImageFragment extends Fragment implements INavigation {
    private static final String TAG = "TESTING_IMAGE";
    private PreferencesLocal preferencesLocal = new PreferencesLocal();

    public TestingImageFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.testing_image_fragment, container, false);
        timingTest();

        return view;
    }

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

    private void timingTest() {
        int numParam = 1;

        if (!(preferencesLocal.getProperty(Constants.PREF_NUM_IMAGE) == null)) {
            numParam = Integer.parseInt(preferencesLocal.getProperty(Constants.PREF_NUM_IMAGE));
        }

        if (numParam == 3) {
            preferencesLocal.addProperty(Constants.PREF_NUM_IMAGE,
                    "1",
                    getContext());
            time(30000);
        }

        if (numParam == 2) {
            preferencesLocal.addProperty(Constants.PREF_NUM_IMAGE,
                    "3",
                    getContext());
            time(45000);
        }

        if (numParam == 1) {
            preferencesLocal.addProperty(Constants.PREF_NUM_IMAGE,
                    "2",
                    getContext());
            time(60000);
        }
    }

    /**
     * Метод, отвечающий, за отображение всплывающего окна - подсказки о состоянии работы программы.
     * После истечения времени задержки интерфейса функция обеспечивает переход к следующей активности.
     *
     * @param startTime время, отведенное на запоминание фигур.
     */
    private void time(int startTime) {
        CountDownTimer start = new CountDownTimer(startTime, 15000) {

            public void onTick(long milliesUntilFinished) {
                showToast();
            }

            public void onFinish() {
                replaceFragment("TESTING_IMAGE_VARIANT", new TestingImageVariantFragment());
            }
        }.start();
    }

    /**
     * Метод для отрисовки всплывающего окна.
     */
    private void showToast() {
        Toast toast = Toast.makeText(getContext(),
                "Программа работает.",
                Toast.LENGTH_LONG);
        View view = toast.getView();
        toast.getView().setPadding(10, 10, 10, 10);
        view.setBackgroundResource(R.color.colorAccent);
        toast.show();
    }
}
