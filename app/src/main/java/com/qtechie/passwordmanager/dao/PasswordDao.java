package com.qtechie.passwordmanager.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.qtechie.passwordmanager.model.PasswordModel;

import java.util.List;

/**
 * Created by Admin on 04-03-2018.
 */

@Dao
public interface PasswordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addPassword(PasswordModel model);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addPassword(List<PasswordModel> modelList);

    @Query("select * from PasswordModel where 1")
    List<PasswordModel> getAllPasswordModels();

    @Query("select * from PasswordModel where id= :id")
    PasswordModel getPasswordModel(int id);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int updatePasswordModel(PasswordModel model);

    @Delete
    int deletePassword(PasswordModel model);

    @Query("Delete from PasswordModel where 1")
    void deleteAllPasswordModels();
}
