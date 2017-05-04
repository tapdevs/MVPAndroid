package com.tapdevs.mvpandroid.presenter;

import com.tapdevs.mvpandroid.data.DataManager;
import com.tapdevs.mvpandroid.abstractions.presenters.UserInterface;
import com.tapdevs.mvpandroid.models.User;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.realm.RealmResults;

/**
 * Created by Jan S. on 25/04/2017.
 */

public class UsersPresenter implements UserInterface.Presenter {

    private UserInterface.View userInterfaceView;
    private DataManager mDataManager;
    private CompositeDisposable mCompositeDisposable;

    @Inject
    public UsersPresenter(CompositeDisposable compositeDisposable, UserInterface.View userInterfaceView, DataManager dataManager) {
        this.mCompositeDisposable=compositeDisposable;
        this.userInterfaceView=userInterfaceView;
        this.mDataManager=dataManager;
    }

    @Override
    public void loadPost() {

        mCompositeDisposable.add(mDataManager.getUserList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(mDataManager.getScheduler())
                .subscribe(userList -> userInterfaceView.showPosts(userList), throwable -> userInterfaceView.showError(throwable),() -> userInterfaceView.showComplete()));
    }
}
