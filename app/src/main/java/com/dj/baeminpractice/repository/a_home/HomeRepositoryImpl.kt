package com.dj.baeminpractice.repository.a_home

import com.dj.baeminpractice.model.BannerItem
import com.dj.baeminpractice.model.GridItem
import com.dj.baeminpractice.model.data.fakeBannerItemList
import com.dj.baeminpractice.model.data.fakeGridItemList

//singleton
object HomeRepositoryImpl : HomeRepository {
    override suspend fun getBannerItems(): List<BannerItem> {
        return fakeBannerItemList
    }

    override suspend fun getGridItems(): List<GridItem> {
        return fakeGridItemList
    }

}