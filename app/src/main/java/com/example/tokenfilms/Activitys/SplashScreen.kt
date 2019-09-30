package com.example.tokenfilms.Activitys

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tokenfilms.R
import android.support.v4.os.HandlerCompat.postDelayed
import android.content.Intent
import android.os.Handler


class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val handler = Handler()
        handler.postDelayed(Runnable { mostrarMainActivity() }, 2000)
    }
    private fun mostrarMainActivity() {
        val intent = Intent(
                this@SplashScreen, MainActivity::class.java
        )
        startActivity(intent)
        finish()
    }
}
