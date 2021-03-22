package com.dj.baeminpractice.ui.d_order.sub

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dj.baeminpractice.R
import com.dj.baeminpractice.databinding.FragmentDeliverTakeOutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeliverTakeOutFragment: Fragment(R.layout.fragment_deliver_take_out){
    private var _binding: FragmentDeliverTakeOutBinding? = null
    private val binding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDeliverTakeOutBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}