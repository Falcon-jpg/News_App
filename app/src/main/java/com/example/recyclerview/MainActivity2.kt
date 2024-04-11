package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.recyclerview.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("head")
        val imgID = intent.getIntExtra("image",R.drawable.img1)
        val content = intent.getStringExtra("body")

        binding.newsHead.text = name
        binding.newsImg.setImageResource(imgID)
        binding.newsWrap.text = content
    }
}