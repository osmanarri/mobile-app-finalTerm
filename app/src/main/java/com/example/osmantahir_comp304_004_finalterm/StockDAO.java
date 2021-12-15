package com.example.osmantahir_comp304_004_finalterm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StockDAO {
    @Insert
    void insertStock(StockInfo stock);
    //
    @Query("SELECT * FROM StockInfo WHERE stockSymbol = :stockSymbol")
    LiveData<List<StockInfo>> getStockBySymbol(String stockSymbol);
    //
    @Query("SELECT * FROM StockInfo")
    LiveData<List<StockInfo>> getAllStocks();

}