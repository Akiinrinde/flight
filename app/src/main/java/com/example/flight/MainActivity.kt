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
import com.google.android.material.tabs.TabLayout
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var tabToolBar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.tool_bar)
        var tabViewPager = findViewById<ViewPager>(R.id.tab_viewpager)
        var tabTabLayout = findViewById<TabLayout>(R.id.tab_tablayout)

        var textView: TextView = findViewById(R.id.first_text_view)

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

class ViewPagerAdapter(supportFragmentManager: FragmentManager) :
    FragmentPagerAdapter(supportFragmentManager) {

    private var fragmentList1 :ArrayList<Fragment> = ArrayList()
    private var fragmentTitleList1: ArrayList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return fragmentList1[position]
    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList1[position]
    }

    override fun getCount(): Int {
        return fragmentList1.size
    }

    fun addFragment(fragment: Fragment, title: String){
        fragmentList1.add(fragment)
        fragmentTitleList1.add(title)
    }
}
