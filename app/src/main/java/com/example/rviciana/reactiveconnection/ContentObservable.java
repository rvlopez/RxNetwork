package com.example.rviciana.reactiveconnection;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import io.reactivex.Observable;

public class ContentObservable {

    private ContentObservable() {
        throw new AssertionError("No instance");
    }

    public static Observable<Intent> fromBroadcast(Context context, IntentFilter intentFilter) {
        return Observable.create(new OnSubscribeBroadcastRegister(context, intentFilter));
    }
}
