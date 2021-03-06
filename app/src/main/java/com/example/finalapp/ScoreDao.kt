package com.example.finalapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ScoreDao {
//    @Query("SELECT * FROM score_table ORDER BY score DESC")
    @Query("select * from score_table order by (score + 0) DESC")
    fun getScores(): Flow<List<Score>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(score: Score)

    @Query("DELETE FROM score_table")
    suspend fun deleteAll()
}