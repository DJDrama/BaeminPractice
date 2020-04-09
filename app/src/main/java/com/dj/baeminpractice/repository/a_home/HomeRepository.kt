package com.dj.baeminpractice.repository.a_home

import com.dj.baeminpractice.model.BannerItem
import com.dj.baeminpractice.model.GridItem

interface HomeRepository {
    suspend fun getBannerItems(): List<BannerItem>
    suspend fun getGridItems(): List<GridItem>
}