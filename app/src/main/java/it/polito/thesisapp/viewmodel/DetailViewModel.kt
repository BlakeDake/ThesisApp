package it.polito.thesisapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {
    var counter by mutableIntStateOf(0)
        private set

    fun incrementCounter() {
        counter++
    }
}