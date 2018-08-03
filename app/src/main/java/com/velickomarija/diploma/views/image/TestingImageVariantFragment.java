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
import com.velickomarija.diploma.models.PreferencesLocal;
import com.velickomarija.diploma.views.questionnaire.QuestionEnter2Fragment;
import com.velickomarija.diploma.views.sound.TestingSoundFragment;

import java.util.HashMap;
import java.util.Map;

public class TestingImageVariantFragment extends Fragment implements INavigation {
    private static final String TAG = "TESTING_IMAGE_VARIANT";

    private Algorithms algorithms = new Algorithms();
    private TextView title;
    private int parsedColor = Color.parseColor("#37bc51");
    private PreferencesLocal preferencesLocal = new PreferencesLocal();

    private Button buttonReady;

    private ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5,
            imageButton6, imageButton7, imageButton8, imageButton9, imageButton10, imageButton11, imageButton12,
            imageButton13, imageButton14, imageButton15, imageButton16, imageButton17, imageButton18,
            imageButton19, imageButton20, imageButton21, imageButton22, imageButton23, imageButton24,
            imageButton25, imageButton26, imageButton27, imageButton28, imageButton29, imageButton30, imageButton31,
            imageButton32, imageButton33, imageButton34, imageButton35, imageButton36;

    private boolean btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14,
            btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25, btn26,
            btn27, btn28, btn29, btn30, btn31, btn32, btn33, btn34, btn35, btn36;
    private boolean[] btnArray = new boolean[36];

    public void onBackPressed() {
        // do nothing
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.testing_image_veriant_fragment, container, false);

        initButtons(view);

        title = (TextView) view.findViewById(R.id.textViewTit);
        title.setText("Отметьте фигуры, которые Вы запомнили");

        if (preferencesLocal.getProperty("PREF_NUM_IMAGE").equals("3")) {
            reverseElement1();
        }
        if (preferencesLocal.getProperty("PREF_NUM_IMAGE").equals("1")) {
            reverseElement2();
        }
        if (preferencesLocal.getProperty("PREF_NUM_IMAGE").equals("4")) {
            title.setText("Давайте вспомним фигуры, которые\n мы запомниали, и отметим их");
            reverseElement3();
        }

        getFalseButton();

        buttonReady = view.findViewById(R.id.button_testing_image);
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

