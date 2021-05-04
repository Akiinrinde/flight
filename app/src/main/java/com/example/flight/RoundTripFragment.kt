package com.example.flight

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.flight.R.*
import com.example.flight.databinding.RoundTripBinding

class RoundTripFragment: Fragment() {

    private lateinit var fragmentFirstBinding: RoundTripBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View? {
        fragmentFirstBinding = RoundTripBinding.inflate(layoutInflater)
        return fragmentFirstBinding.root
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val firstSpinner = fragmentFirstBinding.firstSpinner
        val adapter = ArrayAdapter.createFromResource(activity!!.applicationContext, array.first_dates, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        firstSpinner.adapter =adapter


        firstSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                parent?.getItemAtPosition(position)
//                Toast.makeText(view?.context,
//                        getString(R.string.selected_item) + " " +
//                                "" + parent?.getItemAtPosition(position), Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        val secondSpinner = fragmentFirstBinding.secondSpinner
        ArrayAdapter.createFromResource(activity!!.applicationContext, array.second_dates, android.R.layout.simple_spinner_item).also { secondAdapter ->
            secondSpinner.adapter = secondAdapter
        }

        secondSpinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                parent?.getItemAtPosition(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }


        val  adultSpinner = fragmentFirstBinding.adultSpinner
        val adultAdapter = ArrayAdapter.createFromResource(activity!!.applicationContext, array.adults, android.R.layout.simple_spinner_item)
        adultSpinner.adapter = adultAdapter

        adultSpinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                parent?.getItemAtPosition(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        val babySpinner =fragmentFirstBinding.childSpinner
        val babyAdapter = ArrayAdapter.createFromResource(activity!!.applicationContext, array.babies, android.R.layout.simple_spinner_item)
        babySpinner.adapter = babyAdapter

        babySpinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                parent?.getItemAtPosition(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        val firstButton = fragmentFirstBinding.firstButton
        firstButton.setOnClickListener {
            changeStroke(firstButton)
        }

        val secondButton = fragmentFirstBinding.secondButton
        secondButton.setOnClickListener {
           changeStroke(secondButton)
        }

        val thirdButton = fragmentFirstBinding.thirdButton
        thirdButton.setOnClickListener {
            changeStroke(thirdButton)
        }

    }

    private fun changeStroke(button: Button){
        val gd = GradientDrawable()
        gd.cornerRadius = 10f
        gd.setColor(Color.WHITE)
        val color = this.resources.getColor(R.color.green)
        gd.setStroke(2, color )
        button.background = gd
    }



}