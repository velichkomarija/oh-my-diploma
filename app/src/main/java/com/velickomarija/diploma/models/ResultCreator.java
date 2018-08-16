package com.velickomarija.diploma.models;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Класс для генерации результатов тестирования.
 */
public class ResultCreator {

    final static PreferencesLocal preferencesLocal = new PreferencesLocal();
    private static final String TAG = "RESULT_CREATOR";

    /**
     * Метод, генерирующий полный результата тестирования для отправки в хранилище.
     *
     * @return Строка с результатом тестирования.
     */
    public static String generateFullResult() {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Информация о тестируемом:")
                .append(preferencesLocal.getProperty(Constants.PREF_NAME) + "/")
                .append(preferencesLocal.getProperty(Constants.PREF_AGE) + "/")
                .append(preferencesLocal.getProperty(Constants.PREF_MALE) + "/")
                .append(preferencesLocal.getProperty(Constants.PREF_EDUCATION) + "/")
                .append(preferencesLocal.getProperty(Constants.PREF_ETC_INFORMATION))
                .append("\n\n");

        stringBuffer.append("Результаты тестирования слухоречевой памяти: \n")
                .append("Параметр C1: ")
                .append(preferencesLocal.getProperty(Constants.PREF_C1))
                .append("\n")
                .append("Параметр C2: ")
                .append(preferencesLocal.getProperty(Constants.PREF_C2))
                .append("\n")
                .append("Параметр C4: ")
                .append(preferencesLocal.getProperty(Constants.PREF_C4))
                .append("\n")
                .append("Параметр C5: ")
                .append(preferencesLocal.getProperty(Constants.PREF_C5))
                .append("\n")
                .append("Параметр C6: ")
                .append(preferencesLocal.getProperty(Constants.PREF_C6))
                .append("\n")
                .append("Параметр C6(количество ошибок): ")
                .append(preferencesLocal.getProperty(Constants.PREF_REAL_C6))
                .append("\n")
                .append("Сумма: ")
                .append(preferencesLocal.getProperty(Constants.PREF_TOTAL_SOUND))
                .append("\n\n");

        stringBuffer.append("Результаты тестирования зрительной памяти: \n")
                .append("Параметр Z1: ")
                .append(preferencesLocal.getProperty(Constants.PREF_Z1))
                .append("\n")
                .append("Параметр Z2: ")
                .append(preferencesLocal.getProperty(Constants.PREF_Z2))
                .append("\n")
                .append("Параметр Z4: ")
                .append(preferencesLocal.getProperty(Constants.PREF_Z4))
                .append("\n")
                .append("Параметр Z5: ")
                .append(preferencesLocal.getProperty(Constants.PREF_Z5))
                .append("\n")
                .append("Параметр Z6: ")
                .append(preferencesLocal.getProperty(Constants.PREF_Z6))
                .append("\n")
                .append("Параметр Z6(количество ошибок): ")
                .append(preferencesLocal.getProperty(Constants.PREF_REAL_Z6))
                .append("\n")
                .append("Сумма: ")
                .append(preferencesLocal.getProperty(Constants.PREF_TOTAL_IMAGE))
                .append("\n\n");

        stringBuffer.append("Результаты тестирования: ")
                .append(preferencesLocal.getProperty(Constants.PREF_TOTAL));

        return stringBuffer.toString();
    }

    /**
     * Метод, генерирующий уникальное имя файла для отправки.
     *
     * @return Строка с названием файла.
     */
    private static String createNameFile() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer
                .append(preferencesLocal.getProperty(Constants.PREF_NAME))
                .append("_")
                .append((int) (Math.random() * 10000))
                .append(".txt");

        return stringBuffer.toString();
    }

    /**
     * Метод, осуществляющий отправку файла в хранилище.
     *
     * @param context контекст выполнения программы.
     */
    public static void sendFile(final Context context) {

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference().child(createNameFile());

        try {
            InputStream stream = context.openFileInput(createFile(createNameFile(), context).getName());
            UploadTask uploadTask = storageRef.putStream(stream);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    exception.printStackTrace();
                    //      Toast.makeText(context, "Upload Failed!", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "Upload Failed!");
                }
            }).addOnSuccessListener(new OnSuccessListener() {
                @Override
                public void onSuccess(Object o) {
                    //   Toast.makeText(context, "Upload successful!", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "Upload successful!");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод, создающий файл для отправки в хранилище. Файл также создается в памяти телефона.
     *
     * @param name    имя файла.
     * @param context контекст выполнения приложения.
     * @return Объект типа File.
     */
    private static File createFile(String name, Context context) {
        FileOutputStream outputStream;

        File file = new File(context.getFilesDir(), name);
        try {
            outputStream = context.openFileOutput(name, Context.MODE_PRIVATE);
            outputStream.write(generateFullResult().
                    getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "File was not create!");
        }

        return file;
    }
}
