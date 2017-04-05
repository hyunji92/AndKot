package dev.jeonghyeonji.andkot.view.main.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.jeonghyeonji.andkot.R

/**
 * Created by jeonghyeonji on 2017. 4. 5..
 */
class NoteViewHolder(val context: Context, parent: ViewGroup?, val onClickListener: View.OnClickListener) :
        RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_grid_view_holder, parent, false)) {

    fun onBindView(position: Int){

    }
}