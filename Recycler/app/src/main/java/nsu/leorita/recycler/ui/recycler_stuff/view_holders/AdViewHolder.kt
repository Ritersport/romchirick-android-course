package nsu.leorita.recycler.ui.recycler_stuff.view_holders

import androidx.recyclerview.widget.RecyclerView
import nsu.leorita.recycler.databinding.AdItemBinding
import nsu.leorita.recycler.ui.recycler_stuff.items.AdItem

class AdViewHolder(
    private val binding: AdItemBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(ad: AdItem) {
        binding.categoryText.text = ad.category
        binding.headerText.text = ad.header
        binding.descriptionText.text = ad.text
    }
}