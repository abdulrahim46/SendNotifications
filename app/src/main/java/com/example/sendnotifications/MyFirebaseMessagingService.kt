package com.example.sendnotifications

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService(){
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Looper.prepare()
        Handler().post {
            Log.d("TAG", "onMessageReceived: ${remoteMessage.notification}")
            Toast.makeText(baseContext,remoteMessage.notification?.title, Toast.LENGTH_LONG).show()
        }

        Looper.loop()
    }

}