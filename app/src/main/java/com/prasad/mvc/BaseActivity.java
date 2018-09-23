package com.prasad.mvc;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by prasad on 9/23/18.
 */

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


public class BaseActivity extends AppCompatActivity {

    private Toolbar mToolBar;

    private FragmentManager.OnBackStackChangedListener mOnBackStackChangedListener = new FragmentManager.OnBackStackChangedListener() {
        public void onBackStackChanged() {
            BaseActivity.this.setToolBarIcon();
        }
    };


    View.OnClickListener toolBarListener = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            if (BaseActivity.this.getBackStackCount() > 1) {
                BaseActivity.this.clearStack();
            }
        }
    };

    private Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.moviePosterFragId);
    }

    private FragmentTransaction navigate(Class<?> paramClass, Bundle paramBundle, FragmentTransaction paramFragmentTransaction) {

        Fragment localFragment = null;
        try {
            localFragment = (Fragment) paramClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        if ((paramBundle != null) && (localFragment != null)) {
            localFragment.setArguments(paramBundle);
        }
        paramFragmentTransaction.replace(R.id.moviePosterFragId, localFragment, paramClass.toString());
        return paramFragmentTransaction;
    }

    public void navigateToFragment(Class<?> paramClass, boolean paramBoolean, Bundle paramBundle) {
        if ((getCurrentFragment() == null) || (getCurrentFragment().getClass() != paramClass)) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            navigate(paramClass, paramBundle, fragmentTransaction);

            if (paramBoolean) {
                fragmentTransaction.addToBackStack(paramClass.toString());
            }
            fragmentTransaction.commitAllowingStateLoss();
        }
    }


    private void setToolBarIcon() {
        int i = getBackStackCount();
        //Log.logMessage("@@@backcount::" + i);
        if (i > 1) {
            Drawable localDrawable = ContextCompat.getDrawable(this, 2130837526);
            localDrawable.setColorFilter(ContextCompat.getColor(this, 2131427354), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(localDrawable);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            return;
        }
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    public void clearStack() {
        getSupportFragmentManager().popBackStack();
    }

    public int getBackStackCount() {
        return getSupportFragmentManager().getBackStackEntryCount();
    }

    public void hideToolBar() {
        this.mToolBar.setVisibility(View.GONE);
    }


    public void onBackPressed() {
        if (getBackStackCount() < 2) {
            finish();
            return;
        }
        super.onBackPressed();
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
    }

    protected void onDestroy() {
        getSupportFragmentManager().removeOnBackStackChangedListener(this.mOnBackStackChangedListener);
        super.onDestroy();
    }

    public void onPostCreate(Bundle paramBundle) {
        super.onPostCreate(paramBundle);
        this.mToolBar = ((Toolbar) findViewById(R.id.toolbar));
        if (this.mToolBar != null) {
            setSupportActionBar(this.mToolBar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayShowTitleEnabled(false);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setHomeButtonEnabled(true);
            }
        }
        getSupportFragmentManager().addOnBackStackChangedListener(this.mOnBackStackChangedListener);
        this.mToolBar.setNavigationOnClickListener(this.toolBarListener);
    }

    public void setToolBarTitle(String paramString) {
        if (this.mToolBar != null) {
            TextView localTextView = (TextView) this.mToolBar.findViewById(R.id.toolbar_title);
            localTextView.setTextSize(20.0F);
            localTextView.setText(paramString);
        }
    }

    public void showToolBar() {
        this.mToolBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();


    }
}

