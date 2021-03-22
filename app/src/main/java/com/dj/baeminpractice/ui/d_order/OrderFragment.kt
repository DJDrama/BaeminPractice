package com.dj.baeminpractice.ui.d_order

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dj.baeminpractice.R
import com.dj.baeminpractice.databinding.FragmentOrderBinding
import com.dj.baeminpractice.ui.d_order.sub.BMartFragment
import com.dj.baeminpractice.ui.d_order.sub.DeliverTakeOutFragment
import com.dj.baeminpractice.ui.d_order.sub.ShoppingLiveFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderFragment : Fragment(R.layout.fragment_order) {
    private var _binding: FragmentOrderBinding? = null
    private val binding
        get() = _binding!!

    private val title = arrayOf("배달﹒포장", "B마트", "쇼핑라이브")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOrderBinding.bind(view)

        setUpViewPager()
    }

    private fun setUpViewPager() {
        binding.pager.apply {
            adapter = object : FragmentStateAdapter(requireActivity()) {
                override fun getItemCount(): Int {
                    return title.size
                }

                override fun createFragment(position: Int): Fragment {
                    return when (position) {
                        0 -> DeliverTakeOutFragment()
                        1 -> BMartFragment()
                        2 -> ShoppingLiveFragment()
                        else -> DeliverTakeOutFragment()
                    }
                }
            }
        }
        TabLayoutMediator(binding.tabLayout, binding.pager){tab, position ->
            tab.text = title[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}