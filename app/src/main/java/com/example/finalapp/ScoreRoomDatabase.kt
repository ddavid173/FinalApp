package com.example.finalapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.security.AccessControlContext

@Database(entities = [Score::class], version = 1, exportSchema = false)
public abstract class ScoreRoomDatabase : RoomDatabase(){

    abstract fun scoreDao(): ScoreDao

    private class ScoreDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase){
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.scoreDao())
                }
            }
        }
        suspend fun populateDatabase(scoreDao: ScoreDao){
            scoreDao.deleteAll()
            var score = Score("0")
            scoreDao.insert(score)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ScoreRoomDatabase? = null

        fun getDatabase(context: Context,
                        scope: CoroutineScope
                        ): ScoreRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = androidx.room.Room.databaseBuilder(
                    context.applicationContext,
                    ScoreRoomDatabase::class.java,
                    "score_database"
                ).addCallback(ScoreDatabaseCallback(scope)).build()
                INSTANCE = instance

                instance
            }
        }
    }
}