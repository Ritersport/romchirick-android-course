package nsu.leorita.recycler.ui.recycler_stuff.view_holders

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import nsu.leorita.recycler.databinding.SongItemBinding
import nsu.leorita.recycler.ui.recycler_stuff.items.SongItem

class SongViewHolder(
    private val binding: SongItemBinding
) : ViewHolder(binding.root) {

    fun bind(song: SongItem) {
        binding.songNameText.text = song.name
        binding.singerText.text = song.singer
    }

}