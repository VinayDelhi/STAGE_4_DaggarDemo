package com.mindorks.bootcamp.learndagger.di.module;

import android.content.Context;

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.di.qualifier.ActivityContext;
import com.mindorks.bootcamp.learndagger.ui.HomeViewModel;
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper;

import androidx.fragment.app.Fragment;
import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @ActivityContext
    @Provides
    Context provideContext() {
        return fragment.getContext();
    }

   /* @Provides
    HomeViewModel provideHomeViewModel(
            DatabaseService databaseService,
            NetworkService networkService,
            NetworkHelper networkHelper){
        return new HomeViewModel(databaseService, networkService, networkHelper);
    }*/
}
