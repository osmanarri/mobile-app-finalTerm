package com.example.osmantahir_comp304_004_finalterm;


import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;

public class StockRepository {
    //
    private MutableLiveData<Integer> insertResult =
            new MutableLiveData<>();
    private MutableLiveData<List<StockInfo>> searchResults =
            new MutableLiveData<>();
    private LiveData<List<StockInfo>> allStocks;
    private LiveData<List<StockInfo>> mStockBySymbol;
    private StockDAO stockDao;
    //
    public StockRepository(Application application) {
        StockDatabase db = StockDatabase.getDatabase(application);
        stockDao = db.stockDao();
        allStocks = stockDao.getAllStocks();
    }

    // returns query results as LiveData object
// to be called by our ViewModel
    public LiveData<List<StockInfo>> getAllStocks() {
        return allStocks;
    }
    //
// returns insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }
    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
// that you're not doing any long running operations on the main thread, blocking the UI.
    void insertStock(StockInfo stock) {
//a lambda expression used hear to male the call
        StockDatabase.databaseWriteExecutor.execute(() -> {
            try {
                stockDao.insertStock(stock);
//tell livedata for the changes
                insertResult.postValue(1); //correct
            } catch (Exception e) {
                insertResult.postValue(0); //error
            }
        });
    }

    //
    LiveData<List<StockInfo>> getStockBySymbol(String stockSymbol)
    {
//return the results from JOIN table
        mStockBySymbol = stockDao.getStockBySymbol(stockSymbol);
        return mStockBySymbol;

    }

}


