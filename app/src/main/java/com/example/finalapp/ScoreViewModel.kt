package com.example.finalapp

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ScoreViewModel(private val repository: ScoreRepository) : ViewModel() {
    val allScores: LiveData<List<Score>> = repository.allScores.asLiveData()

    fun insert(score: Score) = viewModelScope.launch {
        repository.insert(score)
    }

    fun delete() = viewModelScope.launch{
        repository.delete()
    }
}

class ScoreViewModelFactory(private val repository: ScoreRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ScoreViewModel::class.java)){
            return ScoreViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}