package com.dj.baeminpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.dj.baeminpractice.model.BannerItem
import com.dj.baeminpractice.ui.MainActivityViewModel
import com.dj.baeminpractice.ui.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.setBannerItems(
            listOf(
                BannerItem(R.drawable.first),
                BannerItem(R.drawable.second),
                BannerItem(R.drawable.third),
                BannerItem(R.drawable.fourth),
                BannerItem(R.drawable.fifth)
            )
        )

        iv_hamburger.setOnClickListener(this)
        initViewPager2()
        subscribeObservers()
    }

    private fun initViewPager2() {
        viewPager2.apply {
            viewPagerAdapter = ViewPagerAdapter()
            adapter = viewPagerAdapter
            registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    tv_page_number.text = "${position+1}"
                }
            })
        }
    }

    private fun subscribeObservers() {
        viewModel.bannerItemList.observe(this, Observer { bannerItemList ->
            viewPagerAdapter.submitList(bannerItemList)
        })
    }

    override fun onClick(p0: View?) {
        p0?.let {
            when (it.id) {
                R.id.iv_hamburger -> {

                }
            }
        }
    }
}
