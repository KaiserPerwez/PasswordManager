package com.kaiser.passwordmanager.dao

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.kaiser.passwordmanager.model.PasswordModel

@Dao
interface PasswordDao {

    @Insert(onConflict = REPLACE)
    fun insert(passwordModel: PasswordModel)

    @Update(onConflict = REPLACE)
    fun update(passwordModel: PasswordModel)

    @Delete
    fun delete(passwordModel: PasswordModel)

    @Query("DELETE FROM PasswordTable")
    fun deleteAll()

    @Query("SELECT * FROM PasswordTable")
    fun getAll(): List<PasswordModel>
}