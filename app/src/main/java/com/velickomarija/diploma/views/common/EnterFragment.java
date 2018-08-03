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

public class EnterFragment extends Fragment implements INavigation {
    private static final String TAG = "ENTER_TESTING";

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

    public EnterFragment() {
    }

    @Override
    public void replaceFragment(String tag, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
