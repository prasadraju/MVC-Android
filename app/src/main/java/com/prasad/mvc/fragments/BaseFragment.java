package com.prasad.mvc.fragments;

import android.support.v4.app.Fragment;

import com.prasad.mvc.BaseActivity;

/**
 * Created by prasad on 9/23/18.
 */

public class BaseFragment  extends Fragment {


    private BaseActivity mBaseActivity;

    BaseActivity getBaseActivityInstance(){
        return this.mBaseActivity = (BaseActivity)getActivity();
    }

}
