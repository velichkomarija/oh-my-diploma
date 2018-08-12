package com.velickomarija.diploma.models;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс, описывающий алгоритмы обработки данных, полученных от пользователя.
 */
public class Algorithms {

    private PreferencesLocal preferencesLocal = new PreferencesLocal();

    private static final String resQuestion1 = "Вы склонны составлять планы и" +
            " действовать в соответствии с ними.";

    private static final String resQuestion2 = "Вы стремитесь разобраться в воспринимаемом." +
            " Интерпретируете свой опыт в зависимости от текущей ситуации. " +
            "Нечасто реализуете сложные и детальные планы";

    private static final String resQuestion3 = "Вы практикуете творческий и оригинальный подход" +
            " без большого внимания к последствиям деятельности. У вас нет склонности " +
            "корректировать поведение.";

    private static final String resQuestion4 = "У Вас нет склонности инициировать планы и " +
            "интерпретировать опыт. Вы ориентируетесь на повседневные дела и реагируете на текущие ситуации.";

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
        newFigure.put(11, 24);
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

    private static final Map<String, String> keyQuestions1;

    static {
        keyQuestions1 = new HashMap<>();
        keyQuestions1.put("H4B4", "Стабильный режим деятельности.");
        keyQuestions1.put("H4B3", "Режим деятельности/восприятия.");
        keyQuestions1.put("H4B2", "Режим восприятия/деятельности.");
        keyQuestions1.put("H4B1", "Стабильный режим восприятия.");

        keyQuestions1.put("H3B4", "Режим деятельности/стимулирования.");
        keyQuestions1.put("H3B3", "Режим деятельности, зависящий от контекста.");
        keyQuestions1.put("H3B2", "Режим восприятия, зависящий от контекста.");
        keyQuestions1.put("H3B1", "Режим восприятия/приспособления.");

        keyQuestions1.put("H2B4", "Режим стимулирования/деятельности.");
        keyQuestions1.put("H2B3", "Режим стимулирования, зависящий от контекста.");
        keyQuestions1.put("H2B2", "Режим приспособления, зависящий от контекста.");
        keyQuestions1.put("H2B1", "Режим восприятия, зависящий от контекста.");

        keyQuestions1.put("H1B4", "Стабильный режим стимулирования.");
        keyQuestions1.put("H1B3", "Режим стимулирования/приспособления.");
        keyQuestions1.put("H1B2", "Режим приспособления/ стимулирования.");
        keyQuestions1.put("H1B1", "Стабильный режим приспособления.");
    }

    /**
     * Метод, отвечающий за переинициализацию списка с ключевыми словами.
     */
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

    /**
     * Метод, отвечающий за переинициализацию ключевых слов.
     */
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

    /**
     * Метод, отвечающий за переинициализацию ключевых промежутков узнавания.
     */
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


    private void reloadMapNewFigure() {
        newFigure.clear();
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
        newFigure.put(11, 24);
    }

