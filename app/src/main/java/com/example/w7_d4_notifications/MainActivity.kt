package com.example.w7_d4_notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.w7_d4_notifications.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder

    private val notificationId = 1234
    private val channelId = "myapp.notifications"
    private val description = "First Notification App"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        binding.notificationButton.setOnClickListener {

            val intent = Intent(this, NotificationActivity::class.java)

            val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                notificationManager.createNotificationChannel(notificationChannel)


                builder = Notification.Builder(this, channelId)
                    .setSmallIcon(R.drawable.ic_baseline_circle_notifications_24)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_baseline_circle_notifications_24))
                    .setContentIntent(pendingIntent)
                    .setContentTitle("First Notification")
                    .setContentText(binding.notificationEditText.text!!)
            } else {

                builder = Notification.Builder(this)
                    .setSmallIcon(R.drawable.ic_baseline_circle_notifications_24)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_baseline_circle_notifications_24))
                    .setContentIntent(pendingIntent)
                    .setContentTitle("First Notification")
                    .setContentText(binding.notificationEditText.text!!)
            }

            notificationManager.notify(notificationId, builder.build())
        }
    }
}