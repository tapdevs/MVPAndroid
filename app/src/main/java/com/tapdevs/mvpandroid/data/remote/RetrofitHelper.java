package com.tapdevs.mvpandroid.data.remote;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.tapdevs.mvpandroid.utils.AppConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by  Jan Shair on 31/01/2017.
 */

public class RetrofitHelper {

    public ApiCalls newApiCalls() {

        ApiCalls apiInterface = new Retrofit.Builder()
                .baseUrl(AppConstants.SERVER_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiCalls.class);

        return apiInterface;
    }
}
