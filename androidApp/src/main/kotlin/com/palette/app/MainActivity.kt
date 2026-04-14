package com.palette.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.palette.kmp.App
import com.palette.kmp.setAndroidContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAndroidContext(this)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}


