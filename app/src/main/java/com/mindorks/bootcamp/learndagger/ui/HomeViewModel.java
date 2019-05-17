package com.mindorks.bootcamp.learndagger.ui;

import android.util.Log;

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.di.scope.FragmentScope;
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

@FragmentScope
public class HomeViewModel {

    private DatabaseService databaseService;
    private NetworkService networkService;
    private NetworkHelper networkHelper;

    @Inject
    public HomeViewModel(DatabaseService databaseService,
                         NetworkService networkService,
                         NetworkHelper networkHelper){

        this.databaseService =databaseService;
        this.networkService = networkService;
        this.networkHelper = networkHelper;

        Log.d("DEBUG", networkService.toString());
    }

    public DatabaseService getDatabaseService() {
        return databaseService;
    }

    public NetworkService getNetworkService() {
        return networkService;
    }

    public NetworkHelper getNetworkHelper() {
        return networkHelper;
    }

    public String getSomeData() {
        return databaseService.getDummyData()
                + " : " + networkService.getDummyData()
                + " : " + networkHelper.isNetworkConnected();
    }
}
