package com.example.mvvmrecyclerview

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalTime.of
import java.util.List.of
import java.util.Map.of
import java.util.OptionalDouble.of
import java.util.Set.of

class MainActivity : AppCompatActivity() {

    private var viewManager = LinearLayoutManager(this)
    private lateinit var musicViewModel: MusicViewModel
    private lateinit var mainrecycler: RecyclerView
    private lateinit var but: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainrecycler = findViewById(R.id.musicRV)
        val application = requireNotNull(this).application


        musicViewModel = ViewModelProvider(this).get(MusicViewModel::class.java)


        but = findViewById(R.id.addbtn)

        but.setOnClickListener {
            addData()
        }
        initialiseAdapter()

    }

    private fun initialiseAdapter() {
        mainrecycler.layoutManager = viewManager
        observeData()
    }

    fun observeData() {
        musicViewModel.musicList.observe(this, Observer {

            mainrecycler.adapter = MusicAdapter(musicViewModel, it, this)
        })
    }

    fun addData() {
            var blog = MusicModel("Hello","World")
            musicViewModel.add(blog)
            mainrecycler.adapter?.notifyDataSetChanged()


    }
}