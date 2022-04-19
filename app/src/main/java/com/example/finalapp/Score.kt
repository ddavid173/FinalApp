package com.example.finalapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "score_table")
data class Score (@PrimaryKey @ColumnInfo(name="score") val score: String)