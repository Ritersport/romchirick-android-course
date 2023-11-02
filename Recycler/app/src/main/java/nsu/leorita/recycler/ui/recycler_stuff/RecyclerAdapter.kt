package nsu.leorita.recycler.ui.recycler_stuff

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import nsu.leorita.recycler.ui.recycler_stuff.delegates.Delegate
import nsu.leorita.recycler.ui.recycler_stuff.diff_util.CommonCallbackImpl
import nsu.leorita.recycler.ui.recycler_stuff.items.ListItem

class RecyclerAdapter(
    private val delegates: List<Delegate>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<ListItem> = mutableListOf()
        set(value) {
            val callback = CommonCallbackImpl(oldItems = field,
                newItems = value,
                getChangePayloadImpl = { _, _ -> Any() })
            field = value
            notifyDataSetChanged()
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
        }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int =
        delegates.indexOfFirst { delegate -> delegate.forItem(items[position]) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        delegates[viewType].getViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegates[getItemViewType(position)].bindViewHolder(holder, items[position])
    }



}