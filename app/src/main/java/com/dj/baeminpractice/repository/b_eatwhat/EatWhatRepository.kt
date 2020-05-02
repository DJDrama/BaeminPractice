package com.dj.baeminpractice.repository.b_eatwhat

import com.dj.baeminpractice.model.BannerItem
import com.dj.baeminpractice.model.WhatToEat

interface EatWhatRepository {
    suspend fun getWhatToEatItems(): List<WhatToEat>
}