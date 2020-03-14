package com.dj.baeminpractice.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dj.baeminpractice.model.BannerItem

class MainActivityViewModel : ViewModel() {
    private val _bannerItemList: MutableLiveData<List<BannerItem>> = MutableLiveData()

    val bannerItemList: LiveData<List<BannerItem>>
        get() = _bannerItemList


    fun setBannerItems(list: List<BannerItem>){
        _bannerItemList.value = list
    }

}