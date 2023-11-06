package nsu.leorita.recycler.ui.recycler_stuff.diff_util

import nsu.leorita.recycler.ui.recycler_stuff.items.AdItem
import nsu.leorita.recycler.ui.recycler_stuff.items.ListItem
import nsu.leorita.recycler.ui.recycler_stuff.items.SongItem

class CommonCallbackImpl(
    private val oldItems: List<ListItem>,
    private val newItems: List<ListItem>,
) : BaseCallbackImpl<ListItem>(oldItems, newItems) {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]
        if (oldItem is SongItem && newItem is SongItem) {
            if ((oldItem.name == newItem.name) && (oldItem.singer == newItem.singer)) {
                return true
            }
        }
        if (oldItem is AdItem && newItem is AdItem) {
            if ((oldItem.category == newItem.category) && (oldItem.header == newItem.header) && (oldItem.text == newItem.text)) {
                return true
            }
        }
        return false
    }


}