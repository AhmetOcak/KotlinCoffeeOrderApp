package com.kotlinorderapp.ui.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlinorderapp.CoffeeAdapter
import com.kotlinorderapp.R
import com.kotlinorderapp.databinding.FragmentCoffeeMenuBinding


class CoffeeMenuFragment : Fragment() {

    private var _binding: FragmentCoffeeMenuBinding? = null

    private val binding get() = _binding!!

    private val coffeeImageList = arrayListOf<Int>(
        R.drawable.coffee_cup,
        R.drawable.coffee_cup,
        R.drawable.coffee_cup,
        R.drawable.coffee_cup,
        R.drawable.coffee_cup,
        R.drawable.coffee_cup,
        R.drawable.coffee_cup,
        R.drawable.coffee_cup,
        R.drawable.coffee_cup,
        R.drawable.coffee_cup,
        R.drawable.coffee_cup,
        R.drawable.coffee_cup,
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCoffeeMenuBinding.inflate(inflater, container, false)

        val adapter = CoffeeAdapter(
            resources.getStringArray(R.array.coffee_names),
            resources.getStringArray(R.array.coffee_price),
            resources.getStringArray(R.array.coffee_description),
            coffeeImageList
        )

        binding.recylerview.layoutManager = LinearLayoutManager(activity)
        binding.recylerview.adapter = adapter

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}