    /**
     * Метод, преобразовывающий строку в асоциативный список значений.
     *
     * @param text строка значений, полученных от пользователя.
     * @return Ассоциативный список значений.
     */
    private Map<Integer, String> textToMap(String text) {
        Map<Integer, String> map = new HashMap<>();
        String newText = text.replace(",", " ");
        String[] strArray = newText.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            map.put(i + 1, strArray[i]);
        }
        return map;
    }

    /**
     * Метод для подсчета первичных результатов первого опросника.
     *
     * @param B параметр верхнего головного мозга.
     * @param H параметр нижнего головного мозга.
     * @return Строка с первичными результатами опроса 1.
     */
    private String createTestResult(int B, int H) {
        String BN = null;
        String HN = null;

        if (B < 27) {
            BN = "B1";
        } else if (B >= 27 && B < 37) {
            BN = "B2";
        } else if (B >= 37 && B < 47) {
            BN = "B3";
        } else if (B >= 47) {
            BN = "B4";
        }

        if (H < 27) {
            HN = "H1";
        } else if (H >= 27 && H < 37) {
            HN = "H2";
        } else if (H >= 37 && H < 47) {
            HN = "H3";
        } else if (H >= 47) {
            HN = "H4";
        }

        return HN.concat(BN);
    }

    /**
     * Метод для подсчета конечного результата первого опросника.
     *
     * @param str строка первичных результатов.
     * @return Строка с конечным результатом для отображения пользователю.
     */
    private String getFullResult(String str) {
        String result = "";

        if (str.contains("деятельности")) {
            result = result.concat(resQuestion1);
        }
        if (str.contains("восприятия")) {
            result = result.concat(resQuestion2);
        }
        if (str.contains("стимулирования")) {
            result = result.concat(resQuestion3);
        }
        if (str.contains("приспособления")) {
            result = result.concat(resQuestion4);
        }
        return str.
                concat("\n").
                concat(result);
    }

    /**
     * Метод, обнуляющий результаты, если они отрицательные.
     *
     * @param digit результат пробы.
     * @return Результат пробы, если не отрицательное число, 0 - если число было отрицательным.
     */
    private int zeroAdapter(int digit) {
        if (digit < 0) {
            return 0;
        } else {
            return digit;
        }
    }

    /**
     * Метод, подсчитывающий первичные результаты слуховых проб.
     *
     * @param text    строка, введенная пользователем.
     * @param context контекст выполнения пррограммы.
     * @return Число верно воспроизведенных слов.
     */
    public int algorithmSoundMemoryC1(String text, Context context) {
        Map<Integer, String> map;
        int sum = 0;
        int mistakes;
        boolean flag = false;
        map = textToMap(text);

        try {
            mistakes = Integer.valueOf(preferencesLocal.getProperty("PREF_C6"));
        } catch (Exception e) {
            mistakes = 0;
            e.printStackTrace();
        }

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
                if (!item.getValue().equals("")) {
                    mistakes++;
                }
                item.setValue("0");
            }
            flag = false;
        }
        //обновляем карту
        reloadMapWords();
        for (Map.Entry<Integer, String> newWord : map.entrySet()) {
            if (Integer.parseInt(newWord.getValue()) != 0) {
                sum++;
            }
        }
        preferencesLocal.addProperty("PREF_C6", String.valueOf(mistakes), context);
        return sum;
    }

    /**
     * Подсчет результатов первых трёх зрительных проб.
     *
     * @param map     данные, введенные от пользователя.
     * @param context контекст выполнения приложения.
     * @return Число верно воспроизведенных изображений.
     */
    public int algorithmImageMemoryZ1(Map<Integer, Boolean> map, Context context) {
        int sum = 0;
        boolean flag = false;
        int mistakes;

        try {
            mistakes = Integer.valueOf(preferencesLocal.getProperty("PREF_Z6"));
        } catch (Exception e) {
            mistakes = 0;
            e.printStackTrace();
        }

        for (Map.Entry<Integer, Boolean> item : map.entrySet()) {
            for (Map.Entry<Integer, Integer> digit : generalImage.entrySet()) {
                flag = false;
                if ((item.getValue() == true) && item.getKey().equals(digit.getValue())) {
                    sum++;
                    flag = true;
                    break;
                }
            }
            if ((flag == false) && (item.getValue() == true)) {
                mistakes++;
            }
        }
        preferencesLocal.addProperty("PREF_Z6", String.valueOf(mistakes), context);
        reloadMapDigit();
        return sum;
    }

    /**
     * Подсчет параметров C2 и Z2.
     *
     * @param p1 результаты первой пробы.
     * @param p2 результаты второй пробы.
     * @param p3 результаты третьей пробы.
     * @return Строка со значением параметра C2 или Z.
     */
    public String algorithmSoundMemoryC2(String p1, String p2, String p3) {
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

    /**
     * Метод для подсчета верно узнаных старых слов из новых.
     *
     * @param text данные, введеные пользователем.
     * @return Строка с результатами узнавания.
     */
    public String algorithmFindOldWordsInNew(String text, Context context) {
        int res = 0;
        int error = 0;
        String resString;
        int[] resArray = new int[11];
        try {
            String[] strArray = text.split(" ");
            for (int i = 0; i < strArray.length; i++) {
                res = Integer.parseInt(strArray[i]);
                if ((0 <= res) && (res <= 400)) {
                    resArray[0] = 1;
                } else if ((400 < res) && (res <= 650)) {
                    resArray[1] = 1;
                } else if ((950 <= res) && (res <= 1200)) {
                    resArray[2] = 1;
                } else if ((1500 <= res) && (res <= 1750)) {
                    resArray[3] = 1;
                } else if ((2050 <= res) && (res <= 2300)) {
                    resArray[4] = 1;
                } else if ((2800 <= res) && (res <= 3050)) {
                    resArray[5] = 1;
                } else if ((3600 <= res) && (res <= 3900)) {
                    resArray[6] = 1;
                } else if ((4200 <= res) && (res <= 4750)) {
                    resArray[7] = 1;
                } else if ((5000 <= res) && (res <= 5300)) {
                    resArray[8] = 1;
                } else if ((5300 < res) && (res <= 5600)) {
                    resArray[9] = 1;
                } else if ((6100 <= res) && (res <= 6400)) {
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

            int mistakes = Integer.valueOf(preferencesLocal.getProperty("PREF_C6"));
            mistakes = mistakes + error;
            preferencesLocal.addProperty("PREF_C6", String.valueOf(mistakes), context);

            if (res > 10) {
                res = 10;
            }
            resString = String.valueOf(res);
        } catch (Exception e) {
            resString = "0";
        }
        return resString;
    }

    /**
     * Подсчет слов, которые непроизвольно запомнены пользователем.
     *
     * @param text данные, введеные пользователем.
     * @return Строка с результатами узнаваниями.
     */
    public String algorithmSoundNewWords(String text) {
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

    /**
     * Метод, подсчитывающий результат узнавания новых фигур из старых.
     *
     * @param map данные о узнавании, полученные от пользователя.
     * @return Строка результата узнавания.
     */
    public String algotithmImageNew(Map<Integer, Boolean> map, Context context) {
        int sum = 0;
        boolean flag = false;
        int mistakes;

        try {
            mistakes = Integer.valueOf(preferencesLocal.getProperty("PREF_Z6"));
        } catch (Exception e) {
            mistakes = 0;
            e.printStackTrace();
        }

        for (Map.Entry<Integer, Boolean> item : map.entrySet()) {
            for (Map.Entry<Integer, Integer> digit : newFigure.entrySet()) {
                flag = false;
                if ((item.getValue() == true) && item.getKey().equals(digit.getValue())) {
                    sum++;
                    flag = true;
                    break;
                }
            }
            if ((flag == false) && (item.getValue() == true)) {
                mistakes++;
            }
        }
        preferencesLocal.addProperty("PREF_Z6", String.valueOf(mistakes), context);
        reloadMapNewFigure();
        return String.valueOf(sum);
    }

    /**
     * Метод, подсчитывающий ошибки воспроизведения. Параметры C6/Z6.
     *
     * @param str первичный результат C6/Z6.
     * @return Скорректированное значение результата.
     */
    public String getCorrectionC6(String str, String pref, Context context) {
        preferencesLocal.addProperty(pref, str, context);
        int res = 10 - Integer.parseInt(str);
        if (res < 0) {
            return "0";
        }
        return String.valueOf(res);
    }

    /**
     * Метод для обработки результатов первого опросника.
     *
     * @param array массив ответов пользователя.
     * @return Строка с результатами для предъявления пользователю.
     */
    public String algorithmQuestionOne(int[] array) {
        int B = 0;
        int H = 0;

        for (int i = 0; i < array.length; i++) {
            if ((i == 1) ||
                    (i == 2) ||
                    (i == 5) ||
                    (i == 6) ||
                    (i == 7) ||
                    (i == 11) ||
                    (i == 13) ||
                    (i == 14) ||
                    (i == 17) ||
                    (i == 18)) {
                B = B + array[i];
            } else {
                H = H + array[i];
            }
        }

        String res = createTestResult(B, H);

        for (Map.Entry<String, String> entry : keyQuestions1.entrySet()) {
            if (entry.getKey().equals(res)) {
                res = entry.getValue();
            }
        }

        return getFullResult(res);
    }

    /**
     * Метод, определяющий тип памяти по результатам второго опросника.
     *
     * @param array массив ответов пользователя.
     * @return Строка с результатом для предъявления пользователю.
     */
    private String getFullResult(int[] array) {
        StringBuffer result = new StringBuffer();
        result.append("Предметно-действенное мышление. ")
                .append(getLevel(array[0]))
                .append("\n")
                .append("Абстрактно-символическое мышление. ")
                .append(getLevel(array[1]))
                .append("\n")
                .append("Словесно-логическое мышление. ")
                .append(getLevel(array[2]))
                .append("\n")
                .append("Наглядно-образное мышление. ")
                .append(getLevel(array[3]))
                .append("\n")
                .append("Креативность (творческое мышление). ")
                .append(getLevel(array[4]))
                .append("\n");

        return result.toString();
    }

    /**
     * Метод для вычисления уровня развития определенного типа мышления для опросника 2.
     *
     * @param number количество ответов по данномй типу мышления.
     * @return Строка с уровнем развития типа мышления.
     */
    private String getLevel(int number) {
        if (0 <= number && number <= 2) {
            return "Уровень - низкий.";
        }
        if (3 <= number && number <= 5) {
            return "Уровень - средний.";
        } else {
            return "Уровень - высокий.";
        }
    }

    /**
     * Метод, подсчитывающий результаты второго опросника.
     *
     * @param array массив ответов пользователя.
     * @return Строка с результатами второго опросника.
     */
    public String algorithmQuestionTwo(int[] array) {
        int[] mind = new int[5];


        for (int i = 0; i < array.length; i++) {
            if ((i == 0) ||
                    (i == 5) ||
                    (i == 10) ||
                    (i == 15) ||
                    (i == 20) ||
                    (i == 25) ||
                    (i == 30) ||
                    (i == 35)) {
                mind[0] = mind[0] + array[i];
            }
            if ((i == 1) ||
                    (i == 6) ||
                    (i == 11) ||
                    (i == 16) ||
                    (i == 21) ||
                    (i == 26) ||
                    (i == 31) ||
                    (i == 36)) {
                mind[1] = mind[1] + array[i];
            }
            if ((i == 2) ||
                    (i == 7) ||
                    (i == 12) ||
                    (i == 17) ||
                    (i == 22) ||
                    (i == 27) ||
                    (i == 32) ||
                    (i == 37)) {
                mind[2] = mind[2] + array[i];
            }
            if ((i == 3) ||
                    (i == 8) ||
                    (i == 13) ||
                    (i == 18) ||
                    (i == 23) ||
                    (i == 28) ||
                    (i == 33) ||
                    (i == 38)) {
                mind[3] = mind[3] + array[i];
            } else {
                mind[4] = mind[4] + array[i];
            }
        }

        return getFullResult(getFullResult(mind));
    }

}
