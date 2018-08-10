package com.velickomarija.diploma.views.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.velickomarija.diploma.INavigation;
import com.velickomarija.diploma.R;
import com.velickomarija.diploma.models.Functions;
import com.velickomarija.diploma.models.PreferencesLocal;
import com.velickomarija.diploma.views.pause.ShulteFragment;
import com.velickomarija.diploma.views.sound.TestingEnterSoundFragment;

public class ProfileFragment extends Fragment implements INavigation {
    private static final String TAG = "PROFILE";
    private RadioGroup radioGroup;
    private PreferencesLocal pref = new PreferencesLocal();
    private Spinner spinner;
    private EditText ageBox, nameBox;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        initAllPreference();

        RadioButton radioButton1 = (RadioButton) view.findViewById(R.id.male);
        RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.famale);

        radioGroup = (RadioGroup) view.findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        Toast.makeText(getContext(),
                                "Ничего не выбрано",
                                Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.male:
                        saveMale("Мужской");
                        break;

                    case R.id.famale:
                        saveMale("Женский");
                        break;

                    default:
                        break;
                }
            }
        });

        ageBox = (EditText) view.findViewById(R.id.age_input);
        nameBox = (EditText) view.findViewById(R.id.name_input_field);

        spinner = (Spinner) view.findViewById(R.id.education_input_field);
        spinner.setSelection(0);

        ((Button) view.findViewById(R.id.next_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean nameFlag = saveName(view);
                boolean ageFlag = saveAge(view);

                saveEtcInformation(view);
                saveEducation();

                if (nameFlag == true && ageFlag == true) {
                    replaceFragment("TESTING_ENTER_SOUND", new TestingEnterSoundFragment());
                    //    replaceFragment("SHULTE", new ShulteFragment());
                }
            }
        });
        return view;
    }

    /**
     * Метод, выполняющий первичную инициализацию полей настроек приложения.
     */
    private void initAllPreference() {
        Context context = getContext();
        PreferencesLocal preferencesLocal = new PreferencesLocal();
        //триггеры
        preferencesLocal.addProperty("PREF_NUM_SOUND", "1", context);
        preferencesLocal.addProperty("PREF_NUM_IMAGE", "none", context);
        //данные о пользователе
        preferencesLocal.addProperty("PREF_NAME", "none", context);
        preferencesLocal.addProperty("PREF_AGE", "none", context);
        preferencesLocal.addProperty("PREF_EDUCATION", "none", context);
        preferencesLocal.addProperty("PREF_MALE", "none", context);
        preferencesLocal.addProperty("PREF_ETC_INFORMATION", "none", context);
        //результат первых трех проб в слуховой памяти
        preferencesLocal.addProperty(" PREF_SOUNDRESULT1", "0", context);
        preferencesLocal.addProperty(" PREF_SOUNDRESULT2", "0", context);
        preferencesLocal.addProperty(" PREF_SOUNDRESULT3", "0", context);
        //результат первых проб зрительной памяти
        preferencesLocal.addProperty("PREF_IMAGE1", "0", context);
        preferencesLocal.addProperty("PREF_IMAGE2", "0", context);
        preferencesLocal.addProperty("PREF_IMAGE3", "0", context);
        //результат C1,C2,C4,C6, Z1,Z2,Z4,Z6
        preferencesLocal.addProperty("PREF_C1", "0", context);
        preferencesLocal.addProperty("PREF_C2", "0", context);
        preferencesLocal.addProperty("PREF_C4", "0", context);
        preferencesLocal.addProperty("PREF_C6", "0", context);
        preferencesLocal.addProperty("PREF_Z1", "0", context);
        preferencesLocal.addProperty("PREF_Z2", "0", context);
        preferencesLocal.addProperty("PREF_Z4", "0", context);
        preferencesLocal.addProperty("PREF_Z6", "0", context);
        //Отсроченные
        preferencesLocal.addProperty("PREF_SOUNDLASTRESULT1", "0", context);
        preferencesLocal.addProperty("PREF_С5", "0", context);
        preferencesLocal.addProperty("PREF_LASTIMAGERESULT2", "0", context);
        preferencesLocal.addProperty("PREF_SOUNDLASTRESULT2", "0", context);
        preferencesLocal.addProperty("PREF_LASTIMAGERESULT1", "0", context);
        preferencesLocal.addProperty("PREF_Z5", "0", context);
        //Старые слова
        preferencesLocal.addProperty("PREF_RESULTOLDWORDS", "0", context);
        //узнавание
        preferencesLocal.addProperty("PREF_FINDINGIMAGERESULT2", "0", getContext());
    }

    /**
     * Метод, обрабатывающий нажатия на радио-кнопки.
     *
     * @param view объект класса View.
     */
    public void onClick(View view) {
        // очистить все переключатели
        radioGroup.clearCheck();
    }

    /**
     * Метод, сохраняющий значение параметра "ФИО тестируемого"
     *
     * @param view объект класса View.
     * @return Булева переменная, отвечающая за признак заполненности поля.
     * Если true - то поле заполнено, не заполнено - false.
     */
    private boolean saveName(View view) {
        //получаем ФИО
        boolean flag = true;
        try {
            String name = nameBox.getText().toString();

            if (name.equals(null) ||
                    name.equals("")) {
                throw new Exception();
            }

            pref.addProperty("PREF_NAME",
                    name,
                    getContext());

        } catch (Exception e) {
            Functions.showErrorDialog(view, "Поле ФИО заполнено некорректно!");
            flag = false;
        }
        return flag;
    }

    /**
     * Метод, отвечающий за обработку поля "Пол".
     *
     * @param text строка.
     */
    private void saveMale(String text) {
        //получаем пол
        pref.addProperty("PREF_MALE", text, getContext());
    }

    /**
     * Метод, отвечающий за сохранение данных поля "Другая информация".
     */
    private void saveEtcInformation(View view) {
        //получаем другую информацию
        EditText etcInformationBox = (EditText) view.findViewById(R.id.etc_input_field);
        try {
            String etcInformation = etcInformationBox.getText().toString();

            pref.addProperty("PREF_ETC_INFORMATION",
                    etcInformation,
                    getContext());

        } catch (Exception e) {
            pref.addProperty("PREF_ETC_INFORMATION",
                    " ",
                    getContext());
        }
    }

    /**
     * Метод, проверяющий значение поля "Возраст".
     *
     * @param view объект класса View.
     * @return Булева переменная, показывающая правильно заполнено поле (true) или нет (false).
     */
    private boolean saveAge(View view) {
        //получаем возраст
        boolean flag = true;

        String stringAge = ageBox.getText().toString();

        try {
            Integer age = Integer.parseInt(stringAge);
            if (age <= 7 || age > 100) {
                throw new Exception();
            }
            pref.addProperty("PREF_AGE",
                    stringAge,
                    getContext());

        } catch (Exception e) {
            Functions.showErrorDialog(view, "Поле Возраст заполнено некорректно");
            flag = false;
        }
        return flag;
    }

    /**
     * Метод, сохраняющий информацию о поле "Образование".
     */
    private void saveEducation() {
        //получаем образование
        String selected = spinner.getSelectedItem().toString();
        pref.addProperty("PREF_EDUCATION",
                selected,
                getContext());
    }

    @Override
    public void replaceFragment(String tag, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
