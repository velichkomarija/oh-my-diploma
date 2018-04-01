package com.example.velickomarija.diploma;

import android.test.mock.MockApplication;
import android.text.BoringLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by velic on 08.01.2018.
 */

public class Algoritms {

    private static final Map<Integer, String> generalWordsMap;

    static {
        generalWordsMap = new HashMap<Integer, String>();
        generalWordsMap.put(1, "КЛЕЙ");
        generalWordsMap.put(2, "ЛУЧ");
        generalWordsMap.put(3, "КУБ");
        generalWordsMap.put(4, "ТРОН");
        generalWordsMap.put(5, "ШУБА");
        generalWordsMap.put(6, "ВЕЛОСИПЕД");
        generalWordsMap.put(7, "ЗВЕЗДА");
        generalWordsMap.put(8, "НИТКА");
        generalWordsMap.put(9, "ПЕСОК");
        generalWordsMap.put(10, "БЕЛКА");
        generalWordsMap.put(11, "ПЫЛЬ");
    }

    private static final Map<Integer, String> generalAndNewWordsMap;

    static {
        generalAndNewWordsMap = new HashMap<Integer, String>();
        generalAndNewWordsMap.put(1, "ЗВЕЗДА");
        generalAndNewWordsMap.put(2, "ПОТОЛОК");
        generalAndNewWordsMap.put(3, "СЕНО");
        generalAndNewWordsMap.put(4, "КЛЕЙ");
        generalAndNewWordsMap.put(5, "ШУБА");
        generalAndNewWordsMap.put(6, "МОЛОКО");
        generalAndNewWordsMap.put(7, "КАТУШКА");
        generalAndNewWordsMap.put(8, "ПЕСОК");
        generalAndNewWordsMap.put(9, "ЦВЕТОК");
        generalAndNewWordsMap.put(10, "БЕЛКА");
        generalAndNewWordsMap.put(11, "ВАЗА");
        generalAndNewWordsMap.put(12, "МЫШЬ");
        generalAndNewWordsMap.put(13, "ЛУЧ");
        generalAndNewWordsMap.put(14, "ТКАНЬ");
        generalAndNewWordsMap.put(15, "ЛЕСОК");
        generalAndNewWordsMap.put(16, "КУБ");
        generalAndNewWordsMap.put(17, "ШЕЛК");
        generalAndNewWordsMap.put(18, "НИТКА");
        generalAndNewWordsMap.put(19, "КОРОНА");
        generalAndNewWordsMap.put(20, "ТРОН");
        generalAndNewWordsMap.put(21, "ПАЛЬТО");
        generalAndNewWordsMap.put(22, "ВЕЛОСИПЕД");
        generalAndNewWordsMap.put(23, "ПЫЛЬ");
    }

    private static final Map<Integer, Integer> generalImage;

    static {
        generalImage = new HashMap<>();
        generalImage.put(1, 1);
        generalImage.put(2, 22);
        generalImage.put(3, 7);
        generalImage.put(4, 10);
        generalImage.put(5, 27);
        generalImage.put(6, 18);
        generalImage.put(7, 30);
        generalImage.put(8, 12);
        generalImage.put(9, 14);
        generalImage.put(10, 34);
        generalImage.put(11, 32);
        generalImage.put(12, 24);
    }

    private static final Map<Integer, Integer> newFigure;

    static {
        newFigure = new HashMap<>();
        newFigure.put(1, 2);
        newFigure.put(2, 4);
        newFigure.put(3, 6);
        newFigure.put(4, 9);
        newFigure.put(5, 11);
        newFigure.put(6, 13);
        newFigure.put(7, 15);
        newFigure.put(8, 17);
        newFigure.put(9, 21);
        newFigure.put(10, 23);
    }

    private static final ArrayList<String> newWords;

