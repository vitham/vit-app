package com.vit.vitapp.ui.base;

import android.arch.lifecycle.ViewModelProvider;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.vit.presentation.features.VitViewModelFactory;
import com.vit.vitapp.R;
import com.vit.vitapp.utils.Constants;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {
    protected static final String TAG = BaseActivity.class.getSimpleName();

    @Inject
    public ViewModelProvider.Factory mViewModelFactory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(getLayoutId());
        initView();
        ButterKnife.bind(this);

        Constants.handlingErrorRxJava();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }



    protected abstract void initView();

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void showToast(@StringRes int message) {
        showToast(getString(message));
    }

    public void showSnackbar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
    }
}
