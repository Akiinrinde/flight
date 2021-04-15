package com.example.flight

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import java.util.*

class RoundTripFragment: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.round_trip, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val firstSpinner = view.findViewById<Spinner>(R.id.first_spinner)

        if(firstSpinner != null){
            var adapter = ArrayAdapter.createFromResource(activity!!.applicationContext, R.array.first_dates, android.R.layout.simple_spinner_item)
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
        ArrayAdapter.createFromResource(activity!!.applicationContext, R.array.second_dates, android.R.layout.simple_spinner_item).also { secondAdapter ->
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
        val adultAdapter = ArrayAdapter.createFromResource(activity!!.applicationContext,R.array.adults, android.R.layout.simple_spinner_item)
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
        val babyAdapter = ArrayAdapter.createFromResource(activity!!.applicationContext, R.array.babies, android.R.layout.simple_spinner_item)
        babySpinner.adapter = babyAdapter

        babySpinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                parent?.getItemAtPosition(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }



}