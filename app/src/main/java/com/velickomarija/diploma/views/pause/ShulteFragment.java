package com.velickomarija.diploma.views.pause;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.velickomarija.diploma.INavigation;
import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.PreferencesLocal;
import com.velickomarija.diploma.views.common.ResultFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

public class ShulteFragment extends Fragment implements INavigation {
    private static final String TAG = "SHULTE";
    private TextView digit1, digit2, digit3, digit4, digit5, digit6, digit7, digit8, digit9, digit10,
            digit11, digit12, digit13, digit14, digit15, digit16, digit17, digit18, digit19, digit20,
            digit21, digit22, digit23, digit24, digit25, title;
    private PreferencesLocal preferencesLocal = new PreferencesLocal();
    int shulteNum = 1;
    private LinearLayout table;
    int currentNumber = 1;
    boolean flag = true;
    Button buttonNext;
    ArrayList<Integer> notShuffled;

    public ShulteFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shulte_fragment, container, false);

        digit1 = view.findViewById(R.id.digit1);
        setClickListener(digit1);

        digit2 = view.findViewById(R.id.digit2);
        setClickListener(digit2);

        digit3 = view.findViewById(R.id.digit3);
        setClickListener(digit3);

        digit4 = view.findViewById(R.id.digit4);
        setClickListener(digit4);

        digit5 = view.findViewById(R.id.digit5);
        setClickListener(digit5);

        digit6 = view.findViewById(R.id.digit6);
        setClickListener(digit6);

        digit7 = view.findViewById(R.id.digit7);
        setClickListener(digit7);

        digit8 = view.findViewById(R.id.digit8);
        setClickListener(digit8);

        digit9 = view.findViewById(R.id.digit9);
        setClickListener(digit9);

        digit10 = view.findViewById(R.id.digit10);
        setClickListener(digit10);

        digit11 = view.findViewById(R.id.digit11);
        setClickListener(digit11);

        digit12 = view.findViewById(R.id.digit12);
        setClickListener(digit12);

        digit13 = view.findViewById(R.id.digit13);
        setClickListener(digit13);

        digit14 = view.findViewById(R.id.digit14);
        setClickListener(digit14);

        digit15 = view.findViewById(R.id.digit15);
        setClickListener(digit15);

        digit16 = view.findViewById(R.id.digit16);
        setClickListener(digit16);

        digit17 = view.findViewById(R.id.digit17);
        setClickListener(digit17);

        digit18 = view.findViewById(R.id.digit18);
        setClickListener(digit18);

        digit19 = view.findViewById(R.id.digit19);
        setClickListener(digit19);

        digit20 = view.findViewById(R.id.digit20);
        setClickListener(digit20);

        digit21 = view.findViewById(R.id.digit21);
        setClickListener(digit21);

        digit22 = view.findViewById(R.id.digit22);
        setClickListener(digit22);

        digit23 = view.findViewById(R.id.digit23);
        setClickListener(digit23);

        digit24 = view.findViewById(R.id.digit24);
        setClickListener(digit24);

        digit25 = view.findViewById(R.id.digit25);
        setClickListener(digit25);

        title = view.findViewById(R.id.text_instruction);
        table = view.findViewById(R.id.table);

        buttonNext = view.findViewById(R.id.go_last_testing);
        return view;
    }

    private void setClickListener(final TextView textView) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tapNumber = textView.getText().toString();
                if (flag) {
                    if (currentNumber != 25) {
                        if (tapNumber.equals(String.valueOf(currentNumber))) {
                            timing(textView, R.color.colorAccent);
                            currentNumber++;
                        } else {
                            timing(textView, Color.RED);
                        }
                    } else {
                        shulteNum++;
                        if (shulteNum == 2) {
                            shuffleNumbers();
                            title.setText("Еще раз, пожалуйста. Как можно быстрее.");
                            currentNumber = 1;
                            //reverse
                        }
                        if (shulteNum == 3) {
                            shuffleNumbers();
                            title.setText("А теперь нажимайте все числа в обратном порядке. От 25 до 1.");
                            currentNumber = 25;
                            flag = false;
                        }
                        table.setClickable(false);
                    }
                } else {
                    if (currentNumber != 1) {
                        if (tapNumber.equals(String.valueOf(currentNumber))) {
                            timing(textView, R.color.colorAccent);
                            currentNumber--;
                        } else {
                            timing(textView, Color.RED);
                        }
                    } else {
                        title.setText("Спасибо! Вы отлично справились!");
                        buttonNext.setVisibility(View.VISIBLE);
                        buttonNext.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                replaceFragment("RESULT_FRAGMENT", new ResultFragment());
                            }
                        });
                    }
                }
            }
        });
    }

    private void timing(final TextView textView, final int color) {
        final CountDownTimer start = new CountDownTimer(250, 50) {
            public void onTick(long milliesUntilFinished) {
                textView.setTextColor(color);
            }

            public void onFinish() {
                textView.setTextColor(Color.BLACK);
            }
        }.start();
    }

    private void shuffleNumbers() {
        notShuffled = new ArrayList<Integer>();
        for (int i = 1; i <= 25; i++) {
            notShuffled.add(i);
        }
        Collections.shuffle(notShuffled);

        digit1.setText(String.valueOf(notShuffled.get(0)));
        digit2.setText(String.valueOf(notShuffled.get(1)));
        digit3.setText(String.valueOf(notShuffled.get(2)));
        digit4.setText(String.valueOf(notShuffled.get(3)));
        digit5.setText(String.valueOf(notShuffled.get(4)));
        digit6.setText(String.valueOf(notShuffled.get(5)));
        digit7.setText(String.valueOf(notShuffled.get(6)));
        digit8.setText(String.valueOf(notShuffled.get(7)));
        digit9.setText(String.valueOf(notShuffled.get(8)));
        digit10.setText(String.valueOf(notShuffled.get(9)));
        digit11.setText(String.valueOf(notShuffled.get(10)));
        digit12.setText(String.valueOf(notShuffled.get(11)));
        digit13.setText(String.valueOf(notShuffled.get(12)));
        digit14.setText(String.valueOf(notShuffled.get(13)));
        digit15.setText(String.valueOf(notShuffled.get(14)));
        digit16.setText(String.valueOf(notShuffled.get(15)));
        digit17.setText(String.valueOf(notShuffled.get(16)));
        digit18.setText(String.valueOf(notShuffled.get(17)));
        digit19.setText(String.valueOf(notShuffled.get(18)));
        digit20.setText(String.valueOf(notShuffled.get(19)));
        digit21.setText(String.valueOf(notShuffled.get(20)));
        digit22.setText(String.valueOf(notShuffled.get(21)));
        digit23.setText(String.valueOf(notShuffled.get(22)));
        digit24.setText(String.valueOf(notShuffled.get(23)));
        digit25.setText(String.valueOf(notShuffled.get(24)));
    }

    @Override
    public void replaceFragment(String tag, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
