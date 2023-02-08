package com.example.criminalintent2

import java.util.*

data class Crime(
    val id: UUID = UUID.randomUUID(), // вспомогательный класс, генерирует универсальные и
//    уникальные идентификаторы (генерируется через вызов UUID.randomUUID())
    var title: String = "",
    val date: Date = Date(),
    val isSolved: Boolean = false,
) {

}