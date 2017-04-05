package dev.jeonghyeonji.andkot.view.main.adapter.model

/**
 * Created by jeonghyeonji on 2017. 4. 5..
 */
interface NoteAdapterContract {
    interface View {

        fun setOnClickListener(onClick: (Int, Boolean) -> Unit)

        fun notifyDataChange()
    }

    interface Model {

        fun clear()

        fun addItem()
    }
}