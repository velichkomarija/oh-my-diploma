package com.example.velickomarija.diploma;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AlgorithmsTest {

    ConstantsForTesting constantsForTesting = new ConstantsForTesting();
    String textSoundResult = constantsForTesting.getTestSound1();
    String textImageResult = constantsForTesting.getTestImageString1();

    int par1 = 3;
    int par2 = 6;
    int par3 = 8;


    @Test
    public void testToMapInteger() {
        Map<Integer, Integer> map = new HashMap<>();
        String[] strArray = textImageResult.split(" ");

        for (int i = 0; i < strArray.length; i++) {
            map.put(i + 1, Integer.parseInt(strArray[i]));
        }

        for (Map.Entry<Integer, Integer> digit : map.entrySet()) {
            System.out.println(digit.getKey() + " " + digit.getValue());
        }
    }

    @Test
    public void textToMap() {
        int j = 0;
        Map<Integer, String> map = new HashMap<>();
        String[] array = constantsForTesting.getEqualsTestSound1();
        String[] strArray = textSoundResult.split(" ");

        for (int i = 0; i < strArray.length; i++) {
            map.put(i + 1, strArray[i]);
        }

        for (Map.Entry<Integer, String> word : map.entrySet()) {
            assertEquals(word.getKey() + " " + word.getValue(), array[j]);
            j++;
        }
    }

    @Test
    public void AlgorithmSoundMemory() {
        Map<Integer, String> map = new HashMap<>();
        int sum = 0;
        boolean flag = false;

        //карта с результатами в основном алгоритме testToMap()
        String[] strArray = textSoundResult.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            map.put(i + 1, strArray[i]);
        }

        //заменяем слова на порядки в карте-эталоне
        for (Map.Entry<Integer, String> item : map.entrySet()) {
            for (Map.Entry<Integer, String> word : ConstantsForTesting.getGeneralWordsMap().entrySet()) {
                if (item.getValue().toUpperCase().equals(word.getValue())) {
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

        //подсчет количества слов при первом запоминаниии
        for (Map.Entry<Integer, String> newWord : map.entrySet()) {
            // System.out.println(newWord.getKey() + " " + newWord.getValue());
            if (Integer.parseInt(newWord.getValue()) != 0) {
                sum++;
            }
        }
        assertEquals(sum, 11);
    }

    int zeroAdapter(int digit) {
        if (digit < 0) {
            return 0;
        } else {
            return digit;
        }
    }

    @Test
    //подсчет С2
    public void AlgorithmSoundMemoryC2() {
        //вычисления по таблице результатов с подсчетом вычетов и проб
        int res = 0;
        int regular1 = par1 - par2;
        int regular2 = par2 - par3;
        regular1 = zeroAdapter(regular1);
        regular2 = zeroAdapter(regular2);


        int newResPar2 = par2 - 1 - regular1;
        int newResPar3 = par3 - 2 - regular2;

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
        assertEquals(res, 6);
    }

    @Test
    //подсчет Z1
    public void AlgorithmImageMemoryZ1() {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        boolean flag = false;

        //карта с результатами в основном алгоритме testToMapInt()
        String[] strArray = textImageResult.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            map.put(i + 1, Integer.parseInt(strArray[i]));
        }

        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            for (Map.Entry<Integer, Integer> word : ConstantsForTesting.getGeneralImage().entrySet()) {
                if (item.getValue() == word.getValue()) {
                    //item.setValue(item.getKey());
                    word.setValue(0);
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                item.setValue(0);
            }
            flag = false;
        }

        for (Map.Entry<Integer, Integer> newWord : map.entrySet()) {
            System.out.println(newWord.getKey() + " " + newWord.getValue());
            if (newWord.getValue() != 0) {
                sum++;
            }
        }
        assertEquals(sum, 12);

    }
}