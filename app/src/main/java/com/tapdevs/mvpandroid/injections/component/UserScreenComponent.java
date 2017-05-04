package com.tapdevs.mvpandroid.injections.component;

import com.tapdevs.mvpandroid.data.DataManager;
import com.tapdevs.mvpandroid.data.RealmDataManager;
import com.tapdevs.mvpandroid.injections.modules.UserScreenModule;
import com.tapdevs.mvpandroid.injections.scope.PerDataManager;
import com.tapdevs.mvpandroid.view.fragments.UsersFragment;

import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Jan S. on 03/05/2017.
 */

@PerDataManager
@Component(dependencies = NetComponent.class ,modules = UserScreenModule.class)
public interface UserScreenComponent {
    void inject(UsersFragment fragment);


    CompositeDisposable provideCompositeDisposable();
    RealmDataManager providesRealm();
    DataManager provideDataManager();
}
