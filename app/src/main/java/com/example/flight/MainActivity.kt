package com.example.flight

import android.graphics.Color
import android.graphics.ColorMatrix
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import android.widget.Toolbar
import androidx.annotation.Nullable
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.flight.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val tabToolBar = binding.toolBar
        val tabViewPager = binding.tabViewpager
        val tabTabLayout = binding.tabTablayout

        val textView: TextView = binding.firstTextView

        val spannable = SpannableString("Find Flight, \nExplore Paradise")
        spannable.setSpan(ForegroundColorSpan(getColor(R.color.orange)), 5, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.text = spannable

        setSupportActionBar(tabToolBar)
        setUpViewPager(tabViewPager)

        tabTabLayout.setupWithViewPager(tabViewPager)



    }

    private fun setUpViewPager( viewPager: ViewPager){
        var adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(OneWayFragment(), "One Way")
        adapter.addFragment(RoundTripFragment(), "Round Trip")

        viewPager.adapter = adapter
    }
}

