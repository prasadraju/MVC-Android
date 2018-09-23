package com.prasad.mvc;


import android.os.Bundle;
import android.widget.FrameLayout;

import com.prasad.mvc.fragments.MovieDetailsFragment;
import com.prasad.mvc.fragments.MoviePostersFragment;
import com.prasad.mvc.pojo.MoviesPostersData;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Welcome on 5/1/2016.
 */
public class MainActivity extends BaseActivity implements MoviePostersFragment.Communicator {


    @Bind(R.id.moviePosterFragId)
    FrameLayout moviePosterFragId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    public void onPostCreate(Bundle paramBundle) {
        super.onPostCreate(paramBundle);
        navigateToFragment(MoviePostersFragment.class, true, null);
    }


    @Override
    public void Message(MoviesPostersData.Inner data) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("moviesData", data);
        navigateToFragment(MovieDetailsFragment.class, true, bundle);


    }

}
