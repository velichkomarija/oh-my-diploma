package com.velickomarija.diploma;

import android.support.v4.app.Fragment;

/**
 * Интерфейс для обеспечения навигации между фрагментами.
 */
public interface INavigation {
    /**
     * Метод для смены фрагментов.
     * @param tag тег фрагмента.
     * @param fragment объект класса Fragment.
     */
    void replaceFragment(String tag, Fragment fragment);
}
