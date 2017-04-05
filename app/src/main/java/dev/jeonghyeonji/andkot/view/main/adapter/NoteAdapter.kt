package dev.jeonghyeonji.andkot.view.main.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import dev.jeonghyeonji.andkot.view.main.adapter.model.NoteAdapterContract

/**
 * Created by jeonghyeonji on 2017. 4. 5..
 */

class NoteAdapter(val context: Context) : RecyclerView.Adapter<NoteViewHolder>(), NoteAdapterContract.Model, NoteAdapterContract.View {

    //val noteList = ArrayList<Note>()

    private lateinit var onClickListener: View.OnClickListener

    override fun setOnClickListener(onClick: (Int, Boolean) -> Unit) {
        onClickListener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun onBindViewHolder(holder: NoteViewHolder?, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int)
            = NoteViewHolder(context, parent, onClickListener)

    override fun notifyDataChange() {

    }

    override fun clear() {

    }

    override fun addItem() {

    }


}