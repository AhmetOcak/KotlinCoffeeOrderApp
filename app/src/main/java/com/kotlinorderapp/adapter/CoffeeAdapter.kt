package com.kotlinorderapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.kotlinorderapp.R
import com.kotlinorderapp.viewmodels.OrderViewModel


class CoffeeAdapter(
    private val coffeeName: Array<String>,
    private val coffeePrice: Array<String>,
    private val coffeeDescription: Array<String>,
    private val coffeeImage: ArrayList<Int>,
    private val sharedViewModel: OrderViewModel,
) : RecyclerView.Adapter<CoffeeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val coffeeName: TextView = itemView.findViewById(R.id.coffee_name)
        val coffeePrice: TextView = itemView.findViewById(R.id.coffee_price)
        val coffeeDescription: TextView = itemView.findViewById(R.id.coffee_description)
        val coffeeImage: ImageView = itemView.findViewById(R.id.coffee_image)

        val view = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coffee_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.coffeeName.text = coffeeName[position]
        holder.coffeePrice.text = coffeePrice[position]
        holder.coffeeDescription.text = coffeeDescription[position]
        holder.coffeeImage.setImageResource(coffeeImage[position])

        holder.view.setOnClickListener {
            sharedViewModel.setCoffeeInfo(
                holder.coffeeName.text.toString(),
                holder.coffeePrice.text.toString().toDouble()
            )
            holder.view.findNavController()
                .navigate(R.id.action_coffeeMenuFragment_to_checkoutFragment)
        }
    }

    override fun getItemCount() = coffeeName.size
}