        imageButton25 = view.findViewById(R.id.imageButton25);
        imageButton25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn25 = clcSymbol(imageButton25, btn25);
            }
        });

        imageButton26 = view.findViewById(R.id.imageButton26);
        imageButton26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn26 = clcSymbol(imageButton26, btn26);
            }
        });

        imageButton27 = view.findViewById(R.id.imageButton27);
        imageButton27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn27 = clcSymbol(imageButton27, btn27);
            }
        });

        imageButton28 = view.findViewById(R.id.imageButton28);
        imageButton28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn28 = clcSymbol(imageButton28, btn28);
            }
        });

        imageButton29 = view.findViewById(R.id.imageButton29);
        imageButton29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn29 = clcSymbol(imageButton29, btn29);
            }
        });

        imageButton30 = view.findViewById(R.id.imageButton30);
        imageButton30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn30 = clcSymbol(imageButton30, btn30);
            }
        });

        imageButton31 = view.findViewById(R.id.imageButton31);
        imageButton31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn31 = clcSymbol(imageButton31, btn31);
            }
        });

        imageButton32 = view.findViewById(R.id.imageButton32);
        imageButton32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn32 = clcSymbol(imageButton32, btn32);
            }
        });

        imageButton33 = view.findViewById(R.id.imageButton33);
        imageButton33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn33 = clcSymbol(imageButton33, btn33);
            }
        });

        imageButton34 = view.findViewById(R.id.imageButton34);
        imageButton34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn34 = clcSymbol(imageButton34, btn34);
            }
        });

        imageButton35 = view.findViewById(R.id.imageButton35);
        imageButton35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn35 = clcSymbol(imageButton35, btn35);
            }
        });

        imageButton36 = view.findViewById(R.id.imageButton36);
        imageButton36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn36 = clcSymbol(imageButton36, btn36);
            }
        });
    }

    /**
     * Метод для вторичной перестановки фигур местами.
     */
    private void reverseElement2() {
        //general image
        imageButton1.setImageResource(R.drawable.symbol8);
        imageButton7.setImageResource(R.drawable.symbol9);
        imageButton10.setImageResource(R.drawable.symbol2);
        imageButton12.setImageResource(R.drawable.symbol3);
        imageButton14.setImageResource(R.drawable.symbol6);
        imageButton18.setImageResource(R.drawable.symbol10);
        imageButton22.setImageResource(R.drawable.symbol11);
        imageButton24.setImageResource(R.drawable.symbol1);
        imageButton27.setImageResource(R.drawable.symbol4);
        imageButton30.setImageResource(R.drawable.symbol7);
        imageButton32.setImageResource(R.drawable.symbol12);
        imageButton34.setImageResource(R.drawable.symbol5);
        //else image
        imageButton2.setImageResource(R.drawable.symbol6i);
        imageButton3.setImageResource(R.drawable.symbol5r);
        imageButton4.setImageResource(R.drawable.symbol3i);
        imageButton5.setImageResource(R.drawable.symbol2i);
        imageButton6.setImageResource(R.drawable.symbol12r);
        imageButton8.setImageResource(R.drawable.symbol12i);
        imageButton9.setImageResource(R.drawable.symbol10i);
        imageButton11.setImageResource(R.drawable.symbol10r);
        imageButton13.setImageResource(R.drawable.symbol2r);
        imageButton15.setImageResource(R.drawable.symbol11r);
        imageButton16.setImageResource(R.drawable.symbol5i);
        imageButton17.setImageResource(R.drawable.symbol4r);
        imageButton19.setImageResource(R.drawable.symbol1r);
        imageButton20.setImageResource(R.drawable.symbol7r);
        imageButton21.setImageResource(R.drawable.symbol9i);
        imageButton23.setImageResource(R.drawable.symbol9r);
        imageButton25.setImageResource(R.drawable.symbol4i);
        imageButton26.setImageResource(R.drawable.symbol11i);
        imageButton28.setImageResource(R.drawable.symbol6r);
        imageButton29.setImageResource(R.drawable.symbol3r);
        imageButton31.setImageResource(R.drawable.symbol8r);
        imageButton33.setImageResource(R.drawable.symbol7i);
        imageButton35.setImageResource(R.drawable.symbol8i);
        imageButton36.setImageResource(R.drawable.symbol1i);
    }

    /**
     * Метод для первичной перестановки фигур местами.
     */
    private void reverseElement1() {
        //general image
        imageButton1.setImageResource(R.drawable.symbol11);
        imageButton7.setImageResource(R.drawable.symbol5);
        imageButton10.setImageResource(R.drawable.symbol2);
        imageButton12.setImageResource(R.drawable.symbol9);
        imageButton14.setImageResource(R.drawable.symbol10);
        imageButton18.setImageResource(R.drawable.symbol1);
        imageButton22.setImageResource(R.drawable.symbol12);
        imageButton24.setImageResource(R.drawable.symbol6);
        imageButton27.setImageResource(R.drawable.symbol4);
        imageButton30.setImageResource(R.drawable.symbol7);
        imageButton32.setImageResource(R.drawable.symbol8);
        imageButton34.setImageResource(R.drawable.symbol3);
        //else image
        imageButton2.setImageResource(R.drawable.symbol11r);
        imageButton3.setImageResource(R.drawable.symbol9r);
        imageButton4.setImageResource(R.drawable.symbol3r);
        imageButton5.setImageResource(R.drawable.symbol6i);
        imageButton6.setImageResource(R.drawable.symbol3i);
        imageButton8.setImageResource(R.drawable.symbol4i);
        imageButton9.setImageResource(R.drawable.symbol10i);
        imageButton11.setImageResource(R.drawable.symbol12r);
        imageButton13.setImageResource(R.drawable.symbol12i);
        imageButton15.setImageResource(R.drawable.symbol9i);
        imageButton16.setImageResource(R.drawable.symbol10r);
        imageButton17.setImageResource(R.drawable.symbol11i);
        imageButton19.setImageResource(R.drawable.symbol7r);
        imageButton20.setImageResource(R.drawable.symbol1r);
        imageButton21.setImageResource(R.drawable.symbol8r);
        imageButton23.setImageResource(R.drawable.symbol2r);
        imageButton25.setImageResource(R.drawable.symbol5r);
        imageButton26.setImageResource(R.drawable.symbol6r);
        imageButton28.setImageResource(R.drawable.symbol8i);
        imageButton29.setImageResource(R.drawable.symbol4r);
        imageButton31.setImageResource(R.drawable.symbol7i);
        imageButton33.setImageResource(R.drawable.symbol5i);
        imageButton35.setImageResource(R.drawable.symbol2i);
        imageButton36.setImageResource(R.drawable.symbol1i);
    }

    /**
     * Метод для перестановки фигур местами.
     */
    private void reverseElement3() {
        //general image
        imageButton1.setImageResource(R.drawable.symbol10);
        imageButton7.setImageResource(R.drawable.symbol12);
        imageButton10.setImageResource(R.drawable.symbol3);
        imageButton12.setImageResource(R.drawable.symbol8);
        imageButton14.setImageResource(R.drawable.symbol7);
        imageButton18.setImageResource(R.drawable.symbol5);
        imageButton22.setImageResource(R.drawable.symbol9);
        imageButton24.setImageResource(R.drawable.symbol4);
        imageButton27.setImageResource(R.drawable.symbol2);
        imageButton30.setImageResource(R.drawable.symbol6);
        imageButton32.setImageResource(R.drawable.symbol11);
        imageButton34.setImageResource(R.drawable.symbol1);
        //else image
        imageButton2.setImageResource(R.drawable.symbol11i);
        imageButton3.setImageResource(R.drawable.symbol3r);
        imageButton4.setImageResource(R.drawable.symbol12i);
        imageButton5.setImageResource(R.drawable.symbol2i);
        imageButton6.setImageResource(R.drawable.symbol4i);
        imageButton8.setImageResource(R.drawable.symbol9i);
        imageButton9.setImageResource(R.drawable.symbol11r);
        imageButton11.setImageResource(R.drawable.symbol12r);
        imageButton13.setImageResource(R.drawable.symbol6r);
        imageButton15.setImageResource(R.drawable.symbol9r);
        imageButton16.setImageResource(R.drawable.symbol8r);
        imageButton17.setImageResource(R.drawable.symbol3i);
        imageButton19.setImageResource(R.drawable.symbol2r);
        imageButton20.setImageResource(R.drawable.symbol7r);
        imageButton21.setImageResource(R.drawable.symbol1i);
        imageButton23.setImageResource(R.drawable.symbol10i);
        imageButton25.setImageResource(R.drawable.symbol5r);
        imageButton26.setImageResource(R.drawable.symbol10r);
        imageButton28.setImageResource(R.drawable.symbol7i);
        imageButton29.setImageResource(R.drawable.symbol8i);
        imageButton31.setImageResource(R.drawable.symbol6i);
        imageButton33.setImageResource(R.drawable.symbol4r);
        imageButton35.setImageResource(R.drawable.symbol1r);
        imageButton36.setImageResource(R.drawable.symbol5i);
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
        btn25 = false;
        btn26 = false;
        btn27 = false;
        btn28 = false;
        btn29 = false;
        btn30 = false;
        btn31 = false;
        btn32 = false;
        btn33 = false;
        btn34 = false;
        btn35 = false;
        btn36 = false;
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
        btnArray[24] = btn25;
        btnArray[25] = btn26;
        btnArray[26] = btn27;
        btnArray[27] = btn28;
        btnArray[28] = btn29;
        btnArray[29] = btn30;
        btnArray[30] = btn31;
        btnArray[31] = btn32;
        btnArray[32] = btn33;
        btnArray[33] = btn34;
        btnArray[34] = btn35;
        btnArray[35] = btn36;
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

    /**
     * Метод для корректирования полученных результатов.
     *
     * @param res результат тестирования.
     * @return Скорректированный результат тестирования.
     */
    private String initResString(String res) {
        if (res.equals("11") || res.equals("12")) {
            return "10";
        }
        return res;
    }

    /**
     * Метод-обработчик нажатия на кнопку "Готово". Выполняет методы по подсчету результатов.
     */
    private void onClickToGoNextTestingImage() {
        Map<Integer, Boolean> map = new HashMap<>();
        btnArray = getArrayButtons();
        for (int i = 0; i < 36; i++) {
            map.put(i + 1, btnArray[i]);
        }

        int res = algorithms.algorithmImageMemoryZ1(map, getContext());
        String resString = String.valueOf(res);

        if (preferencesLocal.getProperty("PREF_NUM_IMAGE").equals("2")) {

            preferencesLocal.addProperty("PREF_Z1",
                    initResString(resString),
                    getContext());

            preferencesLocal.addProperty("PREF_RESULTIMAGE1",
                    resString,
                    getContext());

            showDialogImage(getString(R.string.message_title),
                    "3",
                    "TESTING_ENTER_IMAGE",
                    new TestingEnterImageFragment()
            );

        } else if (preferencesLocal.getProperty("PREF_NUM_IMAGE").equals("3")) {

            preferencesLocal.addProperty("PREF_RESULTIMAGE2",
                    resString,
                    getContext());

            showDialogImage(getString(R.string.message_title),
                    "1",
                    "TESTING_ENTER_IMAGE",
                    new TestingEnterImageFragment()
            );

        } else if (preferencesLocal.getProperty("PREF_NUM_IMAGE").equals("1")) {

            preferencesLocal.addProperty("PREF_RESULTIMAGE3",
                    resString,
                    getContext());

            String par1 = preferencesLocal.getProperty("PREF_RESULTIMAGE1");
            String par2 = preferencesLocal.getProperty("PREF_RESULTIMAGE2");
            String par3 = preferencesLocal.getProperty("PREF_RESULTIMAGE3");
            String result = algorithms.algorithmSoundMemoryC2(par1, par2, par3);

            preferencesLocal.addProperty("PREF_Z2",
                    result,
                    getContext());
            showDialogImage(getString(R.string.message_title),
                    "4",
                    "TESTING_SOUND",
                    new TestingSoundFragment());

        } else {

            preferencesLocal.addProperty("PREF_LASTIMAGERESULT1",
                    resString,
                    getContext());
            preferencesLocal.addProperty("PREF_Z5",
                    initResString(resString),
                    getContext());

            showDialogImage(getString(R.string.message_title),
                    "5",
                    "QUESTION_SECOND_ENTER",
                    new QuestionEnter2Fragment()
            );
            //todo второе отсроченное
        }
    }

    /**
     * Метод, отображающий окно-подтверждение на действие пользователя при тестировании зрительной памяти.
     *
     * @param text     текст сообщения-подтверждения.
     * @param num      идентификатор следующей пробы.
     * @param tag      тег перехода.
     * @param fragment переходной фрагмент.
     */
    public void showDialogImage(String text, final String num, final String tag, final Fragment fragment) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.important_message)
                .setMessage(text)
                .setIcon(R.drawable.ic_error_black_24dp)
                .setCancelable(false).setPositiveButton(getString(R.string.yes_go),
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        PreferencesLocal preferencesLocal = new PreferencesLocal();
                        preferencesLocal.addProperty("PREF_NUM_IMAGE",
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

    @Override
    public void replaceFragment(String tag, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
