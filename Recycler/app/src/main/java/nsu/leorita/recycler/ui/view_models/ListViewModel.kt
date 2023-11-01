package nsu.leorita.recycler.ui.view_models

import android.content.Context
import androidx.lifecycle.ViewModel
import nsu.leorita.recycler.domain.SongService
import nsu.leorita.recycler.ui.recycler_stuff.delegates.Delegate
import nsu.leorita.recycler.ui.recycler_stuff.delegates.SongDelegate
import nsu.leorita.recycler.ui.recycler_stuff.items.ListItem
import nsu.leorita.recycler.ui.recycler_stuff.items.SongItem

class ListViewModel(private val songService: SongService) : ViewModel() {
    fun getDelegates(context: Context): List<Delegate> =
        listOf(
            SongDelegate(context),
        )

    fun getItems(): List<ListItem> {
        val songs: List<SongItem> = songService.getSongs().map {
            SongItem(it.name, it.singer)
        }
        return songs
    }

}