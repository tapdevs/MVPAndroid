package com.tapdevs.mvpandroid.injections.component;

import android.app.Application;


import com.tapdevs.mvpandroid.data.DataManager;
import com.tapdevs.mvpandroid.data.RealmDataManager;
import com.tapdevs.mvpandroid.injections.modules.AppModule;
import com.tapdevs.mvpandroid.injections.modules.NetModule;
import com.tapdevs.mvpandroid.utils.SharedPreferenceUtil;
import com.tapdevs.mvpandroid.view.fragments.UsersFragment;
import com.tapdevs.mvpandroid.view.activities.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by  Jan Shair on 31/01/2017.
 */

@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface NetComponent {
     void inject(Application application);
     void inject(MainActivity activity);

     void inject(UsersFragment fragment);

    SharedPreferenceUtil provideSharedPreferences();
    RealmDataManager providesRealm();
    DataManager provideDataManager();

}
