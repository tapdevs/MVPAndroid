package com.tapdevs.mvpandroid;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.tapdevs.mvpandroid.injections.component.DaggerNetComponent;
import com.tapdevs.mvpandroid.injections.component.NetComponent;
import com.tapdevs.mvpandroid.injections.modules.AppModule;
import com.tapdevs.mvpandroid.injections.modules.NetModule;
import com.tapdevs.mvpandroid.utils.AppConstants;
import com.tapdevs.mvpandroid.utils.CrashlyticsTree;

import io.realm.Realm;
import timber.log.Timber;

/**
 * Created by Jan S. on 25/04/2017.
 */

public class App extends Application{

    private NetComponent mNetComponent;



    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        mNetComponent = DaggerNetComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .netModule(new NetModule(AppConstants.SERVER_URL))
                .build();

        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree()); else     Timber.plant(new CrashlyticsTree());
        Realm.init(this);

    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

    public void inject(){
        getNetComponent().inject(this);
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }
}
