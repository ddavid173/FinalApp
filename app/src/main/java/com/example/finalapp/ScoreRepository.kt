package com.example.finalapp

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class ScoreRepository(private val scoreDao: ScoreDao) {
    val allScores: Flow<List<Score>> = scoreDao.getScores()

    @WorkerThread
    suspend fun insert(score: Score){
        scoreDao.insert(score)
    }

    @WorkerThread
    suspend fun delete(){
        scoreDao.deleteAll()
    }
}