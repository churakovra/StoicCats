package com.churakov.stoiccats

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgView = findViewById<ImageView>(R.id.catImageView)
        val nextImgBtn = findViewById<Button>(R.id.next_img_bt)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.imgUrlData.observe(this) {
            Glide.with(this)
                .load(it.toURL())
                .into(imgView)
        }

        nextImgBtn.setOnClickListener {
            lifecycleScope.launch {
                viewModel.loadImg()
            }
        }

    }
}