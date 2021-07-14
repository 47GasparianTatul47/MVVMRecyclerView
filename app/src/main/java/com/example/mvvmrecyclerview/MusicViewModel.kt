package com.example.mvvmrecyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MusicViewModel: ViewModel() {
    var musicList = MutableLiveData<ArrayList<MusicModel>>()
    var newMusicList = arrayListOf<MusicModel>()


    fun add(music: MusicModel){
        newMusicList.add(music)
        musicList.value=newMusicList
    }

}
