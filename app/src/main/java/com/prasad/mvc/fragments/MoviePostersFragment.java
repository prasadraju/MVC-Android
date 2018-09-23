package com.prasad.mvc.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.prasad.mvc.MainActivity;
import com.prasad.mvc.R;
import com.prasad.mvc.adapters.MoviesDataAdapter;
import com.prasad.mvc.helpers.ConnectionDetector;
import com.prasad.mvc.helpers.Storage;
import com.prasad.mvc.helpers.Utils;
import com.prasad.mvc.pojo.MoviesPostersData;
import com.prasad.mvc.servicemanger.Constants;
import com.prasad.mvc.servicemanger.RequestController;
import com.prasad.mvc.servicemanger.RequestResponse;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MoviePostersFragment extends BaseFragment implements AdapterView.OnItemClickListener {


    @Bind(R.id.movies_grid)
    GridView gridView;
    private Communicator communicator;
    Activity mActivity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movieposters, container, false);

        ButterKnife.bind(this, view);

        setHasOptionsMenu(true);

        gridView.setOnItemClickListener(this);

        if (ConnectionDetector.isConnected(getActivity())) {
            moviePostersPopular();
        } else {
            Utils.showToastMsg(getActivity(), Constants.NO_INTERNET);
        }
        return view;
    }

    private void moviePostersPopular() {
        Utils.showProgress(getActivity());
        RequestController helper = new RequestController(getActivity());
        helper.moviePostersPopular(new RequestResponse() {
            @Override
            public void onResponse(Object response) {
                Utils.hideProgress();
                List<MoviesPostersData.Inner> moviePosterList = ((MoviesPostersData) response).getResults();
                MoviesDataAdapter adapter = new MoviesDataAdapter(getActivity(), moviePosterList);
                gridView.setAdapter(adapter);

            }

            @Override
            public void onFailure(String failure) {
                Utils.hideProgress();
                Utils.showToastMsg(getActivity(), Constants.ERROR);
            }
        });
    }


    private void moviePostersToprated() {

        RequestController helper = new RequestController(getActivity());
        helper.moviePostersToprated(new RequestResponse() {
            @Override
            public void onResponse(Object response) {

                List<MoviesPostersData.Inner> moviePosterList = ((MoviesPostersData) response).getResults();
                MoviesDataAdapter adapter = new MoviesDataAdapter(getActivity(), moviePosterList);
                gridView.setAdapter(adapter);
            }

            @Override
            public void onFailure(String failure) {
                Utils.showToastMsg(getActivity(), Constants.ERROR);
            }
        });

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.toprated) {

            ((MainActivity) getActivity()).getSupportActionBar().setTitle("TopRated Movies");

            if (ConnectionDetector.isConnected(getActivity())) {
                moviePostersToprated();
            } else {
                Utils.showToastMsg(getActivity(), Constants.NO_INTERNET);
            }

        } else if (id == R.id.popularity) {

            ((MainActivity) getActivity()).getSupportActionBar().setTitle("Pop Movies");
            if (ConnectionDetector.isConnected(getActivity())) {
                moviePostersPopular();
            } else {
                Utils.showToastMsg(getActivity(), Constants.NO_INTERNET);
            }

        } else if (id == R.id.favourite) {

            ((MainActivity) getActivity()).getSupportActionBar().setTitle("Favourite");
            Storage storage = new Storage(getActivity());
            MoviesDataAdapter adapter = new MoviesDataAdapter(getActivity(), storage.getFavMoviesData());
            gridView.setAdapter(adapter);
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        MoviesPostersData.Inner data = (MoviesPostersData.Inner) parent.getItemAtPosition(position);
        updateDetailFragment(data);
    }

    private void updateDetailFragment(MoviesPostersData.Inner data) {

//        communicator.Message(data);
        Bundle bundle = new Bundle();
        bundle.putSerializable("moviesData", data);
        getBaseActivityInstance().navigateToFragment(MovieDetailsFragment.class, true, bundle);
    }

    //Create Interface
    public interface Communicator {
        public void Message(MoviesPostersData.Inner data);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity) {
            mActivity = (Activity) context;
        }

        if (mActivity instanceof Communicator) {
            communicator = (Communicator) mActivity;

        } else {
            throw new ClassCastException(mActivity.toString()
                    + " must implemenet MoviePostersFragment.Communicator");
        }
    }


}