    static {
        newWords = new ArrayList<>();
        newWords.add("ПОТОЛОК");
        newWords.add("МОЛОКО");
        newWords.add("КАТУШКА");
        newWords.add("СЕНО");
        newWords.add("ЦВЕТОК");
        newWords.add("ВАЗА");
        newWords.add("МЫШЬ");
        newWords.add("ТКАНЬ");
        newWords.add("ЛЕСОК");
        newWords.add("ШЕЛК");
        newWords.add("КОРОНА");
        newWords.add("ПАЛЬТО");
    }

    private void reloadArrayList() {
        newWords.clear();
        newWords.add("ПОТОЛОК");
        newWords.add("МОЛОКО");
        newWords.add("КАТУШКА");
        newWords.add("СЕНО");
        newWords.add("ЦВЕТОК");
        newWords.add("ВАЗА");
        newWords.add("МЫШЬ");
        newWords.add("ТКАНЬ");
        newWords.add("ЛЕСОК");
        newWords.add("ШЕЛК");
        newWords.add("КОРОНА");
        newWords.add("ПАЛЬТО");
    }

    private void reloadMapWords() {
        generalWordsMap.clear();
        generalWordsMap.put(1, "КЛЕЙ");
        generalWordsMap.put(2, "ЛУЧ");
        generalWordsMap.put(3, "КУБ");
        generalWordsMap.put(4, "ТРОН");
        generalWordsMap.put(5, "ШУБА");
        generalWordsMap.put(6, "ВЕЛОСИПЕД");
        generalWordsMap.put(7, "ЗВЕЗДА");
        generalWordsMap.put(8, "НИТКА");
        generalWordsMap.put(9, "ПЕСОК");
        generalWordsMap.put(10, "БЕЛКА");
        generalWordsMap.put(11, "ПЫЛЬ");
    }

    private void reloadMapDigit() {
        generalImage.clear();
        generalImage.put(1, 1);
        generalImage.put(2, 22);
        generalImage.put(3, 7);
        generalImage.put(4, 10);
        generalImage.put(5, 27);
        generalImage.put(6, 18);
        generalImage.put(7, 30);
        generalImage.put(8, 12);
        generalImage.put(9, 14);
        generalImage.put(10, 34);
        generalImage.put(11, 32);
        generalImage.put(12, 24);
    }

