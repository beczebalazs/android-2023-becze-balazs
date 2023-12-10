package com.tasty.recipesapp.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.tasty.recipesapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    private val SPLASH_TIME_OUT: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val handlerThread = HandlerThread("SplashHandlerThread", -10)
        handlerThread.start()
        val handler = Handler(handlerThread.looper)
        handler.postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT)
    }

    override fun onStart() {
        super.onStart()
        Log.d("SplashActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SplashActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SplashActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SplashActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SplashActivity", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("SplashActivity", "onRestart")
    }
}
