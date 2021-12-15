package com.example.osmantahir_comp304_004_finalterm;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {StockInfo.class}, version = 1)
public abstract class StockDatabase extends RoomDatabase {
    //
    private static volatile StockDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    // use this to run database operations
// asynchronously on a background thread.
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static final String DATABASE_NAME = "StockDB";
    //declare an abstract method to allow repository to access
// interface methods
    public abstract StockDAO stockDao();
    //a static method to allow creation of one database instance
//create and initialize the database instance
    static StockDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
//synchronised block
            synchronized (StockDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            StockDatabase.class, DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}//


