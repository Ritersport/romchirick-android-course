package nsu.leorita.recycler.ui.recycler_stuff.delegates

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nsu.leorita.recycler.R
import nsu.leorita.recycler.databinding.SongItemBinding
import nsu.leorita.recycler.ui.recycler_stuff.view_holders.SongViewHolder
import nsu.leorita.recycler.ui.recycler_stuff.items.ListItem
import nsu.leorita.recycler.ui.recycler_stuff.items.SongItem

class SongDelegate(context: Context) : Delegate {
    override fun forItem(item: ListItem): Boolean = item is SongItem

    override fun getViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SongItemBinding.inflate(inflater, parent, false)
        return SongViewHolder(binding)
    }
    override fun bindViewHolder(holder: RecyclerView.ViewHolder, item: ListItem) {
        (holder as SongViewHolder).let { songViewHolder ->
            val songItem = item as SongItem
            songViewHolder.bind(songItem)
        }
    }
}