package com.example.myapplication

import android.util.Log
import android.view.InflateException
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView

class NewAdapter(val inflater: LayoutInflater, val items: List<Newitem>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("NewsAdapter", "onCreateViewHolder $viewType")
        if (viewType == VIEW_TYPE_ITEM) {
            return NewsViewHolder(inflater.inflate(R.layout.item_new, parent, false))
        } else {
            return  HeaderNewHolder(inflater.inflate(R.layout.item_header, parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) VIEW_TYPE_HEADER else VIEW_TYPE_ITEM

    }

    override fun getItemCount() = items.size + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("NewsAdapter", "onCreateViewHolder $position")
        if (holder is NewsViewHolder) {
            holder.bind(items[position-1])
        }
    }

    companion object {
        const val VIEW_TYPE_ITEM = 0
        const val VIEW_TYPE_HEADER = 1

    }

}








