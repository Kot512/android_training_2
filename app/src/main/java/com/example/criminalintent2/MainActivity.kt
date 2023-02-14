package com.example.criminalintent2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment =                                       // при уничтожении
            supportFragmentManager.findFragmentById(R.id.fragment_container) // активити (при выс-
                                                // вобождении памяти или повороте экрана) список
        if (currentFragment == null) {          // фрагментов сохраняется (и после уничтожения
            val fragment = CrimeFragment()      // восстанавливает фрагменты из списка
            supportFragmentManager                      // весь этот код - транзакция фрагмента
                .beginTransaction()                     // (т.е. добавление, удаление, присоединение,
                .add(R.id.fragment_container, fragment) // отсоединение и замена фрагментов в списке
                .commit()                               // фрагментов)
        }
    }
}