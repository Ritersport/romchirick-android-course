package nsu.leorita.recycler.ui.recycler_stuff.diff_util

import androidx.recyclerview.widget.DiffUtil

abstract class BaseCallbackImpl<T>(
    private val oldItems: Collection<T>,
    private val newItems: Collection<T>
) : DiffUtil.Callback(){
    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size
}