package com.example.velickomarija.diploma;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by velic on 09.01.2018.
 */

public class ConstantsForTesting {
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

    public static Map<Integer, Integer> getGeneralImage() {
        return generalImage;
    }

    private static final Map<Integer, Integer> generalImage;

    static {
        generalImage = new HashMap<>();
        generalImage.put(1, 10);
        generalImage.put(2, 18);
        generalImage.put(3, 7);
        generalImage.put(4, 19);
        generalImage.put(5, 3);
        generalImage.put(6, 1);
        generalImage.put(7, 16);
        generalImage.put(8, 12);
        generalImage.put(9, 8);
        generalImage.put(10, 14);
        generalImage.put(11, 20);
        generalImage.put(12, 5);
    }


    //набор констант для тестирования алгоритмов обработки слуховых показателей
    private String testSound1 = "Клей луч куб трон шуба велосипед звезда нитка песок белка пыль";
    private String testSound2 = "Пыль белка песок нитка звезда велосипед шуба трон куб луч клей";
    private String testSound3 = "Клей меч луч нитка песок белка пыль кот пыль белка";
    private String testSound4 = "";
    private String testSound5 = "Звезда белка пыль клей луч велосипед";
    private String[] equalsTestSound1 = new String[]{"1 Клей", "2 луч", "3 куб", "4 трон", "5 шуба",
            "6 велосипед", "7 звезда", "8 нитка", "9 песок", "10 белка", "11 пыль"};

    //набор констант для тестирования алгоритмов обработки показателей зоительной памяти
    private String testImageString1 = "10 18 7 19 3 1 16 12 8 14 20 5 ";
    private String testImageString2 = "5 6 8 12 1 21 9";
    private String testImageString3 = "";

    public static Map<Integer, String> getGeneralWordsMap() {
        return generalWordsMap;
    }

    public static Map<Integer, String> getGeneralAndNewWordsMap() {
        return generalAndNewWordsMap;
    }

    public String getTestSound1() {
        return testSound1;
    }

    public String getTestSound2() {
        return testSound2;
    }

    public String getTestSound3() {
        return testSound3;
    }

    public String getTestSound4() {
        return testSound4;
    }

    public String getTestSound5() {
        return testSound5;
    }

    public String[] getEqualsTestSound1() {
        return equalsTestSound1;
    }

    public String getTestImageString1() {
        return testImageString1;
    }

    public String getTestImageString2() {
        return testImageString2;
    }

    public String getTestImageString3() {
        return testImageString3;
    }
}
