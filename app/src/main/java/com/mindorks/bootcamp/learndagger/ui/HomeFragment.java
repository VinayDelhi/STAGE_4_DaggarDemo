package com.mindorks.bootcamp.learndagger.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mindorks.bootcamp.learndagger.R;
import com.mindorks.bootcamp.learndagger.MyApplication;
import com.mindorks.bootcamp.learndagger.di.component.DaggerFragmentComponent;
import com.mindorks.bootcamp.learndagger.di.module.FragmentModule;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    @Inject
    HomeViewModel homeViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getDependencies();
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, null);
    }

    public void getDependencies(){
        DaggerFragmentComponent
                .builder()
                .applicationComponent(((MyApplication)(getActivity()).getApplication()).applicationComponent)
                .fragmentModule(new FragmentModule(getActivity().getApplicationContext()))
                .build()
                .inject(this);

        Log.d("DEBUG", homeViewModel.toString());
    }
}
