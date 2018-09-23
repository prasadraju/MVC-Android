package com.prasad.mvc.servicemanger;

import android.content.Context;
import com.google.gson.Gson;
import com.prasad.mvc.pojo.MoviesPostersData;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by prasad on 9/22/18.
 */

public class RequestController implements Callback<ResponseBody>{

    Context mContext;
    RequestResponse mRequestResponse;
    Class cls;

    public RequestController(Context paramContext)
    {
        this.mContext = paramContext;
    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        if (response.isSuccessful()) {
            try {
                Object object=new Gson().fromJson( response.body().string(), cls);
                mRequestResponse.onResponse(object);
            } catch (IOException e) {
                mRequestResponse.onFailure(e.toString());
            }
        } else {
            mRequestResponse.onFailure(response.errorBody().toString());
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        mRequestResponse.onFailure(t.getMessage());
    }

    public void moviePostersPopular(RequestResponse requestResponse) {
        this.cls=MoviesPostersData.class;
        this.mRequestResponse=requestResponse;
        MovieDatabaseApi api = ApiClient.getClient().create(MovieDatabaseApi.class);
        Call<ResponseBody> call = api.getPosters(Constants.API_KEY);
        call.enqueue(this);
    }

    public void moviePostersToprated(RequestResponse requestResponse) {
        this.cls=MoviesPostersData.class;
        this.mRequestResponse=requestResponse;
        MovieDatabaseApi api = ApiClient.getClient().create(MovieDatabaseApi.class);
        Call<ResponseBody> call = api.getPostersTopRated(Constants.API_KEY);
        call.enqueue(this);
    }

}
