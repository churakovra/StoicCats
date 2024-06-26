package com.churakov.stoiccats

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgView = findViewById<ImageView>(R.id.cat_image_view)
        val progressBar = findViewById<ProgressBar>(R.id.loading_pb)
        val nextImgBtn = findViewById<Button>(R.id.next_img_bt)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.imgUrlData.observe(this) {
            try {
                Glide.with(this)
                    .load(it.toURL())
                    .into(imgView)
            } catch (e: Exception) {
                Log.d("MainActivity", e.toString())
            }
        }
        viewModel.isLoading.observe(this) {
            progressBar.visibility = if (it) View.VISIBLE else View.INVISIBLE
        }

        nextImgBtn.setOnClickListener {
            lifecycleScope.launch {
                viewModel.loadImg()
            }
        }

    }
}