package com.example.w7_d4_notifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.w7_d4_notifications.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}