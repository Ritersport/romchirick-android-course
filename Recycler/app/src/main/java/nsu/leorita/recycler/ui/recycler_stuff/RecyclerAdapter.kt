package nsu.leorita.recycler.ui.recycler_stuff

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nsu.leorita.recycler.ui.recycler_stuff.delegates.Delegate
import nsu.leorita.recycler.ui.recycler_stuff.items.ListItem
import nsu.leorita.recycler.ui.recycler_stuff.view_holders.SongViewHolder

class RecyclerAdapter(
    private val delegates: List<Delegate>,
    private var items: List<ListItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int =
        delegates.indexOfFirst { delegate -> delegate.forItem(items[position]) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        delegates[viewType].getViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegates[getItemViewType(position)].bindViewHolder(holder, items[position])
    }
}