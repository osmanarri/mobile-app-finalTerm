package com.example.osmantahir_comp304_004_finalterm;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;

public class StockViewModel extends AndroidViewModel {
    private StockRepository repository;
    private LiveData<List<StockInfo>> allStocks;

    public StockViewModel(Application application) {
        super(application);
        repository = new StockRepository(application);
        allStocks = repository.getAllStocks();
    }

    LiveData<List<StockInfo>> getAllStocks() {
        return allStocks;
    }

    public void insertStock(StockInfo stock) {
        repository.insertStock(stock);
    }

    LiveData<List<StockInfo>> getStockBySymbol(String stockSymbol) {
        return repository.getStockBySymbol(stockSymbol);
    }

}