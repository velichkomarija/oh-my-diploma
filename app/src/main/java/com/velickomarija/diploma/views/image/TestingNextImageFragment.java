package com.velickomarija.diploma.views.image;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.velickomarija.diploma.INavigation;
import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.Algorithms;
import com.velickomarija.diploma.models.Constants;
import com.velickomarija.diploma.models.PreferencesLocal;
import com.velickomarija.diploma.views.pause.ShulteFragment;

import java.util.HashMap;
import java.util.Map;

public class TestingNextImageFragment extends Fragment implements INavigation {

    private static final String TAG = "TESTING_IMAGE_VARIANT_NEXT";
    private Algorithms algorithms = new Algorithms();
    private TextView textViewTitle1;
    private int parsedColor = Color.parseColor("#37bc51");
    private PreferencesLocal preferencesLocal = new PreferencesLocal();

    private Button buttonReady;

    private ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5,
            imageButton6, imageButton7, imageButton8, imageButton9, imageButton10, imageButton11, imageButton12,
            imageButton13, imageButton14, imageButton15, imageButton16, imageButton17, imageButton18,
            imageButton19, imageButton20, imageButton21, imageButton22, imageButton23, imageButton24;

    private boolean btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14,
            btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24;
    private boolean[] btnArray = new boolean[24];

    public void onBackPressed() {
        // do nothing
    }

