package com.xw.xrecylceviewdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Create by zcr on 2020/8/7
 */
class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewHolder> {

    private var context: Context
    private var count: TextView? = null
    private var data: MutableList<String> = ArrayList()

    constructor(context: Context, listData: MutableList<String>) {
        this.context = context
        this.data = listData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview_view, parent, false)
        count = view.findViewById(R.id.count)
        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        count?.text = position.toString()
    }
}