package com.example.servicesinandroid

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import android.util.Log

class ClassicServices:Service() {
    private lateinit var player:MediaPlayer
    override fun onBind(intent: Intent?): IBinder? {
      return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("message","classic Service created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("message","classic Service Started")
        Log.d("thread",Thread.currentThread().name)
        // creating a media player which
        // will play the audio of Default
        // ringtone in android device
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)

        // providing the boolean
        // value as true to play
        // the audio on loop
        player.setLooping(true)

        // starting the process
        player.start()

        // returns the status
        // of the program
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("message","classic Service    stopped")
        player.stop()
    }
}