    public TestingNextImageFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.testing_last_image_fragment, container, false);

        initButtons(view);

        if (preferencesLocal.getProperty(Constants.PREF_NUM_IMAGE).equals("6")) {

            textViewTitle1 = (TextView) view.findViewById(R.id.textViewTitle);
            textViewTitle1.setText("Сейчас необходимо отметить те " +
                    "\nфигуры, которые были новыми в предыдущей таблице");
        }

        getFalseButton();

        buttonReady = view.findViewById(R.id.button);
        buttonReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickToGoNextTestingImage();
            }
        });
        return view;
    }

    /**
     * Метод инициализации кнопок.
     *
     * @param view экземпляр класса View.
     */
    private void initButtons(View view) {
        imageButton1 = view.findViewById(R.id.imageButton1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1 = clcSymbol(imageButton1, btn1);
            }
        });

        imageButton2 = view.findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2 = clcSymbol(imageButton2, btn2);
            }
        });

        imageButton3 = view.findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn3 = clcSymbol(imageButton3, btn3);
            }
        });

        imageButton4 = view.findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn4 = clcSymbol(imageButton4, btn4);
            }
        });

        imageButton5 = view.findViewById(R.id.imageButton5);
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn5 = clcSymbol(imageButton5, btn5);
            }
        });

        imageButton6 = view.findViewById(R.id.imageButton6);
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn6 = clcSymbol(imageButton6, btn6);
            }
        });

        imageButton7 = view.findViewById(R.id.imageButton7);
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn7 = clcSymbol(imageButton7, btn7);
            }
        });

        imageButton8 = view.findViewById(R.id.imageButton8);
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn8 = clcSymbol(imageButton8, btn8);
            }
        });

        imageButton9 = view.findViewById(R.id.imageButton9);
        imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn9 = clcSymbol(imageButton9, btn9);
            }
        });

        imageButton10 = view.findViewById(R.id.imageButton10);
        imageButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn10 = clcSymbol(imageButton10, btn10);
            }
        });

        imageButton11 = view.findViewById(R.id.imageButton11);
        imageButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn11 = clcSymbol(imageButton11, btn11);
            }
        });

        imageButton12 = view.findViewById(R.id.imageButton12);
        imageButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn12 = clcSymbol(imageButton12, btn12);
            }
        });

        imageButton13 = view.findViewById(R.id.imageButton13);
        imageButton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn13 = clcSymbol(imageButton13, btn13);
            }
        });

        imageButton14 = view.findViewById(R.id.imageButton14);
        imageButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn14 = clcSymbol(imageButton14, btn14);
            }
        });

        imageButton15 = view.findViewById(R.id.imageButton15);
        imageButton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn15 = clcSymbol(imageButton15, btn15);
            }
        });

        imageButton16 = view.findViewById(R.id.imageButton16);
        imageButton16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn16 = clcSymbol(imageButton16, btn16);
            }
        });

        imageButton17 = view.findViewById(R.id.imageButton17);
        imageButton17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn17 = clcSymbol(imageButton17, btn17);
            }
        });

        imageButton18 = view.findViewById(R.id.imageButton18);
        imageButton18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn18 = clcSymbol(imageButton18, btn18);
            }
        });

        imageButton19 = view.findViewById(R.id.imageButton19);
        imageButton19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn19 = clcSymbol(imageButton19, btn19);
            }
        });

        imageButton20 = view.findViewById(R.id.imageButton20);
        imageButton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn20 = clcSymbol(imageButton20, btn20);
            }
        });

        imageButton21 = view.findViewById(R.id.imageButton21);
        imageButton21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn21 = clcSymbol(imageButton21, btn21);
            }
        });

        imageButton22 = view.findViewById(R.id.imageButton22);
        imageButton22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn22 = clcSymbol(imageButton22, btn22);
            }
        });

        imageButton23 = view.findViewById(R.id.imageButton23);
        imageButton23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn23 = clcSymbol(imageButton23, btn23);
            }
        });

        imageButton24 = view.findViewById(R.id.imageButton24);
        imageButton24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn24 = clcSymbol(imageButton24, btn24);
            }
        });

    }

    /**
     * Метод, обнуляющий счетчик нажатий на кнопки.
     */
    private void getFalseButton() {
        btn1 = false;
        btn2 = false;
        btn3 = false;
        btn4 = false;
        btn5 = false;
        btn6 = false;
        btn7 = false;
        btn8 = false;
        btn9 = false;
        btn10 = false;
        btn11 = false;
        btn12 = false;
        btn13 = false;
        btn14 = false;
        btn15 = false;
        btn16 = false;
        btn17 = false;
        btn18 = false;
        btn19 = false;
        btn20 = false;
        btn21 = false;
        btn22 = false;
        btn23 = false;
        btn24 = false;
    }

    /**
     * Метод, формирующий массив с результатами выбора пользователя.
     *
     * @return Массив состояния кнопок для подсчета результатов.
     */
    private boolean[] getArrayButtons() {
        btnArray[0] = btn1;
        btnArray[1] = btn2;
        btnArray[2] = btn3;
        btnArray[3] = btn4;
        btnArray[4] = btn5;
        btnArray[5] = btn6;
        btnArray[6] = btn7;
        btnArray[7] = btn8;
        btnArray[8] = btn9;
        btnArray[9] = btn10;
        btnArray[10] = btn11;
        btnArray[11] = btn12;
        btnArray[12] = btn13;
        btnArray[13] = btn14;
        btnArray[14] = btn15;
        btnArray[15] = btn16;
        btnArray[16] = btn17;
        btnArray[17] = btn18;
        btnArray[18] = btn19;
        btnArray[19] = btn20;
        btnArray[20] = btn21;
        btnArray[21] = btn22;
        btnArray[22] = btn23;
        btnArray[23] = btn24;
        return btnArray;
    }

    /**
     * Метод-обработчик нажатия на кнопки с изображениями.
     *
     * @param imageButton кнопка с изображением.
     * @param btn         булева переменная, хранящая состояние кнопки: true - кнопка нажата, false - кнопка не активна.
     * @return Новое состояние кнопки. ( true - кнопка нажата, false - кнопка не активна).
     */
    private boolean clcSymbol(ImageButton imageButton, boolean btn) {
        if (btn == true) {
            imageButton.setBackgroundColor(Color.WHITE);
            btn = false;
        } else {
            imageButton.setBackgroundColor(parsedColor);
            btn = true;
        }
        return btn;
    }


    public void onClickToGoNextTestingImage() {

        String resString = "";
        Map<Integer, Boolean> map = new HashMap<>();
        btnArray = getArrayButtons();

        for (int i = 0; i < 24; i++) {
            map.put(i + 1, btnArray[i]);
        }
        resString = algorithms.algotithmImageNew(map, getContext());

        if (preferencesLocal.getProperty(Constants.PREF_NUM_IMAGE).equals("5")) {

            preferencesLocal.addProperty(Constants.PREF_FINDINGIMAGERESULT,
                    resString,
                    getContext());

            showDialogImage(getString(R.string.message_title), "6", TAG, new TestingNextImageFragment());

        } else if (preferencesLocal.getProperty(Constants.PREF_NUM_IMAGE).equals("6")) {

            preferencesLocal.addProperty(Constants.PREF_Z4,
                    resString,
                    getContext());

            // showDialogImage(getString(R.string.message_title), "6", "RESULT_FRAGMENT", new ResultFragment());
            showDialogImage(getString(R.string.message_title), "7", "SHULTE", new ShulteFragment());
        }
    }

    @Override
    public void replaceFragment(String tag, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void showDialogImage(String text, final String num, final String tag, final Fragment fragment) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.important_message)
                .setMessage(text)
                .setIcon(R.drawable.ic_error_black_24dp)
                .setCancelable(false).setPositiveButton(getString(R.string.yes_go),
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        preferencesLocal.addProperty(Constants.PREF_NUM_IMAGE,
                                num,
                                getContext());
                        replaceFragment(tag, fragment);
                    }

                })
                .setNegativeButton(getString(R.string.cancel),
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }

                        }
                );
        builder.setMessage(Html.fromHtml("<font color='#000000'>" + text + "</font>"));
        AlertDialog alert = builder.create();
        alert.show();
    }
}
