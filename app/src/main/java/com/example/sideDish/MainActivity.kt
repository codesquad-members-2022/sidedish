package com.example.sideDish

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDate

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clearCache()
    }

    private fun clearCache() {

        // getPreferences 현재 엑티비티에서만 사용
        // Context.MODE_PRIVATE 내앱에서만 사용
        val shared = getPreferences(Context.MODE_PRIVATE)
        Thread(Runnable {
            val recent = shared.getLong(RECENT_CLEAR_DATE, System.currentTimeMillis())
            if (System.currentTimeMillis() - recent > ONE_MONTH) {
                with(shared.edit()) {
                    putLong(RECENT_CLEAR_DATE, System.currentTimeMillis()).apply()
                }
                Glide.get(this).clearDiskCache()
            } else {
                Log.d(TAG, System.currentTimeMillis().toString())
                Log.d(TAG, recent.toString())
            }
        }).start()
    }

    companion object {
        const val RECENT_CLEAR_DATE = "date"
        const val TAG = "MainActivity"
        const val ONE_MONTH = 30 * 60 * 60 * 24
    }
}