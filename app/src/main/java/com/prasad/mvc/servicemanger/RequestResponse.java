package com.prasad.mvc.servicemanger;

import retrofit2.Response;

/**
 * Created by prasad on 9/22/18.
 */

public interface RequestResponse {

    public void onResponse(Object response);
    public void onFailure(String failure);


}
