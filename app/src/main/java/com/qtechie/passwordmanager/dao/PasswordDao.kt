package com.qtechie.passwordmanager.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update

import com.qtechie.passwordmanager.model.PasswordModel

/**
 * Created by Admin on 04-03-2018.
 */

@Dao
interface PasswordDao {

    @get:Query("select * from PasswordModel where 1")
    val allPasswordModels: List<PasswordModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPassword(model: PasswordModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPassword(modelList: List<PasswordModel>)

    @Query("select * from PasswordModel where id= :id")
    fun getPasswordModel(id: Int): PasswordModel

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updatePasswordModel(model: PasswordModel): Int

    @Delete
    fun deletePassword(model: PasswordModel): Int

    @Query("Delete from PasswordModel where 1")
    fun deleteAllPasswordModels()
}
