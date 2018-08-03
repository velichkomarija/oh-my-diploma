package com.velickomarija.diploma.models;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Класс-обертка на класс SharedPreferences. Необходим для избавления от дублирования кода.
 */
public class PreferencesLocal {

    private static final String PREFS_FILE = "Account";
    private static final String TAG = "PREFERENCE";
    private static SharedPreferences settings = null;
    private static SharedPreferences.Editor editor = null;
    private static Context context = null;

    /**
     * Метод для инициализации контекста работы приложения.
     *
     * @param cont контекст выполнения программы.
     */
    private static void init(Context cont) {
        context = cont;
    }

    /**
     * Метод для инициализации базовых параметров класса.
     */
    private static void init() {
        settings = context.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        editor = settings.edit();
    }

    /**
     * Метод, добавляющий пару ключ-значений в файл настроек приложения.
     *
     * @param name    имя параметра.
     * @param value   значение параметра.
     * @param context контекст выполнения приложения.
     */
    public void addProperty(String name, String value, Context context) {
        init(context);
        if (settings == null) {
            init();
        }
        editor.putString(name, value);
        editor.commit();
        Log.d(TAG, name.concat(": ").concat(value));
    }

    /**
     * Метод, возвращающий значение указанного параметра настроек приложения.
     *
     * @param name название параметра.
     * @return Значение параметра настроек.
     */
    public String getProperty(String name) {
        if (settings == null) {
            init();
        }
        return settings.getString(name, null);
    }
}
