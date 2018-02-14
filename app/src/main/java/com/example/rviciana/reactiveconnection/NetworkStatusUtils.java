package com.example.rviciana.reactiveconnection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkStatusUtils {

   private static NetworkInfo checkNetworkInfo(Context context) {
       ConnectivityManager connectivityManager =
               (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

       if (connectivityManager != null) {
           return connectivityManager.getActiveNetworkInfo();
       }
       return null;
   }

   public static boolean isNetworkConnected(Context context) {
       NetworkInfo networkInfo = checkNetworkInfo(context);
       return (networkInfo != null && networkInfo.isConnected());
   }
}
