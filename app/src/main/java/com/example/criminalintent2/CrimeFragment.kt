package com.example.criminalintent2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment

// функции жизненного цикла класса Fragment - открытые (в отличие от Activity), поскольку
// мх будут вызывать другие активити

// настройка представления фрагмента (layout) происходит не в onCreate(), а в onCreateView()

class CrimeFragment: Fragment() {

    private lateinit var crime: Crime
    private lateinit var titleField: EditText
    private lateinit var dateButton: Button
    private lateinit var solvedCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        crime = Crime()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime, container, false)

        titleField = view.findViewById(R.id.crime_title)
        dateButton = view.findViewById(R.id.crime_date)

        dateButton.apply {
            text = crime.date.toString()
            isEnabled = false
        }

        return view
    }

    override fun onStart() {  // когда пользователь видит фрагмент (после восстановления состояния виджетов)
        super.onStart()

        val titleWatcher = object: TextWatcher {

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {

            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                crime.title = s.toString()   // помещаем введенную пользователем строку в заголовок Crime
            }

            override fun afterTextChanged(s: Editable?) {

            }
        }
        titleField.addTextChangedListener(titleWatcher) // назначаем слушатель на EditText
//        Этот слушатель, в отличие от onClickListener, срабатывает не только при взаимодействии
//        с пользователем, но и при восстановлении состояния виджета (т.е. когда виджет пересобирается,
//        например, при повороте экрана). Поэтому мы устанавливаем его в onStart (после восстановления
//        состояния виджета, происходящего после onCreateView и перед onStart): поскольку нам важно то,
//        что было введено пользоваталем в поле EditText, мы пересоздаем виджет после восстановления
//        состояния, вследствие чего в поле останется то, что было в данный момент находилось в
//        crime.title???




    }
}