package nsu.leorita.recycler.ui.recycler_stuff.delegates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nsu.leorita.recycler.databinding.AdItemBinding
import nsu.leorita.recycler.ui.recycler_stuff.items.AdItem
import nsu.leorita.recycler.ui.recycler_stuff.items.ListItem
import nsu.leorita.recycler.ui.recycler_stuff.view_holders.AdViewHolder

class AdDelegate : Delegate {
    override fun forItem(item: ListItem): Boolean = item is AdItem

    override fun getViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdItemBinding.inflate(inflater, parent, false)
        return AdViewHolder(binding)
    }

    override fun bindViewHolder(holder: RecyclerView.ViewHolder, item: ListItem) {
        (holder as AdViewHolder).let { adViewHolder ->
            val adItem = item as AdItem
            adViewHolder.bind(adItem)
        }
    }
}