    private Map<Integer, String> textToMap(String text) {
        Map<Integer, String> map = new HashMap<>();
        String newText = text.replace(",", " ");
        String[] strArray = newText.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            map.put(i + 1, strArray[i]);
        }
        return map;
    }

    int zeroAdapter(int digit) {
        if (digit < 0) {
            return 0;
        } else {
            return digit;
        }
    }

    //подсчет С1 на первой пробе + подсчеты сумм на пробе 2,3
    public int AlgorithmSoundMemoryC1(String text) {
        Map<Integer, String> map;
        int sum = 0;
        boolean flag = false;
        map = textToMap(text);

        for (Map.Entry<Integer, String> item : map.entrySet()) {
            for (Map.Entry<Integer, String> word : generalWordsMap.entrySet()) {
                if (item.getValue().equalsIgnoreCase(word.getValue())) {
                    item.setValue(word.getKey().toString());
                    word.setValue("0");
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                item.setValue("0");
            }
            flag = false;
        }
        //обновляем карту
        reloadMapWords();
        for (Map.Entry<Integer, String> newWord : map.entrySet()) {
            // System.out.println(newWord.getKey() + " " + newWord.getValue());
            if (Integer.parseInt(newWord.getValue()) != 0) {
                sum++;
            }
        }
        return sum;
    }

    //подсчет Z1 на первой пробе + подсчеты сумм на пробе 2,3
    public int AlgorithmImageMemoryZ1(Map<Integer, Boolean> map) {
        int sum = 0;

        for (Map.Entry<Integer, Boolean> item : map.entrySet()) {
            for (Map.Entry<Integer, Integer> digit : generalImage.entrySet()) {
                if ((item.getValue() == true) && item.getKey().equals(digit.getValue())) {
                    sum++;
                    break;
                }
            }
        }
        reloadMapDigit();
        return sum;
    }

    //подсчет С2 и Z2
    public String AlgorithmSoundMemoryC2(String p1, String p2, String p3) {
        //вычисления по таблице результатов с подсчетом вычетов и проб
        int res = 0;
        int par1 = Integer.parseInt(p1);
        int par2 = Integer.parseInt(p2);
        int par3 = Integer.parseInt(p3);

        if (par1 > 10) {
            par1 = 10;
        }
        if (par2 > 10) {
            par2 = 10;
        }
        if (par3 > 10) {
            par3 = 10;
        }

        int regular1 = par1 - par2;
        int regular2 = par2 - par3;
        regular1 = zeroAdapter(regular1);
        regular2 = zeroAdapter(regular2);

        int newResPar2 = par2 - 1;
        int newResPar3 = par3 - 2;

        //проверка на выход за пределы нуля
        newResPar2 = zeroAdapter(newResPar2);
        newResPar3 = zeroAdapter(newResPar3);

        if (par1 >= newResPar2 && par1 >= newResPar3) {
            res = par1;
        } else if (newResPar2 >= par1 && newResPar2 >= newResPar3) {
            res = newResPar2;
        } else {
            res = newResPar3;
        }

        res = res - regular1 - regular2;
        res = zeroAdapter(res);

        return String.valueOf(res);
    }

    //подсчет слов на узновании из новых
    public String AlgorithmFindOldWorldsInNew(String text) {
        int res = 0;
        int error = 0;
        String resString;
        int[] resArray = new int[11];
        try {
            String[] strArray = text.split(" ");
            for (int i = 0; i < strArray.length; i++) {
                res = Integer.parseInt(strArray[i]);
                if ((0 <= res) && (res <= 300)) {
                    resArray[0] = 1;
                } else if ((300 < res) && (res <= 500)) {
                    resArray[1] = 1;
                } else if ((640 <= res) && (res <= 800)) {
                    resArray[2] = 1;
                } else if ((1000 <= res) && (res <= 1200)) {
                    resArray[3] = 1;
                } else if ((1350 <= res) && (res <= 1510)) {
                    resArray[4] = 1;
                } else if ((1900 <= res) && (res <= 2070)) {
                    resArray[5] = 1;
                } else if ((2410 <= res) && (res <= 2600)) {
                    resArray[6] = 1;
                } else if ((2800 <= res) && (res <= 2950)) {
                    resArray[7] = 1;
                } else if ((3340 <= res) && (res <= 3500)) {
                    resArray[8] = 1;
                } else if ((3500 < res) && (res <= 3680)) {
                    resArray[9] = 1;
                } else if ((4000 <= res) && (res <= 4200)) {
                    resArray[10] = 1;
                } else {
                    error++;
                }
            }
            
            res = 0;

            for (int j = 0; j < resArray.length; j++) {
                res += resArray[j];
            }
            res = res - error;
            res = zeroAdapter(res);
            //без учета максимальной 10
            resString = String.valueOf(res);
        }
        catch (Exception e){
            resString = "0";
        }
        return resString;
    }

    //подсчет запоминания новых слов
    public String AlgorihmSoundNewWords(String text) {
        int res = 0;
        String[] strArray = text.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < newWords.size(); j++) {
                if (strArray[i].equalsIgnoreCase(newWords.get(j))) {
                    newWords.set(j, "");
                    res++;
                }
            }
        }
        reloadArrayList();
        return String.valueOf(res);
    }

    //подсчет новых фигур
    public String AlgotihmImageNew(Map<Integer, Boolean> map) {
        int sum = 0;

        for (Map.Entry<Integer, Boolean> item : map.entrySet()) {
            for (Map.Entry<Integer, Integer> digit : newFigure.entrySet()) {
                if ((item.getValue() == true) && item.getKey().equals(digit.getValue())) {
                    sum++;
                    break;
                }
            }
        }
       // reloadMapNewFigure();
        return String.valueOf(sum);
    }
}
