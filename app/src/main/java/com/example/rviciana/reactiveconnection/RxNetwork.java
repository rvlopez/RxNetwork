package com.example.rviciana.reactiveconnection;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import io.reactivex.Observable;

public class RxNetwork {

    public RxNetwork() {
        // No instances
    }

    public static Observable<Boolean> stream(Context context) {
        final IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);

        return ContentObservable.fromBroadcast(context, intentFilter)
                .map(intent -> NetworkStatusUtils.isNetworkConnected(context))
                .distinctUntilChanged();
    }
}
