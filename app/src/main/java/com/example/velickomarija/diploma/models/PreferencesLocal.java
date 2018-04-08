package com.example.velickomarija.diploma.models;

import android.content.Context;
import android.content.SharedPreferences;


public class PreferencesLocal {

    private static final String PREFS_FILE = "Account";
    private static SharedPreferences settings = null;
    private static SharedPreferences.Editor editor = null;
    private static Context context = null;

    private static void init(Context cont) {
        context = cont;
    }

    private static void init() {
        settings = context.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        editor = settings.edit();
    }

    public void addProperty(String name, String value, Context context) {
        init(context);
        if (settings == null) {
            init();
        }
        editor.putString(name, value);
        editor.commit();
    }

    public String getProperty(String name) {
        if (settings == null) {
            init();
        }
        return settings.getString(name, null);
    }
}
