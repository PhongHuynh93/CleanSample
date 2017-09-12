package com.example.cpu11112_local.cleansample.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cpu11112_local.cleansample.App;
import com.example.cpu11112_local.cleansample.injection.component.FragmentComponent;
import com.example.cpu11112_local.cleansample.injection.module.FragmentModule;

import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by USER on 5/3/2017.
 */

public abstract class BaseFragment extends Fragment {
    protected final CompositeDisposable mSubscriptions = new CompositeDisposable();
    private FragmentComponent mFragmentComponent;

    public FragmentComponent fragmentComponent() {
        if (mFragmentComponent == null) {
//            mFragmentComponent = DaggerFragmentComponent.builder()
//                    .fragmentModule(new FragmentModule(this))
//                    .movieComponent(App.get(getActivity()).getComponent())
//                    .build();

            mFragmentComponent = App.get(getActivity()).getComponent().newSubFragmentComponent(new FragmentModule(this));
        }
        return mFragmentComponent;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getResourceLayout(), container, false);
        ButterKnife.bind(this, view);
        initViews(view);
        return view;
    }

    public abstract int getResourceLayout();

    public abstract void initViews(View view);
}
