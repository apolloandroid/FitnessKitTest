package com.example.fitnesskittest.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitnesskittest.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}