package com.example.ut3ejerciciosevaluables

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ut3ejerciciosevaluables.databinding.ActivityLayout1Binding

class Layout1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityLayout1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLayout1Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}