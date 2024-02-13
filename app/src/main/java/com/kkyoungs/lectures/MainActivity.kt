package com.kkyoungs.lectures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kkyoungs.lector.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view = View(this)

        view.setOnClickListener { println("안녕") }
    }

}