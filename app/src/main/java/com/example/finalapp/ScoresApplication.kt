package com.example.finalapp

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ScoresApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { ScoreRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { ScoreRepository(database.scoreDao()) }
}