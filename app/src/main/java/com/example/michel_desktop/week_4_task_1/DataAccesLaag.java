package com.example.michel_desktop.week_4_task_1;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DataAccesLaag {

    @Query("SELECT * FROM storgelocatie")
    public List<StorgeSaveModel> getAllStorgeModel();

    @Insert
    public void insertReminders(StorgeSaveModel sm);

    @Delete
    public void deleteReminders(StorgeSaveModel sm);

    @Update
    public void updateReminders(StorgeSaveModel sm);
}
