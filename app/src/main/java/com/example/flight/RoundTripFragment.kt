package com.example.flight

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.flight.R.*
import java.util.*

class RoundTripFragment: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layout.round_trip, container, false)

    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val firstSpinner = view.findViewById<Spinner>(R.id.first_spinner)

        if(firstSpinner != null){
            var adapter = ArrayAdapter.createFromResource(activity!!.applicationContext, array.first_dates, android.R.layout.simple_spinner_item)
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


       }


        val secondSpinner = view.findViewById<Spinner>(R.id.second_spinner)
        ArrayAdapter.createFromResource(activity!!.applicationContext, array.second_dates, android.R.layout.simple_spinner_item).also { secondAdapter ->
//            secondAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
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


        val  adultSpinner = view.findViewById<Spinner>(R.id.adult_spinner)
        val adultAdapter = ArrayAdapter.createFromResource(activity!!.applicationContext, array.adults, android.R.layout.simple_spinner_item)
//        adultAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adultSpinner.adapter = adultAdapter

        adultSpinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                parent?.getItemAtPosition(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        val babySpinner = view.findViewById<Spinner>(R.id.child_spinner)
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


        var firstButton = view.findViewById<Button>(R.id.first_button)
        firstButton.setOnClickListener {
            changeStroke(firstButton)
        }

        var secondButton = view.findViewById<Button>(R.id.second_button)
        secondButton.setOnClickListener {
           changeStroke(secondButton)
        }

        var thirdButton = view.findViewById<Button>(R.id.third_button)
        thirdButton.setOnClickListener {
            changeStroke(thirdButton)
        }

    }

    fun changeStroke(button: Button){
        val gd = GradientDrawable()
        gd.cornerRadius = 10f
        gd.setColor(Color.WHITE)
        val color = this.resources.getColor(R.color.green)
        gd.setStroke(2, color )
        button.background = gd
    }



}