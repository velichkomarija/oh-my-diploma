package com.example.velickomarija.diploma.models;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.View;

import com.example.velickomarija.diploma.R;
import com.example.velickomarija.diploma.views.image.TestingImageVariantActivity;
import com.example.velickomarija.diploma.views.sound.TestingSoundActivity;

public class Functions {

    //диалоговое окно на ошибку
    public static void showErrorDialog(View v, String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setTitle("Важное сообщение!")
                .setMessage(text)
                .setIcon(R.drawable.ic_error_black_24dp)
                .setCancelable(false)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }

                        });
        builder.setMessage(Html.fromHtml("<font color='#000000'>" + text + "</font>"));
        AlertDialog alert = builder.create();
        alert.show();
    }

    //диалоговое окно на ложное нажатие
    public static void showDialog(final Class cl, String text, final View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle("Важное сообщение!")
                .setMessage(text)
                .setIcon(R.drawable.ic_error_black_24dp)
                .setCancelable(false).setPositiveButton("Да, продолжить",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        // dialog.cancel();
                        activityToGo(cl, view);
                    }

                })
                .setNegativeButton("Отмена",
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

    //диалоговое окно на ложное нажатие
    public static void showDialogImage(final Class cl, String text, final View view, final String num) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle("Важное сообщение!")
                .setMessage(text)
                .setIcon(R.drawable.ic_error_black_24dp)
                .setCancelable(false).setPositiveButton("Да, продолжить",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        // dialog.cancel();
                        PreferencesLocal preferencesLocal = new PreferencesLocal();
                        preferencesLocal.addProperty("PREF_NUM_IMAGE",
                                num,
                                view.getContext());
                        activityToGo(cl, view);
                    }

                })
                .setNegativeButton("Отмена",
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

    //диалоговое окно на ложное нажатие
    public static void showDialogSound(final Class cl, String text, final View view, final String num) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle("Важное сообщение!")
                .setMessage(text)
                .setIcon(R.drawable.ic_error_black_24dp)
                .setCancelable(false).setPositiveButton("Да, продолжить",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        // dialog.cancel();
                        PreferencesLocal preferencesLocal = new PreferencesLocal();
                        preferencesLocal.addProperty("PREF_NUM_SOUND",
                                num,
                                view.getContext());
                        activityToGo(cl, view);
                    }

                })
                .setNegativeButton("Отмена",
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

    //переход между активити
    public static void activityToGo(Class cl, View view) {
        Intent intent = new Intent(view.getContext(), cl);
        view.getContext().startActivity(intent);
    }
}
