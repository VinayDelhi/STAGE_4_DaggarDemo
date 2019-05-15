package com.mindorks.bootcamp.learndagger.di.module;

import android.content.Context;

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.ui.HomeViewModel;
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    private Context context;

    public FragmentModule(Context context) {
        this.context = context;
    }

    @Provides
    HomeViewModel provideHomeViewModel(
            DatabaseService databaseService,
            NetworkService networkService,
            NetworkHelper networkHelper){
        return new HomeViewModel(databaseService, networkService, networkHelper);
    }
}
