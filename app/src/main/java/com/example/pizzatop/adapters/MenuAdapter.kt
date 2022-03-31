package com.example.pizzatop.adapters


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pizzatop.Data.Info


import com.example.pizzatop.databinding.ItemFoodBinding

class MenuAdapter(private val menu:ArrayList<Info>,
                  private val image:ArrayList<String>):RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

  inner class MenuViewHolder(private val view: ItemFoodBinding):RecyclerView.ViewHolder(view.root) {
        @SuppressLint("SetTextI18n")
        fun bind(pizza: Info,url:String) {
            val title = view.Title
            val rec = view.recept
            val materialButton = view.price
            val imageView=view.imageView
            title.text = pizza.name
            rec.text= pizza.topping?.joinToString()
            materialButton.text = pizza.price.toString() + " "+ "kr"
            Glide.with(view.root)
                .load(url)
                .centerCrop()
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MenuViewHolder {
        val holder= ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(holder)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(menu[position],image[position])
    }

    override fun getItemCount(): Int {
    return menu.size
    }
}