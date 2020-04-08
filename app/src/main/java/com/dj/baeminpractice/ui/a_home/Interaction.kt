package com.dj.baeminpractice.ui.a_home

import android.view.View
import com.dj.baeminpractice.model.BannerItem

interface Interaction: View.OnClickListener {
    fun onBannerItemClicked(bannerItem: BannerItem)
}