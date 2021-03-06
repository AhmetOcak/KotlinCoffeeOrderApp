package com.kotlinorderapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.kotlinorderapp.data.CoffeeData
import com.kotlinorderapp.adapter.CoffeeAdapter
import com.kotlinorderapp.R
import com.kotlinorderapp.databinding.FragmentCoffeeMenuBinding
import com.kotlinorderapp.viewmodels.OrderViewModel


class CoffeeMenuFragment : Fragment() {

    private var _binding: FragmentCoffeeMenuBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCoffeeMenuBinding.inflate(inflater, container, false)

        val adapter = CoffeeAdapter(
            resources.getStringArray(R.array.coffee_names),
            resources.getStringArray(R.array.coffee_price),
            resources.getStringArray(R.array.coffee_description),
            CoffeeData().coffeeImageList,
            sharedViewModel
        )

        val layoutManager = FlexboxLayoutManager(activity)
        layoutManager.justifyContent = JustifyContent.SPACE_AROUND
        layoutManager.alignItems = AlignItems.CENTER
        binding.recylerview.layoutManager = layoutManager
        binding.recylerview.adapter = adapter

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}