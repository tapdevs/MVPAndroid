package com.tapdevs.mvpandroid.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import static com.tapdevs.mvpandroid.utils.SnackBarUtils.showSnackBarOnNoInternet;


/**
 * Created by  Jan Shair on 08/02/2017.
 */

public class NetworkUtils {

    public static boolean checkInternet(Activity context){
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if(!(activeNetworkInfo != null && activeNetworkInfo.isConnected())){
            showSnackBarOnNoInternet(context);
            return false;
        }
        return true;
    }


}
