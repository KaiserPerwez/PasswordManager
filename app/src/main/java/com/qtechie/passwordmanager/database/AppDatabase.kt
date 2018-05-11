package com.qtechie.passwordmanager.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

import com.qtechie.passwordmanager.dao.PasswordDao
import com.qtechie.passwordmanager.model.PasswordModel

/**
 * Created by Admin on 04-03-2018.
 */

@Database(entities = arrayOf(PasswordModel::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun passwordDao(): PasswordDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE
                    ?: Room.databaseBuilder<AppDatabase>(context, AppDatabase::class.java!!, "pwd_db")
                            //Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                            // To simplify the exercise, allow queries on the main thread.
                            // Don't do this on a real app!
                            .allowMainThreadQueries()
                            // recreate the database if necessary
                            .fallbackToDestructiveMigration()
                            .build()
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
