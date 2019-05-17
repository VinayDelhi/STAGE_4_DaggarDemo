package com.mindorks.bootcamp.learndagger.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.mindorks.bootcamp.learndagger.MyApplication;
import com.mindorks.bootcamp.learndagger.R;
import com.mindorks.bootcamp.learndagger.di.component.DaggerActivityComponent;
import com.mindorks.bootcamp.learndagger.di.module.ActivityModule;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDependencies();
        setContentView(R.layout.activity_main);

        addHomeFragment();

    }

    public void getDependencies() {
        DaggerActivityComponent
                .builder()
                .applicationComponent(((MyApplication) getApplication()).applicationComponent)
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);

    }

    private void addHomeFragment() {
        if(getSupportFragmentManager().findFragmentByTag(HomeFragment.TAG) == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_fragment, HomeFragment.newInstance(), HomeFragment.TAG)
                    .commit();
        }
    }
}
