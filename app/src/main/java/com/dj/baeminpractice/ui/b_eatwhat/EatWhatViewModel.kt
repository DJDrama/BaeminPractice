package com.dj.baeminpractice.ui.b_eatwhat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dj.baeminpractice.model.WhatToEat
import com.dj.baeminpractice.repository.b_eatwhat.EatWhatRepository
import com.dj.baeminpractice.repository.b_eatwhat.EatWhatRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class EatWhatViewModel
    @Inject
    constructor(
        private val eatWhatRepository: EatWhatRepository
    ): ViewModel() {
    private val _eatWhatToEatList: MutableLiveData<List<WhatToEat>> = MutableLiveData()
    val eatWhatToEatList: LiveData<List<WhatToEat>>
        get() = _eatWhatToEatList

    fun getFakeWhatToEatList() {
        viewModelScope.launch {
            withContext(IO) {
                _eatWhatToEatList.postValue(eatWhatRepository.getWhatToEatItems())
            }
        }
    }
}