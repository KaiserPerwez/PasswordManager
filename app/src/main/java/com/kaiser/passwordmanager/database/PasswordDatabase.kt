package com.kaiser.passwordmanager.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.kaiser.passwordmanager.dao.PasswordDao
import com.kaiser.passwordmanager.model.PasswordModel
import com.kaiser.passwordmanager.utils.ConstUtils.DATABASE_NAME

@Database(entities = arrayOf(PasswordModel::class), version = 1)
abstract class PasswordDatabase : RoomDatabase() {
    abstract fun passwordDao(): PasswordDao

    companion object {
        private var INSTANCE: PasswordDatabase? = null
        //@get syncronised
        //TODO:Modify this syncronisation as in giftpool
        fun getInstance(context: Context): PasswordDatabase? {
            if (INSTANCE == null) {
                synchronized(PasswordDatabase) {
                    INSTANCE = Room.databaseBuilder(context,
                            PasswordDatabase::class.java,
                            DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            //   .allowMainThreadQueries()
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}