package com.tapdevs.mvpandroid.abstractions.presenters;

import com.tapdevs.mvpandroid.models.User;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmResults;

/**
 * Created by Jan S. on 25/04/2017.
 */

public interface UserInterface {
    interface View {
        void showPosts(List<User> posts);

        void showError(Throwable message);

        void showComplete();
    }

    interface Presenter {
        void loadPost();
    }
}
