package com.example.velickomarija.diploma.models;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ResultCreator {

    final static PreferencesLocal preferencesLocal = new PreferencesLocal();

    public static String generateFullResult() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Информация о тестируемом:")
                .append(preferencesLocal.getProperty("PREF_NAME") + "/")
                .append(preferencesLocal.getProperty("PREF_AGE") + "/")
                .append(preferencesLocal.getProperty("PREF_EDUCATION") + "/")
                .append(preferencesLocal.getProperty("PREF_ETC_INFORMATION"))
                .append("\n\n");

        stringBuffer.append("Результаты тестирования слухоречевой памяти: \n")
                .append("Параметр C1: ")
                .append(preferencesLocal.getProperty("PREF_C1"))
                .append("\n")
                .append("Параметр C2: ")
                .append(preferencesLocal.getProperty("PREF_C2"))
                .append("\n")
                .append("Параметр C4: ")
                .append(preferencesLocal.getProperty("PREF_C4"))
                .append("\n")
                .append("Параметр C5: ")
                .append(preferencesLocal.getProperty("PREF_C5"))
                .append("\n")
                .append("Параметр C6: ")
                .append(preferencesLocal.getProperty("PREF_C6"))
                .append("\n")
                .append("Сумма: ")
                .append(preferencesLocal.getProperty("PREF_TOTAL_SOUND"))
                .append("\n\n");

        stringBuffer.append("Результаты тестирования зрительной памяти: \n")
                .append("Параметр Z1: ")
                .append(preferencesLocal.getProperty("PREF_Z1"))
                .append("\n")
                .append("Параметр Z2: ")
                .append(preferencesLocal.getProperty("PREF_Z2"))
                .append("\n")
                .append("Параметр Z4: ")
                .append(preferencesLocal.getProperty("PREF_Z4"))
                .append("\n")
                .append("Параметр Z5: ")
                .append(preferencesLocal.getProperty("PREF_Z5"))
                .append("\n")
                .append("Сумма: ")
                .append(preferencesLocal.getProperty("PREF_TOTAL_IMAGE"))
                .append("\n\n");

        stringBuffer.append("Результаты тестирования: ")
                .append(preferencesLocal.getProperty("PREF_TOTAL"));

        return stringBuffer.toString();
    }

    private static String createNameFile(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer
                .append(preferencesLocal.getProperty("PREF_NAME"))
                .append((int)(Math.random()*1000))
                .append(".txt");
        return stringBuffer.toString();
    }

    public static void sendFile(final Context context){
        FirebaseStorage storage = FirebaseStorage.getInstance();

        StorageReference storageRef = storage.getReference().child(createNameFile());

        try {
            InputStream stream = context.openFileInput(createFile(createNameFile(),context).getName());
            UploadTask uploadTask = storageRef.putStream(stream);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    exception.printStackTrace();
                    Toast.makeText(context, "Upload Failed!", Toast.LENGTH_SHORT).show();
                }
            }).addOnSuccessListener(new OnSuccessListener() {
                @Override
                public void onSuccess(Object o) {
                    Toast.makeText(context, "Upload successful!", Toast.LENGTH_SHORT).show();
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static File createFile(String name, Context context){
        FileOutputStream outputStream;

        File file = new File(context.getFilesDir(), name);

        try {
            outputStream = context.openFileOutput(name, Context.MODE_PRIVATE);
            outputStream.write(generateFullResult().
                    getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "какашка!", Toast.LENGTH_SHORT).show();
        }
        return file;
    }
}
