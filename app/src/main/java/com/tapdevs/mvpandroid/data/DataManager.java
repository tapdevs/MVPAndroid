package com.tapdevs.mvpandroid.data;

import android.app.Application;
import android.content.Context;

import com.tapdevs.mvpandroid.App;
import com.tapdevs.mvpandroid.data.remote.ApiCalls;
import com.tapdevs.mvpandroid.injections.component.DaggerNetComponent;
import com.tapdevs.mvpandroid.injections.modules.AppModule;
import com.tapdevs.mvpandroid.injections.modules.NetModule;
import com.tapdevs.mvpandroid.models.User;
import com.tapdevs.mvpandroid.utils.AppConstants;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;

/**
 * Created by  Jan Shair on 31/01/2017.
 */

public class DataManager {

    @Inject
    protected ApiCalls apiCalls;
    @Inject protected Scheduler mSubscribeScheduler;


    public DataManager(Application context) {
        injectDependencies(context);
    }

    public DataManager(ApiCalls apiCalls,
                       Scheduler subscribeScheduler) {
        this.apiCalls = apiCalls;
        mSubscribeScheduler = subscribeScheduler;
    }

    protected void injectDependencies(Context context) {
        DaggerNetComponent.builder()
                .appModule(new AppModule(App.get(context)))
                .netModule(new NetModule(AppConstants.SERVER_URL))
                .build()
                .inject(App.get(context));
    }

    public Scheduler getScheduler() {
        return mSubscribeScheduler;
    }

    public io.reactivex.Observable<List<User>> getUserList() {
        return apiCalls.getUsers();

    }






}
