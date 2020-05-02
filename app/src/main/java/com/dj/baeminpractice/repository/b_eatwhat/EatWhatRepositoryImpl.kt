package com.dj.baeminpractice.repository.b_eatwhat

import com.dj.baeminpractice.model.WhatToEat
import com.dj.baeminpractice.model.data.fakeWhatToEatList

object EatWhatRepositoryImpl : EatWhatRepository {

    override suspend fun getWhatToEatItems(): List<WhatToEat> {
        return fakeWhatToEatList
    }
}