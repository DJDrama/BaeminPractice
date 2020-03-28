package com.dj.baeminpractice

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenStarted
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.dj.baeminpractice.model.BannerItem
import com.dj.baeminpractice.model.data.fakeBannerItemList
import com.dj.baeminpractice.model.data.fakeGridItemList
import com.dj.baeminpractice.ui.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_slide_menu.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), View.OnClickListener, Interaction {
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var gridRecyclerViewAdapter: GridRecyclerViewAdapter
    private lateinit var viewModel: MainActivityViewModel
    private var isRunning = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.setBannerItems(fakeBannerItemList)
        viewModel.setGridItems(fakeGridItemList)

        iv_hamburger.setOnClickListener(this)
        ll_left_area.setOnClickListener(this)

        tv_see_detail.setOnClickListener(this)
        iv_arrow.setOnClickListener(this)


        initViewPager2()
        subscribeObservers()
        autoScrollViewPager()
    }

    private fun initViewPager2() {
        viewPager2.apply {
            viewPagerAdapter = ViewPagerAdapter(this@MainActivity)
            adapter = viewPagerAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    isRunning=true
                    tv_page_number.text = "${position + 1}"

                    //직접 유저가 스크롤했을 떄!
                    viewModel.setCurrentPosition(position)
                }
            })
        }
        gridRecyclerView.apply {
            gridRecyclerViewAdapter = GridRecyclerViewAdapter()
            layoutManager = GridLayoutManager(this@MainActivity, 4)

            adapter = gridRecyclerViewAdapter
        }
    }

    private fun subscribeObservers() {
        viewModel.bannerItemList.observe(this, Observer { bannerItemList ->
            viewPagerAdapter.submitList(bannerItemList)
        })

        viewModel.gridItemList.observe(this, Observer {gridItemList->
            gridRecyclerViewAdapter.submitList(gridItemList)
        })

        viewModel.currentPosition.observe(this, Observer { currentPosition ->
            viewPager2.currentItem = currentPosition
        })

    }

    private fun autoScrollViewPager() {
        lifecycleScope.launch {
            whenStarted {
                while (isRunning) {
                    delay(3000)
                    viewModel.getCurrentPosition()?.let {
                        viewModel.setCurrentPosition((it.plus(1)) % 5)
                    }
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        isRunning = false
    }

    override fun onResume() {
        super.onResume()
        isRunning = true
    }

    override fun onBannerItemClicked(bannerItem: BannerItem) {
        startActivity(Intent(this@MainActivity, EventActivity::class.java))
    }

    override fun onClick(p0: View?) {
        p0?.let {
            when (it.id) {
                R.id.iv_hamburger -> {
                    if(drawer_layout.isDrawerOpen(ll_drawer)){
                        drawer_layout.closeDrawer(ll_drawer)
                    }else{
                        drawer_layout.openDrawer(ll_drawer)
                    }
                }
                R.id.ll_left_area->{
                    if(drawer_layout.isDrawerOpen(ll_drawer)){
                        drawer_layout.closeDrawer(ll_drawer)
                    }
                }
                R.id.tv_see_detail, R.id.iv_arrow->{
                    if(ll_detail.visibility == View.GONE){
                        ll_detail.expand(scrollView = nested_scroll_view)
                        tv_see_detail.text="닫기"
                        iv_arrow.setImageResource(R.drawable.arrow_up)
                    }else{ //VISIBLE
                        ll_detail.collapse()
                        tv_see_detail.text="자세히보기"
                        iv_arrow.setImageResource(R.drawable.arrow_down)
                    }
                }
            }
        }
    }
}

