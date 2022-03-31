package com.example.pizzatop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.pizzatop.databinding.ItemBannerBinding


class ImageBannerAdapter(private val bannerImages:ArrayList<String>): RecyclerView.Adapter<ImageBannerAdapter.BannerHolder>() {
    class BannerHolder(private val item_binding: ItemBannerBinding):RecyclerView.ViewHolder(item_binding.root) {
        fun bind(url:String){
            val imageView=item_binding.imageView
               Glide.with(item_binding.root)
                   .load(url)
                   .transform(RoundedCorners(40))
                   .into(imageView)
           }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerHolder {
        val holder=ItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
       return BannerHolder(holder)
    }

    override fun onBindViewHolder(holder: BannerHolder, position: Int) {
        holder.bind(bannerImages[position])
    }

    override fun getItemCount(): Int {
        return bannerImages.size
    }
}