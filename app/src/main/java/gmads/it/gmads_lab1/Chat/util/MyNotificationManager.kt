package gmads.it.gmads_lab1.Chat.util

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v4.app.NotificationCompat
import gmads.it.gmads_lab1.R
import android.media.RingtoneManager


/**
 * Created by giorgiocrepaldi on 19/05/18.
 */

class MyNotificationManager {
    val ctx : Context
    val NOTIFICATION_ID = 254

    constructor(ctx : Context){
        this.ctx = ctx
    }

    fun showNotification(from : String, notification : String, intent : Intent){

        var pendingIntent = PendingIntent.getActivity(
                 ctx,
                NOTIFICATION_ID,
                intent,
                PendingIntent.FLAG_ONE_SHOT
        );

        var channelId : String = "fcm_default_channel"

        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        var builder = NotificationCompat.Builder(ctx, channelId)

        var mNotification = builder
                .setSmallIcon(R.drawable.ic_add_book_24dp)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setContentTitle(from)
                .setContentText(notification)
                .setLargeIcon(BitmapFactory.decodeResource(ctx.resources, R.mipmap.my_launcher_overbooking_layer))
                .setSound(defaultSoundUri)
                .build()

        mNotification.flags = Notification.FLAG_AUTO_CANCEL

        var notificationManager : NotificationManager = ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify(NOTIFICATION_ID, mNotification)

    }
}