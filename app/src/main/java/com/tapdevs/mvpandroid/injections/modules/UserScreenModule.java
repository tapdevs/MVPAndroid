package com.tapdevs.mvpandroid.injections.modules;

import android.app.Application;

import com.tapdevs.mvpandroid.abstractions.presenters.UserInterface;
import com.tapdevs.mvpandroid.data.DataManager;
import com.tapdevs.mvpandroid.data.RealmDataManager;
import com.tapdevs.mvpandroid.data.remote.ApiCalls;
import com.tapdevs.mvpandroid.data.remote.RetrofitHelper;
import com.tapdevs.mvpandroid.injections.scope.PerDataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jan S. on 03/05/2017.
 */

@Module
public class UserScreenModule {


        private final UserInterface.View mView;


        public UserScreenModule(UserInterface.View mView) {
            this.mView = mView;
        }

        @Provides
        @PerDataManager
        UserInterface.View providesMainScreenContractView() {
            return mView;
        }


    @Provides
    @PerDataManager
    ApiCalls provideApiInterface() {

        return new RetrofitHelper().newApiCalls();
    }

    @Provides
    @PerDataManager
    DataManager provideDataManager(){
        return new DataManager(provideApiInterface(), provideSubscribeScheduler());
    }

    @Provides
    @PerDataManager
    Scheduler provideSubscribeScheduler() {
        return Schedulers.io();
    }


    @Provides
    @PerDataManager
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerDataManager
        // Application reference must come from ApplicationModule.class
    RealmDataManager providesRealm() {
        return new RealmDataManager();
    }
}
