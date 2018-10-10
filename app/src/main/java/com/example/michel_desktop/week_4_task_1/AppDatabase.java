package com.example.michel_desktop.week_4_task_1;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


@Database(entities = {StorgeSaveModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    //data acces laag
    public abstract DataAccesLaag storgeModelDOA();

    //database naam
    private final static String NAME_DATABASE = "weekvierdbsec";

    //Static instance
    private static AppDatabase sInstance;

    //maak de appDatabase get instance naam
    public static AppDatabase getInstance(Context context) {
        if(sInstance == null) {
            sInstance = Room.databaseBuilder(context, AppDatabase.class,   NAME_DATABASE).allowMainThreadQueries().build();
        }

        return sInstance;
    }
}