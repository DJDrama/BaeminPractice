package com.dj.baeminpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iv_hamburger.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        p0?.let{
            when(it.id){
                R.id.iv_hamburger->{

                }
            }
        }
    }
}
