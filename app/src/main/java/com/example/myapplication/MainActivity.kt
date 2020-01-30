package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener

class MainActivity : AppCompatActivity() {
    val items = arrayListOf (
        Newitem( "заголовок 1","Подзаголовок 1", Color.RED),
        Newitem( "заголовок 2","Подзаголовок 2", Color.BLUE),
        Newitem( "заголовок 3","Подзаголовок 3", Color.GREEN),
        Newitem( "заголовок 4","Подзаголовок 4", Color.YELLOW),
        Newitem( "заголовок 1","Подзаголовок 1", Color.RED),
        Newitem( "заголовок 2","Подзаголовок 2", Color.BLUE),
        Newitem( "заголовок 3","Подзаголовок 3", Color.GREEN),
        Newitem( "заголовок 4","Подзаголовок 4", Color.YELLOW),
        Newitem( "заголовок 1","Подзаголовок 1", Color.RED),
        Newitem( "заголовок 2","Подзаголовок 2", Color.BLUE),
        Newitem( "заголовок 3","Подзаголовок 3", Color.GREEN),
        Newitem( "заголовок 4","Подзаголовок 4", Color.YELLOW)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun initRecycler () {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = NewAdapter(LayoutInflater.from(this), items)

        val itemDecor = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        itemDecor.setDrawable(getDrawable(R.drawable.black_line)!!)
        recyclerView.addItemDecoration(itemDecor)


        findViewById<View>(R.id.addBtn).setOnClickListener {
            items.add(2, Newitem("New item", "----", Color.MAGENTA))
            recyclerView.adapter?.notifyItemInserted(2)
        }
        findViewById<View>(R.id.removeBtn).setOnClickListener() {
            items.removeAt(2)
            recyclerView.adapter?.notifyItemRemoved(2)
        }

        recyclerView.addOnScrollListener(object : OnScrollListener () {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if ((recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition() == items.size - 1) {
                    items.add(Newitem("Pagination new item", "+++++", Color.BLACK))
                    items.add(Newitem("Pagination new item", "+++++", Color.BLACK))
                    items.add(Newitem("Pagination new item", "+++++", Color.BLACK))
                    items.add(Newitem("Pagination new item", "+++++", Color.BLACK))
                    items.add(Newitem("Pagination new item", "+++++", Color.BLACK))

                    recyclerView.adapter?.notifyItemRangeInserted(items.size - 5, 5)
                }
            }
        })
    }

    class CustomItemDecoreation(context: Context, orintation: Int): DividerItemDecoration(context, orintation) {
        override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            super.onDrawOver(c, parent, state)
        }

        override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            super.onDraw(c, parent, state)
        }

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            super.getItemOffsets(outRect, view, parent, state)
        }
    }

}
