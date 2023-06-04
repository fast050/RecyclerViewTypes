package com.example.recyclerviewtypes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.recyclerviewtypes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val mixDataList = arrayListOf<BaseItemType>(
            OrderResponse("SKYE BLUE"),
            ProfileResponse("Rao", R.mipmap.ic_launcher),
            ProfileResponse("Khalid", R.mipmap.ic_launcher),
            ProfileResponse("Khalil", R.mipmap.ic_launcher),
            ProfileResponse("Salman", R.mipmap.ic_launcher),
            ProfileResponse("Khalid", R.mipmap.ic_launcher),
            ProfileResponse("Khalil", R.mipmap.ic_launcher),
            ProfileResponse("Salman", R.mipmap.ic_launcher),
            ProfileResponse("Khalid", R.mipmap.ic_launcher),
            ProfileResponse("Khalil", R.mipmap.ic_launcher),
            ProfileResponse("Salman", R.mipmap.ic_launcher),
            ProfileResponse("Khalid", R.mipmap.ic_launcher),
            ProfileResponse("Khalil", R.mipmap.ic_launcher),
            ProfileResponse("Salman", R.mipmap.ic_launcher),
            ProfileResponse("Noman", R.mipmap.ic_launcher),
        )

        binding.apply {
            val layoutManager = LinearLayoutManager(this@MainActivity , HORIZONTAL , false)
            val adapter = MixAdapter()
            mixRecyclerView.layoutManager = layoutManager
            mixRecyclerView.adapter = adapter
            adapter.submitList(mixDataList)
        }

    }
}