package com.dj.baeminpractice.ui.a_home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dj.baeminpractice.R
import com.dj.baeminpractice.model.BannerItem
import kotlinx.android.synthetic.main.item_layout_banner.view.*

class ViewPagerAdapter(private val interaction: Interaction) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var bannerItemList: List<BannerItem>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BannerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout_banner, parent, false),
            interaction
        )
    }

    override fun getItemCount(): Int {
        return bannerItemList?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bannerItemList?.let { bannerItemList ->
            (holder as BannerViewHolder).bind(bannerItemList[position])
        }
    }

    //functions
    fun submitList(list: List<BannerItem>?) {
        bannerItemList = list
        notifyDataSetChanged()
    }


    //ViewHolder
    class BannerViewHolder
    constructor(itemView: View, private val interaction: Interaction) : RecyclerView.ViewHolder(itemView) {
        fun bind(bannerItem: BannerItem) {
            itemView.setOnClickListener {
                interaction.onBannerItemClicked(bannerItem)
            }
            itemView.iv_banner_image.setImageResource(bannerItem.image)
        }
    }
}