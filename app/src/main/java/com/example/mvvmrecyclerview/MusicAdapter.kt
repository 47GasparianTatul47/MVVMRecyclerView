package com.example.mvvmrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MusicAdapter(
    private val arrayList: ArrayList<MusicModel>,
    private val context: Context
) : RecyclerView.Adapter<MusicAdapter.ViewHolders>() {

    class ViewHolders(view: View) : RecyclerView.ViewHolder(view) {

        val nameMusic :TextView = itemView.findViewById(R.id.titleMusic)
        val actorMusic :TextView = itemView.findViewById(R.id.actorMusic)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolders {
        val view = LayoutInflater.from(context).inflate(R.layout.music_item, parent, false)
        return ViewHolders(view)
    }

    override fun onBindViewHolder(holder: ViewHolders, position: Int) {
        holder.nameMusic.text = arrayList[position].name
        holder.actorMusic.text = arrayList[position].actor

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}