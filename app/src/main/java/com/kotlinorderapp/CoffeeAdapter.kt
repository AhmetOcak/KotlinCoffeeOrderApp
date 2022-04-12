package com.kotlinorderapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CoffeeAdapter(
    private val coffeeName: Array<String>,
    private val coffeePrice: Array<String>,
    private val coffeeDescription: Array<String>,
    private val coffeeImage: ArrayList<Int>
) : RecyclerView.Adapter<CoffeeAdapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val coffeeName : TextView = itemView.findViewById(R.id.coffee_name)
        val coffeePrice : TextView = itemView.findViewById(R.id.coffee_price)
        val coffeeDescription : TextView = itemView.findViewById(R.id.coffee_description)
        val coffeeImage : ImageView = itemView.findViewById(R.id.coffee_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coffee_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoffeeAdapter.ViewHolder, position: Int) {
        holder.coffeeName.text = coffeeName[position]
        holder.coffeePrice.text = "$" + coffeePrice[position]
        holder.coffeeDescription.text = coffeeDescription[position]
        holder.coffeeImage.setImageResource(coffeeImage[position])
    }

    override fun getItemCount() = coffeeName.size
}