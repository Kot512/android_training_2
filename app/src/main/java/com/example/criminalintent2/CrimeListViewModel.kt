package com.example.criminalintent2

import androidx.lifecycle.ViewModel

class CrimeListViewModel: ViewModel() {

    val crimes = mutableListOf<Crime>()
    init {
        for (i in 0 until 100) {
            val crime = Crime()
            crime.title = "Crime №$i"
            crime.isSolved = i % 2 == 0
            crime.requiresPolice = i <= 37
            crimes += crime
        }

        crimes.sortBy { it.requiresPolice }
    }

    val withPoliceCall = crimes.count { it.requiresPolice }
}