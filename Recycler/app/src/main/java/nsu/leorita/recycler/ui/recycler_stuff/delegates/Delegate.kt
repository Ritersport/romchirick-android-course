package nsu.leorita.recycler.ui.recycler_stuff.delegates

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nsu.leorita.recycler.ui.recycler_stuff.items.ListItem

interface Delegate {
    fun forItem(item: ListItem): Boolean
    fun getViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    fun bindViewHolder(holder: RecyclerView.ViewHolder, item: ListItem)
}