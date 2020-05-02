package com.dj.baeminpractice.ui.b_eatwhat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dj.baeminpractice.model.WhatToEat
import com.dj.baeminpractice.repository.b_eatwhat.EatWhatRepositoryImpl
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EatWhatViewModel : ViewModel() {
    private val _eatWhatToEatList: MutableLiveData<List<WhatToEat>> = MutableLiveData()
    val eatWhatToEatList: LiveData<List<WhatToEat>>
        get() = _eatWhatToEatList

    fun getFakeWhatToEatList() {
        viewModelScope.launch {
            withContext(IO) {
                _eatWhatToEatList.postValue(EatWhatRepositoryImpl.getWhatToEatItems())
            }
        }
    }
}