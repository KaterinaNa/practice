package com.example.myapplication

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_new.*
import kotlinx.android.synthetic.main.item_new.view.*
import com.example.myapplication.Newitem as Newitem


class NewsViewHolder (itemItem: View): RecyclerView.ViewHolder(itemItem){
    val titleTv = itemItem.findViewById<TextView>(R.id.titleTv)
    val subtitleTv = itemItem.findViewById<TextView>(R.id.subtitleTv)
    val imgTv = itemItem.findViewById<ImageView>(R.id.imgTv)

   fun bind(item: Newitem) {
       titleTv.text = item.title
       subtitleTv.text = item.subtitle
       imgTv.setBackgroundColor(item.color)

   }


}