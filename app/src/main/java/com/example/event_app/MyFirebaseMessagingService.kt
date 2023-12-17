package com.example.event_app

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.example.event_app.presentation.HomePage
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.firebase.messaging.remoteMessage

const val channelId = "notification_channel"
const val channelName = "com.example.event_app"
class MyFirebaseMessagingService : FirebaseMessagingService() {

    // generate the notifications
    // attach the notification created with the custom layout
    // show the notification

    override fun onMessageReceived(message: RemoteMessage) {
        if (message.getNotification() != null) {
            generateNotification(message.notification!!.title!!, message.notification!!.body!!)
        }
    }

    @SuppressLint("RemoteViewLayout")
    fun getRemoteView(title : String, message : String) : RemoteViews {
        val remoteview = RemoteViews("com.example.event_app", R.layout.notification_card_item)

        remoteview.setTextViewText(R.id.notification_title, title)
        remoteview.setTextViewText(R.id.notification_time, message)
        remoteview.setImageViewResource(R.id.notification_image, R.drawable.logo_dark)

        return remoteview
    }

    fun generateNotification(title : String, message: String) {
        val intent = Intent(this, HomePage::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent = PendingIntent.getActivity(this, 0, intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE)

        var builder : NotificationCompat.Builder = NotificationCompat.Builder(applicationContext, channelId)
            .setSmallIcon(R.drawable.logo_dark)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000, 1000, 1000, 1000))
            .setOnlyAlertOnce(true)
            .setContentIntent(pendingIntent)

        builder = builder.setContent(getRemoteView(title, message))

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        notificationManager.notify(0, builder.build())
    }
}