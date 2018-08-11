package com.example.mmart.eadbox.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager

import com.example.mmart.eadbox.R
import com.example.mmart.eadbox.ui.adapter.ListVideosAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = recycler_view

        recyclerView.adapter = ListVideosAdapter(this, videos());
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
    }

    private fun videos(): List<Video> {
        return listOf<Video>(Video("Video 1"), Video("Video 2"))
    }

}
